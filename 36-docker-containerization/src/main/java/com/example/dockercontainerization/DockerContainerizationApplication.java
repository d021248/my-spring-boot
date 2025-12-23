package com.example.dockercontainerization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Docker Containerization Demo Application
 * 
 * Dockerfile, layered jars, buildpacks
 * 
 * Port: 8116
 * Landing Page: http://localhost:8116
 */
@SpringBootApplication
public class DockerContainerizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerContainerizationApplication.class, args);
    }
}
