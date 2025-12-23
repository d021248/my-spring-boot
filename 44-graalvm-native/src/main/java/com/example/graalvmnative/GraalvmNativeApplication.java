package com.example.graalvmnative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * GraalVM Native Demo Application
 * 
 * Native image compilation, AOT
 * 
 * Port: 8124
 * Landing Page: http://localhost:8124
 */
@SpringBootApplication
public class GraalvmNativeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraalvmNativeApplication.class, args);
    }
}
