package com.upb.agripos;

import com.upb.agripos.Model.AlatPertanian;
import com.upb.agripos.Model.Benih;
import com.upb.agripos.Model.ObatHama;
import com.upb.agripos.Model.Produk;
import com.upb.agripos.Model.Pupuk; // Untuk latihan mandiri
import com.upb.agripos.Util.CreditBy;

public class MainPolymorphism {
    public static void main(String[] args) {
        
    
        Produk[] daftarProduk = {
            // Namun diisi oleh objek-objek Subclass
            new Benih("BKN-670", "Benih Padi Mapan", 40000, 110, "Mapan"),
            new Pupuk("PKK-191", "Pupuk Gramason", 300000, 35, "Gramason"),
            new AlatPertanian("JJA-551", "Pompa Air", 1000000, 10, "Besi"),
            new ObatHama("OBH-689", "Sandor", 50000, 60, "Wereng") // Latihan Mandiri
        };

        System.out.println("===  Daftar Info Produk (Demonstrasi Dynamic Binding) ===");
        
      
        for (Produk p : daftarProduk) {
            System.out.println(p.getInfo()); 
        }

 
        System.out.println("\n=== Demonstrasi Overloading tambahStok ===");
        Produk produkTes = daftarProduk[0]; 
        
        System.out.println("Stok awal: " + produkTes.getInfo()); 
        
        // Memanggil method tambahStok(int jumlah)
        produkTes.tambahStok(9); 
        
        // Memanggil method tambahStok(double jumlah)
        produkTes.tambahStok(7.8); 

        
        // 3. Panggil CreditBy
        System.out.println("\n----------");

        CreditBy.print("240202836", "Husain Stefano");
    }
}