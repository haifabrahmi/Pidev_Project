/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.maintenance;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author haifa
 */
public class MaintenanceController implements Initializable {

     
    @FXML
    private Label Description;
    @FXML
    private Label date_entretien;
    @FXML
    private Label id_user;
    @FXML
    private AnchorPane id_m;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
      public void setbus(maintenance b) {
            Description.setText(b.getDescription());
           date_entretien.setText(String.valueOf(b.getDate_entretien()));
           //id_m.setText(String.valueOf(b.getId_m()));
          
           
    
}
}