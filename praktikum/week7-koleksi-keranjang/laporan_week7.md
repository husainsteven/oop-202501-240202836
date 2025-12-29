# Laporan Praktikum Minggu 7
Topik: Collections dan Implementasi Keranjang Belanja

## Identitas
- Nama  : Husain Stefano
- NIM   : 240202836
- Kelas : 3IKRA

---

## Tujuan
- Menjelaskan konsep collection dalam Java (List, Map, Set).
- Menggunakan ArrayList untuk menyimpan dan mengelola objek.
- Mengimplementasikan Map atau Set sesuai kebutuhan pengelolaan data.
- Melakukan operasi dasar pada collection: tambah, hapus, dan hitung total.
- Menganalisis efisiensi penggunaan collection dalam konteks sistem Agri-POS.

---

## Dasar Teori
1. Collections Framework
Java Collections Framework menyediakan struktur data untuk mengelola objek secara dinamis dan efisien.

Struktur utama:

- List (implementasi: ArrayList) — Terurut, dapat menyimpan elemen duplikat.
- Map (implementasi: HashMap) — Menyimpan pasangan key–value, akses cepat berdasarkan key.
- Set (implementasi: HashSet) — Tidak menerima duplikat dan tidak mempertahankan urutan.

---

## Langkah Praktikum
1. Membuat Class Product
package com.upb.agripos;

public class Product {
    private final String code;
    private final String name;
    private final double price;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}

2. Implementasi Keranjang dengan ArrayList
package com.upb.agripos;

import java.util.ArrayList;

public class ShoppingCart {
    private final ArrayList<Product> items = new ArrayList<>();

    public void addProduct(Product p) { items.add(p); }
    public void removeProduct(Product p) { items.remove(p); }

    public double getTotal() {
        double sum = 0;
        for (Product p : items) {
            sum += p.getPrice();
        }
        return sum;
    }

    public void printCart() {
        System.out.println("Isi Keranjang:");
        for (Product p : items) {
            System.out.println("- " + p.getCode() + " " + p.getName() + " = " + p.getPrice());
        }
        System.out.println("Total: " + getTotal());
    }
}

3. Main Program
package com.upb.agripos;

public class MainCart {
    public static void main(String[] args) {
        System.out.println("Hello, I am [Nama]-[NIM] (Week7)");

        Product p1 = new Product("P01", "Beras", 50000);
        Product p2 = new Product("P02", "Pupuk", 30000);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.printCart();

        cart.removeProduct(p1);
        cart.printCart();
    }
}

4. Implementasi Alternatif Menggunakan Map
package com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartMap {
    private final Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product p) { items.put(p, items.getOrDefault(p, 0) + 1); }

    public void removeProduct(Product p) {
        if (!items.containsKey(p)) return;
        int qty = items.get(p);
        if (qty > 1) items.put(p, qty - 1);
        else items.remove(p);
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void printCart() {
        System.out.println("Isi Keranjang (Map):");
        for (Map.Entry<Product, Integer> e : items.entrySet()) {
            System.out.println("- " + e.getKey().getCode() + " " + e.getKey().getName() + " x" + e.getValue());
        }
        System.out.println("Total: " + getTotal());
    }
}.

---

<<<<<<< HEAD
## Kode Program  

```java
package com.upb.agripos;

public class MainCart {
    public static void main(String[] args) {
        System.out.println("Hello, I am [HUSAIN STEFANO]-[240202836] (Week7)");

        Product p1 = new Product("P04", "Beras", 60000);
        Product p2 = new Product("P08", "Pupuk", 35000);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.printCart();

        cart.removeProduct(p1);
        cart.printCart();
    }
}
```

```java
package com.upb.agripos;

public class Product {
    private final String code;
    private final String name;
    private final double price;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}
```

