package com.example.profiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Profiles Demo
 * 
 * Demonstrates:
 * - Environment-specific configuration with @Profile
 * - Multiple property files (application-dev.properties, application-prod.properties)
 * - Profile activation via spring.profiles.active
 * - Profile-specific beans and configurations
 * - @Conditional annotations
 * - Profile groups
 * - Default profiles
 * 
 * Run with different profiles:
 * - mvn spring-boot:run -Dspring-boot.run.profiles=dev
 * - mvn spring-boot:run -Dspring-boot.run.profiles=prod
 * - mvn spring-boot:run -Dspring-boot.run.profiles=test
 * 
 * Or set environment variable:
 * - export SPRING_PROFILES_ACTIVE=dev
 * 
 * Endpoints:
 * - GET /api/config - Show current active profile and configuration
 * - GET /actuator/env - View all environment properties
 */
@SpringBootApplication
public class SpringProfilesApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringProfilesApp.class, args);
    }
}
