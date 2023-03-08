/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui.image;

import edu.esprit.entities.Circuit;
import edu.esprit.entities.Station;
import edu.esprit.services.ServiceCircuit;
import edu.esprit.utils.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
 
public class AffichercircuitController implements Initializable {
      @FXML
    private TableView<Circuit> tv2;


    @FXML
    private TableColumn<Circuit,String> nom_c;
    @FXML
    private TableColumn<Circuit,Integer> liste_c;
    @FXML
    private TableColumn<Circuit,Integer> nbrbus_c;
    @FXML
    private TableColumn<Circuit,Date> horaire_c;
    @FXML
    private TableColumn<Circuit,String> distance_c;
ServiceCircuit sc = new ServiceCircuit();
Circuit c = new Circuit();
 ObservableList<Circuit>  ListCIR = FXCollections.observableArrayList();
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
  
    public void remplir(){
       try{
             List list = sc.getAll();
        ListCIR.addAll(list);
        nom_c.setCellValueFactory(new PropertyValueFactory<>("nom_c"));
        liste_c.setCellValueFactory(new PropertyValueFactory<>("liste_c"));
        nbrbus_c.setCellValueFactory(new PropertyValueFactory<>("nbrbus_c"));
        horaire_c.setCellValueFactory(new PropertyValueFactory<>("horaire_c"));
        distance_c.setCellValueFactory(new PropertyValueFactory<>("distance_c"));
         tv2.setItems(ListCIR);
       }catch(Exception e){
           System.out.println("asslema"+e);
    }}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        remplir();
        
        
    }    
    void setdatacircuit(Circuit c) {
     }  
   
    

    @FXML
    private void supprimer1(  ActionEvent event) {
        
    

  Circuit c = tv2.getSelectionModel().getSelectedItem(); // Récupérer le circuit sélectionné
    if (c != null) {
        sc.supprimer(c.getId_c()); // Appeler la méthode "supprimer" du service en lui passant l'ID du circuit à supprimer
        ListCIR.remove(c); // Supprimer le circuit de la liste observable
    }
    }

    @FXML
    private void modifier1(ActionEvent event) throws IOException, ParseException {
        Circuit circuit = tv2.getSelectionModel().getSelectedItem();
    if (circuit != null) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifiercircuit.fxml"));
        Parent root = loader.load();
        ModifiercircuitController controller = loader.getController();
        
        controller.setListener(new ModifiercircuitController.PopupListener() {
               @Override
                        public void onInfoSent( Boolean Rendez_vousInstance) {
                           tv2.getItems().clear();
                           
                           remplir();
                }
                });
            
             controller.setAtrtribute(circuit);
               controller.setListener(new ModifiercircuitController.PopupListener() {

            @Override
            public void onInfoSent(Boolean value) {
                // Code à exécuter après la modification de la station
                remplir(); // Rafraîchir la liste des stations affichées
            }
        });
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    } else {
        JOptionPane.showMessageDialog(null, "Veuillez sélectionner un circuit à modifier.");
    }
}
    }

