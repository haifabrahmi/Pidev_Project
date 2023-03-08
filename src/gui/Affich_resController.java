/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Reservation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.ReservationService;

/**
 * FXML Controller class
 *
 * @author BouheniMed
 */
public class Affich_resController implements Initializable {

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
    private TableColumn<Reservation, String> type_ticket;

    @FXML
    private TableColumn<Reservation, Float> prix_totale;
    @FXML
    private TextField recherche;
ReservationService rs = new ReservationService();
                ObservableList<Reservation>  ListRes = FXCollections.observableArrayList();
          Reservation r = new Reservation();
    @FXML
    private TextField res_input;
    @FXML
    private Button Ajouter_ress;
    @FXML
    private Button modifier;
    /**
     * Initializes the controller class.
     */
  
      /**
     * Initializes the controller class.
     */
     public void remplir(){
       try{
             List list = rs.recuperer();
                     ListRes.addAll(list);
        id_res.setCellValueFactory(new PropertyValueFactory<>("id_res"));
        date_res.setCellValueFactory(new PropertyValueFactory<>("date_res"));
        heure_res.setCellValueFactory(new PropertyValueFactory<>("heure_res"));
        nb_place.setCellValueFactory(new PropertyValueFactory<>("nb_place"));
        type_ticket.setCellValueFactory(new PropertyValueFactory<>("Type_ticket"));
        prix_totale.setCellValueFactory(new PropertyValueFactory<>("prix_totale"));
                tv.setItems(ListRes); 
       }catch(Exception e){
           System.out.println("asslema"+e);
    }}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         recherche.textProperty().addListener((observable, oldValue, newValue) -> {
    try {
        recherche(null); // Call the recherche method with a dummy ActionEvent
    } catch (SQLException ex) {
        Logger.getLogger(Affich_resController.class.getName()).log(Level.SEVERE, null, ex);
    }
});
         ListRes = FXCollections.observableArrayList();
        try {
            // Get all tickets from the database
            ListRes.addAll(rs.recuperer());
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_TicketController.class.getName()).log(Level.SEVERE, null, ex);
        }

    // Add listener to tableview selection
    tv.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            // Display the ID of the selected row in the textfield
            res_input.setText(Integer.toString(newSelection.getId_res()));
        }
    });
         try {

          List list = rs.recuperer();
           
      
        ListRes.addAll(list);
        id_res.setCellValueFactory(new PropertyValueFactory<>("id_res"));
        date_res.setCellValueFactory(new PropertyValueFactory<>("date_res"));
        heure_res.setCellValueFactory(new PropertyValueFactory<>("heure_res"));
        nb_place.setCellValueFactory(new PropertyValueFactory<>("nb_place"));
        type_ticket.setCellValueFactory(new PropertyValueFactory<>("Type_ticket"));
        prix_totale.setCellValueFactory(new PropertyValueFactory<>("prix_totale"));
                tv.setItems(ListRes); 
                this.modifier();
                
} catch (SQLException ex) {
             System.out.println("error baba "+ex);        }
    }

   @FXML
private void supprimer(ActionEvent event) throws SQLException {
     String idText = res_input.getText();
    if (idText.matches("\\d+")) {
        int id = Integer.parseInt(idText);
        Reservation r = new Reservation();
        r.setId_res(id);
        rs.supprimer(r);
        
        
        // Remove the deleted reservation from the tableview
        tv.getItems().removeIf(reservation -> reservation.getId_res() == id);
         Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Reservation Supprimé");
        alert.setHeaderText(null);
        alert.setContentText("Reservation Supprimé");
        alert.showAndWait();
    } else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText(null);
        alert.setContentText("Le champ doit contenir un nombre valide !");
        alert.showAndWait();
    }
}
    
     @FXML
private void recherche(ActionEvent event) throws SQLException {
    String idText = recherche.getText();
    if (!idText.isEmpty()) {
        if (idText.matches("\\d+")) {
            int id = Integer.parseInt(idText);
            List<Reservation> list = rs.rechercher(id);
            ListRes.clear();
            ListRes.addAll(list);
            tv.refresh();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText(null);
            alert.setContentText("Le champ doit contenir un nombre valide !");
            alert.showAndWait();
        }
    } else {
        // If the search field is empty, display all reservations
        List<Reservation> list = rs.recuperer();
        ListRes.clear();
        ListRes.addAll(list);
        tv.refresh();
    }
    
}





   

    @FXML
 private void modifier() {
     
     
 
 }
 
 
 
 
 void setdatareservation(Reservation r) {
     }

   @FXML
  private void Ajouter(ActionEvent event) throws IOException {
        
          FXMLLoader loader = new FXMLLoader(getClass().getResource("Ajouter_res.fxml"));
            Parent root = loader.load();
            Ajouter_resController controller = loader.getController();
            controller.setajoutres(r);

            Ajouter_ress.getScene().setRoot(root);
  }
}