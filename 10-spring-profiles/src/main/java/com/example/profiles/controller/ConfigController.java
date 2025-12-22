package com.example.profiles.controller;

import com.example.profiles.config.AppProperties;
import com.example.profiles.config.DatabaseConfig.DatabaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Controller to display active profiles and configuration
 */
@RestController
@RequestMapping("/api/config")
@EnableConfigurationProperties(AppProperties.class)
public class ConfigController {

    private final Environment environment;
    private final AppProperties appProperties;
    private final DatabaseInfo databaseInfo;

    @Value("${server.port:8080}")
    private int serverPort;

    @Autowired
    public ConfigController(Environment environment, 
                           AppProperties appProperties,
                           DatabaseInfo databaseInfo) {
        this.environment = environment;
        this.appProperties = appProperties;
        this.databaseInfo = databaseInfo;
    }

    @GetMapping
    public Map<String, Object> getConfiguration() {
        Map<String, Object> config = new HashMap<>();
        
        config.put("activeProfiles", Arrays.asList(environment.getActiveProfiles()));
        config.put("defaultProfiles", Arrays.asList(environment.getDefaultProfiles()));
        config.put("serverPort", serverPort);
        config.put("appProperties", appProperties);
        config.put("database", databaseInfo);
        
        return config;
    }

    @GetMapping("/profiles")
    public Map<String, Object> getProfiles() {
        Map<String, Object> profiles = new HashMap<>();
        
        profiles.put("active", Arrays.asList(environment.getActiveProfiles()));
        profiles.put("default", Arrays.asList(environment.getDefaultProfiles()));
        profiles.put("acceptsProfiles", Map.of(
            "dev", environment.acceptsProfiles("dev"),
            "prod", environment.acceptsProfiles("prod"),
            "test", environment.acceptsProfiles("test")
        ));
        
        return profiles;
    }
}
