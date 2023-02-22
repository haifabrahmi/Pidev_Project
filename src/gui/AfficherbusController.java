/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.bus;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import services.busService;

/**
 * FXML Controller class
 *
 * @author haifa
 */
public class AfficherbusController implements Initializable {
    
     busService bs = new busService();
    @FXML
    private TableView<bus> table;
    @FXML
    private TableColumn<bus, String> modele;
    @FXML
    private TableColumn<bus,  Integer> capacite;
   
@FXML
    private TableColumn<bus, Integer> id_bus;
    
    @FXML
    private TableColumn<bus, Date> date_depart;
    @FXML
    private TableColumn<bus, Date> date_arrivee; 
   @FXML
    private TableColumn<bus,Integer> num_de_plaque;
   
            busService bb = new busService();
                ObservableList<bus>  ListBus = FXCollections.observableArrayList();
          bus b = new bus();
  
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try{
         List list = bb.recuperer(b);
        
           
      
       ListBus.addAll(list);
        modele.setCellValueFactory(new PropertyValueFactory<>("modele"));
        num_de_plaque.setCellValueFactory(new PropertyValueFactory<>("numero_de_plaque"));
       capacite.setCellValueFactory(new PropertyValueFactory<>("capacite"));
        date_depart.setCellValueFactory(new PropertyValueFactory<>("date_depart"));
        date_arrivee.setCellValueFactory(new PropertyValueFactory<>("date_arrive"));
        id_bus.setCellValueFactory(new PropertyValueFactory<>("id_bus"));
 
                table.setItems(ListBus);
} catch (SQLException ex) {
             System.out.println("asslema "+ex);        }
    }

    @FXML
    private void Modifier(ActionEvent event) {
    }

    @FXML
    private void Supprimer(ActionEvent event) {
    }
}

        
    
        // TODO
       
    

