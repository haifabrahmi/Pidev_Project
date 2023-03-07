/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui.image;

import edu.esprit.entities.Circuit;
import edu.esprit.entities.Station;
import edu.esprit.gui.image.ModifiersationController.PopupListener;
import edu.esprit.services.Service;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AfficherstationController implements Initializable {
      @FXML
    private TableView<Station> tv;
    //int index=-1;

    @FXML
    private TableColumn<Station,String > nom_s;
    @FXML
    private TableColumn<Station, String> adresse_s;
    @FXML
    private TableColumn<Station, String> ligne_s;
    @FXML
    private TableColumn<Station, Date> horaire_s;
    @FXML
    private TableColumn<Station, String> equipement_s;
    @FXML
    private TableColumn<Station, String> commentaire_s;
   
    Station s = new Station();
    Service st = new Service();
    ObservableList<Station>  ListRes = FXCollections.observableArrayList();
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;

    /**
     * Initializes the controller class.
     */
    
    public void remplir(){
       try{
        List list = st.getAll();
        ListRes.addAll(list);
        nom_s.setCellValueFactory(new PropertyValueFactory<>("nom_s"));
        adresse_s.setCellValueFactory(new PropertyValueFactory<>("adresse_s"));
        ligne_s.setCellValueFactory(new PropertyValueFactory<>("ligne_s"));
        horaire_s.setCellValueFactory(new PropertyValueFactory<>("horaire_s"));
        equipement_s.setCellValueFactory(new PropertyValueFactory<>("equipement_s"));
        commentaire_s.setCellValueFactory(new PropertyValueFactory<>("commentaire_s"));
        tv.setItems(ListRes);
    }catch(Exception e){
           System.out.println("asslema"+e);
    }}
        
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        remplir();
        
    }
    
    
    void setdatastation(Station s) {
     }

    @FXML
    private void supprimer(ActionEvent event) {
      
   Station station = tv.getSelectionModel().getSelectedItem();
    if (station != null) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppression");
        alert.setHeaderText(null);
        alert.setContentText("Êtes-vous sûr de vouloir supprimer la station " + station.getNom_s() + " ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
         //   st.supprimerStation(station);
            ListRes.remove(station);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Veuillez sélectionner une station à supprimer.");
    }
    }

    
    
    
    
    @FXML
   private void modifier(ActionEvent event) throws IOException, ParseException {
    Station station = tv.getSelectionModel().getSelectedItem();
    if (station != null) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifiersation.fxml"));
        Parent root = loader.load();
        ModifiersationController controller = loader.getController();
        
        
         controller. setListener(new ModifiersationController.PopupListener() {
                        @Override
                        public void onInfoSent( Boolean Rendez_vousInstance) {
                           tv.getItems().clear();
                           
                           remplir();
                }
                    });
        controller.setAtrtribute(station);
        controller.setListener(new PopupListener() {
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
        JOptionPane.showMessageDialog(null, "Veuillez sélectionner une station à modifier.");
    }
}

    
    }

    


        

    
    
    
    

