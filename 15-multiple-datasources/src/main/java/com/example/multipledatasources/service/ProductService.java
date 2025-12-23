package com.example.multipledatasources.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.multipledatasources.model.Product;
import com.example.multipledatasources.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Product create(String name) {
        return repo.save(new Product(name));
    }

    public List<Product> list() {
        return repo.findAll();
    }
}
