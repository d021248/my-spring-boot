package com.example.best.practices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/**
 * ⭐ ENHANCED IN SPRING BOOT 4.0: Best Practices with JSpecify
 * 
 * Spring Boot 4.0 introduces JSpecify for better null safety.
 * 
 * This module demonstrates production-ready best practices:
 * - Null safety with @Nullable and @NonNull annotations (JSpecify)
 * - Exception handling patterns
 * - Bean validation
 * - Structured logging
 * - Configuration externalization
 * - API documentation
 * - Security best practices
 * 
 * JSpecify is now the standard for null safety annotations across
 * the Spring ecosystem, replacing various vendor-specific solutions.
 */
@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    CommandLineRunner bestPracticesDemo() {
        return args -> {
            System.out.println("=".repeat(70));
            System.out.println("⭐ ENHANCED IN SPRING BOOT 4.0: Best Practices with JSpecify");
            System.out.println("=".repeat(70));
            System.out.println("🌐 Landing Page: http://localhost:8089");
            System.out.println("   📖 Complete production best practices documentation");
            System.out.println();
            System.out.println("🎯 Best Practices Demonstrated:");
            System.out.println("   ✓ Null Safety - JSpecify annotations (@Nullable/@NonNull)");
            System.out.println("   ✓ Exception Handling - @RestControllerAdvice");
            System.out.println("   ✓ Bean Validation - Jakarta Validation API");
            System.out.println("   ✓ Structured Logging - SLF4J patterns");
            System.out.println("   ✓ Configuration - @ConfigurationProperties");
            System.out.println("   ✓ Security - Spring Security best practices");
            System.out.println();
            System.out.println("🎓 Final Module: Production readiness checklist and SOLID principles");
            System.out.println("=".repeat(70));
        };
    }
}
