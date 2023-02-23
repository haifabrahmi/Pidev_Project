/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ReservationService;
import entities.Reservation;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author BouheniMed
 */
public class Afficher_resController implements Initializable {

    @FXML
    private TableView<Reservation> tv;
    @FXML
    private TableColumn<Reservation, Integer> id_res;
    @FXML
    private TableColumn<Reservation, Date> date_res;
    @FXML
    private TableColumn<Reservation, String> heure_res;
    @FXML
    private TableColumn<Reservation, Integer> nb_place;
    @FXML
    private TableColumn<Reservation, Integer> immat;
    @FXML
    private TableColumn<Reservation, Integer> id_ticket;
    @FXML
    private TableColumn<Reservation, Integer> id_usr;
            ReservationService rs = new ReservationService();
                ObservableList<Reservation>  ListRes = FXCollections.observableArrayList();
          Reservation r = new Reservation();
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {

          List list = rs.recuperer();
           
      
       ListRes.addAll(list);
        date_res.setCellValueFactory(new PropertyValueFactory<>("date_res"));
        id_res.setCellValueFactory(new PropertyValueFactory<>("id_res"));
        heure_res.setCellValueFactory(new PropertyValueFactory<>("heure_res"));
        nb_place.setCellValueFactory(new PropertyValueFactory<>("nb_place"));
        immat.setCellValueFactory(new PropertyValueFactory<>("imatriculation"));
        id_ticket.setCellValueFactory(new PropertyValueFactory<>("id_ticket"));
        id_usr.setCellValueFactory(new PropertyValueFactory<>("id_usr"));
                tv.setItems(ListRes); 
                
} catch (SQLException ex) {
             System.out.println("asslema "+ex);        }
    }
    public void setdatafficher_res(Reservation r) {
    }
    private void supprimer(ActionEvent event) throws SQLException {
   r.setId_res(java.sql.Date.valueOf(id_res.getValue()));
    }
    }