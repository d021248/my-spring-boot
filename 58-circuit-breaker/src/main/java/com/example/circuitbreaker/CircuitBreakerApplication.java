package com.example.circuitbreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Circuit Breaker Demo Application
 * 
 * Resilience4j patterns
 * 
 * Port: 8138
 * Landing Page: http://localhost:8138
 */
@SpringBootApplication
public class CircuitBreakerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CircuitBreakerApplication.class, args);
    }
}
