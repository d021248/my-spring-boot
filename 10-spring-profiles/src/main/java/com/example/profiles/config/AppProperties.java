package com.example.profiles.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

/**
 * Application properties that vary by profile
 */
@ConfigurationProperties(prefix = "app")
public record AppProperties(
    String name,
    String environment,
    @DefaultValue("INFO") String logLevel,
    Features features,
    Api api
) {
    public record Features(
        boolean advancedLogging,
        boolean caching,
        boolean monitoring
    ) {}
    
    public record Api(
        String baseUrl,
        int timeout,
        int retries
    ) {}
}
