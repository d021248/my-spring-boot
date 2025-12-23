package com.example.auditlogging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Audit Logging Demo Application
 * 
 * Track changes, who did what when
 * 
 * Port: 8134
 * Landing Page: http://localhost:8134
 */
@SpringBootApplication
public class AuditLoggingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuditLoggingApplication.class, args);
    }
}
