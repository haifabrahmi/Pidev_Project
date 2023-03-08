/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafx.application.Application;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import entities.Photo;
import javafx.stage.Stage;
/**
 *
 * @author Baklouti
 */
public class NewMain extends Application {
   @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../gui/FrontEnd_Publication.fxml"));
                        //Parent root = FXMLLoader.load(getClass().getResource("../gui/AddCom.fxml"));

            Scene scene = new Scene(root);
            primaryStage.setTitle("Ajout publication");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException ex) {
            System.out.println("Err" + ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        

    } 
}
