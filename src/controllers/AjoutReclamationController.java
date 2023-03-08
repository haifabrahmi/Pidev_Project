/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Reclamation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import org.controlsfx.control.Notifications;
import services.CRUDReclamation;


/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class AjoutReclamationController implements Initializable {

    @FXML
    private ComboBox<String> comboCategorie;
    @FXML
    private TextField textObjet;
    @FXML
    private TextArea textReclamation;
    @FXML
    private Button envoyerReclamation;
    private String combo ;
    @FXML
    private TextField textiduser;
    @FXML
    private Button exportToPdf;

    /**
     * Initializes the controller class.
     */
    @FXML
   public void exportToPdf(){
     try {
         FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Enregistrer le fichier PDF");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        File selectedFile = fileChooser.showSaveDialog(null);
        if (selectedFile != null) {
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, new FileOutputStream(selectedFile));
        document.open();
        PdfPTable table = new PdfPTable(2);
        PdfPCell c1 = new PdfPCell(new Phrase("Sujet"));
        table.addCell(c1);
        PdfPCell c2 = new PdfPCell(new Phrase("Description"));
        table.addCell(c2);
       
        table.setHeaderRows(1);
        CRUDReclamation pcrud = new CRUDReclamation();
        List <Reclamation> listeProduits =  pcrud.afficherReclamations();
        for (Reclamation p : listeProduits) {
            table.addCell(p.getObjet_Reclamation());
            table.addCell(String.format(p.getDescription_Reclamation()));
           
        }
        document.add(table);
        document.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Export PDF");
        alert.setHeaderText(null);
        alert.setContentText("Le fichier a été exporté avec succès !");
        alert.showAndWait();}
    } catch (FileNotFoundException | DocumentException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Export PDF");
        alert.setHeaderText(null);
        alert.setContentText("Une erreur s'est produite lors de l'exportation du fichier PDF !");
        alert.showAndWait();
    }}
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        comboCategorie.getItems().addAll("Chauffeur","Voyageur","Admin");
        comboCategorie.setOnAction(event->{ 
        
                combo = comboCategorie.getSelectionModel().getSelectedItem();
                System.out.println(combo);
} );}
        
      
        
//            public Reclamation(int id_user, String objet_Reclamation, 
//                    String description_Reclamation, String categorie_Reclamation, 
//                    int etat_Reclamation) {
       /* envoyerReclamation.setOnAction( e -> {
            if (textObjet.getText().isEmpty() || textReclamation.getText().isEmpty()||comboCategorie.getValue().isEmpty()||textiduser.getText().isEmpty() )
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("Information Dialog");

                alert.setHeaderText(null);

                alert.setContentText("Veuillez remplir tous les champs!");

                alert.show();
                }
            else {
       /* Reclamation rec = new Reclamation(12,textObjet.getText(),textReclamation.getText(),combo,0);
        CRUDReclamation crud1=new CRUDReclamation();
        crud1.ajouterReclamation(rec);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

                alert.setTitle("Information Dialog");

                alert.setHeaderText(null);

                alert.setContentText("Reclamation ajoutée avec succés!");

                alert.show();
       
               
        
        } );*/
        
     
            

    @FXML
    private void envoyer(ActionEvent event) {
   
            String id_userStr=textiduser.getText();
    
    String description_Reclamation= textReclamation.getText();
    String objet_Reclamation=textObjet.getText();
    String categorie_Reclamation= comboCategorie.getValue();

  if (id_userStr.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("id_user doit etre saisie");
            alert.setTitle("Probleme");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else if (description_Reclamation.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("description_Reclamation doit etre saisie");
            alert.setTitle("Probleme");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else if (objet_Reclamation.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Objet_Reclamation doit etre saisie");
            alert.setTitle("Probleme");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else if (categorie_Reclamation.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("categorie_Reclamation doit etre saisie");
            alert.setTitle("Probleme");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
            else {
try{
    int id_user = Integer.parseInt(id_userStr);        
    Reclamation R1 = new Reclamation (id_user, categorie_Reclamation,objet_Reclamation, description_Reclamation,0);
                CRUDReclamation cr = new CRUDReclamation();
                cr.ajouterReclamation(R1);
                /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Reclamation inséré avec succès!");
                alert.showAndWait();*/
                Notifications.create()
                    .title("Nouvelle Réclamation")
                    .text("Une nouvelle Réclamation a été créé")
                    .showInformation();

  
    
        } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText(" ID utilisateur doivent etre un entier");
                alert.setTitle("Probleme");
                alert.setHeaderText(null);
                alert.showAndWait();
            }
        }
}

    @FXML
    private void genererCSV(ActionEvent event) throws IOException {
        try{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Enregistrer le fichier CSV");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showSaveDialog(null);
        if (selectedFile != null) {
            FileWriter fileWriter = new FileWriter(selectedFile);
            CRUDReclamation pcrud = new CRUDReclamation();
            List<Reclamation> listeProduits = pcrud.afficherReclamations();
            fileWriter.append("Sujet");
            fileWriter.append(",");
            fileWriter.append("Description");
            fileWriter.append("\n");

            for (Reclamation p : listeProduits) {
                fileWriter.append(p.getObjet_Reclamation());
                fileWriter.append(",");
                fileWriter.append(p.getDescription_Reclamation());
                fileWriter.append("\n");
            }
            fileWriter.flush();
            fileWriter.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Export CSV");
            alert.setHeaderText(null);
            alert.setContentText("Le fichier a été exporté avec succès !");
            alert.showAndWait();
        }
    }catch (IOException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Export CSV");
        alert.setHeaderText(null);
        alert.setContentText("Une erreur s'est produite lors de l'exportation du fichier CSV !");
        alert.showAndWait();
    }
        
    }}

