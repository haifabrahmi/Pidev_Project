/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.reclammation;
import entities.reponse;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import services.reponseService;

/**
 * FXML Controller class
 *
 * @author user
 */
public class GererRepController implements Initializable {

    @FXML
    private TextField tfresol;
    @FXML
    private DatePicker tfdate;
    @FXML
    private Button btnAjout;
    @FXML
    private Button Retour;
    @FXML
    private Button afficher_rep;
    
    reponseService rps = new reponseService();
    reponse rep = new reponse();
    reclammation rec = new reclammation();
    
//    @FXML
//    private TextField tfnom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterRep(ActionEvent event) {
        
        
    reponse rep = new reponse();
    rep.setResolution_reclam(tfresol.getText());
    java.sql.Date date = java.sql.Date.valueOf(tfdate.getValue());
    rep.setDate_reponse(date);
    
    // Créer un objet reclamation qui contient le nom de voyageur
    reclammation r = new reclammation();
    r.setNom_voyageur("Nom du voyageur");
    
    // Passer l'objet reclamation à la méthode ajouter de reponseService
    rep.setReclammation(r);
    rps.ajouter(rep);
    System.out.println("reponse ajoutée avec succes");
    }

    @FXML
    private void RetourRep(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
            Parent root = loader.load();
            AcceuilController controller = loader.getController();
                        controller.setdatarep(rep);

            

            Retour.getScene().setRoot(root);
    }

    @FXML
    private void afficherRep(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("afficheRep.fxml"));
            Parent root = loader.load();
            AfficheRepController controller = loader.getController();
            controller.setData(tfresol.getText()+""+tfdate.getValue());
            tfresol.getScene().setRoot(root);
            
            
        
    }

    void setdatarec(reponse rep) {
    }
    
}
