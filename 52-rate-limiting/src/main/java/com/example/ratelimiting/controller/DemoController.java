package com.example.ratelimiting.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/demo")
    public Map<String, Object> demo() {
        return Map.of(
            "module", "Rate Limiting",
            "port", 8132,
            "status", "active",
            "timestamp", new Date()
        );
    }
    
    @GetMapping("/info")
    public Map<String, String> info() {
        return Map.of(
            "name", "Rate Limiting",
            "description", "Module 52 implementation"
        );
    }
}