```java
package com.upb.agripos;

import java.util.ArrayList;

public class ShoppingCart {
    private final ArrayList<Product> items = new ArrayList<>();

    public void addProduct(Product p) { items.add(p); }
    public void removeProduct(Product p) { items.remove(p); }

    public double getTotal() {
        double sum = 0;
        for (Product p : items) {
            sum += p.getPrice();
        }
        return sum;
    }

    public void printCart() {
        System.out.println("Isi Keranjang:");
        for (Product p : items) {
            System.out.println("- " + p.getCode() + " " + p.getName() + " = " + p.getPrice());
        }
        System.out.println("Total: " + getTotal());
    }
}
```

```java
package com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartMap {
    private final Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product p) { items.put(p, items.getOrDefault(p, 0) + 1); }

    public void removeProduct(Product p) {
        if (!items.containsKey(p)) return;
        int qty = items.get(p);
        if (qty > 1) items.put(p, qty - 1);
        else items.remove(p);
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void printCart() {
        System.out.println("Isi Keranjang (Map):");
        for (Map.Entry<Product, Integer> e : items.entrySet()) {
            System.out.println("- " + e.getKey().getCode() + " " + e.getKey().getName() + " x" + e.getValue());
        }
        System.out.println("Total: " + getTotal());
    }
}
```

## Hasil Eksekusi 
![Screenshot hasil](screenshots/CuplikanlayarWeek7.png)
![Screenshot hasil](screenshots/CuplikanlayarWeek7(2).png)

---

## Analisis

=======
## Kode Program
```java
package com.upb.agripos;

public class MainCart {
    public static void main(String[] args) {
        System.out.println("Hello, I am [HUSAIN STEFANO]-[240202836] (Week7)");

        Product p1 = new Product("P04", "Beras", 60000);
        Product p2 = new Product("P08", "Pupuk", 35000);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.printCart();

        cart.removeProduct(p1);
        cart.printCart();
    }
}
```
```java
package com.upb.agripos;

public class Product {
    private final String code;
    private final String name;
    private final double price;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}
```
```java
package com.upb.agripos;

import java.util.ArrayList;

public class ShoppingCart {
    private final ArrayList<Product> items = new ArrayList<>();

    public void addProduct(Product p) { items.add(p); }
    public void removeProduct(Product p) { items.remove(p); }

    public double getTotal() {
        double sum = 0;
        for (Product p : items) {
            sum += p.getPrice();
        }
        return sum;
    }

    public void printCart() {
        System.out.println("Isi Keranjang:");
        for (Product p : items) {
            System.out.println("- " + p.getCode() + " " + p.getName() + " = " + p.getPrice());
        }
        System.out.println("Total: " + getTotal());
    }
}
```
```java
package com.upb.agripos;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartMap {
    private final Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product p) { items.put(p, items.getOrDefault(p, 0) + 1); }

    public void removeProduct(Product p) {
        if (!items.containsKey(p)) return;
        int qty = items.get(p);
        if (qty > 1) items.put(p, qty - 1);
        else items.remove(p);
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void printCart() {
        System.out.println("Isi Keranjang (Map):");
        for (Map.Entry<Product, Integer> e : items.entrySet()) {
            System.out.println("- " + e.getKey().getCode() + " " + e.getKey().getName() + " x" + e.getValue());
        }
        System.out.println("Total: " + getTotal());
    }
}
```
## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/hasil.png)
)
---

## Analisis
>>>>>>> 462020bc1d41c21c17f43bcdf1190a466d4cb627
Praktikum Week 7 membahas penerapan konsep Object-Oriented Programming (OOP) melalui studi kasus keranjang belanja. Program menggunakan class Cart untuk mengelola data item dan class MainCart sebagai pengatur alur program.

Penggunaan koleksi memungkinkan item ditambah dan dihapus secara dinamis, serta total harga diperbarui otomatis. Hal ini menunjukkan keunggulan OOP dalam mengelola data yang terstruktur dan fleksibel.

Output program menampilkan isi keranjang sebelum dan sesudah penghapusan item secara jelas, sehingga proses program mudah dipahami. Secara keseluruhan, pendekatan Week 7 menghasilkan program yang lebih modular,
<<<<<<< HEAD

