package com.budiluhur.product_catalog.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.budiluhur.product_catalog.exception.ProductNotFoundException;
import com.budiluhur.product_catalog.repository.ProductRepository;

class ProductServiceTest {

    private final ProductService service =
            new ProductService(new ProductRepository(), new DiscountService());

    @Test
    void hargaDiskonSepuluhPersenHarusBenar() throws Exception {
        double hasil = service.getDiscountedProductPrice("PRD-01", 10.0);
        assertEquals(405000.0, hasil, 0.001);
    }

    @Test
    void produkTidakAdaHarusMelemparException() {
        assertThrows(ProductNotFoundException.class,
                () -> service.getProductById("PRD-99"));
    }
}