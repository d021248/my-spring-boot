package com.example.loggingstrategies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Logging Strategies Demo Application
 * 
 * Logback, log levels, MDC, structured logging
 * 
 * Port: 8107
 * Landing Page: http://localhost:8107
 */
@SpringBootApplication
public class LoggingStrategiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoggingStrategiesApplication.class, args);
    }
}
