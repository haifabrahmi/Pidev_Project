/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Role;
import entities.User;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import services.UserServices;

/**
 * FXML Controller class
 *
 * @author user
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfpassword;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfnumber;
    @FXML
    private TextField tfprenom;
    @FXML
    private RadioButton rbadmin;
    @FXML
    private RadioButton rbchauffeur;
    @FXML
    private RadioButton rbvoyageur;
    @FXML
    private Button blogin;
    @FXML
    private ToggleGroup rbGroup;
    
    UserServices us  = new UserServices();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void AjouterUser(ActionEvent event) {
        RadioButton selectedRadioButton = (RadioButton) rbGroup.getSelectedToggle();
        String selectedOption = selectedRadioButton.getText();
        User u = new User();
        u.setNom(tfnom.getText());
        u.setPrenom(tfprenom.getText());
        u.setEmail(tfemail.getText());
        u.setPassword(tfpassword.getText());
        u.setNumber(Integer.parseInt(tfnumber.getText()));
        // Vérification de l'option sélectionnée
        if (selectedRadioButton == rbadmin) {
            
            u.setRole(Role.admin);
        } else if (selectedRadioButton == rbchauffeur) {
            
            u.setRole(Role.chauffeur);
        } else if (selectedRadioButton == rbvoyageur) {
            
            u.setRole(Role.voyageur);
        } else {
            // Aucune option sélectionnée
        }
                    System.out.println("User ajouter avec succes");

    }
}
