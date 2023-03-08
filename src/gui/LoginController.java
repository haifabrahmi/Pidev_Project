/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.UserServices;

/**
 * FXML Controller class
 *
 * @author user
 */
public class LoginController implements Initializable {

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
    
    private Stage primaryStage;
    
    UserServices us = new UserServices() {};
    @FXML
    private Button mdp;
    
    
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showPassword.setVisible(false);
    }    

    @FXML
    private void signUp(ActionEvent event) {
        try {
                Parent page = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
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
    private void login(ActionEvent event) {
        try{
            User user = new User();
       
            us.login(nomLogin,passwordField);
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Menuintegration.fxml"));
                    Parent root = loader.load();
                    AdminController AdminController = loader.getController();
                    AdminController.setIdUser(user);
                    Stage stage = (Stage) ((Node) nomLogin).getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.setResizable(false);
                    stage.show();
            
        } catch (IOException ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @FXML
    private void toggleButton(ActionEvent event) throws IOException {
        String nom = nomLogin.getText();
        String password = passwordField.getText();
        
        // Vérifie si l'utilisateur est un admin
        
               
        // Vérifie si l'utilisateur est un voyageur ou chauffeur
            
           
        // Si les informations de connexion sont incorrectes
        
        
        
        if (ToggleButton.isSelected()){
            showPassword.setVisible(true);
            showPassword.textProperty().bind(Bindings.concat(passwordField.getText()));
            ToggleButton.setText("Hide");
            
        }else{
            showPassword.setVisible(false);
            ToggleButton.setText("Hide");
        }
    }

    @FXML
    private void PasswordField(ActionEvent event) {
        showPassword.textProperty().bind(Bindings.concat(passwordField.getText()));
    }

    @FXML
    private void password(KeyEvent event) {
        String password = passwordField.getSelectedText();

    }

    @FXML
    private void MDP(ActionEvent event) {
         try {
                Parent page = FXMLLoader.load(getClass().getResource("MDP.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }

    private void mdpp(ActionEvent event) {
                 try {
                Parent page = FXMLLoader.load(getClass().getResource("MDP.fxml"));
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
    private void MDPPP(MouseEvent event) {
              try {
                Parent page = FXMLLoader.load(getClass().getResource("MDP.fxml"));
                Scene scene = new Scene(page);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
    }
    
}
