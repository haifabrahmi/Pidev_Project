/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author haifa
 */
public class ajouterbusmain extends Application {
    
      public void start(Stage primaryStage) {
   try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ajouterbus.fxml"));
            Parent root = loader.load();
            Scene sc = new Scene(root);
            primaryStage.setTitle("bus");
            primaryStage.setScene(sc);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
        
    public static void main(String[] args) {
        launch(args);
    }
    
}