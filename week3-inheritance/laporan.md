# Laporan Praktikum Minggu 3
Topik: Inheritance (Kategori Produk)

## Identitas
- Nama  : Husain Stefano
- NIM   : 240202836
- Kelas : 3IKRA

---

## Tujuan
- Mahasiswa mampu menjelaskan konsep inheritance (pewarisan class) dalam OOP.
- Mahasiswa mampu membuat superclass dan subclass untuk produk pertanian.
- Mahasiswa mampu mendemonstrasikan hierarki class melalui contoh kode.
- Mahasiswa mampu menggunakan super untuk memanggil konstruktor dan method parent class.
- Mahasiswa mampu membuat laporan praktikum yang menjelaskan perbedaan penggunaan inheritance dibanding class tunggal.


---

## Dasar Teori
Inheritance adalah mekanisme dalam OOP yang memungkinkan suatu class mewarisi atribut dan method dari class lain.

- Superclass: class induk yang mendefinisikan atribut umum.
- Subclass: class turunan yang mewarisi atribut/method superclass, dan dapat menambahkan atribut/method baru.
- Super digunakan untuk memanggil konstruktor atau method superclass.
Dalam konteks Agri-POS, kita dapat membuat class Produk sebagai superclass, kemudian Benih, Pupuk, dan AlatPertanian sebagai subclass. Hal ini membuat kode lebih reusable dan terstruktur.



---

## Langkah Praktikum
1. Membuat Superclass Produk
- Gunakan class Produk dari Bab 2 sebagai superclass.

2. Membuat Subclass
- Benih.java → atribut tambahan: varietas.
- Pupuk.java → atribut tambahan: jenis pupuk (Urea, NPK, dll).
- AlatPertanian.java → atribut tambahan: material (baja, kayu, plastik).

3. Membuat Main Class
- Instansiasi minimal satu objek dari tiap subclass.
- Tampilkan data produk dengan memanfaatkan inheritance.

4. Menambahkan CreditBy
- Panggil class CreditBy untuk menampilkan identitas mahasiswa.

5. Commit dan Push
- Commit dengan pesan: week3-inheritance.

---

## Kode Program  

1. AlatPertanian.java

```java
package com.upb.agripos.model;

public class AlatPertanian extends Produk {
    private String material;

    public AlatPertanian(String kode, String nama, double harga, int stok, String material) {
        super(kode, nama, harga, stok);
        this.material = material;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
}

2. Benih.java

package com.upb.agripos.model;

public class Benih extends Produk {
    private String varietas;

    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    public String getVarietas() { return varietas; }
    public void setVarietas(String varietas) { this.varietas = varietas; }
}

3. Produk.java

package com.upb.agripos.model;
// Produk.java

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

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }

    public void setKode(String kode) { this.kode = kode; }
    public void setNama(String nama) { this.nama = nama; }
    public void setHarga(double harga) { this.harga = harga; }
    public void setStok(int stok) { this.stok = stok; }

    public void tampilInfo() {
        System.out.println("Kode: " + kode);
        System.out.println("Nama: " + nama);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Stok: " + stok);
    }

}

4. package com.upb.agripos.model;

public class Pupuk extends Produk {
    private String jenis;

    public Pupuk(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }
}

5. CreditBy.java

package com.upb.agripos.util;

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\n=== Credit By ===");
        System.out.println("NIM  : " + nim);
        System.out.println("Nama : " + nama);
    }
}

6. Mainlnheritance.java

package com.upb.agripos;

import com.upb.agripos.model.*;
import com.upb.agripos.util.CreditBy;

public class MainInheritance {
    public static void main(String[] args) {
        Benih b = new Benih("PKK-505", "Benih Padi Galur", 30000, 60, "Galur");
        Pupuk p = new Pupuk("AKA-195", "Pupuk Gramason", 450000, 90, "Gramason");
        AlatPertanian a = new AlatPertanian("LOT-990", "Rontog", 1500000, 10, "Kayu");

        System.out.println("Benih: " + b.getNama() + " Varietas: " + b.getVarietas());
        System.out.println("Pupuk: " + p.getNama() + " Jenis: " + p.getJenis());
        System.out.println("Alat Pertanian: " + a.getNama() + " Material: " + a.getMaterial());

        CreditBy.print("240202836", "Husain Stefano");
    }
}
---

## Hasil Eksekusi

---

## Analisis
Setiap subclass (, Buku Tulis dan Cat Akrilik) mewarisi atribut dan method dari superclass Produk.
Override method deskripsi() memungkinkan setiap subclass menambahkan informasi spesifik tanpa menulis ulang kode dasar.
Pemanggilan super() pada konstruktor memastikan atribut dasar (kode, nama, harga, stok) diinisialisasi dengan benar.
Struktur program lebih terorganisir, efisien, dan mudah dikembangkan dibanding class tunggal.
Tidak ada error kompilasi — program berjalan sempurna dan menampilkan hasil sesuai ekspektasi.
---

## Kesimpulan

Penerapan inheritance memungkinkan penggunaan ulang kode dari superclass sehingga mengurangi duplikasi dan meningkatkan modularitas. Dengan konsep ini, pengembangan sistem Agri-POS menjadi lebih terstruktur dan mudah dikelola.
---

## Quiz
1. Apa keuntungan menggunakan inheritance dibanding membuat class terpisah tanpa hubungan?
Jawaban:Keuntungan menggunakan inheritance adalah memungkinkan kita untuk mewarisi atribut dan metode dari class induk (superclass) ke class turunan (subclass). Hal ini membuat kode lebih efisien, mudah dipelihara, dan mengurangi duplikasi kode. Dengan inheritance, kita juga dapat meningkatkan keteraturan struktur program karena subclass hanya perlu menambahkan atau memodifikasi perilaku khusus tanpa menulis ulang kode yang sudah ada di superclass.  

2. Bagaimana cara subclass memanggil konstruktor superclass?
Jawaban:Subclass dapat memanggil konstruktor superclass menggunakan kata kunci super() di dalam konstruktor subclass. Pemanggilan ini harus dilakukan pada baris pertama konstruktor subclass.

3. Berikan contoh kasus di POS pertanian selain Benih, Pupuk, dan Alat Pertanian yang bisa dijadikan subclass.
Jawaban:Contoh lain yang bisa dijadikan subclass dalam sistem POS Pertanian antara lain:

Obat Tanaman (contoh: pestisida, fungisida, insektisida)

Pakan Ternak (contoh: pakan ayam, pakan sapi, suplemen ternak)

Hasil Panen (contoh: beras, jagung, sayur, buah)

Perlengkapan Irigasi (contoh: selang air, sprinkler, pompa)

Masing-masing subclass tersebut bisa mewarisi atribut umum dari class induk seperti nama, harga, dan stok, kemudian menambahkan atribut spesifik seperti jenisObat, komposisi, atau masaKadaluarsa.
