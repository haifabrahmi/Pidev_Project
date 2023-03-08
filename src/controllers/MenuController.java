/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Reponse;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class MenuController implements Initializable {

    @FXML
    private Button envoyer;
    @FXML
    private Button consulter;
    @FXML
    private Button recadmin;
    @FXML
    private Button repadmin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        consulter.setOnAction( e ->{ 
             try {
                Parent root = FXMLLoader.load(getClass().getResource("/gui/ConsulterReclamationClient.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Consultation des réclamations");
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {

            }
         });
         
          recadmin.setOnAction( e ->{ 
             try {
                Parent root = FXMLLoader.load(getClass().getResource("/gui/ConsulterReclamationAdmin.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Consultation des réclamations");
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {

            }
         });
          
          
          repadmin.setOnAction( e ->{ 
             try {
                Parent root = FXMLLoader.load(getClass().getResource("/gui/AfficherReponses.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Consultation des réponses");
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {

            }
         });
         
           envoyer.setOnAction( e ->{ 
             try {
                Parent root = FXMLLoader.load(getClass().getResource("/gui/AjoutReclamation.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle(" Ajouter Reclamation");
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {

            }
         });
          
          
          
    }    

   

    void setdatarep(TableColumn<Reponse, String> rep) {
      
       
    }
    
}
