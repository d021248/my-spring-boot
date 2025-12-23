package com.example.batchprocessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Batch Processing Demo Application
 * 
 * Job configuration, chunks, listeners
 * 
 * Port: 8122
 * Landing Page: http://localhost:8122
 */
@SpringBootApplication
public class BatchProcessingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchProcessingApplication.class, args);
    }
}
