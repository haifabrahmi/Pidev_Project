/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import entities.reclammation;
import entities.reponse;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import services.reclammationService;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.layout.element.Paragraph;
import static com.itextpdf.kernel.pdf.PdfName.Stream;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.text.pdf.PdfException;
import java.awt.Desktop;
import java.io.File;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.SQLException;
import javafx.scene.control.Cell;
import javafx.stage.FileChooser;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





/**
 * FXML Controller class
 *
 * @author user
 */
public class AfficheReclamController implements Initializable {

    @FXML
    private TableColumn<reclammation, String> nomTv;
    @FXML
    private TableColumn<reclammation , String> descrTv;
    @FXML
    private TableColumn<reclammation, Date> dateTv;
    
    reclammationService rs= new reclammationService();
    int index=-1;
   reclammation r = new reclammation();
    ObservableList<reclammation>  ListRes = FXCollections.observableArrayList();
    @FXML
    private Button retour_aff;
    @FXML
    private TableView<reclammation> table;
    @FXML
    private Button genererPDF;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         List list = rs.afficher();
        ListRes.addAll(list);
        nomTv.setCellValueFactory(new PropertyValueFactory<>("nom_voyageur"));
        dateTv.setCellValueFactory(new PropertyValueFactory<>("date_depot"));
        descrTv.setCellValueFactory(new PropertyValueFactory<>("description"));

        table.setItems(ListRes);

    }    

    @FXML
    private void supprimer(ActionEvent event) {
        reclammation r = table.getSelectionModel().getSelectedItem(); // Récupère l'objet sélectionné dans la TableView
    if (r != null) { // Vérifie si un objet a été sélectionné
        reclammationService rs = new reclammationService();
        rs.delete(r.getId_rec()); // Appelle la méthode de suppression appropriée de votre service de réclamations
        ListRes.remove(r);
        table.refresh();
    } else {
        // Affiche un message d'erreur si aucun objet n'a été sélectionné
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Aucune réclamation sélectionnée");
        alert.setContentText("Veuillez sélectionner une réclamation dans la liste pour la supprimer.");
        alert.showAndWait();
    }
        
        
    }
    
    
   
    

    @FXML
    private void modifier(ActionEvent event) throws IOException,ParseException, SQLException {
    
  FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierRec.fxml"));
    AnchorPane detailPage = loader.load();
    ModifierRecController detailControlleur = loader.getController();

    // Définir un écouteur pour être notifié lorsque la vue de modification est fermée
    detailControlleur.setListener(new ModifierRecController.PopupListener() {
        @Override
        public void onInfoSent(Boolean Rendez_vousInstance) {
            // Rafraîchir la table des réclamations lorsque la vue de modification est fermée
            table.getItems().clear();
            remplir();
        }
    });

    // Obtenir la réclamation sélectionnée dans la table
    reclammation r = table.getSelectionModel().getSelectedItem();

    if (r != null) { 
        detailControlleur.setAttribute(r);

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.getDialogPane().setContent(detailPage);
        dialog.setTitle("Modifier la réclamation");
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        Optional<ButtonType> clickButton = dialog.showAndWait();

        if (clickButton.isPresent() && clickButton.get() == ButtonType.OK) {
            // Appeler la méthode confirmer de ModifierRecController pour mettre à jour la réclamation
            detailControlleur.confirmer(event);

            // Rafraîchir la table des réclamations pour afficher les modifications
            table.getItems().clear();
            remplir();

            // Afficher un message de confirmation
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Réclamation mise à jour");
            alert.setHeaderText("La réclamation a été mise à jour avec succès.");
            alert.showAndWait();
        }
    } else {
        // Afficher un message d'erreur si aucune réclamation n'a été sélectionnée
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Aucune réclamation sélectionnée");
        alert.setContentText("Veuillez sélectionner une réclamation dans la liste pour la modifier.");
        alert.showAndWait();
    }


        
        
    }

    void setdatarec1(reclammation r) {
    }

    @FXML
    private void retouraff(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gererReclam.fxml"));
            Parent root = loader.load();
            GererReclamController controller = loader.getController();
            controller.setdatarec(r);

            retour_aff.getScene().setRoot(root);
    }
    
    
    
    public void remplir(){
        
       try {
        List<reclammation> list = rs.afficher();
        ListRes.addAll(list);
        nomTv.setCellValueFactory(new PropertyValueFactory<>("nom_voyageur"));
        descrTv.setCellValueFactory(new PropertyValueFactory<>("description"));
//        dateTv.setCellValueFactory(new PropertyValueFactory<>("date_depot"));
        table.setItems(ListRes);
    } catch (Exception e) {
        System.out.println("error" + e);
    }
        
}
    
    
    void getSelected() {
                    System.out.println("rah il ghali rah");

        try{
    	index=table.getSelectionModel().getSelectedIndex();
    	if(index <=-1)
    	{
    		return;
    	}
        System.out.println(index);}catch(Exception e){
            System.out.println(e);
            System.out.println("hobi ");
}
    
    }

    void setdatarep1(reponse rep) {
    }
    
    


       
    @FXML
