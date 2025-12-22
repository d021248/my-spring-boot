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
            System.out.println("🔐 JWT Security enabled");
            System.out.println("💾 Caffeine Caching enabled");
            System.out.println("⚡ Async Processing enabled");
            System.out.println("📡 Event-Driven Architecture enabled");
            System.out.println("🌊 WebFlux Reactive enabled");
            System.out.println("=".repeat(70));
            
            // Demo JWT
            String token = jwtUtil.generateToken("demo-user");
            System.out.println("Demo JWT Token: " + token.substring(0, Math.min(50, token.length())) + "...");
            System.out.println("=".repeat(70));
            System.out.println("Server running on: http://localhost:8081");
            System.out.println("=".repeat(70));
        };
    }
}
