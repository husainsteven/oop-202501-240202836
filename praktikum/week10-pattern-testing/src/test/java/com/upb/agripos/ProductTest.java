package com.upb.agripos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.upb.agripos.model.Product;

public class ProductTest {
    @Test
    public void testProductName() {
        Product p = new Product("P01", "Benih Jagung");
        assertEquals("Benih Jagung", p.getName());
    }

    @Test
    public void testProductCode() {
        Product p = new Product("P01", "Benih Jagung");
        assertEquals("P01", p.getCode());
    }

    @Test
    public void testProductNotNull() {
        Product p = new Product("P02", "Pupuk Urea");
        assertNotNull(p);
        assertNotNull(p.getCode());
        assertNotNull(p.getName());
    }
}
