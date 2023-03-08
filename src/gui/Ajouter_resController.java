package gui;

import entities.Coupon;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

import entities.Reservation;
import entities.Ticket;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import services.CouponService;
import services.ReservationService;
import services.TicketService;

public class Ajouter_resController implements Initializable {

    @FXML
    private TextField nb_place;
    @FXML
    private DatePicker dateres;
    @FXML
    private ChoiceBox<String> heure_res;
    private String[] data = {"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00" };

    ReservationService rs = new ReservationService();
    Reservation r = new Reservation();
    @FXML
    private ChoiceBox<String> type_ticket;
    @FXML
    private Label prix_ticket;
    @FXML
    private Label price;
    @FXML
    private Button ajouter_res;
    @FXML
    private Button afficher;

    @Override
public void initialize(URL url, ResourceBundle rb) {
    
    heure_res.getItems().addAll(data);
    heure_res.getSelectionModel().clearSelection();
    
    try {
        // Create an instance of the TicketService class
        TicketService ticketService = new TicketService();

        // Get the list of tickets from the database
        List<Ticket> tickets = ticketService.recuperer();

        // Create an ObservableList of type String to hold the type_ticket values
        ObservableList<String> typeTickets = FXCollections.observableArrayList();

        // Loop through the tickets list and add the type_ticket values to the typeTickets list
        tickets.stream().forEach((ticket) -> {
            typeTickets.add(ticket.getType_ticket());
        });

        // Set the type_ticket values in the type_ticketChoiceBox
        type_ticket.setItems(typeTickets);

        // Set a listener to update the price label when a new ticket type is selected
        type_ticket.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                try {
                    // Get the price of the selected ticket type
                    float prix = (float) ticketService.getPrixByType(newValue);


                    // Set the price in the price label
                    prix_ticket.setText(String.format("%.0f", prix));

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }

    // Set the minimum date to the current date
    dateres.setValue(LocalDate.now());

    // Set the maximum date to one year from the current date
    LocalDate maxDate = LocalDate.now().plus(1, ChronoUnit.YEARS);
    dateres.setDayCellFactory(d -> new DateCell() {
        @Override
        public void updateItem(LocalDate item, boolean empty) {
            super.updateItem(item, empty);
            if (item.isBefore(dateres.getValue()) || item.isAfter(maxDate)) {
                setDisable(true);
            }
        }
    });
    
}
    public void setajoutres(Reservation r) {
    }
    @FXML
    private void ajouterReservation(ActionEvent event) throws SQLException {
    // Vérifier si tous les champs sont remplis
    if (dateres.getValue() == null || nb_place.getText().isEmpty() || heure_res.getValue() == null || type_ticket.getValue() == null || prix_ticket.getText() == null   ) {
        // Afficher un message d'erreur si l'un des champs est vide
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs !");
        alert.showAndWait();
        return;
    }
     // Vérifier si le champ 'nb_place' contient un nombre valide
   
        int nbPlace = Integer.parseInt(nb_place.getText());
        if (nbPlace > 5) {
            // message d'erreur si le nombre de places dépasse 3
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Le nombre de places ne doit pas dépasser 5 !");
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

    r.setPrix(Float.parseFloat(prix_ticket.getText())); // get the price value from the label

    r.setNb_place (Integer.parseInt(nb_place.getText()));
    r.setDate_res(Date.valueOf(dateres.getValue()));
    r.setHeure_res(heure_res.getValue());
    r.setType_ticket(type_ticket.getValue());
    int nb_place = r.getNb_place();
    double prix = r.getPrix();
    double total_price = nb_place * prix;
    price.setText(String.valueOf(total_price));
    r.setPrix_totale(Float.parseFloat(price.getText()));
    rs.ajouter(r);

    
}


   

   


    @FXML
    private void afficher(ActionEvent event) {
        
    }


    
}
