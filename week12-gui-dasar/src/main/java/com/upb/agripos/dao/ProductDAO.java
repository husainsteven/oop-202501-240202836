package com.upb.agripos.dao;

import com.upb.agripos.model.Product;
import java.util.List;

public interface ProductDAO {
    void save(Product product); // Menggunakan nama 'save'
    List<Product> getAllProducts(); // Menggunakan nama 'getAllProducts'
}