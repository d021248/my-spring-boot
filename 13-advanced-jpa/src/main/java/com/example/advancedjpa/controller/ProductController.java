package com.example.advancedjpa.controller;

import com.example.advancedjpa.entity.Product;
import com.example.advancedjpa.dto.ProductDTO;
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
