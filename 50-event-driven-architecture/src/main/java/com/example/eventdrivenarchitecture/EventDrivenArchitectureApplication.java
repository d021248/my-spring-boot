package com.example.eventdrivenarchitecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Event Driven Architecture Demo Application
 * 
 * Domain events, event sourcing
 * 
 * Port: 8130
 * Landing Page: http://localhost:8130
 */
@SpringBootApplication
public class EventDrivenArchitectureApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventDrivenArchitectureApplication.class, args);
    }
}
