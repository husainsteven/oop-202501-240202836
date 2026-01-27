package com.upb.agripos.service;

import java.util.List;

import com.upb.agripos.exception.InvalidInputException;
import com.upb.agripos.model.Cart;
import com.upb.agripos.model.CartItem;
import com.upb.agripos.model.Product;

public class CartService {
    private Cart cart;

    public CartService() {
        this.cart = new Cart();
    }

    public void addToCart(Product product, int quantity) throws InvalidInputException {
        if (product == null) {
            throw new InvalidInputException("Produk tidak boleh null!");
        }
        if (quantity <= 0) {
            throw new InvalidInputException("Quantity harus lebih dari 0!");
        }
        if (quantity > product.getStock()) {
            throw new InvalidInputException("Stok tidak mencukupi! Stok tersedia: " + product.getStock());
        }
        
        cart.addItem(product, quantity);
    }

    public void removeFromCart(String productCode) throws InvalidInputException {
        if (productCode == null || productCode.isEmpty()) {
            throw new InvalidInputException("Kode produk tidak valid!");
        }
        cart.removeItem(productCode);
    }

    public void clearCart() {
        cart.clear();
    }

    public double calculateTotal() {
        return cart.getTotal();
    }

    public List<CartItem> getCartItems() {
        return cart.getItems();
    }

    public int getTotalItems() {
        return cart.getTotalItems();
    }

    public boolean isCartEmpty() {
        return cart.isEmpty();
    }

    public Cart getCart() {
        return cart;
    }
}