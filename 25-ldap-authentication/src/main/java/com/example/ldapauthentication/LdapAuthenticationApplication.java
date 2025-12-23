package com.example.ldapauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * LDAP Authentication Demo Application
 * 
 * LDAP integration
 * 
 * Port: 8105
 * Landing Page: http://localhost:8105
 */
@SpringBootApplication
public class LdapAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(LdapAuthenticationApplication.class, args);
    }
}
