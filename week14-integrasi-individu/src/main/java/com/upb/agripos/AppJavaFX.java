package com.upb.agripos;

import com.upb.agripos.view.PosView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppJavaFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        System.out.println("Hello World, I am HUSAIN STEFANO-240202836");
        System.out.println("===========================================");
        System.out.println("Agri-POS System - Bab 14 Integrasi Individu");
        System.out.println("===========================================");
        
        PosView posView = new PosView();
        
        Scene scene = new Scene(posView, 900, 600);
        
        primaryStage.setTitle("Agri-POS System - Bab 14 Integrasi Individu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}