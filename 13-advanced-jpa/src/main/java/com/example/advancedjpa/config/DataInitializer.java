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
            Category electronics = new Category();
            electronics.setName("Electronics");
            categoryRepo.save(electronics);

            Category books = new Category();
            books.setName("Books");
            categoryRepo.save(books);

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
