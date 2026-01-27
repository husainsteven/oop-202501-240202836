package com.upb.agripos.dao;

import com.upb.agripos.model.Product;
import java.util.List;

public interface ProductDAO {
    // Sesuaikan nama method dengan yang ada di ProductDAOImpl
    void insert(Product product) throws Exception; 
    void update(Product product) throws Exception;
    void delete(String code) throws Exception;
    Product findByCode(String code) throws Exception;
    List<Product> findAll() throws Exception;
}