package com.example.reactivewebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Reactive WebFlux Demo Application
 * 
 * Mono/Flux, reactive repositories
 * 
 * Port: 8123
 * Landing Page: http://localhost:8123
 */
@SpringBootApplication
public class ReactiveWebfluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveWebfluxApplication.class, args);
    }
}
