/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Avis;
import entities.User;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.AvisServices;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AvisUpdateController implements Initializable {

    @FXML
    private TextField nomUsertf;
    @FXML
    private TextField commenttf;
    @FXML
    private TextField notetf;
    @FXML
    private Button modifier;
    @FXML
    private ImageView imageAvis;
    private Avis avis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public Avis getAttribute() {
    String nom = nomUsertf.getText();
    String commentaire = commenttf.getText();
    int note = Integer.parseInt(notetf.getText());
    Avis a = new Avis(nom,note,commentaire);

    // Return the modified reclammation object
    return a;
}

    void setAvis(Avis selectedAvis) {
    this.avis = selectedAvis;
    }

    void setAttribute(Avis a)throws ParseException {
        this.avis = a;
        nomUsertf.setText(a.getNomUser());
        commenttf.setText(a.getCommentaire());
        notetf.setText(String.valueOf(a.getNote()));
    }

    void setAttribute(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public interface PopupListener {
        void onInfoSent( Boolean value);
    }
    private PopupListener listener;

    public void setListener(PopupListener listener) {
        this.listener = listener;
    }

    @FXML
     void confirmer(ActionEvent event) throws SQLException {
         /*
        AvisServices as = new AvisServices() {};
    Avis a = new Avis();
    a.setIdAvis(a.getIdAvis()); // Nécessaire pour mettre à jour la réclamation correcte
    a.setNomUser(nomUsertf.getText());
    a.setNote(Integer.parseInt(notetf.getText()));
    a.setCommentaire(commenttf.getText());
    as.modifier(a);
    try {
        if (listener != null) {
            listener.onInfoSent(true);
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    Stage stage = (Stage) modifier.getScene().getWindow();
    stage.close();

 */
    AvisServices as = new AvisServices() {};
    Avis a = getAttribute();
    a.setIdAvis(avis.getIdAvis()); // Nécessaire pour mettre à jour la réclamation correcte
    as.modifier(a);
    try {
        if (listener != null) {
            listener.onInfoSent(true);
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    Stage stage = (Stage) modifier.getScene().getWindow();
    stage.close();
}

         
         
}
         
    
    
