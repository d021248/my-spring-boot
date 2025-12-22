package com.example.api.versioning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/**
 * ⭐ NEW IN SPRING BOOT 4.0: API Versioning Support
 * 
 * Demonstrates different API versioning strategies:
 * 1. URL-based versioning: /api/v1/users vs /api/v2/users
 * 2. Header-based versioning: X-API-Version: 1 or 2
 * 3. Content negotiation: Accept: application/vnd.api.v1+json
 * 
 * This module shows how Spring Boot 4.0 makes it easier to maintain
 * multiple API versions simultaneously while evolving your API.
 * 
 * Endpoints:
 * V1 API:
 * - GET  /api/v1/users     - Get all users (V1 format)
 * - GET  /api/v1/users/{id} - Get user by ID (V1 format)
 * - POST /api/v1/users     - Create user (V1 format)
 * 
 * V2 API (Enhanced):
 * - GET  /api/v2/users     - Get all users (V2 format with phone)
 * - GET  /api/v2/users/{id} - Get user by ID (V2 format)
 * - POST /api/v2/users     - Create user (V2 format)
 * - GET  /api/v2/users/search?query=xxx - Search users (NEW in V2)
 */
@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    CommandLineRunner apiVersioningDemo() {
        return args -> {
            System.out.println("=".repeat(70));
            System.out.println("⭐ NEW IN SPRING BOOT 4.0: API Versioning");
            System.out.println("=".repeat(70));
            System.out.println("🔹 V1 API Endpoints (Original):");
            System.out.println("   GET  http://localhost:8082/api/v1/users");
            System.out.println("   GET  http://localhost:8082/api/v1/users/{id}");
            System.out.println("   POST http://localhost:8082/api/v1/users");
            System.out.println();
            System.out.println("🔸 V2 API Endpoints (Enhanced with phone & search):");
            System.out.println("   GET  http://localhost:8082/api/v2/users");
            System.out.println("   GET  http://localhost:8082/api/v2/users/{id}");
            System.out.println("   POST http://localhost:8082/api/v2/users");
            System.out.println("   GET  http://localhost:8082/api/v2/users/search?query=john");
            System.out.println("=".repeat(70));
            System.out.println("💡 Try both versions to see the differences!");
            System.out.println("=".repeat(70));
        };
    }
}
