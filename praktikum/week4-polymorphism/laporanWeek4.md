# Laporan Praktikum Minggu 4
Topik: Polymorphism (Info Produk)

## Identitas
- Nama  : Husain Stefano
- NIM   : 240202836
- Kelas : 3IKRA

---

## Tujuan
- Mahasiswa mampu menjelaskan konsep polymorphism dalam OOP.
- Mahasiswa mampu membedakan method overloading dan overriding.
- Mahasiswa mampu mengimplementasikan polymorphism (overriding, overloading, dynamic binding) dalam program.
- Mahasiswa mampu menganalisis contoh kasus polymorphism pada sistem nyata (Agri-POS).

---

## Dasar Teori
Polymorphism berarti “banyak bentuk” dan memungkinkan objek yang berbeda merespons panggilan method yang sama dengan cara yang berbeda.

- Overloading → mendefinisikan method dengan nama sama tetapi parameter berbeda.
- Overriding → subclass mengganti implementasi method dari superclass.
- Dynamic Binding → pemanggilan method ditentukan saat runtime, bukan compile time.

Dalam konteks Agri-POS, misalnya:
- Method getInfo() pada Produk dioverride oleh Benih, Pupuk, AlatPertanian untuk menampilkan detail spesifik.
- Method tambahStok() bisa dibuat overload dengan parameter berbeda (int, double).

---

## Langkah Praktikum

1. Overloading
Tambahkan method tambahStok(int jumlah) dan tambahStok(double jumlah) pada class Produk.
Overriding

Tambahkan method getInfo() pada superclass Produk.
Override method getInfo() pada subclass Benih, Pupuk, dan AlatPertanian.
Dynamic Binding

Buat array Produk[] daftarProduk yang berisi objek Benih, Pupuk, dan AlatPertanian.
Loop array tersebut dan panggil getInfo(). Perhatikan bagaimana Java memanggil method sesuai jenis objek aktual.
Main Class

Buat MainPolymorphism.java untuk mendemonstrasikan overloading, overriding, dan dynamic binding.
CreditBy

Tetap panggil CreditBy.print("<NIM>", "<Nama>").
Commit dan Push

Commit dengan pesan: week4-polymorphism.

---

## Kode Program
Tuliskan kode utama yang dibuat, contoh:  

1. AlatPertanian.java

```java

package com.upb.agripos.Model;

public class AlatPertanian extends Produk {
    private final String bahan; 

    public AlatPertanian(String kode, String nama, double harga, int stok, String bahan) {
        super(kode, nama, harga, stok);
        this.bahan = bahan;
    }

    @Override
    public String getInfo() {
        return "AlatPertanian   : " + super.getInfo() + ", bahan: " + bahan;
    }
}


2. Benih.java

```java

package com.upb.agripos.Model;

public class Benih extends Produk {
    private String varietas;

    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    @Override
    public String getInfo() {
        return "Benih: " + super.getInfo() + ", Varietas: " + varietas;
    }


 3. ObatHama.java

 ```java

 package com.upb.agripos.Model;

public class ObatHama extends Produk {
    private final String targetHama; 

    public ObatHama(String kode, String nama, double harga, int stok, String targetHama) {
        super(kode, nama, harga, stok);
        this.targetHama = targetHama;
    }

    @Override
    public String getInfo() {
        return "ObatHama  : " + super.getInfo() + ", Target: " + targetHama;
    }
} 

 4. Produk.java

 ```java

 package com.upb.agripos.Model;

public class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public void tambahStok(double jumlah) {
        this.stok += (int) jumlah;
    }

    public String getInfo() {
        return "Produk: " + nama + " (Kode: " + kode + ")";
    }
}

 5. Pupuk.java

 ```java

 package com.upb.agripos.Model;

public class Pupuk extends Produk {
    private String jenis; 

    public Pupuk(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    @Override
    public String getInfo() {
        return "Pupuk  : " + super.getInfo() + ", Jenis: " + jenis;
    }
}

 6. CreditBy.java

 ```java

 package com.upb.agripos.Util;

public class CreditBy {
   
