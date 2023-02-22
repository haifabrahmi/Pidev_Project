/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.bus;
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

/**
 * FXML Controller class
 *
 * @author haifa
 */
public class AjouterbusController implements Initializable {

    @FXML
    private TextField tfmodel;
    @FXML
    private TextField tfnumdeplaque;
    @FXML
    private TextField tfcapacite;
    @FXML
    private DatePicker tfdatedepart;
    @FXML
    private DatePicker tfdatedarrive;
    
     busService bs = new busService();
    @FXML
    private AnchorPane tfiduser;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         
        
    }    

    @FXML
    private void afficher(ActionEvent event) {
         
        
           
      
             }
    

    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
         bus b = new bus();
       b.setModele(tfmodel.getText());
        b.setNumeroPlaque(Integer.parseInt(tfnumdeplaque.getText()));
        b.setCapacite(Integer.parseInt(tfcapacite.getText()));
        java.sql.Date date = java.sql.Date.valueOf(tfdatedepart.getValue());
            b.setDepart(date);
             java.sql.Date date1 = java.sql.Date.valueOf(tfdatedarrive.getValue());
            b.setArrivee(date1); 
            
        try {
            bs.ajouter(b);
            reset();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
         private void reset() {
       tfmodel.setText("");
        tfnumdeplaque.setText("");
       tfcapacite.setText("");
        tfdatedepart.setValue(LocalDate.now());
        tfdatedarrive.setValue(LocalDate.now());
    
    }
    

        
         /*
            b.setModele(tfmodel.getText());
            b.getNumeroPlaque(Integer.parseInt(numdeplaqueField).getText);
            b.getcapacite(Integer.parseInt(capaciteField).getText);
             java.sql.Date date = java.sql.Date.valueOf(tfdatedepart.getValue());
            b.setArrivee(date); 
            java.sql.Date date1 = java.sql.Date.valueOf(tfdatedarrive.getValue());
            b.setArrivee(date1);    
            new busService().ajouter(b);
            tfmodel.setText("");
           tfnumdeplaque.setText("");
           tfcapacite.set
            tfdate.setValue(LocalDate.now());
        
   */
    }
    

