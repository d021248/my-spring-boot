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
