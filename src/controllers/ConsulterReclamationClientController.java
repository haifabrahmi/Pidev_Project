/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Reclamation;
import entities.Reponse;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.CRUDReclamation;
import services.CRUDReponse;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class ConsulterReclamationClientController implements Initializable {

    @FXML
    private TableView<Reclamation> tableRecClient;
    @FXML
    private TableColumn<Reclamation, String> categorie_traite;
    @FXML
    private TableColumn<Reclamation, String> objet_traite;
    @FXML
    private TableColumn<Reclamation, Integer> etat_traite;
    @FXML
    private TableColumn<Reclamation, String> reclamationClient;
    @FXML
    private TableView<Reponse> ViewReponse;
    @FXML
    private TableColumn<Reponse, Integer> idRec;
    @FXML
    private TableColumn<Reponse, String> rep;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherReclamations();
        afficherReponses();
    }
        
        public void afficherReclamations() {
       CRUDReclamation reclamation = new CRUDReclamation();
        ObservableList<Reclamation> ReclamationList =  reclamation.afficherReclamationsClient();
         
       
         
        categorie_traite.setCellValueFactory(new PropertyValueFactory<>("categorie_Reclamation"));
        objet_traite.setCellValueFactory(new PropertyValueFactory<>("objet_Reclamation"));
        etat_traite.setCellValueFactory(new PropertyValueFactory<>("etat_Reclamation"));
        reclamationClient.setCellValueFactory(new PropertyValueFactory<>("description_Reclamation"));
        tableRecClient.setItems(ReclamationList);
        
        
        
    }
        
        public void afficherReponses() {
       CRUDReponse reponse = new CRUDReponse();
        ObservableList<Reponse> ReponseList =  reponse.afficherReponsesClient();
         
       
         
        idRec.setCellValueFactory(new PropertyValueFactory<>("id_Reclamation"));
        rep.setCellValueFactory(new PropertyValueFactory<>("description_Reponse"));
    
        ViewReponse.setItems(ReponseList);
    }    

    private void supprimer(ActionEvent event) {
       // Récupérer la réclamation sélectionnée dans la table
    Reclamation selectedReclamation = tableRecClient.getSelectionModel().getSelectedItem();

    // Vérifier si une réclamation est sélectionnée
    if (selectedReclamation == null) {
        // Afficher un message d'erreur si aucune réclamation n'est sélectionnée
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Aucune réclamation sélectionnée");
        alert.setContentText("Veuillez sélectionner une réclamation dans la table.");
        alert.showAndWait();
        return;
    }

    // Demander une confirmation avant de supprimer la réclamation
    Alert confirmation = new Alert(AlertType.CONFIRMATION);
    confirmation.setTitle("Confirmation");
    confirmation.setHeaderText("Supprimer la réclamation");
    confirmation.setContentText("Êtes-vous sûr de vouloir supprimer la réclamation ?");
    Optional<ButtonType> result = confirmation.showAndWait();
    if (result.get() == ButtonType.OK){
        // Supprimer la réclamation de la base de données
        CRUDReclamation reclamation = new CRUDReclamation();
        reclamation.supprimerReclamation(selectedReclamation);

        // Rafraîchir la table des réclamations
        afficherReclamations();
    } else {
        // Annuler la suppression si l'utilisateur annule la confirmation
        event.consume();
    }

    }
    
}
