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
public class MainSignUp extends Application {
    
   @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader;
            loader = new FXMLLoader(getClass().getResource("../gui/SignUp.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root,852,620);
            primaryStage.setScene(scene);
            primaryStage.setTitle("ajouter User");
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


