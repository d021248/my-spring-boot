package com.example.kubernetesdeployment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Kubernetes Deployment Demo Application
 * 
 * K8s manifests, health probes
 * 
 * Port: 8117
 * Landing Page: http://localhost:8117
 */
@SpringBootApplication
public class KubernetesDeploymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(KubernetesDeploymentApplication.class, args);
    }
}
