/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Comment;
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
import services.CommentServices;
import services.PostServices;

/**
 * FXML Controller class
 *
 * @author 21651
 */
public class Modifier_cController implements Initializable {

    @FXML
    private TextArea des;
    @FXML
    private Button modifier;
    @FXML
    private TextField idC;
    private Content cont;
    private Utilisateur user;
    private Poste p;

    /**
     * Initialise the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setComment(Comment c) {
        des.setText(c.getDescriptioncomment());
        String idp = String
                .valueOf(c.getId_comment());
        idC.setText(idp);
        cont = c.getContent_comment();
        user = c.getUser_id();
        p = c.getId_p();

    }

    @FXML
    private void modifier(ActionEvent event) {
        try {
            CommentServices ps = new CommentServices();
            Utilisateur user = new Utilisateur(1, "baha", "admin");
            String d = des.getText();
            int ide = Integer.parseInt(idC.getText());
            idC.setEditable(false);
            idC.setDisable(true);
            LocalDate currentDate = LocalDate.now();
            Date dateee = Date.valueOf(currentDate);
            Comment c = new Comment(ide, cont, dateee, user, p, d);
            
            ps.modifier(c);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("afficher_c.fxml"));
            Parent root = loader.load();
            
            Scene scene = modifier.getScene();
            scene.setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(Modifier_cController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
