package com.example.multitenancy.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/demo")
    public Map<String, Object> demo() {
        return Map.of(
            "module", "Multitenancy",
            "port", 8133,
            "status", "active",
            "timestamp", new Date()
        );
    }
    
    @GetMapping("/info")
    public Map<String, String> info() {
        return Map.of(
            "name", "Multitenancy",
            "description", "Module 53 implementation"
        );
    }
}
