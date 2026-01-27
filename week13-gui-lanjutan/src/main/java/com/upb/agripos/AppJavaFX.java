package com.upb.agripos;

import com.upb.agripos.view.ProductTableView; // Import view baru

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppJavaFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Menggunakan ProductTableView sebagai root
        ProductTableView root = new ProductTableView(); 
        
        // Ukuran Scene disesuaikan agar tabel terlihat luas
        Scene scene = new Scene(root, 800, 600); 
        
        primaryStage.setTitle("Agri-POS System - Week 13 Lanjutan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}