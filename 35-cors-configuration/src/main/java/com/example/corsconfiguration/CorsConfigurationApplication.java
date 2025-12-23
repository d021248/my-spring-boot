package com.example.corsconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * CORS Configuration Demo Application
 * 
 * Cross-origin resource sharing
 * 
 * Port: 8115
 * Landing Page: http://localhost:8115
 */
@SpringBootApplication
public class CorsConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CorsConfigurationApplication.class, args);
    }
}
