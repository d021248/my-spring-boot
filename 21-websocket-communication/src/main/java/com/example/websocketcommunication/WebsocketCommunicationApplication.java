package com.example.websocketcommunication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * WebSocket Communication Demo Application
 * 
 * Real-time bidirectional communication
 * 
 * Port: 8101
 * Landing Page: http://localhost:8101
 */
@SpringBootApplication
public class WebsocketCommunicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketCommunicationApplication.class, args);
    }
}
