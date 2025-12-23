package com.example.kafkaintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Kafka Integration Demo Application
 * 
 * Producers, consumers, and streams
 * 
 * Port: 8100
 * Landing Page: http://localhost:8100
 */
@SpringBootApplication
public class KafkaIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaIntegrationApplication.class, args);
    }
}
