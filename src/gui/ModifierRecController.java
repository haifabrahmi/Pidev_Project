/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.reclammation;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.reclammationService;
import java.sql.Date;
import java.time.LocalDate;


/**
 * FXML Controller class
 *
 * @author user
 */
public class ModifierRecController implements Initializable {

    @FXML
    private TextField sai_nom;
    @FXML
    private TextField sai_desc;
    @FXML
    private Button confirmButton;
    
       @FXML
    private Button closeButon;

    public reclammation getAttribute() {
 String nom = sai_nom.getText();
    String description = sai_desc.getText();
   

    // Create a new reclammation object with the retrieved data
    reclammation rec = new reclammation(nom, description);

    // Return the modified reclammation object
    return rec;
    }

    
    
    
    
    public interface PopupListener {
        void onInfoSent( Boolean value);
    }
    private PopupListener listener;

    public void setListener(PopupListener listener) {
        this.listener = listener;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                   try {
        confirmButton.setOnAction(event -> {
            try {
                confirmer(event);
            } catch (SQLException e) {
                // Gérer l'exception ici
                e.printStackTrace();
            }
        });
    } catch (Exception e) {
        e.printStackTrace();
    }
    }    
    
    reclammation r = new reclammation();
    public void setAttribute(reclammation r) throws ParseException{
        
        this.r=r;
        
        //System.out.println("hola"+r.getDate_depot());
        sai_nom.setText(r.getNom_voyageur());
        sai_desc.setText(r.getDescription());
     
        
        
    }
    
    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage) closeButon.getScene().getWindow();
        stage.close();
        
        
    }
    
    
 
    @FXML
    public void confirmer(ActionEvent event) throws SQLException{
         reclammationService rs = new reclammationService();
    reclammation reclammation = new reclammation();
    reclammation.setId_rec(r.getId_rec()); // Nécessaire pour mettre à jour la réclamation correcte
    reclammation.setNom_voyageur(sai_nom.getText());
    reclammation.setDescription(sai_desc.getText());
    rs.modifier(reclammation);
    try {
        if (listener != null) {
            listener.onInfoSent(true);
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    Stage stage = (Stage) confirmButton.getScene().getWindow();
    stage.close();

   
}}
