/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Role;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.UserServices;



/**
 * FXML Controller class
 *
 * @author user
 */
public class AdminController implements Initializable {

    @FXML
    private TableView<User> tv;
    @FXML
    private TableColumn<User, String> nomAff;
    @FXML
    private TableColumn<User, String> prenomAff;
    @FXML
    private TableColumn<User, Integer> numberAff;
    @FXML
    private TableColumn<User, String> emailAff;
    @FXML
    private TableColumn<User, String> passwordAff;
    @FXML
    private TableColumn<User, Role> roleAff;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    
    UserServices us = new UserServices() {};
    int index=-1;

    ObservableList <User>  Listuser = FXCollections.observableArrayList();
    User u = new User();
    
    
    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
public void initialize(URL url, ResourceBundle rb) {
    try {
        List<User> list = us.recuperer(u);
        Listuser.addAll(list);
        nomAff.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomAff.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        numberAff.setCellValueFactory(new PropertyValueFactory<>("number"));
        emailAff.setCellValueFactory(new PropertyValueFactory<>("email"));
        passwordAff.setCellValueFactory(new PropertyValueFactory<>("password"));

        roleAff.setCellValueFactory(new PropertyValueFactory<>("role"));
        roleAff.setCellFactory((TableColumn<User, Role> param) -> {
            TableCell<User, Role> cell = new TableCell<User, Role>() {
                @Override
                protected void updateItem(Role item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.toString());
                    }
                }
            };
            return cell;
        });

        tv.setItems(Listuser);

    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    }
}
  
    

    
    private Stage primaryStage;
    
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    public void showView() {
        try {
            // Charge le fichier FXML de la page d'administration
            FXMLLoader loader = new FXMLLoader(getClass().getResource("admin.fxml"));
            Parent root = loader.load();
            
            // Configure le contrôleur de la page d'administration
            AdminController adminController = loader.getController();
            adminController.setPrimaryStage(primaryStage);
            
            // Affiche la scène de la page d'administration dans la fenêtre principale
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // Ajouter ici le reste des méthodes et des fonctionnalités de la page d'administration

    @FXML
private void modifier(ActionEvent event) throws SQLException, ParseException {
    
    try{
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserUpDate.fxml"));
    AnchorPane detailPage = loader.load();
    UserUpDateController detailControlleur = loader.getController();

    // Définir un écouteur pour être notifié lorsque la vue de modification est fermée
    detailControlleur.setListener((Boolean Rendez_vousInstance) -> {
        // Rafraîchir la table des réclamations lorsque la vue de modification est fermée
        tv.getItems().clear();
        remplir();
        });

    // Obtenir la réclamation sélectionnée dans la table
    User u = tv.getSelectionModel().getSelectedItem();

    if (u != null) { 
        detailControlleur.setAttribute(u);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().setContent(detailPage);
        dialog.setTitle("Modifier User");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        Optional<ButtonType> clickButton = dialog.showAndWait();

        if (clickButton.isPresent() && clickButton.get() == ButtonType.OK) {
            // Appeler la méthode confirmer de ModifierRecController pour mettre à jour la réclamation
            detailControlleur.modifier(event);

            // Rafraîchir la table des réclamations pour afficher les modifications
            tv.getItems().clear();
            remplir();

            // Afficher un message de confirmation
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("User mise à jour");
            alert.setHeaderText("Le user a été mise à jour avec succès.");
            alert.showAndWait();
        }
    } else {
        // Afficher un message d'erreur si aucune réclamation n'a été sélectionnée
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Aucune user sélectionnée");
        alert.setContentText("Veuillez sélectionner un avis dans la liste pour la modifier.");
        alert.showAndWait();
    }

        }catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

public void remplir(){
       try {
        List<User> list = us.recuperer(u);
        Listuser.addAll(list);
        nomAff.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomAff.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        numberAff.setCellValueFactory(new PropertyValueFactory<>("number"));
        emailAff.setCellValueFactory(new PropertyValueFactory<>("email"));
        passwordAff.setCellValueFactory(new PropertyValueFactory<>("password"));
        tv.setItems(Listuser);
    } catch (SQLException e) {
        System.out.println("error" + e);
    }
}

void getSelected() {
                    System.out.println("get selected1");

        try{
    	index=tv.getSelectionModel().getSelectedIndex();
    	if(index <=-1)
    	{
    		return;
    	}
        System.out.println(index);}catch(Exception e){
            System.out.println(e);
            System.out.println("get selected2");
}
    
    }

    @FXML
    private void supprimer(ActionEvent event) {
        User selectedUser = tv.getSelectionModel().getSelectedItem();
    if (selectedUser != null) {
        // Get the user ID from the selected row
        int userId = selectedUser.getIdUser();
        // Delete the user from the database
        us.delete(userId);
        // Remove the user from the observable list
        Listuser.remove(selectedUser);
        // Refresh the table view
        tv.refresh();
    }
    } 

    public void setIdUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

