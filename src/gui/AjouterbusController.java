/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entities.bus;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import services.busService;
import gui.MainbusController;
import java.awt.image.BufferedImage;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import utils.MyDB;

/**
 * FXML Controller class
 *
 * @author haifa
 */
public class AjouterbusController implements Initializable {

    @FXML
    private TextField sai_modele;
    @FXML
    private TextField sai_numero_plaque;
    @FXML
    private TextField sai_capacite;
    @FXML
    private TextField sai_destin;

    @FXML
    private DatePicker sai_datedep;
    @FXML
    private DatePicker sai_datearriv;
    @FXML
    private Button ajouter_bus;

    busService bs = new busService();
    bus b = new bus();
    @FXML
    private Button Retour;
    @FXML
    private Button afficher_bus;
    @FXML
    private Button pdf;
    @FXML
    private Button txtphoto;
    @FXML
    private ImageView imageView;
    private FileChooser fileChooser;

    private File selectedFile;
    @FXML
    private TextField sai_image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
        );
        // TODO
    }

    @FXML
    private void ajouterbus(ActionEvent event) {
        String modele = sai_modele.getText();
        String numeroPlaqueStr = sai_numero_plaque.getText();
        String capaciteStr = sai_capacite.getText();
        String destin = sai_destin.getText();
        LocalDate departDate = sai_datedep.getValue();
        LocalDate arriveeDate = sai_datearriv.getValue();
        String image = sai_image.getText();

        // Vérifier si les champs obligatoires sont vides
        if (modele.isEmpty() || numeroPlaqueStr.isEmpty() || capaciteStr.isEmpty() || destin.isEmpty() || departDate == null || arriveeDate == null) {
            // Afficher un message d'erreur et sortir de la méthode
            Alert alert = new Alert(AlertType.ERROR, "Veuillez remplir tous les champs obligatoires.");
            alert.showAndWait();
            return;
        }

        int numeroPlaque = 0;
        int capacite = 0;
        try {
            numeroPlaque = Integer.parseInt(numeroPlaqueStr);
            capacite = Integer.parseInt(capaciteStr);
        } catch (NumberFormatException e) {
            // Afficher un message d'erreur et sortir de la méthode
            Alert alert = new Alert(AlertType.ERROR, "Les champs 'Numéro de plaque' et 'Capacité' doivent contenir des nombres entiers.");
            alert.showAndWait();
            return;
        }
        // Vérifier si les champs 'Modèle' et 'Destination' contiennent uniquement des lettres
        if (!modele.matches("[a-zA-Z]+") || !destin.matches("[a-zA-Z]+")) {
            // Afficher un message d'erreur et sortir de la méthode
            Alert alert = new Alert(AlertType.ERROR, "Les champs 'Modèle' et 'Destination' doivent contenir uniquement des lettres.");
            alert.showAndWait();
            return;
        }
       

        bus b = new bus();
        b.setModele(sai_modele.getText());
        b.setNumeroPlaque(Integer.parseInt(sai_numero_plaque.getText()));
        b.setCapacite(Integer.parseInt(sai_capacite.getText()));
        b.setDestination(sai_destin.getText());
        // b.setModele(sai_image.getText());
        java.sql.Date date = java.sql.Date.valueOf(sai_datedep.getValue());
        b.setDepart(date);
        java.sql.Date date1 = java.sql.Date.valueOf(sai_datearriv.getValue());
        b.setArrivee(date1);
            
        b.setImage(sai_image.getText());

        try {
            bs.ajouter(b);
            reset();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void reset() {
        sai_modele.setText("");
        sai_numero_plaque.setText("");
        sai_capacite.setText("");
        sai_destin.setText("");
        sai_image.setText("");
        sai_datedep.setValue(LocalDate.now());
        sai_datearriv.setValue(LocalDate.now());

    }

    @FXML
    private void Retourbus(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainbus.fxml"));
        Parent root = loader.load();
        MainbusController controller = loader.getController();
        controller.setdatabus(b);

        Retour.getScene().setRoot(root);
    }

    @FXML
    private void afficherbus(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("afficherbus.fxml"));
        Parent root = loader.load();
        AfficherbusController controller = loader.getController();
        controller.setdatabus1(b);

        Retour.getScene().setRoot(root);
    }

    void setdatabus(bus b) {
    }

    @FXML
    private void pdf_button(ActionEvent event) {
        busService bs = new busService();
        Document document = new Document();
        try {

            String currentDateTime = "" + (new Date().getTime());
            PdfWriter.getInstance(document, new FileOutputStream("C://pdf/bus" + currentDateTime.replace(":", "-") + ".pdf"));
            ((com.itextpdf.text.Document) document).open();
            //Image img = Image.getInstance("C://img/logo.png") ;
            //document.add(img);
            Paragraph ph1 = new Paragraph("Liste des bus");
            Paragraph ph2 = new Paragraph("-------------");
            PdfPTable table = new PdfPTable(6);
            //On créer l'objet cellule.
            PdfPCell cell;
            //contenu du tableau.
            table.addCell("id_bus : ");
            table.addCell("modele : ");
            table.addCell("numero_de_plaque : ");
            table.addCell("capacite: ");
            table.addCell("date_depart : ");
            table.addCell("date_arrive : ");
            bs.recuperer(b).forEach(e
                    -> {
                table.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(String.valueOf(e.getId_bus()));
                table.addCell(String.valueOf(e.getModele()));
                table.addCell(String.valueOf(e.getNumeroPlaque()));
                table.addCell(String.valueOf(e.getDepart()));
                table.addCell(String.valueOf(e.getArrivee()));

                //Scale to new height and new width of image
                //Add to document
            }
            );
            ((com.itextpdf.text.Document) document).add(ph1);
            ((com.itextpdf.text.Document) document).add(ph2);
            ((com.itextpdf.text.Document) document).add(table);
            ((com.itextpdf.text.Document) document).addAuthor("list produit");
        } catch (Exception e) {
            System.out.println(e);
        }
        (document).close();

    }

    @FXML
    private void uploadimage(ActionEvent event) throws FileNotFoundException, IOException {
        // Ouvrir la boîte de dialogue pour choisir un fichier
//        selectedFile = fileChooser.showOpenDialog(null);
//        if (selectedFile != null) {
//            Image image = new Image(selectedFile.toURI().toString());
//            imageView.setImage(image);
//        }
        Random rand = new Random();
        int x = rand.nextInt(1000);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        File file = fileChooser.showOpenDialog(null);
        String DBPath = "C:\\\\xampp1\\\\htdocs\\\\imageP\\\\"  + x + ".jpg";
        if (file != null) {
            FileInputStream Fsource = new FileInputStream(file.getAbsolutePath());
            FileOutputStream Fdestination = new FileOutputStream(DBPath);
            BufferedInputStream bin = new BufferedInputStream(Fsource);
            BufferedOutputStream bou = new BufferedOutputStream(Fdestination);
            System.out.println(file.getAbsoluteFile());
            String path=file.getAbsolutePath();
            Image img = new Image(file.toURI().toString());
            imageView.setImage(img);    
            sai_image.setText(DBPath);
            int b = 0;
            while (b != -1) {
                b = bin.read();
                bou.write(b);
            }
            bin.close();
            bou.close();          
        } else {
            System.out.println("error");
        }





    }

}
