package com.example.gama.repositories;

import java.util.List;
import java.util.Optional;

import com.example.gama.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository <Product, Long> {

    
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
        public Optional<Product> findProductByName(String name);

    @Query("SELECT p FROM Product p WHERE LOWER(p.category) LIKE LOWER(CONCAT('%', :category, '%'))")
        public List<Product> findProductByCategory(@Param("category") String category);
}
