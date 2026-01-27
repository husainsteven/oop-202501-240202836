package com.upb.agripos.view;

import com.upb.agripos.controller.PosController;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class PosView extends BorderPane {
    private PosController controller;
    private ProductTableView productTableView;
    private CartView cartView;

    public PosView() {
        this.controller = new PosController();
        initializeUI();
    }

    private void initializeUI() {
        TabPane tabPane = new TabPane();
        
        cartView = new CartView(controller);
        productTableView = new ProductTableView(controller, cartView);

        Tab tabProducts = new Tab("Kelola Produk", productTableView);
        Tab tabCart = new Tab("Keranjang", cartView);

        tabProducts.setClosable(false);
        tabCart.setClosable(false);

        tabPane.getTabs().addAll(tabProducts, tabCart);

        this.setCenter(tabPane);
    }

    public PosController getController() {
        return controller;
    }
}