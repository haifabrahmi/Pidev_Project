/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Reservation;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author BouheniMed
 */
public class TicketController implements Initializable {

    @FXML
    private Label immat;
    @FXML
    private Label heurer;
    @FXML
    private Label dater;
    @FXML
    private Label nbp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setdataticket(Reservation r) {
    immat.setText(String.valueOf(r.getImatriculation()));
        dater.setText(String.valueOf(r.getDate_res()));
                heurer.setText(String.valueOf(r.getHeure_res()));
                nbp.setText(String.valueOf(r.getNb_place()));


    }
    
}
