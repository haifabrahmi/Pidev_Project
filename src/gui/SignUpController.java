/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Role;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
    private Button login;
    @FXML
    private RadioButton rbchauffeur;
    @FXML
    private RadioButton rbvoyageur;
    @FXML
    private RadioButton rbadmin;
    @FXML
    private Button SignUp;
    @FXML
    private Button Cancel;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {
        try {
                Parent page = FXMLLoader.load(getClass().getResource("Login.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

    }

    @FXML
    private void AjouterUser(ActionEvent event) {
         
         try {
             boolean verif = true;
        
        // Vérification du nom
        String nom = tfnom.getText();
        if (nom == null || nom.trim().isEmpty()) {
            verif = false;
        } else if (!nom.matches("^[a-zA-Z\\s]+$")) {
            verif = false;
        }
        // Vérification du prénom
        String prenom = tfprenom.getText();
        if (prenom == null || prenom.trim().isEmpty()) {
            verif = false;
        } else if (!prenom.matches("^[a-zA-Z\\s]+$")) {
            verif = false;
        }
         // Vérification du numéro de téléphone
        String number = tfnumber.getText();
        if (number == null || number.trim().isEmpty()) {
            verif = false;
        } else if (!number.matches("\\d+")) {
            verif = false;
        } else if (number.length() < 8) {
            verif = false;
        }
         // Vérification de l'adresse email
        String email = tfemail.getText();
        if (email == null || email.trim().isEmpty()) {
            verif = false;
        } else if (!email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
            verif = false;
        }
        // Vérification du mot de passe
        String password = tfpassword.getText();
        if (password == null || password.trim().isEmpty()) {
            verif = false;
        } else if (password.length() < 8) {
            verif = false;
        }
        // Vérification du rôle sélectionné
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
        if (!verif) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Avertissement");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez vérifier les informations saisies");
            alert.showAndWait();
        

     } else {
            UserServices us = new UserServices(){};
            User u = new User();
            u.setNom(nom);
            u.setPrenom(prenom);
            u.setEmail(email);
            u.setPassword(password);
            u.setNumber(Integer.parseInt(number));
            
            if (selectedRadioButton == rbadmin) {
                u.setRole(Role.admin);
            } else if (selectedRadioButton == rbchauffeur) {
                u.setRole(Role.chauffeur);
            } else if (selectedRadioButton == rbvoyageur) {
                u.setRole(Role.voyageur);
            }
         us.ajouter(u);
              String username = "sabrine.zekri1@esprit.tn";//change
          String passwords = "2020subreenesprit";//change
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, passwords);
            }
        });
        
        try {
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sabrine.zekri.2001@gmail.com"));//l mail eli bech yeb3ath
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse( tfemail.getText()));
            message.setSubject("Merci pour votre inscription");
            message.setText(" Bonjour "+tfnom.getText()+",\n" +
"\n" +
"Nous tenons à vous remercier pour votre inscription à Tunisbus. Nous sommes ravis de vous avoir parmi nos utilisateurs et nous espérons que vous trouverez notre application utile et facile à utiliser.\n" +
"\n" +
"Si vous avez des questions ou des commentaires, n'hésitez pas à nous contacter. Nous sommes là pour vous aider et nous sommes impatients de vous offrir la meilleure expérience possible.\n" +
"\n" +
"Merci encore pour votre confiance et votre soutien. Nous sommes heureux de vous avoir à bord.\n" +
"\n" +
"Cordialement,\n" +
"Dream workers");
            
            Transport.send(message);
            
            System.out.println("Le message a été envoyé avec succès !");
            
        } catch (MessagingException e) {
  e.printStackTrace();    
            System.out.println("erreur" );} 
        
        
        
       
     
     
     
 
     
    
    }
    
    
         } catch (NumberFormatException | SQLException ex) {
    System.out.println("Erreur lors de l'ajout de l'utilisateur : " + ex.getMessage());
            /*    Alert alert = new Alert(Alert.AlertType.WARNING);
    	        alert.setTitle("Avertissement");
    	        alert.setHeaderText(null);
    	        alert.setContentText("verifier les information saisie  ");
    	        alert.showAndWait();*/
}
    }

    @FXML
    private void Annuler(ActionEvent event) {
    }
    
}
