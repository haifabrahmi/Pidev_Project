/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.bus;
import java.net.URL;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.time.LocalDate;
/**
 * FXML Controller class
 *
 * @author haifa
 */
public class BusController implements Initializable {

    @FXML
    private Label Numdeplaquecapacite;
    @FXML
    private Label datedepartdatearrive;
    @FXML
    private Label modele;
    @FXML
   

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
        public void setbus(bus b) {
           Numdeplaquecapacite.setText(String.valueOf(b.getNumeroPlaque()) + " " + b.getCapacite());
           datedepartdatearrive.setText(String.valueOf(b.getArrivee())+ " " + b.getDepart());
           modele.setText(b.getModele());
           
          
           
        }

    
}
