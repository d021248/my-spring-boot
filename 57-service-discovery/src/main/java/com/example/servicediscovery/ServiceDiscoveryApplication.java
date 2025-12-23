package com.example.servicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Service Discovery Demo Application
 * 
 * Eureka, Consul integration
 * 
 * Port: 8137
 * Landing Page: http://localhost:8137
 */
@SpringBootApplication
public class ServiceDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDiscoveryApplication.class, args);
    }
}
