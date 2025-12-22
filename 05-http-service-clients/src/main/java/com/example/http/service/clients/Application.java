package com.example.http.service.clients;

import com.example.http.service.clients.client.RestClientService;
import com.example.http.service.clients.dto.PostDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/**
 * ⭐ ENHANCED IN SPRING BOOT 4.0: HTTP Service Clients
 * 
 * Spring Boot 4.0 provides enhanced HTTP client capabilities:
 * 1. RestClient - New modern HTTP client (successor to RestTemplate)
 * 2. WebClient - Enhanced reactive HTTP client
 * 3. Declarative HTTP interfaces with @HttpExchange
 * 4. Better integration with Resilience4j for circuit breakers
 * 
 * This module demonstrates:
 * - RestClient with fluent API
 * - WebClient for reactive programming
 * - Circuit breaker patterns with Resilience4j
 * - Error handling and retry mechanisms
 * 
 * Features showcased:
 * - Synchronous HTTP calls with RestClient
 * - Asynchronous reactive calls with WebClient
 * - Circuit breaker for resilience
 * - Clean and modern API design
 */
@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    CommandLineRunner httpClientsDemo(RestClientService restClientService) {
        return args -> {
            System.out.println("=".repeat(70));
            System.out.println("⭐ ENHANCED IN SPRING BOOT 4.0: HTTP Service Clients");
            System.out.println("=".repeat(70));
            
            // Demonstrate RestClient
            System.out.println("\n🔹 RestClient Demo (Synchronous):");
            try {
                PostDTO post = restClientService.getPostById(1L);
                System.out.println("   ✓ Fetched Post: " + post.title());
            } catch (Exception e) {
                System.out.println("   ✗ Error: " + e.getMessage());
            }
            
            System.out.println("\n🔹 Key Improvements in Spring Boot 4.0:");
            System.out.println("   • RestClient replaces RestTemplate with modern fluent API");
            System.out.println("   • Enhanced WebClient with better error handling");
            System.out.println("   • Native @HttpExchange support for declarative clients");
            System.out.println("   • Improved Resilience4j integration");
            
            System.out.println("\n" + "=".repeat(70));
            System.out.println("Server running on: http://localhost:8083");
            System.out.println("=".repeat(70));
        };
    }
}

