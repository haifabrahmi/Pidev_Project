/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import entities.Reclamation;
import entities.Reponse;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.CRUDReclamation;
import services.CRUDReponse;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class ConsulterReclamationAdminController implements Initializable {

    @FXML
    private Button envoyerReponse;
    @FXML
    private Button supprimerrec;
    @FXML
    private Button modifierrec;
    @FXML
    private TextArea textReponse;
    @FXML
    private TextField idReclamationAdmin;
    @FXML
    private TableView<Reclamation> tablerec;
    @FXML
    private TableColumn<?, ?> UtilisateurReclamation;
    @FXML
    private TableColumn<?, ?> id_reclamation;
    @FXML
    private TableColumn<?, ?> categorieReclamation;
    @FXML
    private TableColumn<?, ?> objetReclamation;
    @FXML
    private TableColumn<?, ?> rec;
    @FXML
    private TableColumn<?, ?> etatReclamation;
    @FXML
    private Button rechercherrec;

    /**
     * Initializes the controller class.
     */
  @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherReclamations();
        selectReclamation();
        modifierrec.setOnAction(event -> {
            Reclamation reclamation = new Reclamation(Integer.parseInt(idReclamationAdmin.getText()));
            CRUDReclamation rec = new CRUDReclamation();
            rec.etat(reclamation);
            afficherReclamations();
        });
       
        /*rechercherrec.setOnAction
        (event -> {
            Reclamation reclamation = new Reclamation(Integer.parseInt(idReclamationAdmin.getText()));
          /*  CRUDReclamation rec = new CRUDReclamation();
            rec.RechercherReclamation("0");
            afficherReclamations();*/
         // CRUDReclamation crR = new CRUDReclamation();

        // Appeler la méthode rechercherReclamation avec l'état "0"
       // ObservableList<Reclamation> reclamationsEtatZero = crR.RechercherReclamation("1");

        // Mettre à jour l'interface utilisateur avec la liste de réclamations
        // tablerec.setItems(FXCollections.observableArrayList(reclamationsEtatZero));

            
               
     //   });
     
      rechercherrec.setOnAction( e ->{ 
             try {
                Parent root = FXMLLoader.load(getClass().getResource("/gui/rechercheReclamation.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Consultation des réclamations");
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {

            }
         });
        envoyerReponse.setOnAction( e -> {
        if (textReponse.getText().isEmpty() )
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("Information Dialog");

                alert.setHeaderText(null);

                alert.setContentText("Veuillez remplir tous les champs!");

                alert.show();
                }
            else {
            
        Reponse rep = new Reponse(Integer.parseInt(idReclamationAdmin.getText()),textReponse.getText());
        CRUDReponse crud1=new CRUDReponse();
        crud1.ajouterReponse(rep);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("Information Dialog");

                alert.setHeaderText(null);

                alert.setContentText("Reponse ajoutée avec succés!");

                alert.show();
        }
    
    } );
        
         supprimerrec.setOnAction(event -> {
             Reclamation R1= new Reclamation(Integer.parseInt(idReclamationAdmin.getText()));
             CRUDReclamation rec = new CRUDReclamation();
            rec.supprimerReclamation(R1);
            afficherReclamations();
            
            });
        
        
    }  
    
    public void afficherReclamations() {
       CRUDReclamation R = new CRUDReclamation();
        ObservableList<Reclamation> ReclamationList = (ObservableList<Reclamation>) R.afficherReclamations();

       
        UtilisateurReclamation.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        id_reclamation.setCellValueFactory(new PropertyValueFactory<>("id_Reclamation"));
        categorieReclamation.setCellValueFactory(new PropertyValueFactory<>("categorie_Reclamation"));
        objetReclamation.setCellValueFactory(new PropertyValueFactory<>("objet_Reclamation"));
        rec.setCellValueFactory(new PropertyValueFactory<>("description_Reclamation"));
        etatReclamation.setCellValueFactory(new PropertyValueFactory<>("etat_Reclamation"));
        tablerec.setItems(ReclamationList);
    }
    
     
    
    
    
    public void selectReclamation() {
       tablerec.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                
                idReclamationAdmin.setText(Integer.toString(newValue.getId_Reclamation()));
                
            }
        });
    }    
    
}