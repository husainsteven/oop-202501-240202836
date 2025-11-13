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

3. Pembayaran.java

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

4. Receiptable.java

package main.java.com.upb.agripos.Model.Kontrak;

public interface Receiptable {
    String cetakStruk();
}

5. Validatable.java

package main.java.com.upb.agripos.Model.Kontrak;

public interface Validatable {
    boolean validasi(); // misal validasi OTP/ PIN
}

6. CreditBy.java

package main.java.com.upb.agripos.util;

public class CreditBy {
    public static void print(String nim, String nama) {
        System.out.println("\n---");
        System.out.println("Credit by: " + nim + " - " + nama);
    }
}

7. MianAbstraction.java

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
