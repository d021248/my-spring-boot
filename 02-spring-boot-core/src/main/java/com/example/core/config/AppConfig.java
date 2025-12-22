package com.example.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "app")
@Data
public class AppConfig {
    private String name = "Spring Boot Core Demo";
    private String version = "1.0.0";
    private String environment = "development";
}
