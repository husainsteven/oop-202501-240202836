package com.upb.agripos.view;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ProductTableView extends VBox {
    private TableView<Product> table;
    private TextField txtCode, txtName, txtPrice, txtStock;
    private ProductService productService;
    private ObservableList<Product> productData;

    public ProductTableView() {
        productService = new ProductService(); // Sesuaikan jika Anda menggunakan DAO via Service
        initComponent();
        loadData();
    }

    private void initComponent() {
        setPadding(new Insets(10));
        setSpacing(10);

        // 1. Form Input
        txtCode = new TextField(); txtCode.setPromptText("Kode Produk");
        txtName = new TextField(); txtName.setPromptText("Nama Produk");
        txtPrice = new TextField(); txtPrice.setPromptText("Harga");
        txtStock = new TextField(); txtStock.setPromptText("Stok");

        // 2. Tombol dengan Lambda Expression
        Button btnAdd = new Button("Tambah Produk");
        btnAdd.setOnAction(e -> handleAdd());

        Button btnDelete = new Button("Hapus Produk");
        btnDelete.setOnAction(e -> handleDelete());

        HBox form = new HBox(10, txtCode, txtName, txtPrice, txtStock, btnAdd, btnDelete);

        // 3. TableView
        table = new TableView<>();
        
        TableColumn<Product, String> colCode = new TableColumn<>("Kode");
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));

        TableColumn<Product, String> colName = new TableColumn<>("Nama");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> colPrice = new TableColumn<>("Harga");
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> colStock = new TableColumn<>("Stok");
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        table.getColumns().addAll(colCode, colName, colPrice, colStock);
        table.setPlaceholder(new Label("Belum ada data produk"));

        getChildren().addAll(new Label("Kelola Produk Agri-POS"), form, table);
    }

    private void loadData() {
        // Mengambil data dari DAO melalui Service
        productData = FXCollections.observableArrayList(productService.getAllProducts());
        table.setItems(productData);
    }

    private void handleAdd() {
        Product p = new Product(
            txtCode.getText(),
            txtName.getText(),
            Double.parseDouble(txtPrice.getText()),
            Integer.parseInt(txtStock.getText())
        );
        productService.saveProduct(p);
        loadData(); // Reload TableView
        clearFields();
    }

    private void handleDelete() {
        // Alur Hapus Produk: pilih item -> panggil service -> reload
        Product selected = table.getSelectionModel().getSelectedItem();
        if (selected != null) {
            productService.deleteProduct(selected.getCode());
            loadData();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Pilih produk yang ingin dihapus!");
            alert.show();
        }
    }

    private void clearFields() {
        txtCode.clear();
        txtName.clear();
        txtPrice.clear();
        txtStock.clear();
    }
}