package com.example.graphqlapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * GraphQL API Demo Application
 * 
 * Schema definition, resolvers, subscriptions
 * 
 * Port: 8112
 * Landing Page: http://localhost:8112
 */
@SpringBootApplication
public class GraphqlApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlApiApplication.class, args);
    }
}
