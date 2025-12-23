package com.example.springdatarest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Data REST Demo Application
 * 
 * Auto-exposed repositories with HATEOAS
 * 
 * Port: 8096
 * Landing Page: http://localhost:8096
 */
@SpringBootApplication
public class SpringDataRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestApplication.class, args);
    }
}
