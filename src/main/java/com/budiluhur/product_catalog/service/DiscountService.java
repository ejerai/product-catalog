package com.budiluhur.product_catalog.service;

import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    public double calculateDiscountedPrice(double originalPrice, double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Diskon harus antara 0 dan 100 persen");
        }
        return originalPrice - (originalPrice * discountPercentage / 100);
    }
}