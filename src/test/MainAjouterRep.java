/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class MainAjouterRep extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ajouterReponse.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root,600,400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("ajouter reponse");
            primaryStage.show();

        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
