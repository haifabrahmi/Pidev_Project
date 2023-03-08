/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui.image;

import edu.esprit.entities.Circuit;
import edu.esprit.entities.Station;
import edu.esprit.services.Service;
import edu.esprit.services.ServiceCircuit;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AjouterstationController implements Initializable {
 
    @FXML
    private TextField adresses;

    @FXML
    private Button afficher;

    @FXML
    private Button ajouter;

    @FXML
    private TextField commentaires;

    @FXML
    private TextField equipements;

    @FXML
    private DatePicker horaires;

    @FXML
    private TextField lignes;

    @FXML
    private TextField noms;

    /**
     * Initializes the controller class.
     */
     Service st = new Service();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
    String nom_s = noms.getText();
    String adresse_s = adresses.getText();
    String ligne_s = lignes.getText();
    String equipement_s = equipements.getText();
    String commentaire_s = commentaires.getText();
    Date horaire_s = Date.valueOf(horaires.getValue());

    if (nom_s == null || nom_s.trim().isEmpty() || adresse_s == null || adresse_s.trim().isEmpty()
            || ligne_s == null || ligne_s.trim().isEmpty() || equipement_s == null || equipement_s.trim().isEmpty()
            || commentaire_s == null || commentaire_s.trim().isEmpty()) {
        Alert a = new Alert(Alert.AlertType.WARNING, "Veuillez remplir tous les champs.", ButtonType.OK);
        a.showAndWait();
    } else {
        Station s = new Station(nom_s, adresse_s, ligne_s, horaire_s, equipement_s, commentaire_s);
        Service st = new Service();
        st.ajouter(s);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Station ajoutée", ButtonType.OK);
        a.showAndWait();
    }
}
  //  private void ajouter(ActionEvent event) {
//     String nom_s = noms.getText();
//String addresse_s = adresses.getText();
//String ligne_s = lignes.getText();
//    Date horaire_s = null;
//    String equipement_s = es.getText();
//String commentaire_s = commentaires.getText();
//
//    // Validation de saisie
//    if (nom_s.isEmpty() || commentaire_c.isEmpty()) {
//        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "Tous les champs sont requis", ButtonType.OK);
//        validationAlert.showAndWait();
//        return;
//    }
//
//    try {
//       
//        horaire_s = Date.valueOf(horaires.getValue());
//    
//    } catch (NullPointerException e) {
//        Alert validationAlert = new Alert(Alert.AlertType.ERROR, "L'horaire doit être sélectionné", ButtonType.OK);
//        validationAlert.showAndWait();
//        return;
//    }
//
//    }
//
//   
//
//    Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Station ajouté", ButtonType.OK);
//    a.showAndWait();
//
//    // Vider les champs de saisie
//    noms.setText("");
//    adresses.setText("");
//    lignes.setText("");
//    horaires.setValue(null);
//    equipements.setText("");
    //  commentaires.setText("");
//}
//       

      
    

    

    @FXML
    private void afficher(ActionEvent event) throws IOException {
         Station s = new Station();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("afficherstation.fxml"));
            Parent root = loader.load();
            AfficherstationController controller = loader.getController();
            controller.setdatastation(s);

      afficher.getScene().setRoot(root);
    }
    
}
