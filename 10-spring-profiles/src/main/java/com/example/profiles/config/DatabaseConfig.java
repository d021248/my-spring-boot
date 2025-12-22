package com.example.profiles.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * Profile-specific database configurations
 */
@Configuration
public class DatabaseConfig {

    /**
     * Development database configuration (H2 in-memory)
     */
    @Configuration
    @Profile("dev")
    public static class DevDatabaseConfig {
        
        @Bean
        public DatabaseInfo databaseInfo() {
            return new DatabaseInfo("H2 In-Memory Database", "jdbc:h2:mem:devdb", "dev");
        }
    }

    /**
     * Production database configuration (PostgreSQL)
     */
    @Configuration
    @Profile("prod")
    public static class ProdDatabaseConfig {
        
        @Bean
        public DatabaseInfo databaseInfo() {
            return new DatabaseInfo("PostgreSQL Production", "jdbc:postgresql://localhost:5432/proddb", "prod");
        }
    }

    /**
     * Test database configuration
     */
    @Configuration
    @Profile("test")
    public static class TestDatabaseConfig {
        
        @Bean
        public DatabaseInfo databaseInfo() {
            return new DatabaseInfo("H2 Test Database", "jdbc:h2:mem:testdb", "test");
        }
    }

    /**
     * Default database configuration (when no profile is active)
     */
    @Configuration
    @Profile("default")
    public static class DefaultDatabaseConfig {
        
        @Bean
        public DatabaseInfo databaseInfo() {
            return new DatabaseInfo("H2 Default Database", "jdbc:h2:mem:defaultdb", "default");
        }
    }

    /**
     * Bean that only loads when specific property is set
     */
    @Bean
    @ConditionalOnProperty(name = "app.features.advanced-logging", havingValue = "true")
    public AdvancedLogger advancedLogger() {
        return new AdvancedLogger();
    }

    public record DatabaseInfo(String name, String url, String profile) {}
    
    public static class AdvancedLogger {
        public void log(String message) {
            System.out.println("[ADVANCED LOG] " + message);
        }
    }
}
