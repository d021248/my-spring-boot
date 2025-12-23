package com.example.actuatormonitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Actuator Monitoring Demo Application
 * 
 * Health checks, metrics, custom endpoints
 * 
 * Port: 8106
 * Landing Page: http://localhost:8106
 */
@SpringBootApplication
public class ActuatorMonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorMonitoringApplication.class, args);
    }
}
