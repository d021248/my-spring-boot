package com.example.multipledatasources.config;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.replica")
    public DataSource replicaDataSource() {
        DataSource ds = DataSourceBuilder.create().build();

        // Initialize schema on the replica in-memory DB for the demo so both DBs have
        // the same table
        try (Connection conn = ds.getConnection(); Statement st = conn.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS product (id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255));");
        } catch (Exception e) {
            System.err.println("Warning: failed to init replica schema: " + e.getMessage());
        }

        return ds;
    }

    @Bean
    @Primary
    public DataSource routingDataSource(DataSource primaryDataSource, DataSource replicaDataSource) {
        AbstractRoutingDataSource routing = new AbstractRoutingDataSource() {
            @Override
            protected Object determineCurrentLookupKey() {
                return TenantContext.getCurrentTenant();
            }
        };

        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("primary", primaryDataSource);
        targetDataSources.put("replica", replicaDataSource);

        routing.setTargetDataSources(targetDataSources);
        routing.setDefaultTargetDataSource(primaryDataSource);
        routing.afterPropertiesSet();

        return routing;
    }

}