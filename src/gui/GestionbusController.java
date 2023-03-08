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
import javafx.scene.control.Label;
import services.ReservationService;

/**
 * FXML Controller class
 *
 * @author BouheniMed
 */
public class GestionbusController implements Initializable {

    @FXML
    private Label prix_ticket;
    @FXML
    private Button gestion_res;
    @FXML
    private Button gestion_ticket;
    
ReservationService rs = new ReservationService();

    Reservation r = new Reservation();
    @FXML
    private Button reservation;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
   

    @FXML
    private void gestion_ticket(ActionEvent event) throws IOException {

          FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Afficher_Ticket.fxml"));
            Parent root = loader.load();
            Afficher_TicketController controller = loader.getController();
            controller.setdataticket(r);

            gestion_ticket.getScene().setRoot(root);
    }
     @FXML
    private void gestion_res(ActionEvent event) throws IOException {
        
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Affich_res.fxml"));
            Parent root = loader.load();
            Affich_resController controller = loader.getController();
            controller.setdatareservation(r);

            gestion_res.getScene().setRoot(root);
    }

    @FXML
    private void reservationclient(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("reservation.fxml"));
            Parent root = loader.load();
            ReservationController controller = loader.getController();
            controller.setdatar(r);

            gestion_res.getScene().setRoot(root);
    }
}
