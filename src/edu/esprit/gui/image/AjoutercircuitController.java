/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui.image;

import edu.esprit.entities.Circuit;
import edu.esprit.entities.Station;
import edu.esprit.services.ServiceCircuit;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
    private void ajoute(ActionEvent event) {

           String nom_c = nom_c1.getText();
             int liste_c = Integer.parseInt(liste_c1.getText());
        int nbrbus_c = Integer.parseInt(nbrbus_c1.getText());
        Date horaire_c = Date.valueOf(horaire_c1.getValue());

        String distance_c = distance_c1.getText();

        Circuit c = new Circuit(nom_c,liste_c , nbrbus_c, horaire_c, distance_c);
        ServiceCircuit sc = new ServiceCircuit();
        sc.ajouter(c);

        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "circuit ajouter", ButtonType.OK);
        a.showAndWait();
        
        

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
