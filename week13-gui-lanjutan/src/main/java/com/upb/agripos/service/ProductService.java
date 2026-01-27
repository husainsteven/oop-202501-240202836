package com.upb.agripos.service;

import java.util.List;

import com.upb.agripos.config.DatabaseConnection;
import com.upb.agripos.dao.ProductDAO;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.model.Product;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService() {
        this.productDAO = new ProductDAOImpl(DatabaseConnection.getConnection());
    }

    public void addProduct(String code, String name, String priceStr, String stockStr) throws Exception {
        if (code.isEmpty() || name.isEmpty()) throw new Exception("Data tidak boleh kosong!");
        
        double price = Double.parseDouble(priceStr);
        int stock = Integer.parseInt(stockStr);
        
        Product p = new Product(code, name, price, stock);
        productDAO.save(p);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public void saveProduct(Product product) {
        productDAO.save(product);
    }
    
    public void deleteProduct(String code) {
        productDAO.delete(code);
    }
}