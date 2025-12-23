package com.example.nosqldatabases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * NoSQL Databases Demo Application
 * 
 * MongoDB, Redis, Neo4j examples
 * 
 * Port: 8098
 * Landing Page: http://localhost:8098
 */
@SpringBootApplication
public class NosqlDatabasesApplication {

    public static void main(String[] args) {
        SpringApplication.run(NosqlDatabasesApplication.class, args);
    }
}
