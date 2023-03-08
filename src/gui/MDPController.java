/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
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
public class MDPController implements Initializable {

    private TextField nomLogin;
    @FXML
    private Button Envoyer;
    @FXML
    private TextField codee;
    @FXML
    private TextField emaill;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      codee.setDisable(true);
    }    
    
    public void CreateConfigFile()  {
        try {
           File configFile = new File("config.properties");
            if (!configFile.exists()) {
                Properties properties = new Properties();
               try (OutputStream outputStream = new FileOutputStream(configFile)) {
                    properties.setProperty("database", "localhost");
                    properties.setProperty("username", "root");
                    properties.store(outputStream, "Database Configuration");
                }
           }
      } catch (IOException ex) {
        }
    
}

    private void envoyerEmail(String destinataire, String motDePasse) {
    // Lecture des identifiants SMTP à partir du fichier de configuration
        Properties props = new Properties();
        try (InputStream input = new FileInputStream("C:/Users/user/Documents/3A6-Sem2/tunibus/src/gui/config.properties")) {
            props.load(input);
        } catch (IOException ex) {
            System.out.println("Erreur lors de la lecture du fichier de configuration : " + ex.getMessage());
            return;
        }
        
        // Adresse e-mail de l'expéditeur
        String expediteur = props.getProperty("mail.smtp.user");
    
        // Mot de passe de l'expéditeur
        String motDePasseExpediteur = props.getProperty("mail.smtp.password");
    
        // Hôte du serveur SMTP
        String serveurSmtp = props.getProperty("mail.smtp.host");
    
        // Port du serveur SMTP
        int portSmtp = Integer.parseInt(props.getProperty("mail.smtp.port"));
    
        // Création d'une propriété pour la configuration de JavaMail
        props.put("mail.smtp.host", serveurSmtp);
        props.put("mail.smtp.port", portSmtp);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
    
        // Création d'une session pour la connexion au serveur SMTP
        Session session;
        session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(expediteur, motDePasseExpediteur);
            }
        });
    
        try {
            // Création du message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(expediteur));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire));
            message.setSubject("Mot de passe");
            message.setText("Votre mot de passe est : " + motDePasse);
        
            // Envoi du message
            Transport.send(message);
        
            System.out.println("L'e-mail a été envoyé à " + destinataire);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    

}

    
//    @FXML
//private void Envoyer(ActionEvent event) throws SQLException {
//    UserServices us=new UserServices() {};
//    String nomUtilisateur = nomLogin.getText();
//    String motDePasse = us.obtenirMotDePasse(nomUtilisateur); 
//    
//User user = us.findByUsername(nomUtilisateur);
//if(user != null) {
//    String motDePasse = user.getPassword();
//    envoyerEmail(user.getEmail(), motDePasse);
//}
//
//    
//    envoyerEmail(nomUtilisateur, motDePasse);
//}
      private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
          private static final Random random = new SecureRandom();

    public static String generateCode(int length) {
        StringBuilder codeBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            codeBuilder.append(randomChar);
        }
        return codeBuilder.toString();
    }
/*@FXML
private void Envoyer(ActionEvent event) throws SQLException {
            codee.setDisable(true);

 //verification de lexistance du mail
 String email=emaill.getText();
 UserServices a=new UserServices() {
 };
boolean test=a.findByemail(email);
if(test){
    //generate a code 
    String code = generateCode(8);
System.out.println("The generated code is: " + code);

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
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse( email));
            message.setSubject("Merci pour votre inscription");
            message.setText("");
            
            Transport.send(message);
                   Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Code Sent");
        alert.setHeaderText(null);
        alert.setContentText("A code has been sent to your email. Please enter the code");
        alert.showAndWait();
            
            System.out.println("Le message a été envoyé avec succès !");
            
        } catch (MessagingException e) {
            System.out.println("erreur" );} 
        
        codee.setDisable(false);
       Envoyer.setText("confierrmer");
    
    
}else {
    
    
            Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("User Not Found");
        alert.setHeaderText(null);
        alert.setContentText("The email address entered is not registered.");
        alert.showAndWait();
    
}
 
 
 
 
}*/

    @FXML
    private void Envoyer(ActionEvent event) throws SQLException {
   

    // Verification de l'existence du mail
    String email = emaill.getText();
    UserServices a = new UserServices() {};
     boolean test = a.findByemail(email);
    if (test) {
        // Génération du code
        String code = generateCode(8);
        System.out.println("Le code généré est : " + code);

        String username = "sabrine.zekri1@esprit.tn"; // Changer
        String passwords = "2020subreenesprit"; // Changer

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
            message.setFrom(new InternetAddress("sabrine.zekri.2001@gmail.com")); // L'adresse email à partir de laquelle le message sera envoyé
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("code");
            message.setText("Votre code de vérification est : " + code);

            Transport.send(message);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Code Envoyé");
            alert.setHeaderText(null);
            alert.setContentText("Un code a été envoyé à votre adresse email. Veuillez saisir le code");
            alert.showAndWait();

            // Attendre que l'utilisateur entre le code
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Confirmation du code");
            dialog.setHeaderText(null);
            dialog.setContentText("Saisissez le code que vous avez reçu par email :");

            Optional<String> result = dialog.showAndWait();
            if (result.isPresent() && result.get().equals(code)) {
                // Code correct
                Alert alert2 = new Alert(AlertType.INFORMATION);
                alert2.setTitle("Code correct");
                alert2.setHeaderText(null);
                alert2.setContentText("Le code que vous avez entré est correct.");
                alert2.showAndWait();
            codee.setText(a.returnmdp(email));
            } else {
                // Code incorrect
                Alert alert2 = new Alert(AlertType.ERROR);
                alert2.setTitle("Code incorrect");
                alert2.setHeaderText(null);
                alert2.setContentText("Le code que vous avez entré est incorrect.");
                alert2.showAndWait();
            }

        } catch (MessagingException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

         
        Envoyer.setText("Confirmer");

    } else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Utilisateur introuvable");
        alert.setHeaderText(null);
        alert.setContentText("L'adresse email saisie n'est pas enregistrée.");
        alert.showAndWait();
    }
}

    
}
