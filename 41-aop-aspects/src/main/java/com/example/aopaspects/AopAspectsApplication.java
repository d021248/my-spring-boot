package com.example.aopaspects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * AOP Aspects Demo Application
 * 
 * Cross-cutting concerns, pointcuts
 * 
 * Port: 8121
 * Landing Page: http://localhost:8121
 */
@SpringBootApplication
public class AopAspectsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopAspectsApplication.class, args);
    }
}
