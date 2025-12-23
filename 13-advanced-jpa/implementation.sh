#!/bin/bash
set -e

BASE_DIR="$(pwd)"
PACKAGE_DIR="src/main/java/com/example/advancedjpa"

echo "Implementing Module 13: Advanced JPA..."

# Create entity
cat > "${PACKAGE_DIR}/entity/Product.java" << 'JAVA'
package com.example.advancedjpa.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@NamedEntityGraph(
    name = "Product.withCategory",
    attributeNodes = @NamedAttributeNode("category")
)
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    private String description;
    
    @Column(nullable = false)
    private BigDecimal price;
    
    private Integer stock;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
JAVA

cat > "${PACKAGE_DIR}/entity/Category.java" << 'JAVA'
package com.example.advancedjpa.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
}
JAVA

# Create DTOs
mkdir -p "${PACKAGE_DIR}/dto"
cat > "${PACKAGE_DIR}/dto/ProductSummary.java" << 'JAVA'
package com.example.advancedjpa.dto;

import java.math.BigDecimal;

public interface ProductSummary {
    Long getId();
    String getName();
    BigDecimal getPrice();
    String getCategoryName();
}
JAVA

cat > "${PACKAGE_DIR}/dto/ProductDTO.java" << 'JAVA'
package com.example.advancedjpa.dto;

import java.math.BigDecimal;

public record ProductDTO(Long id, String name, BigDecimal price, Integer stock, String category) {}
JAVA

# Create specifications
mkdir -p "${PACKAGE_DIR}/specification"
cat > "${PACKAGE_DIR}/specification/ProductSpecifications.java" << 'JAVA'
package com.example.advancedjpa.specification;

import com.example.advancedjpa.entity.Product;
import org.springframework.data.jpa.domain.Specification;
import java.math.BigDecimal;

public class ProductSpecifications {
    
    public static Specification<Product> hasName(String name) {
        return (root, query, cb) -> 
            name == null ? cb.conjunction() : cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }
    
    public static Specification<Product> hasPriceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        return (root, query, cb) -> {
            if (minPrice != null && maxPrice != null) {
                return cb.between(root.get("price"), minPrice, maxPrice);
            } else if (minPrice != null) {
                return cb.greaterThanOrEqualTo(root.get("price"), minPrice);
            } else if (maxPrice != null) {
                return cb.lessThanOrEqualTo(root.get("price"), maxPrice);
            }
            return cb.conjunction();
        };
    }
    
    public static Specification<Product> hasCategory(String categoryName) {
        return (root, query, cb) -> 
            categoryName == null ? cb.conjunction() : 
                cb.equal(root.join("category").get("name"), categoryName);
    }
}
JAVA

# Create repository
mkdir -p "${PACKAGE_DIR}/repository"
cat > "${PACKAGE_DIR}/repository/ProductRepository.java" << 'JAVA'
package com.example.advancedjpa.repository;

import com.example.advancedjpa.entity.Product;
import com.example.advancedjpa.dto.ProductSummary;
import com.example.advancedjpa.dto.ProductDTO;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    
    // Projection interface
    List<ProductSummary> findByPriceGreaterThan(BigDecimal price);
    
    // Projection class (DTO)
    @Query("SELECT new com.example.advancedjpa.dto.ProductDTO(p.id, p.name, p.price, p.stock, c.name) " +
           "FROM Product p LEFT JOIN p.category c")
    List<ProductDTO> findAllProductDTOs();
    
    // Entity Graph
    @EntityGraph(value = "Product.withCategory", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findExpensiveProductsWithCategory(@Param("price") BigDecimal price);
    
    // Native query
    @Query(value = "SELECT * FROM products WHERE stock < :threshold", nativeQuery = true)
    List<Product> findLowStockProducts(@Param("threshold") int threshold);
}
JAVA

cat > "${PACKAGE_DIR}/repository/CategoryRepository.java" << 'JAVA'
package com.example.advancedjpa.repository;

import com.example.advancedjpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
JAVA

# Create service
mkdir -p "${PACKAGE_DIR}/service"
cat > "${PACKAGE_DIR}/service/ProductService.java" << 'JAVA'
package com.example.advancedjpa.service;

