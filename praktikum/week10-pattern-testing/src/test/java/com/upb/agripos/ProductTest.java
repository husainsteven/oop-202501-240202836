package com.upb.agripos;

import com.upb.agripos.model.Product;

/**
 * Unit Test untuk Product class
 * Menggunakan Java built-in assertions (tidak memerlukan library eksternal)
 */
public class ProductTest {
    
    /**
     * Test 1: Verifikasi bahwa getName() mengembalikan nama produk yang benar
     */
    public static void testProductName() {
        Product p = new Product("P01", "Benih Jagung");
        assert "Benih Jagung".equals(p.getName()) : "Nama produk tidak sesuai";
        System.out.println("✓ testProductName PASSED");
    }

    /**
     * Test 2: Verifikasi bahwa getCode() mengembalikan kode produk yang benar
     */
    public static void testProductCode() {
        Product p = new Product("P01", "Benih Jagung");
        assert "P01".equals(p.getCode()) : "Kode produk tidak sesuai";
        System.out.println("✓ testProductCode PASSED");
    }

    /**
     * Test 3: Verifikasi bahwa Product dan propertinya tidak null
     */
    public static void testProductNotNull() {
        Product p = new Product("P02", "Pupuk Urea");
        assert p != null : "Product adalah null";
        assert p.getCode() != null : "Kode produk adalah null";
        assert p.getName() != null : "Nama produk adalah null";
        System.out.println("✓ testProductNotNull PASSED");
    }
    
    /**
     * Test 4: Verifikasi data produk lengkap
     */
    public static void testProductComplete() {
        Product p = new Product("P03", "Pestisida Organik");
        assert "P03".equals(p.getCode()) : "Kode produk tidak sesuai";
        assert "Pestisida Organik".equals(p.getName()) : "Nama produk tidak sesuai";
        assert p != null : "Product adalah null";
        System.out.println("✓ testProductComplete PASSED");
    }
    
    /**
     * Main method untuk menjalankan semua test
     */
    public static void main(String[] args) {
        System.out.println("===== UNIT TEST PRODUCT =====\n");
        try {
            testProductName();
            testProductCode();
            testProductNotNull();
            testProductComplete();
            System.out.println("\n===== SEMUA TEST BERHASIL =====");
        } catch (AssertionError e) {
            System.out.println("\n✗ TEST GAGAL: " + e.getMessage());
            System.exit(1);
        }
    }
}
