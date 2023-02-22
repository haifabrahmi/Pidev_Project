/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.bus;
import entites.maintenance;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import services.busService;
import services.maintenanceService;

/**
 * FXML Controller class
 *
 * @author haifa
 */
public class AjoutermaintenanceController implements Initializable {

    
    @FXML
    private TextField Description;
    @FXML
    private DatePicker date_entretien;
      maintenanceService ms = new maintenanceService();
    @FXML
    private AnchorPane id_bus;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ajouter(ActionEvent event) {
         maintenance b= new maintenance();
       b.setDescription(Description.getText());
        java.sql.Date date = java.sql.Date.valueOf(date_entretien.getValue());
            b.setDate_entretien(date);
           //int id_bus = Integer.parseInt(id_bus.getText());

             
        try {
            ms.ajouter(b);
            reset();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

         private void reset() {
       Description.setText("");
      date_entretien.setValue(LocalDate.now());
      
    
    }
    
    }
    

