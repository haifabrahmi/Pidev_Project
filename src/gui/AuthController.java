/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import entities.Role;
import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.UserServices;


/**
 * FXML Controller class
 *
 * @author Bejaoui
 */
public class AuthController implements Initializable {
    Connection cnx = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }
    @FXML
    private TextField nomLogin;
    @FXML
    private Button signUp;
    @FXML
    private Button Login;
    @FXML
    private Label showPassword;
    @FXML
    private ToggleButton ToggleButton;
    @FXML
    private PasswordField passwordField;
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
    private Button login;
    @FXML
    private Button SignUp;
    @FXML
    private Button Cancel;
    @FXML
    private AnchorPane pane_signup;
    @FXML
    private AnchorPane pane_login;
    @FXML
    private RadioButton rbchauffeur;
    @FXML
    private RadioButton rbvoyageur;
    @FXML
    private RadioButton rbadmin;
    
    UserServices us = new UserServices() {};
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // type_up.getItems().addAll("Admin","Client","Partenaire")
        //type_in.getItems().addAll("Admin","Client","Partenaire");
    }    

    @FXML
    private void LoginPaneShow(ActionEvent event) {
        pane_login.setVisible(true);
        pane_signup.setVisible(false);
    }

    @FXML
    private void signupPaneShow(ActionEvent event) {
        pane_login.setVisible(false);
        pane_signup.setVisible(true);
    }

    @FXML
    private void login(ActionEvent event) {
        //cnx = ConnexionSource.getInstance().getCnx();
        String req = "SELECT * FROM user WHERE nom = ? and password = ? ";
        
            try {
            pst = cnx.prepareStatement(req);
            pst.setString(1, tfnom.getText());
            pst.setString(2, tfpassword.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login Successfully");
                
                login.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                
            }else {
                JOptionPane.showMessageDialog(null, "Invalide Username or Password ");
            }
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }

    private void signup(ActionEvent event) {
        
       try {
        
        boolean verif = true;
        
        //***************************************************
        String nom = tfnom.getText();
if (nom == null || nom.trim().isEmpty()) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    	        alert.setTitle("Avertissement");
    	        alert.setHeaderText(null);
    	        alert.setContentText("verifier les information saisie  ");
    	        alert.showAndWait();
                System.out.println("erreeeeeeur");
    verif = false;
    
    return;
}
if (!nom.matches("^[a-zA-Z\\s]+$")) {
    verif = false;
    return;
}
        //***************************************************
        String prenom = tfprenom.getText();
if (nom == null || nom.trim().isEmpty()) {
    verif = false;
    return;
}
if (!nom.matches("^[a-zA-Z\\s]+$")) {
    verif = false;
    return;
}
        //***************************************************
        String number = tfnumber.getText();
if (number == null || number.trim().isEmpty()) {
    verif = false;
    return;
}
if (!number.matches("\\d+")) {
    verif = false;
    return;
}
if (number.length() < 8) {
    verif = false;
    return;
}
        //***************************************************
        String email = tfemail.getText();
if (email == null || email.trim().isEmpty()) {
    verif = false;
    return;
}
if (!email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
    verif = false;
    return;
}
        //***************************************************
        String password = tfpassword.getText();
if (password == null || password.trim().isEmpty()) {
    verif = false;
    return;
}
if (password.length() < 8) {
    verif = false;
    return;
}
        //***************************************************
RadioButton selectedRadioButton = null;
    if (rbadmin.isSelected()) {
        selectedRadioButton = rbadmin;
    } else if (rbchauffeur.isSelected()) {
        selectedRadioButton = rbchauffeur;
    } else if (rbvoyageur.isSelected()) {
        selectedRadioButton = rbvoyageur;
    } else {
        verif = false;
    }

        //***************************************************
if (verif==false)
{
                Alert alert = new Alert(Alert.AlertType.WARNING);
    	        alert.setTitle("Avertissement");
    	        alert.setHeaderText(null);
    	        alert.setContentText("verifier les information saisie  ");
    	        alert.showAndWait();
                System.out.println("erreeeeeeur");
}
//***************************************************
        

        
        
        
        
    

    if (selectedRadioButton != null) {
        User u = new User();
        u.setNom(tfnom.getText());
        u.setPrenom(tfprenom.getText());
        u.setEmail(tfemail.getText());
        u.setPassword(tfpassword.getText());
        u.setNumber(Integer.parseInt(tfnumber.getText()));
        if (selectedRadioButton == rbadmin) {
            u.setRole(Role.admin);
        } else if (selectedRadioButton == rbchauffeur) {
            u.setRole(Role.chauffeur);
        } else if (selectedRadioButton == rbvoyageur) {
            u.setRole(Role.voyageur);
        }
        us.ajouter(u);
        System.out.println("ajout avec succee");
       
    }
    
    
         } catch (Exception ex) {
    System.out.println("Erreur lors de l'ajout de l'utilisateur : " + ex.getMessage());
            /*    Alert alert = new Alert(Alert.AlertType.WARNING);
    	        alert.setTitle("Avertissement");
    	        alert.setHeaderText(null);
    	        alert.setContentText("verifier les information saisie  ");
    	        alert.showAndWait();*/
}
    }

    @FXML
    private void toggleButton(ActionEvent event) {
    }

    @FXML
    private void PasswordField(ActionEvent event) {
    }

    @FXML
    private void AjouterUser(ActionEvent event) {
    }

    @FXML
    private void Annuler(ActionEvent event) {
    }



  


   
    
}
