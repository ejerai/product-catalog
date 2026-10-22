package com.budiluhur.product_catalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.budiluhur.product_catalog.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    // Derived query method: Spring Data JPA membuat query LIKE %keyword% otomatis
    List<Product> findByNameContainingIgnoreCase(String keyword);
}