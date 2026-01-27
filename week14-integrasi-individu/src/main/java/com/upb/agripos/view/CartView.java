package com.upb.agripos.view;

import com.upb.agripos.controller.PosController;
import com.upb.agripos.model.CartItem;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CartView extends BorderPane {
    private PosController controller;
    private ListView<String> cartListView;
    private Label lblTotal;
    private Button btnCheckout;
    private Button btnClear;

    public CartView(PosController controller) {
        this.controller = controller;
        initializeUI();
    }

    private void initializeUI() {
        // Title
        Label lblTitle = new Label("Keranjang Belanja");
        lblTitle.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Cart ListView
        cartListView = new ListView<>();
        cartListView.setPrefHeight(300);

        // Total Label
        lblTotal = new Label("Total: Rp 0");
        lblTotal.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Buttons
        btnCheckout = new Button("Checkout");
        btnClear = new Button("Clear Keranjang");
        Button btnRemove = new Button("Hapus Item");

        btnCheckout.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        btnClear.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");
        btnRemove.setStyle("-fx-background-color: #FF9800; -fx-text-fill: white;");

        // Button Actions
        btnCheckout.setOnAction(e -> handleCheckout());
        btnClear.setOnAction(e -> handleClear());
        btnRemove.setOnAction(e -> handleRemove());

        // Layout
        HBox buttonBox = new HBox(10, btnRemove, btnClear, btnCheckout);
        buttonBox.setPadding(new Insets(10));

        VBox centerBox = new VBox(10, lblTitle, cartListView, lblTotal, buttonBox);
        centerBox.setPadding(new Insets(15));

        this.setCenter(centerBox);

        // Initial refresh
        refreshCart();
    }

    public void refreshCart() {
        cartListView.getItems().clear();
        
        for (CartItem item : controller.getCartItems()) {
            String display = String.format("%s x%d = Rp %.2f", 
                item.getProduct().getName(), 
                item.getQuantity(), 
                item.getSubtotal());
            cartListView.getItems().add(display);
        }

        double total = controller.getCartTotal();
        lblTotal.setText(String.format("Total: Rp %.2f", total));

        // Disable checkout if cart is empty
        btnCheckout.setDisable(controller.isCartEmpty());
    }

    private void handleCheckout() {
        try {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
            confirm.setTitle("Konfirmasi Checkout");
            confirm.setHeaderText("Total: Rp " + String.format("%.2f", controller.getCartTotal()));
            confirm.setContentText("Lanjutkan checkout?");

            if (confirm.showAndWait().get() == ButtonType.OK) {
                controller.checkout();
                new Alert(Alert.AlertType.INFORMATION, "Checkout berhasil!").show();
                refreshCart();
            }
        } catch (Exception ex) {
            new Alert(Alert.AlertType.ERROR, ex.getMessage()).show();
        }
    }

    private void handleClear() {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, 
            "Hapus semua item dari keranjang?", 
            ButtonType.YES, ButtonType.NO);
        
        if (confirm.showAndWait().get() == ButtonType.YES) {
            controller.clearCart();
            refreshCart();
            new Alert(Alert.AlertType.INFORMATION, "Keranjang dikosongkan!").show();
        }
    }

    private void handleRemove() {
        String selected = cartListView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            new Alert(Alert.AlertType.WARNING, "Pilih item yang ingin dihapus!").show();
            return;
        }

        try {
            // Extract product code from selected item
            int index = cartListView.getSelectionModel().getSelectedIndex();
            CartItem item = controller.getCartItems().get(index);
            controller.removeFromCart(item.getProduct().getCode());
            refreshCart();
            new Alert(Alert.AlertType.INFORMATION, "Item dihapus dari keranjang!").show();
        } catch (Exception ex) {
            new Alert(Alert.AlertType.ERROR, ex.getMessage()).show();
        }
    }
}