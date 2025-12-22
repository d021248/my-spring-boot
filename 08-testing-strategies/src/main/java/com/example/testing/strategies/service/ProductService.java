package com.example.testing.strategies.service;

import com.example.testing.strategies.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Product service for demonstrating integration testing
 */
@Service
public class ProductService {
    
    private final List<Product> products = new ArrayList<>();
    private Long nextId = 1L;
    
    public ProductService() {
        // Initialize with some sample data
        products.add(new Product(nextId++, "Laptop", 999.99));
        products.add(new Product(nextId++, "Mouse", 29.99));
        products.add(new Product(nextId++, "Keyboard", 79.99));
    }
    
    public List<Product> findAll() {
        return new ArrayList<>(products);
    }
    
    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> p.id().equals(id))
                .findFirst();
    }
    
    public Product save(Product product) {
        Product newProduct = new Product(nextId++, product.name(), product.price());
        products.add(newProduct);
        return newProduct;
    }
    
    public void deleteById(Long id) {
        products.removeIf(p -> p.id().equals(id));
    }
}
