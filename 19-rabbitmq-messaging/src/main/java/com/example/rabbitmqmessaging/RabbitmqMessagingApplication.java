package com.example.rabbitmqmessaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RabbitMQ Messaging Demo Application
 * 
 * Publisher/subscriber with RabbitMQ
 * 
 * Port: 8099
 * Landing Page: http://localhost:8099
 */
@SpringBootApplication
public class RabbitmqMessagingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqMessagingApplication.class, args);
    }
}
