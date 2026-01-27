package com.upb.agripos.service;

import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.model.Product;
import java.util.List;

public class ProductService {
    private ProductDAO dao;

    public ProductService(ProductDAO dao) {
        this.dao = dao;
    }

    public void addProduct(String code, String name, String priceStr, String stockStr) throws Exception {
        if (code.isEmpty() || name.isEmpty()) throw new Exception("Data tidak boleh kosong!");
        
        double price = Double.parseDouble(priceStr);
        int stock = Integer.parseInt(stockStr);
        
        Product p = new Product(code, name, price, stock);
        dao.save(p); // Memanggil 'save' sesuai Interface
    }

    public List<Product> getAllProducts() {
        return dao.getAllProducts(); // Memanggil 'getAllProducts' sesuai Interface
    }
}