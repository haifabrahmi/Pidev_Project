/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Reclamation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.CRUDReclamation;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class RechercheReclamationController implements Initializable {

    @FXML
    private ComboBox<String> comborech;
    @FXML
    private TableView<Reclamation> tablerech;
    @FXML
    private TableColumn<Reclamation, Integer> recrech;
    @FXML
    private TableColumn<Reclamation, Integer> userrech;
    @FXML
    private TableColumn<Reclamation, String> catrech;
    @FXML
    private TableColumn<Reclamation, String> objrech;
    @FXML
    private TableColumn<Reclamation, String> descrech;
    @FXML
    private TableColumn<Reclamation, Integer> etrech;
    private String etatSelectionne ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       /* RechercherReclamation(etatSelectionne);
        afficherReclamations() ;*/
        
        comborech.getItems().addAll("Admin","Chauffeur","Voyageur");
        comborech.setOnAction(event->{ 
        
                 etatSelectionne = comborech.getSelectionModel().getSelectedItem();
                System.out.println(etatSelectionne);
   
    
   
    // Appeler la méthode rechercherReclamation avec l'état sélectionné
   /// CRUDReclamation crudReclamation = new CRUDReclamation();
   // ObservableList<Reclamation> reclamations = reclamations.RechercherReclamation(etatSelectionne);
    CRUDReclamation crudReclamation = new CRUDReclamation();
    ObservableList<Reclamation> listeReclamations = crudReclamation.RechercherReclamation(etatSelectionne);
    ObservableList<Reclamation> reclamations = FXCollections.observableArrayList(listeReclamations);
     recrech.setCellValueFactory(new PropertyValueFactory<>("id_Reclamation"));
        userrech.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        catrech.setCellValueFactory(new PropertyValueFactory<>("categorie_Reclamation"));
        objrech.setCellValueFactory(new PropertyValueFactory<>("objet_Reclamation"));
        descrech.setCellValueFactory(new PropertyValueFactory<>("description_Reclamation"));
        etrech.setCellValueFactory(new PropertyValueFactory<>("etat_Reclamation"));
        
          
    tablerech.setItems(FXCollections.observableArrayList(reclamations));
} );
    }
    

// Ajouter le ComboBox à votre interface utilisateur
// Par exemple, si vous utilisez JavaFX :
/*AnchorPane anchorPane = new AnchorPane();
anchorPane.getChildren().addAll(comboBox, tableView);
AnchorPane.setTopAnchor(comboBox, 10.0);
AnchorPane.setLeftAnchor(comboBox, 10.0);
AnchorPane.setTopAnchor(tableView, 50.0);
AnchorPane.setLeftAnchor(tableView, 10.0);*/
    
    
    /* public void afficherReclamations() {
       CRUDReclamation R = new CRUDReclamation();
        ObservableList<Reclamation> ReclamationList = (ObservableList<Reclamation>) R.afficherReclamations();

       
       
        recrech.setCellValueFactory(new PropertyValueFactory<>("id_Reclamation"));
        userrech.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        catrech.setCellValueFactory(new PropertyValueFactory<>("categorie_Reclamation"));
        objrech.setCellValueFactory(new PropertyValueFactory<>("objet_Reclamation"));
        descrech.setCellValueFactory(new PropertyValueFactory<>("description_Reclamation"));
        etrech.setCellValueFactory(new PropertyValueFactory<>("etat_Reclamation"));
        tablerech.setItems(ReclamationList);
    }*/

    private void RechercherReclamation(String etatSelectionne) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
