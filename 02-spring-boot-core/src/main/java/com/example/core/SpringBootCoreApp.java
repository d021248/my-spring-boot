package com.example.core;

import com.example.core.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Spring Boot Core Features Demo
 * 
 * Demonstrates:
 * - Dependency Injection with Spring
 * - REST API development with Spring MVC
 * - Spring Data JPA for database access
 * - Configuration management with @ConfigurationProperties
 * - Exception handling with @RestControllerAdvice
 * - Bean validation with Jakarta Validation
 * - H2 in-memory database
 * 
 * Endpoints:
 * - POST   /api/users          - Create a new user
 * - GET    /api/users          - Get all users
 * - GET    /api/users/{id}     - Get user by ID
 * - GET    /api/users?name=xxx - Search users by name
 * - PUT    /api/users/{id}     - Update user
 * - DELETE /api/users/{id}     - Delete user
 * 
 * H2 Console: http://localhost:8080/h2-console
 * JDBC URL: jdbc:h2:mem:testdb
 */
@SpringBootApplication
@EnableConfigurationProperties
public class SpringBootCoreApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCoreApp.class, args);
    }

    @Bean
    CommandLineRunner demo(AppConfig appConfig) {
        return args -> {
            System.out.println("=".repeat(70));
            System.out.println("🚀 Spring Boot Core Features Demo");
            System.out.println("=".repeat(70));
            System.out.println("Application: " + appConfig.getName());
            System.out.println("Version: " + appConfig.getVersion());
            System.out.println("Environment: " + appConfig.getEnvironment());
            System.out.println("=".repeat(70));
            System.out.println("🌐 Landing Page: http://localhost:8082");
            System.out.println("   📖 Complete API documentation with examples");
            System.out.println("=".repeat(70));
            System.out.println("📡 REST API Endpoints:");
            System.out.println("   GET  http://localhost:8082/api/users");
            System.out.println("   POST http://localhost:8082/api/users");
            System.out.println("   GET  http://localhost:8082/api/users/{id}");
            System.out.println("   PUT  http://localhost:8082/api/users/{id}");
            System.out.println("   DELETE http://localhost:8082/api/users/{id}");
            System.out.println("=".repeat(70));
            System.out.println("\n🔹 H2 Console: http://localhost:8082/h2-console");
            System.out.println("   JDBC URL: jdbc:h2:mem:testdb");
            System.out.println("   Username: sa");
            System.out.println("   Password: (empty)");
            System.out.println("=".repeat(70));
        };
    }
}
