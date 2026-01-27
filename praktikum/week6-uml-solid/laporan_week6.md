# Laporan Praktikum 6
Topik: Desain Arsitektur Sistem dengan UML dan Prinsip SOLID

## Identitas
- Nama  : Husain Stefano
- NIM   : 240202836
- Kelas : 3IKRA

---

## Tujuan
1. Mahasiswa mampu mengidentifikasi kebutuhan sistem ke dalam diagram UML.
2. Mahasiswa mampu menggambar UML Class Diagram dengan relasi antar class yang tepat.
3. Mahasiswa mampu menjelaskan prinsip desain OOP (SOLID).
4. Mahasiswa mampu menerapkan minimal dua prinsip SOLID dalam kode program.

---

## Dasar Teori
Sistem Agri-POS (Agricultural Point of Sale) adalah aplikasi Point of Sale (POS) yang dirancang untuk mengelola transaksi penjualan dan inventori produk pertanian.

Sistem ini mendukung dua peran utama:

Kasir: Bertanggung jawab atas proses transaksi penjualan, mulai dari pemilihan produk hingga penyelesaian pembayaran dan pencetakan struk.
Admin: Bertanggung jawab atas manajemen produk (tambah, ubah, hapus, tampil) dan melihat laporan penjualan harian/periodik. Desain arsitektur Agri-POS berfokus pada Maintainability dan Extensibility dengan menerapkan prinsip SOLID, terutama untuk mendukung penambahan metode pembayaran baru di masa depan tanpa memodifikasi modul inti.

---

## Hasil Eksekusi  
[uml_activity]
[uml_class]
[uml_sequence]
[uml_usecasse]

---

## Analisis
Desain UML menunjukkan alur sistem secara lengkap dari perspektif fungsional dan struktural.
Prinsip SOLID diterapkan menggunakan interface (PaymentMethod, ProductRepository) sehingga sistem mudah diperluas.
Activity dan Sequence Diagram menggambarkan skenario sukses dan gagal.
Class Diagram sudah modular dan memenuhi prinsip SRP & DIP.

---

## Kesimpulan
Praktikum ini membuktikan bahwa sinkronisasi antara kebutuhan bisnis dan arsitektur teknis melalui UML menjamin sistem yang konsisten dan bebas celah logika. Penerapan prinsip SOLID pada Class Diagram menciptakan struktur modular yang memudahkan pengembangan fitur baru tanpa merusak fungsi yang sudah ada, sehingga sistem menjadi lebih adaptif dan maintainable dalam jangka panjang. Dengan mempertimbangkan skenario gagal sejak tahap desain, aplikasi menjadi lebih tangguh dalam menangani kendala operasional dunia nyata, memberikan fondasi yang kokoh untuk pengembangan perangkat lunak skala industri yang profesional.

---

## Quiz
(1. [Tuliskan kembali pertanyaan 1 dari panduan]  
   **Jawaban:** …  

2. [Tuliskan kembali pertanyaan 2 dari panduan]  
   **Jawaban:** …  

3. [Tuliskan kembali pertanyaan 3 dari panduan]  
   **Jawaban:** …  )
