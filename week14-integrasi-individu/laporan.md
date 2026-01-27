# Laporan Praktikum Minggu 14 
Topik:Bab 14 – Integrasi Individu (OOP + Database + GUI)
## Identitas
- Nama  : Husain Stefano
- NIM   : 240202836
- Kelas : 3IKRA

---

## Tujuan
Setelah mengikuti praktikum ini, mahasiswa mampu:

Mengintegrasikan konsep OOP (Bab 1–5) ke dalam satu aplikasi yang utuh.
Mengimplementasikan rancangan UML + SOLID (Bab 6) menjadi kode nyata.
Mengintegrasikan Collections + Keranjang (Bab 7) ke alur aplikasi.
Menerapkan exception handling (Bab 9) untuk validasi dan error flow.
Menerapkan pattern + unit testing (Bab 10) pada bagian yang relevan.
Menghubungkan aplikasi dengan database via DAO + JDBC (Bab 11).
Menyajikan aplikasi berbasis JavaFX (Bab 12–13) yang terhubung ke backend.

---

## Dasar Teori
Pada Bab 14, Anda membangun 1 aplikasi individu bernama Agri-POS (kasir sederhana) yang menggabungkan hasil kerja Bab 1–13.

Target akhir:

Aplikasi JavaFX berjalan.
Data Produk tersimpan di PostgreSQL (CRUD via DAO).
Keranjang belanja berjalan (Collections) dan dipakai dalam alur aplikasi.
Struktur kelas mengikuti UML Bab 6 dan prinsip SOLID.
Ada minimal 1 unit test JUnit yang relevan.

---

## Langkah Praktikum
Tidak membuat ulang dari nol. Lanjutkan dan gabungkan kode yang sudah Anda buat di Bab 1–13.
Konsistensi Bab 6 (UML + SOLID) adalah kunci. Jika di Bab 6 Anda menamai kelas/metode tertentu, Bab 14 harus mengikuti nama itu.
DIP (Dependency Inversion) wajib diterapkan:
View (JavaFX) tidak boleh mengakses DAO langsung.
Akses data harus melewati Controller → Service → DAO.
Tidak ada logika SQL/CRUD di layer GUI.
Validasi & error flow wajib memakai exception (Bab 9), bukan hanya if tanpa penanganan.

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
![Screenshot hasil](Cuplikanlayarweek14(2).png Cuplikanlayarweek14.png)
)
---

## Analisis
(
- Jelaskan bagaimana kode berjalan.  
- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.  
- Kendala yang dihadapi dan cara mengatasinya.  
)
---

## Kesimpulan
(Tuliskan kesimpulan dari praktikum minggu ini.  
Contoh: *Dengan menggunakan class dan object, program menjadi lebih terstruktur dan mudah dikembangkan.*)

---

## Quiz
(1. [Tuliskan kembali pertanyaan 1 dari panduan]  
   **Jawaban:** …  

2. [Tuliskan kembali pertanyaan 2 dari panduan]  
   **Jawaban:** …  

3. [Tuliskan kembali pertanyaan 3 dari panduan]  
   **Jawaban:** …  )
