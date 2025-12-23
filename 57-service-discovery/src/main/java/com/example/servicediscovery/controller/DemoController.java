package com.example.servicediscovery.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/demo")
    public Map<String, Object> demo() {
        return Map.of(
            "module", "Service Discovery",
            "port", 8137,
            "status", "active",
            "timestamp", new Date()
        );
    }
    
    @GetMapping("/info")
    public Map<String, String> info() {
        return Map.of(
            "name", "Service Discovery",
            "description", "Module 57 implementation"
        );
    }
}
