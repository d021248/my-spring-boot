package com.example.ratelimiting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Rate Limiting Demo Application
 * 
 * Bucket4j, API throttling
 * 
 * Port: 8132
 * Landing Page: http://localhost:8132
 */
@SpringBootApplication
public class RateLimitingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RateLimitingApplication.class, args);
    }
}
