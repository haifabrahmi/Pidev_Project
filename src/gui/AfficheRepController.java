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
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import services.reponseService;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AfficheRepController implements Initializable {

    @FXML
    private TableView<reponse> tv;
    @FXML
    private TableColumn<reponse, String> resolution_reclam;
    @FXML
    private TableColumn<reponse, Date> date_resolution;
    @FXML
    private TableColumn<reponse, String> tfnom;
    
    reponseService rps = new reponseService();
    reponse rep = new reponse();
    ObservableList<reponse> ListRes = FXCollections.observableArrayList();
    @FXML
    private Button retour_aff;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               List<reponse> list = rps.afficher();
        ListRes.addAll(list);
        resolution_reclam.setCellValueFactory(new PropertyValueFactory<>("resolution_reclam"));
        date_resolution.setCellValueFactory(new PropertyValueFactory<>("date_reponse"));
        tfnom.setCellValueFactory(new PropertyValueFactory<>("nom_voyageur"));
        
        tfnom.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<reponse, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<reponse, String> cellData) {
                reponse rep = cellData.getValue();
                reclammation r = new reclammation();
                return new SimpleStringProperty(r.getNom_voyageur());
            }
        });
        
        tv.setItems(ListRes);
    }    

     

    void setData(String string) {
    }

    @FXML
    private void supprimer(ActionEvent event) {
        reponse rep = tv.getSelectionModel().getSelectedItem();
        if (rep!=null){
            reponseService rps = new reponseService();
            rps.delete(rep.getId_rep());
            ListRes.remove(rep);
            tv.refresh();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Aucune reponse sélectionnée");
        alert.setContentText("Veuillez sélectionner une reponse dans la liste pour la supprimer.");
        alert.showAndWait();
    }
        }
    
    
//    @FXML
//    private void modifier(ActionEvent event){
//        
//    }

    @FXML
    private void retouraff(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gererRep.fxml"));
            Parent root = loader.load();
            GererRepController controller = loader.getController();
            controller.setdatarec(rep);

            retour_aff.getScene().setRoot(root);
    }


    }

   
    

