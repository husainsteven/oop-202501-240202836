package com.upb.agripos;

public class MainCart {
    public static void main(String[] args) {
        System.out.println("Hello, I am [HUSAIN STEFANO]-[240202836] (Week7)");

        Product p1 = new Product("P04", "Beras", 60000);
        Product p2 = new Product("P08", "Pupuk", 35000);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.printCart();

        cart.removeProduct(p1);
        cart.printCart();
    }
}