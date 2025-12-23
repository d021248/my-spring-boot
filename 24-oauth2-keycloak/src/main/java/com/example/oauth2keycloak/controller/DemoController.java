package com.example.oauth2keycloak.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/demo")
    public Map<String, Object> demo() {
        return Map.of(
            "module", "OAuth2 Keycloak",
            "port", 8104,
            "status", "active",
            "timestamp", new Date()
        );
    }
    
    @GetMapping("/info")
    public Map<String, String> info() {
        return Map.of(
            "name", "OAuth2 Keycloak",
            "description", "Module 24 implementation"
        );
    }
}
