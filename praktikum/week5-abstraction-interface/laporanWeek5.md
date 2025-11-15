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
1. Cash.java

```java
package main.java.com.upb.agripos.Model.Pembayaran;

import main.java.com.upb.agripos.Model.Kontrak.Receiptable;

public class Cash extends Pembayaran implements Receiptable {
    private double tunai;

    public Cash(String invoiceNo, double total, double tunai) {
        super(invoiceNo, total);
        this.tunai = tunai;
    }

    @Override
    public double biaya() {
        return 0.0;
    }

    @Override
    public boolean prosesPembayaran() {
        return tunai >= totalBayar(); // sederhana: cukup uang tunai
    }

    @Override
    public String cetakStruk() {
        return String.format("INVOICE %s | TOTAL: %.2f | BAYAR CASH: %.2f | KEMBALI: %.2f",
                invoiceNo, totalBayar(), tunai, Math.max(0, tunai - totalBayar()));
    }
}
```

2. EWallet.java
   
```java
package main.java.com.upb.agripos.Model.Pembayaran;

import main.java.com.upb.agripos.Model.Kontrak.Validatable;
import main.java.com.upb.agripos.Model.Kontrak.Receiptable;

public class EWallet extends Pembayaran implements Validatable, Receiptable {
    private String akun;
    private String otp; // sederhana untuk simulasi

    public EWallet(String invoiceNo, double total, String akun, String otp) {
        super(invoiceNo, total);
        this.akun = akun;
        this.otp = otp;
    }

    @Override
    public double biaya() {
        return total * 0.015; // 1.5% fee
    }

    @Override
    public boolean validasi() {
        return otp != null && otp.length() == 6; // contoh validasi sederhana
    }

    @Override
    public boolean prosesPembayaran() {
        return validasi(); // jika validasi lolos, anggap berhasil
    }

    @Override
    public String cetakStruk() {
        return String.format("INVOICE %s | TOTAL+FEE: %.2f | E-WALLET: %s | STATUS: %s",
                invoiceNo, totalBayar(), akun, prosesPembayaran() ? "BERHASIL" : "GAGAL");
    }
}
```java

3. Pembayaran.java

```java
package main.java.com.upb.agripos.Model.Pembayaran;

public abstract class Pembayaran {
    protected String invoiceNo;
    protected double total;

    public Pembayaran(String invoiceNo, double total) {
        this.invoiceNo = invoiceNo;
        this.total = total;
    }

    public abstract double biaya();               // fee/biaya tambahan
    public abstract boolean prosesPembayaran();   // proses spesifik tiap metode

    public double totalBayar() {
        return total + biaya();
    }

    public String getInvoiceNo() { return invoiceNo; }
    public double getTotal() { return total; }
}
```java

4. Receiptable.java

```java
package main.java.com.upb.agripos.Model.Kontrak;

public interface Receiptable {
    String cetakStruk();
}
```java

5. Validatable.java

```java
package main.java.com.upb.agripos.Model.Kontrak;

public interface Validatable {
    boolean validasi(); // misal validasi OTP/ PIN
}
```java

6. CreditBy.java

```java
package main.java.com.upb.agripos.util;

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\n---");
        System.out.println("Credit by: " + nim + " - " + nama);
    }
}
```java

7. MainAbstraction.java

```java
package main.java.com.upb.agripos;

import main.java.com.upb.agripos.Model.Pembayaran.*;
import main.java.com.upb.agripos.Model.Kontrak.*;
import main.java.com.upb.agripos.util.CreditBy;

public class MainAbstraction {
    public static void main(String[] args) {
        Pembayaran cash = new Cash("MDL-076", 150000, 170000);
        Pembayaran ew = new EWallet("SMS-098", 250000, "Steve@ewallet", "123456");

        System.out.println(((Receiptable) cash).cetakStruk());
        System.out.println(((Receiptable) ew).cetakStruk());

    CreditBy.print("240202836", "Husain Stefano");
    }
}
```java
---

## Hasil Eksekusi
<img width="1920" height="1200" alt="Cuplikan layar 2025-11-13 195752" src="https://github.com/user-attachments/assets/5710c441-77e6-4c16-9468-0d8c10c2ff32" />

