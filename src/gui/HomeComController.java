/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import Services.ServicesPubliaction;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Baklouti
 */
public class HomeComController implements Initializable {

    @FXML
    private Button xbtn;
    @FXML
    private Button add;
    @FXML
    private Button dised;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        
    }    

    @FXML
    private void Exit(ActionEvent event) {
          Stage stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
        JOptionPane.showMessageDialog(null, "Are you sure ? :("); 
    }

    @FXML
    private void AddCom(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCom.fxml"));
        Parent root = loader.load(); 
        add.getScene().setRoot(root);
    }

    @FXML
    private void DisplayEditCom(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DisplayEditCom.fxml"));
        Parent root = loader.load(); 
        dised.getScene().setRoot(root);
    }
    
}
