# Laporan Praktikum Minggu 10 - Design Pattern dan Unit Testing

Topik: Design Pattern (Singleton, MVC) dan Unit Testing menggunakan JUnit

## Identitas
- Nama  : Anonymous
- NIM   : 240202836
- Kelas : 3IKRA
- Tanggal : Januari 2026

---

## Tujuan
Mahasiswa mampu:
1. Menjelaskan dan mengimplementasikan Singleton Pattern
2. Menerapkan Model–View–Controller (MVC) pada aplikasi sederhana
3. Membuat dan menjalankan unit test menggunakan JUnit
4. Menganalisis manfaat penerapan design pattern dan unit testing

---

## Dasar Teori

### 1. Design Pattern
Design pattern adalah solusi desain yang telah teruji untuk masalah umum dalam pengembangan software.

### 2. Singleton Pattern
Pattern yang menjamin class hanya memiliki satu instance dengan akses global melalui `getInstance()`.

### 3. MVC (Model–View–Controller)
Pattern yang memisahkan tanggung jawab aplikasi:
- Model: Data dan logika bisnis
- View: Tampilan/output
- Controller: Penghubung Model dan View

### 4. Unit Testing
Proses pengujian komponen kecil (unit) dengan anotasi `@Test` dan assertion.

---

## Langkah Praktikum

### 1. Persiapan Folder
Membuat struktur direktori sesuai standar Maven:
```
src/main/java/com/upb/agripos/
├── model/
├── view/
├── controller/
└── config/
src/test/java/com/upb/agripos/
```

### 2. Implementasi Komponen

#### a) Model - Product.java
Class yang mewakili data Product dengan properties `code` dan `name`.

#### b) View - ConsoleView.java
Class yang menampilkan output ke konsol menggunakan `System.out.println()`.

#### c) Controller - ProductController.java
Class yang menghubungkan Model dan View, mengandung logika untuk menampilkan produk.

#### d) Singleton - DatabaseConnection.java
Implementasi pattern Singleton dengan:
- Constructor private
- Static instance
- Method getInstance()

#### e) Main Program - AppMVC.java
Program utama yang:
- Menampilkan identitas NIM
- Test Singleton (memastikan kedua instance sama)
- Menjalankan MVC

#### f) Unit Test - ProductTest.java
Membuat 3 test cases untuk Product:
1. Test getName()
2. Test getCode()
3. Test non-null

### 3. Commit Message
```
week10-pattern-testing: Implementasi Singleton, MVC, dan Unit Testing
```

---

## Kode Program Utama

### Product Model
```java
public class Product {
    private final String code;
    private final String name;

    public Product(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
}
```

### ProductController
```java
public class ProductController {
    private final Product model;
    private final ConsoleView view;

    public ProductController(Product model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void showProduct() {
        view.showMessage("Produk: " + model.getCode() + " - " + model.getName());
    }
}
```

### Singleton DatabaseConnection
```java
public class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() { }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
```

### Main Program
```java
public class AppMVC {
    public static void main(String[] args) {
        System.out.println("Hello, I am Anonymous-240202836 (Week10)");
        
        // Test Singleton
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        System.out.println("Singleton Test: " + (db1 == db2 ? "PASS - Same Instance" : "FAIL"));
        
        // MVC
        Product product = new Product("P01", "Pupuk Organik");
        ConsoleView view = new ConsoleView();
        ProductController controller = new ProductController(product, view);
        controller.showProduct();
    }
}
```

### Unit Test
```java
public class ProductTest {
    @Test
    public void testProductName() {
        Product p = new Product("P01", "Benih Jagung");
        assertEquals("Benih Jagung", p.getName());
    }

    @Test
    public void testProductCode() {
        Product p = new Product("P01", "Benih Jagung");
        assertEquals("P01", p.getCode());
    }

    @Test
    public void testProductNotNull() {
        Product p = new Product("P02", "Pupuk Urea");
        assertNotNull(p);
        assertNotNull(p.getCode());
        assertNotNull(p.getName());
    }
}
```

---

## Hasil Eksekusi

### Output Program
```
Hello, I am Anonymous-240202836 (Week10)
Singleton Test: PASS - Same Instance
Produk: P01 - Pupuk Organik
```

### Hasil Unit Test
✅ Semua test cases berhasil (3/3 PASS):
- testProductName() ✓
- testProductCode() ✓
- testProductNotNull() ✓

![Screenshot hasil unit test](screenshots/junit_result.png)

---

## Analisis

### Keuntungan Singleton Pattern
1. Menjamin hanya satu instance yang ada (thread-safe concerns dapat ditangani)
2. Akses global melalui getInstance()
3. Ideal untuk database connection, logger, configuration

### Keuntungan MVC Pattern
1. Separation of Concerns - setiap komponen fokus pada tanggung jawabnya
2. Mudah di-test secara independen
3. Reusable - Model dan Controller dapat bekerja dengan View berbeda
4. Maintainability tinggi

### Keuntungan Unit Testing
1. Early detection of bugs
2. Documentation of code behavior
3. Safe refactoring - perubahan dapat ditest dengan cepat
4. Increased confidence dalam kode

---

## Kesimpulan
Praktikum ini berhasil menunjukkan implementasi design pattern (Singleton dan MVC) serta pentingnya unit testing dalam membangun software yang berkualitas, mudah dimaintain, dan reliable. Ketiga konsep ini bekerja bersama untuk meningkatkan kualitas dan profesionalisme kode.

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
