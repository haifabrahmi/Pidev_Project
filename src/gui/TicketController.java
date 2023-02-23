/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Reservation;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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
    @FXML
    private ImageView retour;

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
    @FXML
    private void retour(MouseEvent event) throws IOException {
        Reservation r = new Reservation();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Reservation.fxml"));
            Parent root = loader.load();
            ReservationController controller = loader.getController();
            controller.setdataReservation(r);

            retour.getScene().setRoot(root);
    }
    }
    

