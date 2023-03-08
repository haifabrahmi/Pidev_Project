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
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ModifiercircuitController implements Initializable {

    @FXML
    private TextField nom_c1;
    @FXML
    private TextField nbrbus_c1;
    @FXML
    private TextField liste_c1;
    @FXML
    private TextField distance_c1;
    @FXML
    private DatePicker horaire_c1;
    @FXML
    private Button annuler1;
    @FXML
    private Button confirmer;
    
     public interface PopupListener{
    void onInfoSent(Boolean value);
    }
    private PopupListener Listener;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
        Circuit c = new Circuit();
    public void setAtrtribute(Circuit c) throws ParseException {
        this.c = c;
        // Remplir les champs de texte avec les données de la station
        nom_c1.setText(c.getNom_c());
        liste_c1.setText(String.valueOf(c.getListe_c()));
        nbrbus_c1.setText(String.valueOf(c.getNbrbus_c()));
        distance_c1.setText(c.getDistance_c());
        
        java.util.Date utilDate =new java.util.Date(c.getHoraire_c().getTime());
        LocalDate localDate = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate localDate1 = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  
      System.out.println(localDate);
        // format the date using the formatter
            
        
        horaire_c1.setValue(localDate);
    }
   public void setListener(ModifiercircuitController.PopupListener listener) {
        this.Listener = listener;
    }
        // TODO
    
    @FXML
    private void annuler1(ActionEvent event) {
    Stage stage = (Stage) annuler1.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void confirmer(ActionEvent event) {
         c.setNom_c(nom_c1.getText());
        
        c.setListe_c(Integer.parseInt(liste_c1.getText()));
        c.setNbrbus_c(Integer.parseInt(nbrbus_c1.getText()));
        c.setDistance_c(distance_c1.getText());
        
        java.sql.Date date = java.sql.Date.valueOf(horaire_c1.getValue());
        c.setHoraire_c(date);
         ServiceCircuit sc = new ServiceCircuit();     
         sc.modifier(c);
          if (Listener != null) {
            Listener.onInfoSent(true);
    }
  Stage stage = (Stage) annuler1.getScene().getWindow();
        stage.close();
    }
    
}
