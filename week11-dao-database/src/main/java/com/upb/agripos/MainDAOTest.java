package com.upb.agripos;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.model.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List; // Tambahkan import ini untuk findAll()

public class MainDAOTest {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/agripos",
            "postgres",
            "12345 "
        );

        ProductDAO dao = new ProductDAOImpl(conn);

        // --- LANGKAH PEMBERSIHAN (Sangat Penting untuk Tes Ulang) ---
        // Menghapus data P02 jika sudah ada dari running sebelumnya
        dao.delete("P02"); 

        // 1. Create (Insert)
        System.out.println("=== 1. INSERT DATA ===");
        dao.insert(new Product("P02", "Pupuk Organik", 25000, 10));
        System.out.println("Produk P02 berhasil ditambah.");

        // 2. Read (Find All)
        System.out.println("\n=== 2. READ ALL DATA ===");
        List<Product> allProducts = dao.findAll();
        for (Product item : allProducts) {
            System.out.println("- " + item.getName() + " (" + item.getCode() + ")");
        }

        // 3. Update
        System.out.println("\n=== 3. UPDATE DATA ===");
        dao.update(new Product("P02", "Pupuk Organik Premium", 30000, 8));
        System.out.println("Produk P02 berhasil diubah.");

        // 4. Read (Find by Code)
        System.out.println("\n=== 4. FIND BY CODE ===");
        Product p = dao.findByCode("P02");
        if (p != null) {
            System.out.println("Data ditemukan: " + p.getName() + " - Harga: " + p.getPrice());
        }

        // 5. Delete (Opsional: Aktifkan jika ingin tabel kosong setelah tes)
        // System.out.println("\n=== 5. DELETE DATA ===");
        // dao.delete("P02");
        // System.out.println("Produk P02 berhasil dihapus.");

        conn.close();
        System.out.println("\nKoneksi ditutup. Praktikum Bab 11 Selesai!");
    }
}