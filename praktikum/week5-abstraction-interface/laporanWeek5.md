# Laporan Praktikum Minggu 5
Topik: Abstraction-Interface 

## Identitas
- Nama  : Husain Stefano
- NIM   : 240202836
- Kelas : 3IKRA

---

## Tujuan
1.Mahasiswa mampu menjelaskan perbedaan abstract class dan interface.
2.Mahasiswa mampu mendesain abstract class dengan method abstrak sesuai kebutuhan kasus.
3.Mahasiswa mampu membuat interface dan mengimplementasikannya pada class.
4.Mahasiswa mampu menerapkan multiple inheritance melalui interface pada rancangan kelas.
5.Mahasiswa mampu mendokumentasikan kode (komentar kelas/method, README singkat pada folder minggu).


---

## Dasar Teori
Abstraksi adalah proses menyederhanakan kompleksitas dengan menampilkan elemen penting dan menyembunyikan detail implementasi.

1. Abstract class: tidak dapat diinstansiasi, dapat memiliki method abstrak (tanpa badan) dan non-abstrak. Dapat menyimpan state (field).
2. Interface: kumpulan kontrak (method tanpa implementasi konkret). Sejak Java 8 mendukung default method. Mendukung multiple inheritance (class dapat mengimplementasikan banyak interface).
3. Gunakan abstract class bila ada shared state dan perilaku dasar; gunakan interface untuk mendefinisikan kemampuan/kontrak lintas hierarki.
Dalam konteks Agri-POS, Pembayaran dapat dimodelkan sebagai abstract class dengan method abstrak prosesPembayaran() dan biaya(). Implementasi konkritnya: Cash dan EWallet. Kemudian, interface seperti Validatable (mis. verifikasi OTP) dan Receiptable (mencetak bukti) dapat diimplementasikan oleh jenis pembayaran yang relevan.

---

## Langkah Praktikum

1.Abstract Class – Pembayaran

Buat Pembayaran (abstract) dengan field invoiceNo, total dan method:
- double biaya() (abstrak) → biaya tambahan (fee).
- boolean prosesPembayaran() (abstrak) → mengembalikan status berhasil/gagal.
- double totalBayar() (konkrit) → return total + biaya();  
2. Subclass Konkret

- Cash → biaya = 0, proses = selalu berhasil jika tunai >= totalBayar().
- EWallet → biaya = 1.5% dari total; proses = membutuhkan validasi.
3. Interface

- Validatable → boolean validasi(); (contoh: OTP).
- Receiptable → String cetakStruk();
4. Multiple Inheritance via Interface

- EWallet mengimplementasikan dua interface: Validatable, Receiptable.
- Cash setidaknya mengimplementasikan Receiptable.
5. Main Class

- Buat MainAbstraction.java untuk mendemonstrasikan pemakaian Pembayaran (polimorfik).
- Tampilkan hasil proses dan struk. Di akhir, panggil CreditBy.print("[NIM]", "[Nama]").
6. Commit dan Push

- Commit dengan pesan: week5-abstraction-interface.


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
<img width="1920" height="1200" alt="Cuplikan layar 2025-11-13 195752" src="https://github.com/user-attachments/assets/5710c441-77e6-4c16-9468-0d8c10c2ff32" />

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
