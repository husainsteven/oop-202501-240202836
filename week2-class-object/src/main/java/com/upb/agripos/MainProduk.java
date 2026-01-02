package com.upb.agripos;

import com.upb.agripos.model.Produk;
import com.upb.agripos.util.CreditBy;

public class MainProduk {
    public static void main(String[] args) {
        Produk p1 = new Produk("SKT-201", "Keripik Pedas", 15000, 50);
        Produk p2 = new Produk("TDR-300", "Donat Coklat", 5000, 20);
        Produk p3 = new Produk("BMW-505", "Hotwheels", 90000, 15);
        Produk p4 = new Produk("SKS-905", "Roti Aoka", 2500, 10);

        System.out.println("Kode: " + p1.getKode() + ", Nama: " + p1.getNama() + ", Harga: " + p1.getHarga() + ", Stok: " + p1.getStok());
        System.out.println("Kode: " + p2.getKode() + ", Nama: " + p2.getNama() + ", Harga: " + p2.getHarga() + ", Stok: " + p2.getStok());
        System.out.println("Kode: " + p3.getKode() + ", Nama: " + p3.getNama() + ", Harga: " + p3.getHarga() + ", Stok: " + p3.getStok());
        System.out.println("Kode: " + p4.getKode() + ", Nama: " + p4.getNama() + ", Harga: " + p4.getHarga() + ", Stok: " + p4.getStok());

        System.out.println("\n=== PERUBAHAN STOK ===");
        p1.tambahStok(15); p1.kurangiStok(45);
        p2.tambahStok(12);
        p3.kurangiStok(7);

        System.out.println("Setelah perubahan:");
        System.out.println(p1.getKode() + " stok sekarang: " + p1.getStok());
        System.out.println(p2.getNama() + " stok sekarang: " + p2.getStok());
        System.out.println(p3.getNama() + " stok sekarang: " + p3.getStok());


        // Tampilkan identitas mahasiswa
        CreditBy.print("240202836", "HUSAIN STEFANO");
    }
}