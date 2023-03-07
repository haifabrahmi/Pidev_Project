/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.bus;
import entities.maintenance;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import services.busService;
import services.maintenanceService;

/**
 * FXML Controller class
 *
 * @author haifa
 */
public class AjoutermaintenanceController implements Initializable {

        busService bs = new busService();
        bus b =new bus();

    @FXML
    private TextField sai_description;
    @FXML
    private DatePicker sai_dateentretien;
    
    @FXML
    private Button ajoutermain;
   
    
    maintenanceService ms = new maintenanceService();
     maintenance m = new maintenance();
    @FXML
    private AnchorPane sai_num_plaque;
    @FXML
    private Button affichermain;
    @FXML
    private Button Retourmain;
    @FXML
    private ComboBox<Integer> combo;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Integer> plaques = new ArrayList<Integer>();
            try {
                plaques = bs.getNumeroDePlaquesUnique();
            } catch (SQLException ex) {
                Logger.getLogger(AjoutermaintenanceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        combo.getItems().addAll(plaques);
    }    

    @FXML
    private void ajouter_main(ActionEvent event) throws SQLException {
        
         String description = sai_description.getText();
         LocalDate entretienDate = sai_dateentretien.getValue();
         int numPlaque = combo.getValue();
          // Vérifier si les champs obligatoires sont vides
    if (description.isEmpty() ||entretienDate == null) {
        // Afficher un message d'erreur et sortir de la méthode
        Alert alert = new Alert(Alert.AlertType.ERROR, "Veuillez remplir tous les champs obligatoires.");
        alert.showAndWait();
        return;
    }
     // Vérifier si les champs 'Modèle' et 'Destination' contiennent uniquement des lettres
    if (!description.matches("[a-zA-Z]+")) {
        // Afficher un message d'erreur et sortir de la méthode
        Alert alert = new Alert(Alert.AlertType.ERROR, "Le champs 'description' doivent contenir uniquement des lettres.");
        alert.showAndWait();
        return;
    }

        
          maintenance b = new maintenance();
          
          b.setNumPlaqueOfBus(numPlaque);
    
       b.setDescription(sai_description.getText());
        java.sql.Date date = java.sql.Date.valueOf(sai_dateentretien.getValue());
            b.setDate_entretien(date);
        //b.setbus(b);
         
            
        try {
           ms.ajouter(b);
            reset();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
         private void reset() {
       sai_description.setText("");  
       sai_dateentretien.setValue(LocalDate.now());
      
    }

    @FXML
    private void afficher_main(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("affichermain.fxml"));
            Parent root = loader.load();
            AffichermainController controller = loader.getController();
            controller.setdatamaintenance(m);

           affichermain.getScene().setRoot(root);
    }
     void setdatamaintenance(maintenance bs) {
     }

    @FXML
    private void Retourmain(ActionEvent event) throws IOException {
    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainbus.fxml"));
            Parent root = loader.load();
            MainbusController controller = loader.getController();
            controller.setdatabus(b);

            Retourmain.getScene().setRoot(root);
        
            
                            
          
            }

   
}
    
    
            
   

    

