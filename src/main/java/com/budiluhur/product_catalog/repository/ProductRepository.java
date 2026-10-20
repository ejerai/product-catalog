package com.budiluhur.product_catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.budiluhur.product_catalog.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}