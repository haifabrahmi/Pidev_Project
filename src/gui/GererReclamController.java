/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.reclammation;
import entities.reponse;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import services.reclammationService;

/**
 * FXML Controller class
 *
 * @author user
 */
public class GererReclamController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private DatePicker tfdate;
    @FXML
    private TextField tfdes;
    @FXML
    private Button btnAjout;
    @FXML
    private Button Retour;
    
     reclammationService rs= new reclammationService();
   reclammation r = new reclammation();
    @FXML
    private Button afficher_reclam;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         btnAjout.setOnAction(e -> {
            reclammation r = new reclammation();
            r.setNom_voyageur(tfnom.getText());
            r.setDescription(tfdes.getText());
           java.sql.Date date = java.sql.Date.valueOf(tfdate.getValue());
            r.setDate_depot(date);  
          new reclammationService().ajouter(r);

            
            

            tfnom.setText("");
            tfdes.setText("");
            tfdate.setValue(LocalDate.now());
        });
    }    

    @FXML
    private void RetourReclam(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
            Parent root = loader.load();
            AcceuilController controller = loader.getController();
                        controller.setdatarec(r);

            

            Retour.getScene().setRoot(root);
    }

    @FXML
    private void afficherRec(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("afficheReclam.fxml"));
            Parent root = loader.load();
            AfficheReclamController controller = loader.getController();
            controller.setdatarec1(r);

            Retour.getScene().setRoot(root);
    
    }

    void setdatarec(reclammation r) {
    }

    void setdatarec(reponse rep) {
    }

    }
    
