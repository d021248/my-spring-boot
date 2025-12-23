package com.example.contentnegotiation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Content Negotiation Demo Application
 * 
 * Multiple response formats (JSON/XML)
 * 
 * Port: 8110
 * Landing Page: http://localhost:8110
 */
@SpringBootApplication
public class ContentNegotiationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentNegotiationApplication.class, args);
    }
}
