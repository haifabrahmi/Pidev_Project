/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Reponse;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import services.CRUDReponse;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class ReponseReclamationController implements Initializable {

    @FXML
    private Button envoyerReponse;
    @FXML
    private TextArea textReponse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    
      {
    envoyerReponse.setOnAction( e -> {
        if (textReponse.getText().isEmpty() )
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("Information Dialog");

                alert.setHeaderText(null);

                alert.setContentText("Veuillez remplir tous les champs!");

                alert.show();
                }
            else {
            
        
        Reponse rep = new Reponse(12,textReponse.getText());
        CRUDReponse crud1=new CRUDReponse();
        crud1.ajouterReponse(rep); }
    
    } );
} 
}