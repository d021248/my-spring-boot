package com.example.multipledatasources.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.multipledatasources.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
