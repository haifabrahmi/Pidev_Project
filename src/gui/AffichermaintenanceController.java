/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.maintenance;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.maintenanceService;

/**
 * FXML Controller class
 *
 * @author haifa
 */
public class AffichermaintenanceController implements Initializable {
   
  maintenanceService ms = new maintenanceService();
    @FXML
    private TableView<maintenance> tab;
    @FXML
    private TableColumn<maintenance, Date> dateentretien;
    @FXML
    private TableColumn<maintenance, String> description;
    
    maintenanceService mt =new maintenanceService();
       ObservableList<maintenance>  Listmaintenance = FXCollections.observableArrayList();
          maintenance bs= new maintenance();
    @FXML
    private TableColumn<maintenance, Integer> id_m;
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try{
         List list = mt.recuperer(bs);
           
      
       Listmaintenance.addAll(list);
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        dateentretien.setCellValueFactory(new PropertyValueFactory<>("date_entretien"));
        id_m.setCellValueFactory(new PropertyValueFactory<>("id_m"));
       
                tab.setItems(Listmaintenance);
} catch (SQLException ex) {
             System.out.println("asslema "+ex);        }
    }}

        // TODO
        
    

