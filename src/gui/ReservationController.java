/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.sql.*;
import entities.Reservation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import services.ReservationService;

/**
 * FXML Controller class
 *
 * @author BouheniMed
 */
public class ReservationController implements Initializable {
    //private ObservableList<Content> obc =FXCollections.observableArrayList(Content.values());
    @FXML
    private Button ajouter_res;
    @FXML
    private TextField nb_place;
    @FXML
    private DatePicker dateres;
    @FXML
    private Button goback;
    @FXML
    private TextField heureres;
    
            ReservationService rs = new ReservationService();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // heureres.setItems(obc);
    }    
  Reservation r = new Reservation();
                
   @FXML
private void ajouterReservation(ActionEvent event) throws SQLException {
    // Vérifier si tous les champs sont remplis
    if(dateres.getValue() == null || nb_place.getText().isEmpty() || heureres.getText().isEmpty()) {
        // Afficher un message d'erreur si l'un des champs est vide
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs !");
        alert.showAndWait();
        return;
    }

    // Vérifier si le champ 'nb_place' contient un nombre valide
    try {
        Integer.parseInt(nb_place.getText());
    } catch (NumberFormatException e) {
        // message d'erreur si le champ 'nb_place' ne contient pas un nombre valide
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText(null);
        alert.setContentText("Le champ 'Nombre de places' doit contenir un nombre valide !");
        alert.showAndWait();
        return;
    }

    // Si toutes les saisies sont valides, ajouter la réservation
    r.setImatriculation(34);
    r.setId_ticket(223);
    r.setId_usr(222);
    r.setDate_res(Date.valueOf(dateres.getValue()));
    r.setNb_place(Integer.parseInt(nb_place.getText()));
    r.setHeure_res(heureres.getText());

    rs.ajouter(r);
}

    

    @FXML
    private void retour(ActionEvent event) throws IOException {
        r.setImatriculation(34);
                r.setId_ticket(223);
                r.setId_usr(222);
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Ticket.fxml"));
            Parent root = loader.load();
            TicketController controller = loader.getController();
            controller.setdataticket(r);

            goback.getScene().setRoot(root);
    }
     void setdataReservation(Reservation r) {
     }
    
}
