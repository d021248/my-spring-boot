package com.example.hateoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * HATEOAS Demo Application
 * 
 * Hypermedia-driven APIs
 * 
 * Port: 8113
 * Landing Page: http://localhost:8113
 */
@SpringBootApplication
public class HateoasApplication {

    public static void main(String[] args) {
        SpringApplication.run(HateoasApplication.class, args);
    }
}
