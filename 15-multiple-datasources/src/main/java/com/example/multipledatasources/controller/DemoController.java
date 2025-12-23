package com.example.multipledatasources.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.multipledatasources.config.TenantContext;
import com.example.multipledatasources.model.Product;
import com.example.multipledatasources.service.ProductService;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/demo")
    public Map<String, Object> demo() {
        return Map.of(
                "module", "Multiple DataSources",
                "port", 8095,
                "status", "active",
                "timestamp", new Date());
    }

    @GetMapping("/info")
    public Map<String, String> info() {
        return Map.of(
                "name", "Multiple DataSources",
                "description", "Module 15 implementation");
    }

    private final ProductService productService;

    public DemoController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Map<String, Object>> listProducts(@RequestHeader(value = "X-Tenant", required = false) String tenant) {
        try {
            if (tenant != null)
                TenantContext.setCurrentTenant(tenant);
            return productService.list().stream().map(p -> {
                Map<String, Object> m = new java.util.HashMap<>();
                m.put("id", p.getId());
                m.put("name", p.getName());
                return m;
            }).collect(Collectors.toList());
        } finally {
            TenantContext.clear();
        }
    }

    @PostMapping("/products")
    public Map<String, Object> createProduct(@RequestHeader(value = "X-Tenant", required = false) String tenant,
            @RequestBody Map<String, String> body) {
        try {
            if (tenant != null)
                TenantContext.setCurrentTenant(tenant);
            Product p = productService.create(body.getOrDefault("name", "unnamed"));
            return Map.of("id", p.getId(), "name", p.getName());
        } finally {
            TenantContext.clear();
        }
    }
}
