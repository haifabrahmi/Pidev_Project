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
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.UserServices;

/**
 * FXML Controller class
 *
 * @author user
 */
public class UserUpDateController implements Initializable {

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
    private RadioButton rbchauffeur;
    @FXML
    private RadioButton rbvoyageur;
    @FXML
    private RadioButton rbadmin;
    @FXML
    private Button modifer;
    private PopupListener listener;
    private User user;
    private User User;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public User getAttribute() {
    String nom = tfnom.getText();
    String prenom = tfprenom.getText();
    int number = Integer.parseInt(tfnumber.getText());
    String email = tfemail.getText();
    String password = tfpassword.getText();
    
     Role role;
    if(rbadmin.isSelected())
        role = Role.admin;
    else if (rbchauffeur.isSelected())
        role = Role.chauffeur;
    else
        role = Role.voyageur;
    
    User u = new User(nom, prenom, number, email, password, role);
    
    return u;

}
    void setAvis(User selectedUser) {
    this.User = selectedUser;
    }
    
    void setAttribute(User a)throws ParseException {
        this.user = a;
        tfnom.setText(a.getNom());
        tfprenom.setText(a.getPrenom());
        tfnumber.setText(String.valueOf(a.getNumber()));
        tfemail.setText(a.getEmail());
        tfpassword.setText(a.getPassword());
    }

    public interface PopupListener {
        void onInfoSent( Boolean value);
    }
    
@FXML
    public void setListener(PopupListener listener) {
        this.listener = listener;
    }


    @FXML
     void modifier(ActionEvent event) throws SQLException {
        
        UserServices us = new UserServices() {};
    User u = getAttribute();
    u.setIdUser(u.getIdUser()); // Nécessaire pour mettre à jour la réclamation correcte
    us.modifier(u);
    try {
        if (listener != null) {
            listener.onInfoSent(true);
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    Stage stage = (Stage) modifer.getScene().getWindow();
    stage.close();
        

    }
    
 

}
