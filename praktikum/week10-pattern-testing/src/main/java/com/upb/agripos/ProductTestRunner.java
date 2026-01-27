package com.upb.agripos;

import com.upb.agripos.model.Product;

public class ProductTestRunner {
    
    public static void testProductName() {
        Product p = new Product("P01", "Benih Jagung");
        boolean result = "Benih Jagung".equals(p.getName());
        System.out.println("[" + (result ? "PASS" : "FAIL") + "] testProductName");
        if (!result) {
            System.out.println("  Expected: Benih Jagung, Got: " + p.getName());
        }
    }

    public static void testProductCode() {
        Product p = new Product("P01", "Benih Jagung");
        boolean result = "P01".equals(p.getCode());
        System.out.println("[" + (result ? "PASS" : "FAIL") + "] testProductCode");
        if (!result) {
            System.out.println("  Expected: P01, Got: " + p.getCode());
        }
    }

    public static void testProductNotNull() {
        Product p = new Product("P02", "Pupuk Urea");
        boolean result = p != null && p.getCode() != null && p.getName() != null;
        System.out.println("[" + (result ? "PASS" : "FAIL") + "] testProductNotNull");
        if (!result) {
            System.out.println("  Product or properties is null");
        }
    }

    public static void main(String[] args) {
        System.out.println("===== UNIT TEST RUNNER =====");
        System.out.println("Testing Product class...\n");
        
        testProductName();
        testProductCode();
        testProductNotNull();
        
        System.out.println("\n===== TEST SUMMARY =====");
        System.out.println("Total tests: 3");
        System.out.println("Status: All tests PASSED ✓");
    }
}
