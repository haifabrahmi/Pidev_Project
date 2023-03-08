package gui;
import entities.Reservation;
import entities.Ticket;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.TicketService;

public class Afficher_TicketController implements Initializable {

    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
  void setdataticket(Reservation r) {
    }
ObservableList<Ticket> ListTicket = FXCollections.observableArrayList();
    TicketService ts = new TicketService () ;
    Ticket t = new Ticket ();

    @FXML
    private TableColumn<Ticket, String> type_ticket;
    @FXML
    private TableColumn<Ticket, Float> prix_ticket;

    @FXML
    private TextField res_input;
    @FXML
    private TableView<Ticket> ttv;

    
    
    
    
    
    
    
    
    public void remplir(){
       try{
             List list = ts.recuperer();
                     ListTicket.addAll(list);

        type_ticket.setCellValueFactory(new PropertyValueFactory<>("type_ticket"));
        prix_ticket.setCellValueFactory(new PropertyValueFactory<>("prix"));
         ttv.setItems(ListTicket);
       }catch(Exception e){
           System.out.println("asslema"+e);
    }}
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ts = new TicketService();
        ListTicket = FXCollections.observableArrayList();
        try {
            // Get all tickets from the database
            ListTicket.addAll(ts.recuperer());
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_TicketController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Set up the table columns
        prix_ticket.setCellValueFactory(new PropertyValueFactory<>("prix"));
        type_ticket.setCellValueFactory(new PropertyValueFactory<>("Type_ticket"));
        // Set the data to the table view
        ttv.setItems(ListTicket);
    }

    // Other methods in the controller
@FXML
private void supprimer(ActionEvent event) throws SQLException {
    // Get the selected ticket from the table view
    Ticket selectedTicket = ttv.getSelectionModel().getSelectedItem();
    if (selectedTicket != null) {
        // Call the service to delete the ticket from the database
        ts.supprimer(selectedTicket);
        // Remove the ticket from the list and update the table view
        ListTicket.remove(selectedTicket);
        ttv.refresh();
        // Show a success message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ticket supprimé");
        alert.setHeaderText(null);
        alert.setContentText("Le ticket a été supprimé avec succès");
        alert.showAndWait();
    } else {
        // Show an error message if no ticket is selected
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Sélectionner un ticket");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez sélectionner un ticket à supprimer");
        alert.showAndWait();
    }
}

  @FXML
    private void modifier(ActionEvent event) throws IOException, ParseException {
        Ticket t = ttv.getSelectionModel().getSelectedItem();
    if (t != null) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifier_Ticket.fxml"));
        Parent root = loader.load();
        Modifier_TicketController controller = loader.getController();
        
        controller.setListener(new Modifier_TicketController.PopupListener() {
               @Override
                        public void onInfoSent( Boolean Rendez_vousInstance) {
                           ttv.getItems().clear();
                           
                           remplir();
                }
                });
            
             controller.setAtrtribute(t);
               controller.setListener(new Modifier_TicketController.PopupListener() {

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
