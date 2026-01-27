package com.upb.agripos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.upb.agripos.exception.InvalidInputException;
import com.upb.agripos.model.Product;
import com.upb.agripos.service.CartService;

class CartServiceTest {
    private CartService cartService;
    private Product testProduct;

    @BeforeEach
    void setUp() {
        cartService = new CartService();
        testProduct = new Product("P001", "Benih Padi", 50000.0, 100);
    }

    @Test
    void testAddToCart_Success() throws InvalidInputException {
        cartService.addToCart(testProduct, 5);
        
        assertEquals(5, cartService.getTotalItems());
        assertEquals(250000.0, cartService.calculateTotal(), 0.01);
        assertFalse(cartService.isCartEmpty());
    }

    @Test
    void testAddToCart_InvalidQuantity() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            cartService.addToCart(testProduct, 0);
        });
        
        assertEquals("Quantity harus lebih dari 0!", exception.getMessage());
    }

    @Test
    void testAddToCart_ExceedStock() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            cartService.addToCart(testProduct, 150);
        });
        
        assertTrue(exception.getMessage().contains("Stok tidak mencukupi"));
    }

    @Test
    void testAddToCart_NullProduct() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            cartService.addToCart(null, 5);
        });
        
        assertEquals("Produk tidak boleh null!", exception.getMessage());
    }

    @Test
    void testRemoveFromCart_Success() throws InvalidInputException {
        cartService.addToCart(testProduct, 5);
        cartService.removeFromCart("P001");
        
        assertTrue(cartService.isCartEmpty());
        assertEquals(0, cartService.getTotalItems());
    }

    @Test
    void testClearCart() throws InvalidInputException {
        cartService.addToCart(testProduct, 5);
        cartService.clearCart();
        
        assertTrue(cartService.isCartEmpty());
        assertEquals(0.0, cartService.calculateTotal(), 0.01);
    }

    @Test
    void testMultipleProducts() throws InvalidInputException {
        Product product2 = new Product("P002", "Pupuk", 30000.0, 50);
        
        cartService.addToCart(testProduct, 2);
        cartService.addToCart(product2, 3);
        
        assertEquals(5, cartService.getTotalItems());
        assertEquals(190000.0, cartService.calculateTotal(), 0.01);
    }

    @Test
    void testAddSameProductTwice() throws InvalidInputException {
        cartService.addToCart(testProduct, 2);
        cartService.addToCart(testProduct, 3);
        
        assertEquals(5, cartService.getTotalItems());
        assertEquals(1, cartService.getCartItems().size());
    }
}