package com.example.advancedjpa.service;

import com.example.advancedjpa.entity.Product;
import com.example.advancedjpa.dto.ProductDTO;
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