---

## Analisis
Program ini menggunakan abstraksi supaya tidak perlu menulis ulang detail cara kerja setiap jenis pembayaran. Semua jenis pembayaran (seperti Cash, EWallet, dan TransferBank) dibuat berdasarkan satu kerangka utama, yaitu class Pembayaran.
Setiap kelas turunan punya aturan sendiri untuk menghitung biaya dan cara memproses pembayaran. Lalu, ada dua interface (Validatable dan Receiptable) yang digunakan agar kelas bisa punya beberapa kemampuan sekaligus
Untuk kesulitannya, sempat bingung memastikan semua kelas turunan sudah melengkapi method dari class abstrak dan interface. Tapi bisa diatasi dengan fitur bantuan IDE (seperti auto generate method) supaya tidak ada yang ketinggalan.
---

## Kesimpulan
Dengan memakai abstract class dan interface, program jadi lebih mudah diatur dan dikembangkan. KKita bisa menambah jenis pembayaran baru tanpa harus mengubah bagian lain dari program. Selain itu, konsep multiple inheritance lewat interface membuat program lebih fleksibel dan tetap aman. Secara keseluruhan, penerapan abstraksi ini membuat kode lebih terstruktur dan efisien.


---

## Quiz
1. Jelaskan perbedaan konsep dan penggunaan abstract class dan interface.  
   Perbedaan antara abstract class dan interface terletak pada konsep serta cara penggunaannya dalam pemrograman Java. Abstract class digunakan sebagai kelas dasar yang dapat memiliki atribut, konstruktor, serta metode yang sudah diimplementasikan sebagian maupun yang bersifat abstrak (tanpa isi). Kelas ini cocok digunakan ketika beberapa kelas memiliki kesamaan perilaku dan struktur data yang dapat diwariskan. Sementara itu, interface berfungsi sebagai kumpulan kontrak perilaku yang harus diikuti oleh kelas lain. Interface hanya berisi deklarasi metode tanpa implementasi, dan seluruh variabelnya bersifat konstan (public static final). Dalam pewarisan, Java hanya mengizinkan satu abstract class untuk di-extend, tetapi memungkinkan satu kelas untuk implements banyak interface sekaligus, sehingga lebih fleksibel dalam mendefinisikan perilak

2. Mengapa multiple inheritance lebih aman dilakukan dengan interface pada Java?  
   Penggunaan interface dalam multiple inheritance dianggap lebih aman di Java karena tidak menimbulkan konflik pewarisan (diamond problem). Hal ini terjadi karena interface hanya mendefinisikan “apa” yang harus dilakukan tanpa menentukan “bagaimana” cara melakukannya. Dengan demikian, beberapa interface dapat digabungkan pada satu kelas tanpa menimbulkan bentrokan implementasi. Sebaliknya, jika Java mengizinkan pewarisan ganda antar kelas, kemungkinan besar akan terjadi konflik ketika dua kelas induk memiliki metode dengan nama dan perilaku yang sama.  

3. Pada contoh Agri-POS, bagian mana yang paling tepat menjadi abstract class dan mana yang menjadi interface? Jelaskan alasannya.  
   Dalam konteks proyek Agri-POS (Agricultural Point of Sale System), bagian yang paling tepat dijadikan abstract class adalah kelas seperti Produk, Transaksi, atau Pengguna, karena ketiganya memiliki atribut dan perilaku dasar yang sama, seperti id, nama, harga, serta metode umum seperti tampilkanInfo() atau hitungTotal(). Sementara itu, bagian yang sebaiknya dijadikan interface adalah Pembayaran, CetakStruk, Diskonable, atau Stokable, karena perilaku tersebut bisa dimiliki oleh berbagai kelas berbeda tanpa perlu berbagi atribut. Misalnya, interface Pembayaran dapat diimplementasikan oleh TransaksiTunai dan TransaksiDigital, keduanya memiliki cara pembayaran berbeda tetapi harus memiliki metode prosesPembayaran(). Dengan pembagian seperti ini, struktur program menjadi lebih teratur, fleksibel, dan mudah dikembangkan.
