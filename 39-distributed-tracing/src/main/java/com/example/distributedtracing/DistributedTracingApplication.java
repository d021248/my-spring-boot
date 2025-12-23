package com.example.distributedtracing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Distributed Tracing Demo Application
 * 
 * Zipkin, Jaeger integration
 * 
 * Port: 8119
 * Landing Page: http://localhost:8119
 */
@SpringBootApplication
public class DistributedTracingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedTracingApplication.class, args);
    }
}
