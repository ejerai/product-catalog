package com.budiluhur.product_catalog.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.budiluhur.product_catalog.exception.ProductNotFoundException;
import com.budiluhur.product_catalog.model.Product;
import com.budiluhur.product_catalog.repository.ProductRepository;

class ProductServiceTest {

    private ProductRepository repository;
    private ProductService service;

    @BeforeEach
    void setUp() {
        // ProductRepository sekarang interface, jadi kita "mock" (tiruan) tanpa
        // database
        repository = mock(ProductRepository.class);
        service = new ProductService(repository, new DiscountService());
    }

    @Test
    void hargaDiskonSepuluhPersenHarusBenar() throws Exception {
        when(repository.findById("PRD-01"))
                .thenReturn(Optional.of(new Product("PRD-01", "Keyboard Mechanical", 450000.0)));

        double hasil = service.getDiscountedProductPrice("PRD-01", 10.0);
        assertEquals(405000.0, hasil, 0.001);
    }

    @Test
    void produkTidakAdaHarusMelemparException() {
        when(repository.findById("PRD-99")).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class,
                () -> service.getProductById("PRD-99"));
    }
}