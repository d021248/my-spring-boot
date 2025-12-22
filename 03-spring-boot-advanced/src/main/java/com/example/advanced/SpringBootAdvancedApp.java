package com.example.advanced;

import com.example.advanced.security.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Spring Boot Advanced Features Demo
 * 
 * Demonstrates:
 * - JWT-based Security
 * - Caching with Caffeine
 * - Async Processing
 * - Event-Driven Architecture
 * - Reactive Programming with WebFlux
 * 
 * Endpoints:
 * - POST /api/auth/login         - Generate JWT token
 * - GET  /api/cache/data/{id}    - Cacheable endpoint
 * - POST /api/async/process      - Async processing
 * - POST /api/events/publish     - Publish application event
 * - GET  /api/reactive/stream    - Reactive stream
 */
@SpringBootApplication
@EnableCaching
@EnableAsync
public class SpringBootAdvancedApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdvancedApp.class, args);
    }
    
    @Bean
    CommandLineRunner advancedDemo(JwtUtil jwtUtil) {
        return args -> {
            System.out.println("=".repeat(70));
            System.out.println("🚀 Spring Boot Advanced Features Demo");
            System.out.println("=".repeat(70));
            System.out.println("🌐 Landing Page: http://localhost:8083");
            System.out.println("   📖 Complete advanced features documentation");
            System.out.println("=".repeat(70));
            System.out.println("\n🔹 Enterprise Features Enabled:");
            System.out.println("   • JWT Security - Token-based authentication");
            System.out.println("   • Caffeine Caching - High-performance caching");
            System.out.println("   • Async Processing - Non-blocking operations");
            System.out.println("   • Event-Driven - Application events");
            System.out.println("   • WebFlux Reactive - Reactive programming");
            System.out.println("\n" + "=".repeat(70));
            
            // Demo JWT
            String token = jwtUtil.generateToken("demo-user");
            System.out.println("Demo JWT Token: " + token.substring(0, Math.min(50, token.length())) + "...");
            System.out.println("=".repeat(70));
        };
    }
}
