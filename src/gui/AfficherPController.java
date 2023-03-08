/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import entities.Publication;
import Services.ServicesPubliaction;
import entities.Publication;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Baklouti
 */
public class AfficherPController implements Initializable {

    @FXML
    private Button retour;
    @FXML
    private TableView<Publication> tableView_Publication;
    @FXML
    private TableColumn<Publication, String> Col_texte;
    @FXML
    private TableColumn<Publication, Integer> Col_likes;
    @FXML
    private TableColumn<?, ?> Col_date;
ServicesPubliaction ps = new ServicesPubliaction();
    ObservableList<Publication> ListPoste = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          Col_texte.setCellValueFactory(new PropertyValueFactory<>("text"));
        Col_likes.setCellValueFactory(new PropertyValueFactory<>("nb_react"));
        Col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Retrieve all Publication objects and add them to the ObservableList
        ListPoste.addAll(ps.select_all(null));

        // Set the items in the TableView to the ObservableList
        tableView_Publication.setItems(ListPoste);
// TODO
    }    

    @FXML
    private void retour(ActionEvent event) {
    }
  
    
     public ObservableList<Publication> getPubs(ArrayList<Publication> pubs)
{
    ObservableList<Publication> listPub = FXCollections.observableArrayList();
    for(int i = 0;i<=pubs.size()-1;i++)
    {
        listPub.add(pubs.get(i));
    }
    return listPub;
}
    
   
}
