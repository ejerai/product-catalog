package com.budiluhur.product_catalog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.budiluhur.product_catalog.model.Product;
import com.budiluhur.product_catalog.repository.ProductRepository;

@SpringBootApplication
public class ProductCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCatalogApplication.class, args);
    }

    // Data seeding: mengisi data awal ke database saat aplikasi start
    @Bean
    public CommandLineRunner initData(ProductRepository repository) {
        return args -> {
            repository.save(new Product("PRD-01", "Keyboard Mechanical", 450000.0));
            repository.save(new Product("PRD-02", "Mouse Wireless Silent", 175000.0));
            repository.save(new Product("PRD-03", "Monitor Gaming 24 Inch", 2100000.0));
            System.out.println("Data awal berhasil disimpan!");
        };
    }
}