import com.example.advancedjpa.entity.Product;
import com.example.advancedjpa.dto.ProductDTO;
import com.example.advancedjpa.dto.ProductSummary;
import com.example.advancedjpa.repository.ProductRepository;
import com.example.advancedjpa.specification.ProductSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductService {
    
    private final ProductRepository productRepository;
    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public List<Product> searchProducts(String name, BigDecimal minPrice, BigDecimal maxPrice, String category) {
        Specification<Product> spec = Specification.where(ProductSpecifications.hasName(name))
                .and(ProductSpecifications.hasPriceBetween(minPrice, maxPrice))
                .and(ProductSpecifications.hasCategory(category));
        return productRepository.findAll(spec);
    }
    
    public List<ProductSummary> getExpensiveProducts(BigDecimal price) {
        return productRepository.findByPriceGreaterThan(price);
    }
    
    public List<ProductDTO> getAllProductDTOs() {
        return productRepository.findAllProductDTOs();
    }
    
    public List<Product> getExpensiveProductsWithCategory(BigDecimal price) {
        return productRepository.findExpensiveProductsWithCategory(price);
    }
    
    public List<Product> getLowStockProducts(int threshold) {
        return productRepository.findLowStockProducts(threshold);
    }
}
JAVA

# Create controller
cat > "${PACKAGE_DIR}/controller/ProductController.java" << 'JAVA'
package com.example.advancedjpa.controller;

import com.example.advancedjpa.entity.Product;
import com.example.advancedjpa.dto.ProductDTO;
import com.example.advancedjpa.dto.ProductSummary;
import com.example.advancedjpa.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    private final ProductService productService;
    
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping("/search")
    public List<Product> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) String category) {
        return productService.searchProducts(name, minPrice, maxPrice, category);
    }
    
    @GetMapping("/expensive")
    public List<ProductSummary> getExpensive(@RequestParam BigDecimal price) {
        return productService.getExpensiveProducts(price);
    }
    
    @GetMapping("/dto")
    public List<ProductDTO> getAllDTOs() {
        return productService.getAllProductDTOs();
    }
    
    @GetMapping("/with-category")
    public List<Product> getExpensiveWithCategory(@RequestParam BigDecimal price) {
        return productService.getExpensiveProductsWithCategory(price);
    }
    
    @GetMapping("/low-stock")
    public List<Product> getLowStock(@RequestParam(defaultValue = "10") int threshold) {
        return productService.getLowStockProducts(threshold);
    }
}
JAVA

# Create data initializer
cat > "${PACKAGE_DIR}/config/DataInitializer.java" << 'JAVA'
package com.example.advancedjpa.config;

import com.example.advancedjpa.entity.Category;
import com.example.advancedjpa.entity.Product;
import com.example.advancedjpa.repository.CategoryRepository;
import com.example.advancedjpa.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;

@Configuration
public class DataInitializer {
    
    @Bean
    CommandLineRunner initDatabase(CategoryRepository categoryRepo, ProductRepository productRepo) {
        return args -> {
            // Create categories
            Category electronics = new Category();
            electronics.setName("Electronics");
            categoryRepo.save(electronics);
            
            Category books = new Category();
            books.setName("Books");
            categoryRepo.save(books);
            
            // Create products
            Product laptop = new Product();
            laptop.setName("Laptop");
            laptop.setDescription("High-performance laptop");
            laptop.setPrice(new BigDecimal("1299.99"));
            laptop.setStock(15);
            laptop.setCategory(electronics);
            productRepo.save(laptop);
            
            Product phone = new Product();
            phone.setName("Smartphone");
            phone.setDescription("Latest model");
            phone.setPrice(new BigDecimal("899.99"));
            phone.setStock(5);
            phone.setCategory(electronics);
            productRepo.save(phone);
            
            Product book = new Product();
            book.setName("Spring Boot Guide");
            book.setDescription("Comprehensive guide");
            book.setPrice(new BigDecimal("49.99"));
            book.setStock(50);
            book.setCategory(books);
            productRepo.save(book);
        };
    }
}
JAVA

# Update application.properties
cat > "src/main/resources/application.properties" << 'PROPS'
# Advanced JPA Configuration
spring.application.name=Advanced JPA
server.port=8093

# H2 Database
spring.datasource.url=jdbc:h2:mem:advancedjpa
spring.datasource.driverClassName=org.h2.Driver
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=create-drop

# Actuator
management.endpoints.web.exposure.include=health,info,metrics
PROPS

echo "✅ Module 13 implementation complete!"

