package com.example.testing.strategies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Landing page controller
 */
@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "index.html";
    }
}
