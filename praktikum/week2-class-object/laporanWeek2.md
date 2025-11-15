# Laporan Praktikum Minggu 2
Topik: Class dan Object

## Identitas
- Nama  : [Husain Stefano]
- NIM   : [240202836]
- Kelas : [3IKRA]

---

## Tujuan
(Tuliskan tujuan praktikum minggu ini.  
 Mahasiswa mampu menjelaskan konsep class, object, atribut, dan method dalam OOP.

Mahasiswa mampu menerapkan access modifier dan enkapsulasi dalam pembuatan class.

Mahasiswa mampu mengimplementasikan class Produk pertanian dengan atribut dan method yang sesuai.

Mahasiswa mampu mendemonstrasikan instansiasi object serta menampilkan data produk pertanian di console.

Mahasiswa mampu menyusun laporan praktikum dengan bukti kode, hasil eksekusi, dan analisis sederhana.)

---

## Dasar Teori
(Tuliskan ringkasan teori singkat (3–5 poin) yang mendasari praktikum.  
Contoh:  
1. Class

Merupakan blueprint atau cetak biru untuk membuat objek.

Di dalamnya terdapat atribut (data/properti) dan method (perilaku/fungsi).  
2. Object

Merupakan hasil instansiasi dari class.

Setiap objek dapat memiliki nilai atribut yang berbeda meskipun menggunakan class yang sama.  
3. Atribut dan Method

Atribut: variabel yang menyimpan data suatu objek (misalnya kode, nama, harga, stok).

Method: fungsi yang memberikan aksi/perilaku pada objek (misalnya tambahStok(), getNama()).

---

## Langkah Praktikum
(Tuliskan Langkah-langkah dalam prakrikum, contoh:
1.Membuat Class Produk

File: Produk.java

Tambahkan atribut kode, nama, harga, dan stok.

Terapkan enkapsulasi (atribut private, akses melalui getter dan setter).  
2. Membuat Class CreditBy

File: CreditBy.java

Menampilkan identitas mahasiswa dengan format:

credit by: <NIM> - <Nama>  
3. Membuat Class MainProduk

File: MainProduk.java

Instansiasi tiga objek produk pertanian dan tampilkan datanya melalui getter.

Tambahkan pemanggilan CreditBy.print() untuk menampilkan identitas di akhir output.

4. Commit dan Push ke GitHub

Pesan commit:

Add practical reports and example files for weeks 1 to 16

---

## Kode Program
(
  1. Produk.java
package main.java.com.upb.agripos;

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
    public void setKode(String kode) { this.kode = kode; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public void kurangiStok(int jumlah) {
        if (this.stok >= jumlah) {
            this.stok -= jumlah;
        } else {
            System.out.println("Stok tidak mencukupi!");
        }
    }
}
2. CreditBy.java
package main.java.com.upb.agripos;

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\ncredit by: " + nim + " - " + nama);
    }
}

3. MainProduk.java
package main.java.com.upb.agripos;

public class MainProduk {
    public static void main(String[] args) {
        Produk p1 = new Produk("BHN-123", "Beras Pandan Wangi 5kg", 75000, 50);
        Produk p2 = new Produk("BMB-456", "Minyak Goreng 2L", 32000, 100);
        Produk p3 = new Produk("ALT-789", "Kompor Gas 2 Tungku", 275000, 20);

        System.out.println("Kode: " + p1.getKode() + ", Nama: " + p1.getNama() + ", Harga: " + p1.getHarga() + ", Stok: " + p1.getStok());
        System.out.println("Kode: " + p2.getKode() + ", Nama: " + p2.getNama() + ", Harga: " + p2.getHarga() + ", Stok: " + p2.getStok());
        System.out.println("Kode: " + p3.getKode() + ", Nama: " + p3.getNama() + ", Harga: " + p3.getHarga() + ", Stok: " + p3.getStok());

        p1.kurangiStok(10);
        p1.tambahStok(8);

        CreditBy.print("240202836", "Husain Stefano");
    }
}


## Hasil Eksekusi
[alt text](<Screenshot 2025-10-16 231934.png>)
[alt text](<Screenshot 2025-10-16 232029.png>)
---

## Analisis
(
Class Produk digunakan sebagai cetak biru objek, berisi atribut dan method untuk mengelola produk pertanian.

Objek p1, p2, dan p3 menunjukkan bahwa setiap instance memiliki nilai data unik.

Enkapsulasi menjaga keamanan data dengan menjadikan atribut private.

Method getter & setter memastikan akses data dapat dikontrol.

Metode tambahStok() dan kurangiStok() menunjukkan perilaku (aksi) objek.

CreditBy.print() memberikan penanda identitas pembuat program pada output. 
)
---

## Kesimpulan
Class berfungsi sebagai template untuk membuat objek.

Object adalah wujud nyata dari class dengan nilai spesifik.

Enkapsulasi mengamankan data dari akses langsung yang tidak valid.

OOP membantu menciptakan sistem yang modular, rapi, dan mudah dikembangkan.

---

## Quiz
(1. Mengapa atribut sebaiknya dideklarasikan sebagai private?
Agar data tidak bisa diakses langsung dari luar class sehingga keamanan dan konsistensi tetap terjaga. 

2. Apa fungsi getter dan setter dalam enkapsulasi?
Getter membaca nilai atribut, setter mengubah nilai secara terkontrol.

3. Bagaimana class Produk mendukung pengembangan aplikasi POS ke depannya?
Class Produk dapat diperluas dengan fitur transaksi, manajemen stok, diskon, hingga laporan sehingga dapat menjadi dasar aplikasi POS yang kompleks.