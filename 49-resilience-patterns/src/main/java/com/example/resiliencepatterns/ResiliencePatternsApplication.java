package com.example.resiliencepatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Resilience Patterns Demo Application
 * 
 * Circuit breaker, retry, bulkhead
 * 
 * Port: 8129
 * Landing Page: http://localhost:8129
 */
@SpringBootApplication
public class ResiliencePatternsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResiliencePatternsApplication.class, args);
    }
}