=======
>>>>>>> 462020bc1d41c21c17f43bcdf1190a466d4cb627
---

## Kesimpulan
Berdasarkan praktikum Week 7, dapat disimpulkan bahwa penerapan konsep Object-Oriented Programming (OOP) mampu menghasilkan program yang lebih terstruktur dan mudah dikelola. Penggunaan class dan koleksi data memungkinkan pengelolaan item dalam keranjang belanja dilakukan secara dinamis. Selain itu, pemisahan tanggung jawab antar class membuat program lebih rapi, mudah dipahami, dan siap dikembangkan lebih lanjut.

---

## Quiz
1. Jelaskan perbedaan mendasar antara List, Map, dan Set.
Jawaban: Perbedaan mendasar antara List, Set, dan Map

List
Menyimpan kumpulan data yang berurutan dan boleh mengandung data duplikat. Setiap elemen memiliki indeks.
<<<<<<< HEAD

Set
Menyimpan data tanpa urutan tertentu dan tidak mengizinkan data duplikat.

Map
Menyimpan data dalam bentuk key–value, di mana key harus unik dan digunakan untuk mengakses value.

2. Mengapa ArrayList cocok digunakan untuk keranjang belanja sederhana?
Jawaban: ArrayList cocok digunakan karena:

Mudah menambah dan menghapus item

Menyimpan data secara berurutan

Mendukung data duplikat (misalnya membeli produk yang sama lebih dari satu)

Implementasinya sederhana dan efisien untuk jumlah data kecil hingga menengah 

3. Bagaimana struktur Set mencegah duplikasi data?
Jawaban: Set mencegah duplikasi dengan cara membandingkan elemen menggunakan method equals() dan hashCode(). Jika data yang dimasukkan sudah ada di dalam Set, maka data tersebut tidak akan ditambahkan.

4. Kapan sebaiknya menggunakan Map dibandingkan List? Jelaskan dengan contoh.
Jawaban: Map sebaiknya digunakan ketika data perlu diakses menggunakan kunci unik.

Contoh:
Dalam sistem POS pertanian:

Map cocok untuk menyimpan data produk berdasarkan kode:
Map<String, Produk> daftarProduk;
(kode produk → objek produk)

List lebih cocok untuk menyimpan daftar belanja:
List<Produk> keranjang;
Dengan Map, pencarian produk berdasarkan kode menjadi lebih cepat dan efisien dibandingkan List.
=======

Set
Menyimpan data tanpa urutan tertentu dan tidak mengizinkan data duplikat.

Map
Menyimpan data dalam bentuk key–value,   

2. Mengapa ArrayList cocok digunakan untuk keranjang belanja sederhana?
Jawaban: ArrayList cocok digunakan karena:

Mudah menambah dan menghapus item

Menyimpan data secara berurutan

Mendukung data duplikat (misalnya membeli produk yang sama lebih dari satu)

Implementasin:  

3. Bagaimana struktur Set mencegah duplikasi data?
Jawaban: Set mencegah duplikasi dengan cara membandingkan elemen menggunakan method equals() dan hashCode(). Jika data yang dimasukkan sudah ada di dalam Set, maka data tersebut tidak akan ditambahkan.

4. Kapan sebaiknya menggunakan Map dibandingkan List? Jelaskan dengan contoh.
Jawaban: Map sebaiknya digunakan ketika data perlu diakses menggunakan kunci unik.

Contoh:
Dalam sistem POS pertanian:

Map cocok untuk menyimpan data produk berdasarkan kode:
Map<String, Produk> daftarProduk;
(kode produk → objek produk)

List lebih cocok untuk menyimpan daftar belanja:
List<Produk> keranjang;
Dengan Map, pencarian produk berdasarkan kode menjadi lebih cepat dan efisien dibandingkan List.

>>>>>>> 462020bc1d41c21c17f43bcdf1190a466d4cb627
