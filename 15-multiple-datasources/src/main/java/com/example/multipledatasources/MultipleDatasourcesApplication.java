package com.example.multipledatasources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Multiple DataSources Demo Application
 * 
 * Multi-tenancy and routing datasources
 * 
 * Port: 8095
 * Landing Page: http://localhost:8095
 */
@SpringBootApplication
public class MultipleDatasourcesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipleDatasourcesApplication.class, args);
    }
}
