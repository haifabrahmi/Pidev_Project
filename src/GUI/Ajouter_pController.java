/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Content;
import entites.Poste;
import entites.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import services.PostServices;

/**
 * FXML Controller class
 *
 * @author 21651
 */
public class Ajouter_pController implements Initializable {

    private ObservableList<Content> obc = FXCollections.observableArrayList(Content.values());
    @FXML
    private TextArea text_area;
    @FXML
    private ChoiceBox<Content> myChoiceBox;
    @FXML
    private Label error;
    @FXML
    private Button ajouter;
    @FXML
    private Button retour;

    /**
     * initialise the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        myChoiceBox.setItems(obc);
    }

    @FXML
    private void ajouter(ActionEvent event) {
        Utilisateur user = new Utilisateur(1, "baha", "admin");
        LocalDate currentDate = LocalDate.now();
        String ta = text_area.getText();
        Content choix = myChoiceBox.getValue();
        if (ta.isEmpty()) {
            error.setText("Tous les champs sont obligatoires !");
        }
        PostServices sp = new PostServices();
        Date d = Date.valueOf(currentDate);
        Poste P = new Poste(0, 0, choix, d, ta, user, (byte) 0);
        sp.ajouter(P);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("afficher_p.fxml"));
            Parent root = loader.load();

            Scene scene = retour.getScene();
            scene.setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(Afficher_pController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void retour(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("afficher_p.fxml"));
            Parent root = loader.load();

            Scene scene = retour.getScene();
            scene.setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(Afficher_pController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
