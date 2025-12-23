package com.example.multitenancy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Multitenancy Demo Application
 * 
 * Tenant isolation strategies
 * 
 * Port: 8133
 * Landing Page: http://localhost:8133
 */
@SpringBootApplication
public class MultitenancyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultitenancyApplication.class, args);
    }
}
