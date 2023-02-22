/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.reclammation;
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
public class AjouterReclammationController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private DatePicker tfdate;
    @FXML
    private TextField tfdes;
    @FXML
    private Button btnAjout;

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
    private void afficheReclammation(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherReclammation.fxml"));
            Parent root = loader.load();
            AfficherReclammationController controller = loader.getController();
            controller.setData(tfnom.getText() + " " + tfdes.getText()+" "+ tfdate.getValue());
            tfdate.getScene().setRoot(root);
            
        } catch (IOException ex) {
            System.out.println("error" + ex.getMessage());
        }
        
            
        }
    
    
}
