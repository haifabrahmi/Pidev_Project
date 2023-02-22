/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.Station;
import edu.esprit.services.Service;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AjouterstationController implements Initializable {

  
    @FXML
    private TextField noms;
    @FXML
    private TextField lignes;
    @FXML
    private TextField adresses;
    @FXML
    private TextField equiprments;
    @FXML
    private TextField commentraires;
    @FXML
    private DatePicker horaires;

    // instance database Service
    Service st = new Service();
  //  PersonneService ps = new PersonneService();
    @FXML
    private Label ajouterStation;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        Station s =new Station();
        s.setNom_s(noms.getText());
        s.setLigne_s(lignes.getText());
        s.setAdresse_s(adresses.getText());
        s.setEquipement_s(equiprments.getText());
        s.setCommentaire_s(commentraires.getText());
        LocalDate localDate = horaires.getValue();
    LocalDateTime localDateTime = localDate.atStartOfDay();
    Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
    s.setHoraire_s(Date.from(instant));
        st.ajouter(s);
        System.out.println("station ajouter avec succes");
    
}

    @FXML
    private void afficher(ActionEvent event) {
    }
}

  /*  @FXML
    private void afficher(ActionEvent event) {
       try
       {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Afficher.fxml"));
    AffichestationController controller = loader.getController();
     controller.setData(noms.getText() + " " + lignes.getText()adresses.getText() + " " + equiprments.getText()commentraires.getText() + " " + horaires.getDate());
    }
       catch (IOException ex)
    {
            System.out.println("error" + ex.getMessage());
    }
    }*/
 