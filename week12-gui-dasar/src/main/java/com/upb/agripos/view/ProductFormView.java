package com.upb.agripos.view;

import com.upb.agripos.config.DatabaseConnection;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ProductFormView extends VBox {
    private ProductService service;

    public ProductFormView() {
        // Inisialisasi
        service = new ProductService(new ProductDAOImpl(DatabaseConnection.getConnection()));

        this.setSpacing(10);
        this.setPadding(new Insets(15));

        Label lblTitle = new Label("Input Produk Agri-POS");
        TextField txtCode = new TextField(); txtCode.setPromptText("Kode Produk");
        TextField txtName = new TextField(); txtName.setPromptText("Nama Produk");
        TextField txtPrice = new TextField(); txtPrice.setPromptText("Harga");
        TextField txtStock = new TextField(); txtStock.setPromptText("Stok");
        
        Button btnSave = new Button("Simpan Produk");
        ListView<Product> listView = new ListView<>();

        refreshList(listView);

        btnSave.setOnAction(e -> {
            try {
                service.addProduct(txtCode.getText(), txtName.getText(), txtPrice.getText(), txtStock.getText());
                new Alert(Alert.AlertType.INFORMATION, "Berhasil disimpan!").show();
                refreshList(listView);
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, ex.getMessage()).show();
            }
        });

        this.getChildren().addAll(lblTitle, txtCode, txtName, txtPrice, txtStock, btnSave, new Label("Daftar:"), listView);
    }

    private void refreshList(ListView<Product> listView) {
        listView.getItems().setAll(service.getAllProducts());
    }
}