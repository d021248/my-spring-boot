package com.example.observability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/**
 * Observability with Spring Boot Actuator
 * 
 * This module demonstrates production-ready monitoring:
 * - Health checks
 * - Metrics collection
 * - Application info
 * - Custom health indicators
 * 
 * Actuator Endpoints:
 * - /actuator/health         - Application health status
 * - /actuator/metrics        - Application metrics
 * - /actuator/info           - Application information
 * - /actuator/env            - Environment properties
 */
@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    CommandLineRunner observabilityDemo() {
        return args -> {
            System.out.println("=".repeat(70));
            System.out.println("📊 Observability & Monitoring Demo");
            System.out.println("=".repeat(70));
            System.out.println("🔹 Actuator Endpoints:");
            System.out.println("   http://localhost:8084/actuator");
            System.out.println("   http://localhost:8084/actuator/health");
            System.out.println("   http://localhost:8084/actuator/metrics");
            System.out.println("   http://localhost:8084/actuator/info");
            System.out.println("=".repeat(70));
        };
    }
}
