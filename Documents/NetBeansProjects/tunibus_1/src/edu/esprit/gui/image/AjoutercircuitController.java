/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui.image;

import edu.esprit.entities.Circuit;
import edu.esprit.entities.Station;
import edu.esprit.services.ServiceCircuit;
import java.awt.AWTException;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AjoutercircuitController implements Initializable {

    @FXML
    private Button affiche;

    @FXML
    private Button ajoute;

    @FXML
    private TextField distance_c1;

    @FXML
    private DatePicker horaire_c1;

    @FXML
    private TextField liste_c1;

    @FXML
    private TextField nbrbus_c1;

    @FXML
    private TextField nom_c1;
    /**
     * Initializes the controller class.
     */
    ServiceCircuit sc = new ServiceCircuit();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    

  @FXML
private void ajoute(ActionEvent event) throws AWTException {
    String nom_c = nom_c1.getText();
    int liste_c = 0;
    int nbrbus_c = 0;
    Date horaire_c = null;
    String distance_c = distance_c1.getText();

    // Validation de saisie
    if (nom_c.isEmpty() || distance_c.isEmpty()) {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "Tous les champs sont requis", ButtonType.OK);
        validationAlert.showAndWait();
        return;
    }

    try {
        liste_c = Integer.parseInt(liste_c1.getText());
        nbrbus_c = Integer.parseInt(nbrbus_c1.getText());
        horaire_c = Date.valueOf(horaire_c1.getValue());
    } catch (NumberFormatException e) {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "Le numéro de liste et le nombre de bus doivent être des nombres entiers", ButtonType.OK);
        validationAlert.showAndWait();
        return;
    } catch (NullPointerException e) {
        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "L'horaire doit être sélectionné", ButtonType.OK);
        validationAlert.showAndWait();
        return;
    }



   

    Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Circuit ajouté", ButtonType.OK);
    a.showAndWait();

    // Vider les champs de saisie
    nom_c1.setText("");
    liste_c1.setText("");
    nbrbus_c1.setText("");
    horaire_c1.setValue(null);
    distance_c1.setText("");
}

    @FXML
    private void affiche(ActionEvent event) throws IOException {
        Circuit c = new Circuit();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("affichercircuit.fxml"));
        Parent root = loader.load();
        AffichercircuitController controller = loader.getController();
        controller.setdatacircuit(c);

        affiche.getScene().setRoot(root);
    }

}
