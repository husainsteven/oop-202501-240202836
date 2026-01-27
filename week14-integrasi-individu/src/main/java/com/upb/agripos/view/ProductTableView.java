package com.upb.agripos.view;

import com.upb.agripos.controller.PosController;
import com.upb.agripos.model.Product;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ProductTableView extends BorderPane {
    private PosController controller;
    private TableView<Product> tableView;
    private TextField txtCode, txtName, txtPrice, txtStock;
    private CartView cartView;

    public ProductTableView(PosController controller, CartView cartView) {
        this.controller = controller;
        this.cartView = cartView;
        initializeUI();
    }

    private void initializeUI() {
        // Title
        Label lblTitle = new Label("Kelola Produk");
        lblTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Form Input
        txtCode = new TextField();
        txtCode.setPromptText("Kode Produk");
        txtName = new TextField();
        txtName.setPromptText("Nama Produk");
        txtPrice = new TextField();
        txtPrice.setPromptText("Harga");
        txtStock = new TextField();
        txtStock.setPromptText("Stok");

        // Buttons
        Button btnAdd = new Button("Tambah Produk");
        Button btnDelete = new Button("Hapus Produk");
        Button btnAddToCart = new Button("Tambah ke Keranjang");

        btnAdd.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        btnDelete.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");
        btnAddToCart.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");

        // Table
        tableView = new TableView<>();
        
        TableColumn<Product, String> colCode = new TableColumn<>("Kode");
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        
        TableColumn<Product, String> colName = new TableColumn<>("Nama");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Product, Double> colPrice = new TableColumn<>("Harga");
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        TableColumn<Product, Integer> colStock = new TableColumn<>("Stok");
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tableView.getColumns().addAll(colCode, colName, colPrice, colStock);

        // Button Actions
        btnAdd.setOnAction(e -> handleAddProduct());
        btnDelete.setOnAction(e -> handleDeleteProduct());
        btnAddToCart.setOnAction(e -> handleAddToCart());

        // Layout
        VBox formBox = new VBox(10, txtCode, txtName, txtPrice, txtStock);
        HBox buttonBox = new HBox(10, btnAdd, btnDelete, btnAddToCart);
        VBox topBox = new VBox(10, lblTitle, formBox, buttonBox);
        topBox.setPadding(new Insets(15));

        this.setTop(topBox);
        this.setCenter(tableView);
        this.setPadding(new Insets(15));

        // Load data
        refreshTable();
    }

    public void refreshTable() {
        tableView.getItems().clear();
        tableView.getItems().addAll(controller.getAllProducts());
    }

    private void handleAddProduct() {
        try {
            controller.addProduct(
                txtCode.getText(),
                txtName.getText(),
                txtPrice.getText(),
                txtStock.getText()
            );
            new Alert(Alert.AlertType.INFORMATION, "Produk berhasil ditambahkan!").show();
            clearForm();
            refreshTable();
        } catch (Exception ex) {
            new Alert(Alert.AlertType.ERROR, ex.getMessage()).show();
        }
    }

    private void handleDeleteProduct() {
        Product selected = tableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(Alert.AlertType.WARNING, "Pilih produk yang ingin dihapus!").show();
            return;
        }

        try {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, 
                "Hapus produk: " + selected.getName() + "?",
                ButtonType.YES, ButtonType.NO);
            
            if (confirm.showAndWait().get() == ButtonType.YES) {
                controller.deleteProduct(selected.getCode());
                new Alert(Alert.AlertType.INFORMATION, "Produk berhasil dihapus!").show();
                refreshTable();
            }
        } catch (Exception ex) {
            new Alert(Alert.AlertType.ERROR, ex.getMessage()).show();
        }
    }

    private void handleAddToCart() {
        Product selected = tableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(Alert.AlertType.WARNING, "Pilih produk yang ingin ditambahkan ke keranjang!").show();
            return;
        }

        TextInputDialog dialog = new TextInputDialog("1");
        dialog.setTitle("Tambah ke Keranjang");
        dialog.setHeaderText("Produk: " + selected.getName());
        dialog.setContentText("Masukkan jumlah:");

        dialog.showAndWait().ifPresent(qtyStr -> {
            try {
                int quantity = Integer.parseInt(qtyStr);
                controller.addToCart(selected, quantity);
                new Alert(Alert.AlertType.INFORMATION, 
                    "Berhasil ditambahkan ke keranjang!").show();
                cartView.refreshCart();
            } catch (NumberFormatException ex) {
                new Alert(Alert.AlertType.ERROR, "Jumlah harus berupa angka!").show();
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, ex.getMessage()).show();
            }
        });
    }

    private void clearForm() {
        txtCode.clear();
        txtName.clear();
        txtPrice.clear();
        txtStock.clear();
    }
}