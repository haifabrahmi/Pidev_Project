/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.reclammation;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import services.reclammationService;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AfficherReclammationController implements Initializable {

    @FXML
    private TableView<reclammation> reclamTv;
    @FXML
    private TableColumn<reclammation, String> nomTv;
    @FXML
    private TableColumn<reclammation, String> descrTv;
    @FXML
    private TableColumn<reclammation, Date> dateTv;
// instance database Service 
    reclammationService rs = new reclammationService();
     ObservableList<reclammation>  ListRes = FXCollections.observableArrayList();
          reclammation r = new reclammation();

    @FXML
    private TableColumn<reclammation, Button> delete;
    @FXML
    private AnchorPane welcomeLb;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                      List list = rs.afficher();
                      ListRes.addAll(list);

        
        List<reclammation> reclammations = rs.afficher();
        ObservableList<reclammation> olr = FXCollections.observableArrayList(reclammations);
        reclamTv.setItems(olr);
        nomTv.setCellFactory(new PropertyValueFactory("nom_voyageur"));
        descrTv.setCellFactory(new PropertyValueFactory("description"));
        dateTv.setCellFactory(new PropertyValueFactory("date_depot") );
        this.delete();
        
    }    

    

    private void delete() {
        delete.setCellFactory((param) -> {
            return new TableCell() {
                @Override
                protected void updateItem(Object item, boolean empty) {
                    setGraphic(null);
                    if (!empty) {
                        Button b = new Button("delete");
                        b.setOnAction((event) -> {
                           reclammation rec = reclamTv.getItems().get(getIndex()); // obtenir l'objet reclammation à supprimer
                        int id = rec.getId_rec();
                           rs.delete(id); { // passer l'objet reclammation à la méthode delete()
                            reclamTv.getItems().remove(getIndex());
                            reclamTv.refresh();
                                
                            }

                        });
                        setGraphic(b);

                    }
                }
            };

        });
    }

    void setData(String Message) {
        

    }
    
}
