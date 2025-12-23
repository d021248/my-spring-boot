package com.example.advancedjpa.repository;

import com.example.advancedjpa.entity.Product;
import com.example.advancedjpa.dto.ProductDTO;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    @Query("SELECT new com.example.advancedjpa.dto.ProductDTO(p.id, p.name, p.price, p.stock, c.name) " +
           "FROM Product p LEFT JOIN p.category c")
    List<ProductDTO> findAllProductDTOs();

    @EntityGraph(value = "Product.withCategory", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findExpensiveProductsWithCategory(@Param("price") BigDecimal price);

    @Query(value = "SELECT * FROM products WHERE stock < :threshold", nativeQuery = true)
    List<Product> findLowStockProducts(@Param("threshold") int threshold);
}
