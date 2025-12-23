package com.example.kubernetesdeployment.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/demo")
    public Map<String, Object> demo() {
        return Map.of(
            "module", "Kubernetes Deployment",
            "port", 8117,
            "status", "active",
            "timestamp", new Date()
        );
    }
    
    @GetMapping("/info")
    public Map<String, String> info() {
        return Map.of(
            "name", "Kubernetes Deployment",
            "description", "Module 37 implementation"
        );
    }
}
