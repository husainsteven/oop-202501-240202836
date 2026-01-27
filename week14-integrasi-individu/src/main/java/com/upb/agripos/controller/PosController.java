package com.upb.agripos.controller;

import java.util.List;

import com.upb.agripos.exception.InvalidInputException;
import com.upb.agripos.model.CartItem;
import com.upb.agripos.model.Product;
import com.upb.agripos.service.CartService;
import com.upb.agripos.service.ProductService;

public class PosController {
    private ProductService productService;
    private CartService cartService;

    public PosController() {
        this.productService = new ProductService();
        this.cartService = new CartService();
    }

    // === PRODUCT OPERATIONS ===
    
    public void addProduct(String code, String name, String priceStr, String stockStr) throws Exception {
        productService.addProduct(code, name, priceStr, stockStr);
    }

    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    public void deleteProduct(String code) throws InvalidInputException {
        if (code == null || code.isEmpty()) {
            throw new InvalidInputException("Kode produk tidak boleh kosong!");
        }
        productService.deleteProduct(code);
    }

    // === CART OPERATIONS ===
    
    public void addToCart(Product product, int quantity) throws InvalidInputException {
        cartService.addToCart(product, quantity);
    }

    public void removeFromCart(String productCode) throws InvalidInputException {
        cartService.removeFromCart(productCode);
    }

    public void clearCart() {
        cartService.clearCart();
    }

    public List<CartItem> getCartItems() {
        return cartService.getCartItems();
    }

    public double getCartTotal() {
        return cartService.calculateTotal();
    }

    public int getTotalItemsInCart() {
        return cartService.getTotalItems();
    }

    public boolean isCartEmpty() {
        return cartService.isCartEmpty();
    }

    // === CHECKOUT ===
    
    public void checkout() throws InvalidInputException {
        if (cartService.isCartEmpty()) {
            throw new InvalidInputException("Keranjang masih kosong!");
        }
        
        // TODO: Bisa tambah logika simpan transaksi ke database
        
        // Clear cart setelah checkout
        cartService.clearCart();
    }
}