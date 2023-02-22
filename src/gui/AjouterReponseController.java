/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
import services.reponseService;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AjouterReponseController implements Initializable {

    @FXML
    private TextField tfresol;
    @FXML
    private DatePicker tfdate;
    @FXML
    private Button btnAjout;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         btnAjout.setOnAction(e -> {
            reponse rep = new reponse();
            rep.setResolution_reclam(tfresol.getText());
            java.sql.Date date = java.sql.Date.valueOf(tfdate.getValue());
            rep.setDate_resolution(date);            
            new reponseService().ajouter(rep);
            tfresol.setText("");
            tfdate.setValue(LocalDate.now());
        });
    }    

    @FXML
    private void afficheReponse(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("afficherReclammation.fxml"));
            Parent root = loader.load();
            AfficherReclammationController controller = loader.getController();
            controller.setData(tfresol.getText() + " "+ tfdate.getValue());
            tfresol.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
        
            
        }
    }
    
