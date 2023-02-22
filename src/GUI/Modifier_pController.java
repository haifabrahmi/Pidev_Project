/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Content;
import entites.Poste;
import entites.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import services.PostServices;

/**
 * FXML Controller class
 *
 * @author 21651
 */
public class Modifier_pController implements Initializable {

    @FXML
    private TextArea description;
    @FXML
    private TextField id;
    @FXML
    private Button modifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         id.setDisable(true);
        // TODO
    }    
    public void setPoste(Poste p){
        description.setText(p.getDescription());
        String idp = String.valueOf(p.getId_post());
        id.setText(idp);
    }

    @FXML
    private void modifier(ActionEvent event) {
        PostServices ps=new PostServices();
                  Utilisateur user = new Utilisateur(1, "baha","admin");
                  String d=description.getText();
                  int ide = Integer.parseInt(id.getText());
        id.setEditable(false);
        id.setDisable(true);
        LocalDate currentDate =LocalDate.now();
        Date dateee =Date.valueOf(currentDate);
                   Poste p = new Poste(ide,200, 2000, Content.text, dateee,d, user, (byte)0);
                   
        System.out.println(p);
       ps.modifier(p);
       try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("afficher_p.fxml"));
            Parent root = loader.load();
            Scene scene = modifier.getScene();
            scene.setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(Afficher_pController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
