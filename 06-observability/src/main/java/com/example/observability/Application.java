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
            System.out.println("🌐 Landing Page: http://localhost:8086");
            System.out.println("   📖 Complete observability documentation");
            System.out.println("=".repeat(70));
            System.out.println("\n🔹 Observability Features:");
            System.out.println("   • Metrics - Micrometer for performance data");
            System.out.println("   • Tracing - Distributed request tracking");
            System.out.println("   • Health - Application health checks");
            System.out.println("   • Logging - Structured logging patterns");
            System.out.println("\n🔹 Actuator Endpoints:");
            System.out.println("   http://localhost:8086/actuator");
            System.out.println("   http://localhost:8086/actuator/health");
            System.out.println("   http://localhost:8086/actuator/metrics");
            System.out.println("   http://localhost:8086/actuator/info");
            System.out.println("\n" + "=".repeat(70));
        };
    }
}
