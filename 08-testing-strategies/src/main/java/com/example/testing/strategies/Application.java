package com.example.testing.strategies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/**
 * Testing Strategies with Spring Boot
 * 
 * This module demonstrates various testing approaches:
 * - Unit Testing with JUnit 5 & Mockito
 * - Integration Testing with @SpringBootTest
 * - Test containers for database testing
 * - MockMvc for REST API testing
 * - WebTestClient for reactive testing
 * 
 * Run tests with: mvn test
 */
@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    CommandLineRunner testingDemo() {
        return args -> {
            System.out.println("=".repeat(70));
            System.out.println("🧪 Testing Strategies Demo");
            System.out.println("=".repeat(70));
            System.out.println("✓ Unit Tests - JUnit 5 & Mockito");
            System.out.println("✓ Integration Tests - @SpringBootTest");
            System.out.println("✓ Testcontainers - Database integration tests");
            System.out.println("✓ MockMvc - REST API testing");
            System.out.println("=".repeat(70));
            System.out.println("Run tests with: mvn test");
            System.out.println("=".repeat(70));
        };
    }
}