     public static void print(String nim, String nama) {
        System.out.println("\n=== Credit By ===");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("=================\n");
    }
}

 7. MianPolymorphsim.java

 ```java

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

---

## Hasil Eksekusi
  
(screenshots/week4.png)

---

## Analisis
- Cara Kerja Kode: Program utama (MainPolymorphism) menginisialisasi sebuah array Produk[] yang berisi empat objek subclass (Benih, Pupuk, AlatPertanian, ObatHama). Saat program melakukan iterasi pada array ini, variabel p memiliki tipe referensi Produk. Namun, ketika p.getInfo() dipanggil, Dynamic Binding terjadi: JVM memeriksa tipe objek aktual saat runtime dan memanggil method getInfo() yang telah di-override di subclass yang sesuai (misal, getInfo() milik Benih saat p menunjuk ke objek Benih).

- Demo Overloading: Program juga mendemonstrasikan Overloading dengan sukses. Pemanggilan produkTes.tambahStok(10) memanggil versi (int), dan produkTes.tambahStok(5.5) memanggil versi (double), yang terlihat jelas dari output cetak yang berbeda ((int) vs (dari double)).

- Perbedaan vs Minggu Sebelumnya: Minggu lalu (Inheritance) kita fokus pada mewarisi properti dan method. Minggu ini (Polymorphism), kita fokus pada mengubah perilaku method yang diwarisi tersebut (overriding) dan memperlakukan objek-objek berbeda seolah-olah mereka satu tipe yang sama (dynamic binding dalam array).

- Kendala: Tidak ada kendala signifikan. Kode berjalan sesuai ekspektasi. Implementasi Latihan Mandiri (ObatHama) juga berhasil diintegrasikan ke dalam array daftarProduk dan menampilkan output yang benar.

---

## Kesimpulan
Polymorphism memungkinkan kode yang lebih fleksibel dan mudah dipelihara. Kita dapat menulis kode generik (seperti loop for (Produk p : ...) ) yang dapat bekerja dengan berbagai objek subclass (Benih, Pupuk, dll) tanpa perlu mengetahui tipe spesifiknya.

---

## Quiz
1. Apa perbedaan overloading dan overriding?  
   Jawaban:Overloading adalah penggunaan beberapa method dengan nama yang sama dalam satu kelas, tetapi memiliki perbedaan pada jumlah atau tipe parameternya. Overloading diproses pada saat compile-time karena compiler menentukan metode mana yang digunakan berdasarkan parameter yang dikirim.
   Sementara itu, overriding adalah ketika subclass mendefinisikan ulang method yang sudah ada di superclass dengan nama dan parameter yang sama. Overriding diproses pada saat runtime, karena Java akan memilih method berdasarkan objek sebenarnya, bukan tipe referensinya.

2.  Bagaimana Java menentukan method mana yang dipanggil dalam dynamic binding?
    Jawaban:Dalam dynamic binding, Java menentukan method yang dijalankan berdasarkan tipe objek yang sebenarnya pada saat program berjalan. Meskipun referensi variabel menggunakan tipe superclass, Java tetap melihat objek nyata yang dihasilkan oleh new, kemudian memilih versi method yang sesuai dengan kelas objek tersebut. Dengan kata lain, pemanggilan method ditentukan saat runtime, bukan saat compile-time.

3. Berikan contoh kasus polymorphism dalam sistem POS selain produk pertanian. 
   Jawaban:Contoh yang mudah adalah pada sistem POS restoran. Misalnya ada kelas induk bernama MenuItem, kemudian subclass seperti Food, Drink, dan Dessert. Ketika sistem menghitung total belanja, semuanya dipanggil melalui referensi MenuItem, tetapi setiap objek akan menjalankan method calculatePrice() versi masing-masing. Makanan bisa punya pajak lebih besar, minuman mungkin punya biaya tambahan, sedangkan dessert bisa memiliki diskon khusus. Walaupun dipanggil melalui referensi yang sama, hasil perhitungan berbeda sesuai tipe objek yang sebenarnya. Itu adalah bentuk polymorphism dalam POS.
