/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.sql.*;
import entities.*;
import services.*;
import utils.MyDB;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableColumnBase;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.geometry.Pos;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.util.converter.IntegerStringConverter;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Baklouti
 */
/**
 * **************************************************************************************************************************
 */
public class AjoutPubController implements Initializable {

    @FXML
    private Button btn_post;
    @FXML
    private TextArea text_area;
    @FXML
    private TextField tf_ph;
    @FXML
    private TableView<Publication> tableView_Publication;
    @FXML
    private TableColumn<Publication, String> Col_Texte;
    @FXML
    private TableColumn<Publication, Integer> Col_likes;
    @FXML
    private TableColumn<?, ?> Col_date;
    @FXML
    private ListView<String> Col_username;
    ObservableList<Publication> ListPoste = FXCollections.observableArrayList();
    ServicesPubliaction ps = new ServicesPubliaction();
    @FXML
    private TextField tf_url;
    @FXML
    private TableView<Photo> tableView_Links;
    @FXML
    private TableColumn<?, ?> Col_Links;
    @FXML
    private Button btn_addpic;

    /**
     * **************************************************************************************************************************
     */
    /**
     * **************************************************************************************************************************
     */

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * **************************************************************************************************************************
     */
 /*************************************************************************************************************************/
    
    @FXML
private void add_pic(ActionEvent event) {
    try {
        Publication selectedPublication = tableView_Publication.getSelectionModel().getSelectedItem();
        if (selectedPublication == null) {
            // No publication selected, show error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No publication selected");
            alert.setContentText("Please select a publication to add a photo to.");
            alert.showAndWait();
            return;
        }
        
        servicePhoto sph = new servicePhoto();
        Photo photo = new Photo();
        String url = tf_url.getText().trim();
        if (url.isEmpty()) {
            // Prompt user to enter a photo URL
            url = promptForPhotoUrl();
            if (url == null) {
                // User cancelled the prompt, do nothing
                return;
            }
        }
        photo.setUrl(url);
        photo.setId_pub(selectedPublication.getId());
        sph.insert(photo);
        
        // Clear and update the list of photos for the selected publication
        tableView_Links.getItems().clear();
        Col_Links.setCellValueFactory(new PropertyValueFactory<>("url"));
        List<Photo> photos = sph.select_all(selectedPublication.getId());
        tableView_Links.setItems(FXCollections.observableArrayList(photos));
    } catch (Exception e) {
        // An error occurred, show error message
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("An error occurred while adding photo");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }
}

/**
 * Prompts the user to enter a URL for the photo to add.
 * Returns the URL entered by the user, or null if the user cancelled the prompt.
 */
private String promptForPhotoUrl() {
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("Enter Photo URL");
    dialog.setHeaderText(null);
    dialog.setContentText("Please enter the URL of the photo you want to add:");

    Optional<String> result = dialog.showAndWait();
    if (result.isPresent()) {
        return result.get().trim();
    } else {
        return null;
    }
}

 
 /*************************************************************************************************************************/
 
    @FXML
    private void Add(ActionEvent event) throws IOException, Exception {
     if(text_area.getText().isEmpty() == false)
        {
            if(text_area.getText().length() > 300)
            {
     //       notif("Post","Text too long ! Try to write less than 300 characters.");
            }
            else
            {
                ServicesPubliaction ps = new ServicesPubliaction();
                Publication p = new Publication();
                Photo ph = new Photo();
                servicePhoto sph = new servicePhoto();
                p.setText(text_area.getText());
                ps.insert(p);
                
                    if(tf_ph.getText().isEmpty()==false)
                     {
                         ph.setId_pub(p.getId());
                         ph.setUrl(tf_ph.getText());
                         System.out.println(ph.toString());
                         sph.insert(ph);
                     }
                        else
                            {
                                if(notif_choix() == 0)
                                {
                                 ph.setId_pub(p.getId());
                                 String url = test();
                                    if(url != null)
                                        {
                                            ph.setUrl(url);
                                            System.out.println(ph.toString());
                                            sph.insert(ph);
                                        }
                                }
                            }
        //ServicesTags STAG = new ServicesTags();
       // STAG.add_relation(p);
   //     Display();
 
        text_area.clear();
        tf_ph.clear();
        }
        }
    }

    /**
     * **************************************************************************************************************************
     */
    public int notif_choix() {
        int dialogButton = 0;
        dialogButton = JOptionPane.showConfirmDialog(null, "You didn't add a link, do you wanna upload an Image ?", "Image", dialogButton);
        System.out.println(dialogButton);
        if (dialogButton == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * **************************************************************************************************************************
     */
    public String test() throws IOException {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Open Resource File Or Close if you don't want to add a Photo :");
        ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", "*.png");
        ExtensionFilter extFilter2 = new FileChooser.ExtensionFilter("*.png", "Image Files");
        ExtensionFilter extFilter3 = new FileChooser.ExtensionFilter("*.jpeg", "*.png");
        ExtensionFilter extFilter4 = new FileChooser.ExtensionFilter("*.jpg", "*.png");
        ExtensionFilter extFilter5 = new FileChooser.ExtensionFilter("*.gif", "*.png");
        fileChooser.getExtensionFilters().addAll(extFilter);
        fileChooser.getExtensionFilters().addAll(extFilter2);
        fileChooser.getExtensionFilters().addAll(extFilter3);
        fileChooser.getExtensionFilters().addAll(extFilter4);
        fileChooser.getExtensionFilters().addAll(extFilter5);
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
            System.out.println(selectedFile.getPath());
            return selectedFile.toURI().toURL().toString();
        }
        return null;
    }

    /**
     * *************************************************************************************************************************
     */
    public ObservableList<Publication> getPubs(ArrayList<Publication> pubs) {
        ObservableList<Publication> listPub = FXCollections.observableArrayList();
        for (int i = 0; i <= pubs.size() - 1; i++) {
            listPub.add(pubs.get(i));
        }
        return listPub;
    }

    /**
     * ****************************************************************************************************************************
     */
  
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    private void Display(ActionEvent event) throws IOException {
        /*
         */
        Col_Texte.setCellValueFactory(new PropertyValueFactory<>("text"));
        Col_likes.setCellValueFactory(new PropertyValueFactory<>("nb_react"));
        Col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Retrieve all Publication objects and add them to the ObservableList
        ListPoste.addAll(ps.select_all(null));

        // Set the items in the TableView to the ObservableList
        tableView_Publication.setItems(ListPoste);
    }
    
    
 /*********************************************************************************************************************/
    
 public ObservableList<Photo> getPhotos(ArrayList<Photo> photos)
{
    ObservableList<Photo> listPhotos = FXCollections.observableArrayList();
    for(int i = 0;i<=photos.size()-1;i++)
    {
        listPhotos.add(photos.get(i));
    }
    return listPhotos;
}

     
  }

 /*********************************************************************************************************************/
   