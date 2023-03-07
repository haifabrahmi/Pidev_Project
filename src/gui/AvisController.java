/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Avis;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.AvisServices;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AvisController implements Initializable {

    @FXML
    private TableView<Avis> tvAvis;
    @FXML
    private TableColumn<Avis, String> nomAffAvis;
    @FXML
    private TableColumn<Avis, Integer> noteAffAvis;
    @FXML
    private TableColumn<Avis, String> commentAffAvis;
    @FXML
    private Button modifier1;
    @FXML
    private TextField nomUsertf;
    @FXML
    private TextField commenttf;
    @FXML
    private TextField notetf;
    @FXML
    private ImageView imageAvis;
    
    AvisServices as = new AvisServices() {};
    ObservableList<Avis>  listRes = FXCollections.observableArrayList();
    Avis a= new Avis();
    int index=-1;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
          List list = as.recuperer(a);
          listRes.addAll(list);
        nomAffAvis.setCellValueFactory(new PropertyValueFactory<>("nomUser"));
        noteAffAvis.setCellValueFactory(new PropertyValueFactory<>("note"));
        commentAffAvis.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
        tvAvis.setItems(listRes);
        
} catch (SQLException ex) {
             System.out.println("asslema "+ex);        }
    }    
    
    
    private Stage primaryStage;
    
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    public void showView() {
        try {
            // Charge le fichier FXML de la page d'administration
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Avis.fxml"));
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

    @FXML
    private void supprimer(ActionEvent event) {

Avis selectedUser = tvAvis.getSelectionModel().getSelectedItem();
    if (selectedUser != null) {
        // Get the user ID from the selected row
        int userId = selectedUser.getIdUser();
        // Delete the user from the database
        as.delete(userId);
        // Remove the user from the observable list
        listRes.remove(selectedUser);
        // Refresh the table view
        tvAvis.refresh();
        
    }
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException, SQLException, ParseException {
        try{
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AvisUpdate.fxml"));
    AnchorPane detailPage = loader.load();
    AvisUpdateController detailControlleur = loader.getController();

    // Définir un écouteur pour être notifié lorsque la vue de modification est fermée
    detailControlleur.setListener((Boolean Rendez_vousInstance) -> {
        // Rafraîchir la table des réclamations lorsque la vue de modification est fermée
        tvAvis.getItems().clear();
        remplir();
        });

    // Obtenir la réclamation sélectionnée dans la table
    Avis a = tvAvis.getSelectionModel().getSelectedItem();

    if (a != null) { 
        detailControlleur.setAttribute(a);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().setContent(detailPage);
        dialog.setTitle("Modifier Avis");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        Optional<ButtonType> clickButton = dialog.showAndWait();

        if (clickButton.isPresent() && clickButton.get() == ButtonType.OK) {
            // Appeler la méthode confirmer de ModifierRecController pour mettre à jour la réclamation
            detailControlleur.confirmer(event);

            // Rafraîchir la table des réclamations pour afficher les modifications
            tvAvis.getItems().clear();
            remplir();

            // Afficher un message de confirmation
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Avis mise à jour");
            alert.setHeaderText("L'Avis a été mise à jour avec succès.");
            alert.showAndWait();
        }
    } else {
        // Afficher un message d'erreur si aucune réclamation n'a été sélectionnée
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Aucune Avis sélectionnée");
        alert.setContentText("Veuillez sélectionner un avis dans la liste pour la modifier.");
        alert.showAndWait();
    }

        }catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void remplir(){
       try {
        List<Avis> list = as.recuperer(a);
        listRes.addAll(list);
        nomAffAvis.setCellValueFactory(new PropertyValueFactory<>("nomUser"));
        commentAffAvis.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
        noteAffAvis.setCellValueFactory(new PropertyValueFactory<>("note"));
        tvAvis.setItems(listRes);
    } catch (SQLException e) {
        System.out.println("error" + e);
    }
}
    
    void getSelected() {
                    System.out.println("get selected1");

        try{
    	index=tvAvis.getSelectionModel().getSelectedIndex();
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
    private void AjouterAvis(ActionEvent event) {
        try {
            Avis a = new Avis();
            a.setNomUser(nomUsertf.getText());
            a.setCommentaire(commenttf.getText());
            a.setNote(Integer.parseInt(notetf.getText()));
            as.ajouter(a);
            System.out.println("Avis ajoute avec succes");
        } catch (SQLException ex) {
            System.out.println("error" + ex.getMessage());
        }
    }

    public void setIdUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
}
