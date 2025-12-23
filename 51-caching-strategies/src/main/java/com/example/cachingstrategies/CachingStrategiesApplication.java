package com.example.cachingstrategies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Caching Strategies Demo Application
 * 
 * Spring Cache, Redis, Caffeine
 * 
 * Port: 8131
 * Landing Page: http://localhost:8131
 */
@SpringBootApplication
public class CachingStrategiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CachingStrategiesApplication.class, args);
    }
}
