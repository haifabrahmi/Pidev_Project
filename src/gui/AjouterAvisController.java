/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Avis;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.AvisServices;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AjouterAvisController implements Initializable {

    @FXML
    private TextField nomUsertf;
    @FXML
    private TextField commenttf;
    @FXML
    private TextField notetf;
    @FXML
    private Button bAjouterAvis;

        AvisServices as = new AvisServices();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void AjouterAvis(ActionEvent event) {
        try {
            Avis a = new Avis();
            a.setNomUser(nomUsertf.getText());
            a.setCommentaire(commenttf.getText());
            a.setNote(Integer.parseInt(notetf.getText()));
            as.ajouter(a);
            System.out.println("Avis ajouter avec succes");
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }
    
    
}
