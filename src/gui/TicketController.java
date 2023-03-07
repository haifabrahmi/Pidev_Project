/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import com.google.zxing.WriterException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;



import entities.Reservation;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author BouheniMed
 */
public class TicketController implements Initializable {

    @FXML
    private Label immat;
    @FXML
    private Label heurer;
    @FXML
    private Label dater;
    @FXML
    private Label nbp;
    @FXML
    private ImageView retour;
    @FXML
    private Label typeticket;
    @FXML
    private Label price;
    @FXML
    private Label prixticket;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setdataticket(Reservation r) {
     immat.setText(String.valueOf(r.getImatriculation()));
    dater.setText(String.valueOf(r.getDate_res()));
    heurer.setText(String.valueOf(r.getHeure_res()));
    prixticket.setText(String.valueOf(r.getPrix()));
    typeticket.setText(String.valueOf(r.getType_ticket()));

    // Calculate the total price based on the number of places reserved and the ticket price
    int nb_place = r.getNb_place();
    double prix_ticket = r.getPrix();
    double total_price = nb_place * prix_ticket;
    price.setText(String.valueOf(total_price));

    nbp.setText(String.valueOf(nb_place));
    }
    @FXML
    private void retour(MouseEvent event) throws IOException {
        Reservation r = new Reservation();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Reservation.fxml"));
            Parent root = loader.load();
            ReservationController controller = loader.getController();
            controller.setdataReservation(r);

            retour.getScene().setRoot(root);
    }

  @FXML
private void imprimer(ActionEvent event) throws DocumentException, FileNotFoundException, IOException, WriterException {
    // Get the data from the labels
    String immatriculation = immat.getText();
    String date_res = dater.getText();
    String heure_res = heurer.getText();
    String nb_place = nbp.getText();
    
    // Create a new PDF document
    Document document = new Document();
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("ticket.pdf"));
    document.open();

    // Add the ticket data to the document
    Font fontTitle = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.BLACK);
    Paragraph title = new Paragraph("Bon Voyage", fontTitle);
    title.setAlignment(Element.ALIGN_CENTER);
    document.add(title);
    
    Font fontData = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
    document.add(new Paragraph("Immatriculation: " + immatriculation, fontData));
    document.add(new Paragraph("Date de réservation: " + date_res, fontData));
    document.add(new Paragraph("Heure de réservation: " + heure_res, fontData));
    document.add(new Paragraph("Nombre de places réservées: " + nb_place, fontData));

    // Add the QR code to the document
    BarcodeQRCode qrCode = new BarcodeQRCode("Reservation " + immatriculation + " " + date_res + " " + heure_res + " " + nb_place, 100, 100, null);
    Image qrImage = qrCode.getImage();
    qrImage.scaleAbsolute(100, 100);
    qrImage.setAbsolutePosition(250, 300);
    PdfContentByte contentByte = writer.getDirectContent();
    contentByte.addImage(qrImage);

    // Close the document
    document.close();

    // Open the PDF file
    File file = new File("ticket.pdf");
    Desktop.getDesktop().open(file);
}

      }
    


    

