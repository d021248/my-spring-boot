package com.example.oauth2keycloak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * OAuth2 Keycloak Demo Application
 * 
 * OAuth2 flows, JWT tokens, SSO
 * 
 * Port: 8104
 * Landing Page: http://localhost:8104
 */
@SpringBootApplication
public class Oauth2KeycloakApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2KeycloakApplication.class, args);
    }
}
