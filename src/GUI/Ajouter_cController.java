/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Comment;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import services.CommentServices;
import services.PostServices;

/**
 * FXML Controller class
 *
 * @author 21651
 */
public class Ajouter_cController implements Initializable {

    private ObservableList<Content> obc = FXCollections.observableArrayList(Content.values());

    @FXML
    private ChoiceBox<Content> myChoiceBox;
    @FXML
    private Label errorr;
    @FXML
    private TextArea textarea;
    private Poste poste;
    @FXML
    private Button comm;
    @FXML
    private Label e;

    /**
     * initialise the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        myChoiceBox.setItems(obc);
    }

    public void setPoste(Poste p) {
        this.poste = p;
    }

    @FXML
    private void ajouter(ActionEvent event) {

        Utilisateur user = new Utilisateur(1, "baha", "admin");
        LocalDate currentDate = LocalDate.now();
        String ta = textarea.getText();
        Content choix = myChoiceBox.getValue();
        if (ta.isEmpty()) {
            errorr.setText("Tous les champs sont obligatoires !");
        }
        
        //Poste p = new Poste(7,200, 2000, Content.text, d,"description", user,(byte)0);
        CommentServices sc = new CommentServices();
        Date d = Date.valueOf(currentDate);
        Comment c = new Comment(choix, d, user, poste, ta);
        sc.ajouter(c);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("afficher_c.fxml"));
            Parent root = loader.load();
            
            Scene scene = comm.getScene();
           scene.setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(Ajouter_cController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
