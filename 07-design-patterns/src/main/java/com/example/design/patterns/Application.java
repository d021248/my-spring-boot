package com.example.design.patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/**
 * Design Patterns with Spring
 * 
 * Demonstrates common design patterns with Spring Framework:
 * - Factory Pattern (Bean factory)
 * - Strategy Pattern (Service implementations)
 * - Observer Pattern (Event listeners)
 * - Decorator Pattern (AOP)
 * - Singleton Pattern (Spring beans default scope)
 */
@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    CommandLineRunner patternsDemo() {
        return args -> {
            System.out.println("=".repeat(70));
            System.out.println("�� Design Patterns with Spring");
            System.out.println("=".repeat(70));
            System.out.println("✓ Factory Pattern - Spring BeanFactory");
            System.out.println("✓ Strategy Pattern - Service implementations");
            System.out.println("✓ Observer Pattern - ApplicationEvent listeners");
            System.out.println("✓ Decorator Pattern - Spring AOP");
            System.out.println("✓ Singleton Pattern - Default bean scope");
            System.out.println("=".repeat(70));
        };
    }
}
