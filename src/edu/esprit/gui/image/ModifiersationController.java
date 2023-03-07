/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui.image;

import edu.esprit.entities.Station;
import edu.esprit.services.Service;
import java.net.URL;
import java.sql.Date;
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
public class ModifiersationController implements Initializable {
   
    private PopupListener listener;

    @FXML
    private TextField noms2;
    @FXML
    private TextField adresses2;
    @FXML
    private TextField lignes2;
    @FXML
    private TextField equipements2;
    @FXML
    private TextField commentaires2;
    @FXML
    private DatePicker horaires2;
    @FXML
    private Button enregitrementbtn;
    @FXML
    private Button annuler;
    public interface PopupListener{
    void onInfoSent(Boolean value);
    }
    private PopupListener Listener;
    
   

   
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }     
    Station s =new Station();
    public void setAtrtribute(Station s) throws ParseException {
        this.s = s;
        // Remplir les champs de texte avec les données de la station
        noms2.setText(s.getNom_s());
        adresses2.setText(s.getAdresse_s());
        lignes2.setText(s.getLigne_s());
        equipements2.setText(s.getEquipement_s());
        commentaires2.setText(s.getCommentaire_s());
        java.util.Date utilDate =new java.util.Date(s.getHoraire_s().getTime());
        LocalDate localDate = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate localDate1 = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  
      System.out.println(localDate);
        // format the date using the formatter
            
        
        horaires2.setValue(localDate);
    }
   public void setListener(PopupListener listener) {
        this.listener = listener;
    }
    @FXML
    void annuler(ActionEvent event) {
   Stage stage = (Stage) annuler.getScene().getWindow();
        stage.close();
    }
    

    @FXML
    private void enregitrement(ActionEvent event) {
          s.setNom_s(noms2.getText());
        s.setAdresse_s(adresses2.getText());
        s.setLigne_s(lignes2.getText());
        s.setEquipement_s(equipements2.getText());
        s.setCommentaire_s(commentaires2.getText());
        java.sql.Date date = java.sql.Date.valueOf(horaires2.getValue());
        s.setHoraire_s(date);
        Service st = new Service();
        st.modifier(s);
    }
    





  
}

    
