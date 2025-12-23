package com.example.databasemigrations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Database Migrations Demo Application
 * 
 * Flyway and Liquibase integration
 * 
 * Port: 8097
 * Landing Page: http://localhost:8097
 */
@SpringBootApplication
public class DatabaseMigrationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseMigrationsApplication.class, args);
    }
}
