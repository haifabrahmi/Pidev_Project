/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Reponse;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.CRUDReponse;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class AfficherReponsesController implements Initializable {

    @FXML
    private TableView<Reponse> tableReponse;
    @FXML
    private TableColumn<Reponse,Integer> idrep;
    @FXML
    private TableColumn<Reponse,Integer> idrec;
    @FXML
    private TableColumn<Reponse,String> rep;
    private Button Retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherReponses();
    }    
    
    

    private void afficherReponses() {
       CRUDReponse Rp = new CRUDReponse();
        ObservableList<Reponse> ReponseList = (ObservableList<Reponse>) Rp.afficherReponses2();

       
        
        idrep.setCellValueFactory(new PropertyValueFactory<>("id_Reponse"));
        idrec.setCellValueFactory(new PropertyValueFactory<>("id_Reclamation"));
       rep.setCellValueFactory(new PropertyValueFactory<>("description_Reponse"));
        tableReponse.setItems(ReponseList);
    }

    @FXML
    private void supprimer(ActionEvent event) {
        Reponse reponseSelectionnee = tableReponse.getSelectionModel().getSelectedItem();
    if (reponseSelectionnee != null) {
        CRUDReponse rp = new CRUDReponse();
        rp.supprimerReponse(reponseSelectionnee);
        tableReponse.getItems().remove(reponseSelectionnee);
        // Afficher un message de confirmation de suppression
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Suppression réussie");
        alert.setHeaderText(null);
        alert.setContentText("La réponse a été supprimée avec succès.");
        alert.showAndWait();
    } else {
        // Aucune réponse sélectionnée, afficher un message d'erreur
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Suppression impossible");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez sélectionner une réponse à supprimer.");
        alert.showAndWait();
    }
        
    }

    private void RetourRep(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Menu.fxml"));
            Parent root = loader.load();
            MenuController controller = loader.getController();
                        controller.setdatarep(rep);

            

            Retour.getScene().setRoot(root);
    }
}
