package com.example.customstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Custom Starter Demo Application
 * 
 * Creating auto-configuration starters
 * 
 * Port: 8120
 * Landing Page: http://localhost:8120
 */
@SpringBootApplication
public class CustomStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomStarterApplication.class, args);
    }
}
