package GUI;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import entities.Reservation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.ReservationService;

public class Modifier_resController implements Initializable {

    @FXML
    private TextField nb_place_input;

    @FXML
    private DatePicker date_res_input;

    @FXML
    private TextField heure_res_input;

    @FXML
    private Button modifier;

    @FXML
    private TextField prix_totale_input;

    ReservationService rs = new ReservationService();
    Reservation r = new Reservation();
    Afficher_resController arc = new Afficher_resController();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void modifier_reservation() throws SQLException {
        String nb_place_text = nb_place_input.getText();
        String heure_res_text = heure_res_input.getText();
        String prix_totale_text = prix_totale_input.getText();
        java.sql.Date date_res = java.sql.Date.valueOf(date_res_input.getValue());

        if (!nb_place_text.isEmpty() && !heure_res_text.isEmpty() && !prix_totale_text.isEmpty()
                && date_res != null) {
            // check if nb_place is integer
            if (nb_place_text.matches("\\d+")) {
                int nb_place = Integer.parseInt(nb_place_text);
                float prix_totale = Float.parseFloat(prix_totale_text);

                r.setDate_res(date_res);
                r.setHeure_res(heure_res_text);
                r.setNb_place(nb_place);
                r.setPrix_totale(prix_totale);

                rs.modifier(r);

                // update the tableview
                arc.ListRes.clear();
                arc.ListRes.addAll(rs.recuperer());
                arc.tv.refresh();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Modification réussie");
                alert.setHeaderText(null);
                alert.setContentText("La réservation a été modifiée avec succès !");
                alert.showAndWait();

                // close the window
                Stage stage = (Stage) modifier.getScene().getWindow();
                stage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de saisie");
                alert.setHeaderText(null);
                alert.setContentText("Le champ nombre de places doit contenir un entier !");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Champ(s) vide(s)");
            alert.setHeaderText(null);
            alert.setContentText("Tous les champs doivent être remplis !");
            alert.showAndWait();
        }
    }

   public void setReservation(Reservation reservation) {
        this.reservation = reservation;
        // Set the existing reservation data in the input fields
        date_res.setText(reservation.getDate_res().toString());
        heure_res.setText(reservation.getHeure_res());
        nb_place.setText(Integer.toString(reservation.getNb_place()));
        prix_totale.setText(Float.toString(reservation.getPrix_totale()));
        immatriculation.setText(Integer.toString(reservation.getImatriculation()));
        id_ticket.setText(Integer.toString(reservation.getId_ticket()));
        id_usr.setText(Integer.toString(reservation.getId_usr()));
    }


   

}