private void genererPDF(ActionEvent event) throws FileNotFoundException, DocumentException {
    // Demander à l'utilisateur où enregistrer le fichier PDF
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Enregistrer le fichier PDF");
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Fichier PDF (*.pdf)", "*.pdf");
    fileChooser.getExtensionFilters().add(extFilter);
    File file = fileChooser.showSaveDialog(null);

    if (file != null) {
        // Créer un nouveau document PDF
        PdfWriter writer = new PdfWriter(new FileOutputStream(file));
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc, PageSize.A4);

        // Ajouter un titre au document
        Paragraph title = new Paragraph("Liste des réclamations");
        document.add(title);

        // Créer un tableau pour les réclamations
        Table table = new Table(new float[]{3, 7}).useAllAvailableWidth();
        table.addHeaderCell("Nom du voyageur");
        table.addHeaderCell("Description");

        // Ajouter les réclamations au tableau
        for (reclammation r : ListRes) {
            table.addCell(r.getNom_voyageur());
            table.addCell(r.getDescription());
        }

        // Ajouter le tableau au document
        document.add(table);

        // Fermer le document
        document.close();

        // Afficher un message de confirmation
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fichier PDF enregistré");
        alert.setHeaderText(null);
        alert.setContentText("Le fichier PDF a été enregistré avec succès.");
        alert.showAndWait();
    }
}


    @FXML
private void gererExcel(ActionEvent event) throws IOException {
    // Demander à l'utilisateur où enregistrer le fichier Excel
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Enregistrer le fichier Excel");
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Fichier Excel (*.xlsx)", "*.xlsx");
    fileChooser.getExtensionFilters().add(extFilter);
    File file = fileChooser.showSaveDialog(null);

    if (file != null) {
        // Créer un nouveau fichier Excel
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Réclamations");

        // Ajouter un en-tête au fichier Excel
        XSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("Nom du voyageur");
        header.createCell(1).setCellValue("Description");

        // Ajouter les réclamations au fichier Excel
        int rowNum = 1;
        for (reclammation r : ListRes) {
            XSSFRow row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(r.getNom_voyageur());
            row.createCell(1).setCellValue(r.getDescription());
        }

        // Enregistrer le fichier Excel
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        workbook.close();

        // Afficher un message de confirmation
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fichier Excel enregistré");
        alert.setHeaderText(null);
        alert.setContentText("Le fichier Excel a été enregistré avec succès.");
        alert.showAndWait();
    }
}

    @FXML
    private void genererCSV(ActionEvent event) throws IOException {
        // Demander à l'utilisateur où enregistrer le fichier CSV
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Enregistrer le fichier CSV");
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Fichier CSV (*.csv)", "*.csv");
    fileChooser.getExtensionFilters().add(extFilter);
    File file = fileChooser.showSaveDialog(null);

    if (file != null) {
        // Créer un nouveau fichier CSV et un writer
        FileWriter csvWriter = new FileWriter(file);

        // Écrire l'en-tête du fichier CSV
        csvWriter.append("Nom du voyageur,Description\n");

        // Écrire les réclamations dans le fichier CSV
        for (reclammation r : ListRes) {
            csvWriter.append(r.getNom_voyageur());
            csvWriter.append(",");
            csvWriter.append(r.getDescription());
            csvWriter.append("\n");
        }

        // Fermer le writer
        csvWriter.flush();
        csvWriter.close();

        // Afficher un message de confirmation
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Fichier CSV enregistré");
        alert.setHeaderText(null);
        alert.setContentText("Le fichier CSV a été enregistré avec succès.");
        alert.showAndWait();
    }}

    
    
    
    
    
    
    
    
   }  

    

   
    

