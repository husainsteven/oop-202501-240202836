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
(Tuliskan kode utama yang dibuat, contoh:  

```java
// Contoh
Produk p1 = new Produk("BNH-001", "Benih Padi", 25000, 100);
System.out.println(p1.getNama());
```
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/hasil.png)
)
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