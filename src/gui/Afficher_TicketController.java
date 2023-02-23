/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Ticket;
import java.net.URL;
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
import services.TicketService;

/**
 * FXML Controller class
 *
 * @author BouheniMed
 */
public class Afficher_TicketController implements Initializable {

    @FXML
    private TableView<?> tv;
    @FXML
    private TableColumn<?, ?> idticket;
    @FXML
    private TableColumn<?, ?> prixticket;
    @FXML
    private TableColumn<?, ?> dateachat;
    
    TicketService rs = new TicketService();
                ObservableList<Ticket>  ListRes = FXCollections.observableArrayList();
          Ticket r = new Ticket();
    @FXML
    private TableColumn<?, ?> typeticket;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
/*try {

          List list = rs.recuperer();
           
      
       ListRes.addAll(list);
        idticket.setCellValueFactory(new PropertyValueFactory<>("id_ticket"));
        prixticket.setCellValueFactory(new PropertyValueFactory<>("prix"));
        dateachat.setCellValueFactory(new PropertyValueFactory<>("date_achat"));
        typeticket.setCellValueFactory(new PropertyValueFactory<>("type_ticket"));
       
                tv.setItems(ListRes); 
                
} catch (SQLException ex) {
             System.out.println("errorrrrrr "+ex);        }
    } */     
} }   
    

