/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author haifa
 */
public class MenuintegrationController implements Initializable {

    @FXML
    private Button mainb;
    @FXML
    private Button mainrec;
    @FXML
    private Button mainblog;
    @FXML
    private Button mainres;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void go_to_bus(ActionEvent event) {
          try {
          Parent root = FXMLLoader.load(getClass().getResource("mainbus.fxml"));
                    Scene sence = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(sence);
                    stage.show();
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    @FXML
    private void go_to_rec(ActionEvent event) {
           try {
          Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                    Scene sence = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(sence);
                    stage.show();
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    @FXML
    private void go_to_blog(ActionEvent event) {
         try {
          Parent root = FXMLLoader.load(getClass().getResource("FrontEnd_Publication.fxml"));
                    Scene sence = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(sence);
                    stage.show();
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    @FXML
    private void go_to_res(ActionEvent event) {
         try {
          Parent root = FXMLLoader.load(getClass().getResource("Gestionbus.fxml"));
                    Scene sence = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(sence);
                    stage.show();
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    @FXML
    private void go_to_station(ActionEvent event) {
        try {
          Parent root = FXMLLoader.load(getClass().getResource("../edu/esprit/gui/image/Maintest.fxml"));
                    Scene sence = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(sence);
                    stage.show();
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    @FXML
    private void go_to_user(ActionEvent event) {
        try {
          Parent root = FXMLLoader.load(getClass().getResource("Menuuser.fxml"));
                    Scene sence = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(sence);
                    stage.show();
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
    
}
