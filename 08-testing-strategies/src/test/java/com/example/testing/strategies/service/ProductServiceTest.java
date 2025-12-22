package com.example.testing.strategies.service;

import com.example.testing.strategies.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration Test Example with @SpringBootTest
 * 
 * Demonstrates:
 * - @SpringBootTest for full application context
 * - @Autowired for dependency injection in tests
 * - Testing service layer with real Spring beans
 */
@SpringBootTest
@DisplayName("Product Service Integration Tests")
class ProductServiceTest {
    
    @Autowired
    private ProductService productService;
    
    @Test
    @DisplayName("Should find all products")
    void testFindAll() {
        List<Product> products = productService.findAll();
        assertNotNull(products);
        assertTrue(products.size() >= 3, "Should have at least 3 initial products");
    }
    
    @Test
    @DisplayName("Should find product by ID")
    void testFindById() {
        Optional<Product> product = productService.findById(1L);
        assertTrue(product.isPresent());
        assertEquals("Laptop", product.get().name());
    }
    
    @Test
    @DisplayName("Should return empty when product not found")
    void testFindByIdNotFound() {
        Optional<Product> product = productService.findById(999L);
        assertTrue(product.isEmpty());
    }
    
    @Test
    @DisplayName("Should create new product")
    void testSave() {
        Product newProduct = new Product(null, "Monitor", 299.99);
        Product saved = productService.save(newProduct);
        
        assertNotNull(saved.id());
        assertEquals("Monitor", saved.name());
        assertEquals(299.99, saved.price(), 0.001);
    }
    
    @Test
    @DisplayName("Should delete product by ID")
    void testDeleteById() {
        int initialSize = productService.findAll().size();
        productService.deleteById(1L);
        
        List<Product> products = productService.findAll();
        assertEquals(initialSize - 1, products.size());
        assertTrue(productService.findById(1L).isEmpty());
    }
}
