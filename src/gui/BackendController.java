/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Reservation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import services.ReservationService;



public class BackendController implements Initializable {
    
    @FXML
    private Button backend;
    @FXML
    private Button frontend;
  

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
            ReservationService rs = new ReservationService();
            Reservation r = new Reservation ();

      @FXML
    private void backend(ActionEvent event) throws IOException {
       
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Afficher_res.fxml"));
            Parent root = loader.load();
            Afficher_resController controller = loader.getController();
            controller.setdataReservation(r);

            backend.getScene().setRoot(root);
    }
            
            
            @FXML
    private void frontend(ActionEvent event) throws IOException {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("reservation.fxml"));
            Parent root = loader.load();
            ReservationController controller = loader.getController();
            controller.setdataReservation(r);

            frontend.getScene().setRoot(root);
    }
    

  
    }
    

