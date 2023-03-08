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
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import services.busService;

/**
 * FXML Controller class
 *
 * @author haifa
 */
public class AfficherbusController implements Initializable {
    busService bs = new busService();
       int index =-1;

    @FXML
    private TableColumn<bus, String> modele;
    @FXML
    private TableColumn<bus, Integer> numero_de_plaque;
    @FXML
    private TableColumn<bus, Integer> capacite;
    @FXML
    private TableColumn<bus, Date> date_depart;
    @FXML
    private TableColumn<bus, Date> date_arrive;
    @FXML
    private TableColumn<bus, String> destination;
    @FXML
    private TableColumn<bus, String> imageTv;
    @FXML
    private TableView<bus> table;
    ObservableList<bus>  ListBus = FXCollections.observableArrayList();
    bus b = new bus();
    @FXML
    private Button retour_aff;
    @FXML
    private Button supprimerbus;
    @FXML
    private Button modifierbus;
    @FXML
    private Button pdf;
    @FXML
    private TextField modeleField;
    @FXML
    private ImageView QrCode;
    
   
   
    


    /**
     * Initializes the controller class.
     */
    
    public void remplir(){
                 try{
         List<bus> list = bs.recuperer(b);
        

      
       ListBus.addAll(list);
        modele.setCellValueFactory(new PropertyValueFactory<>("modele"));
        numero_de_plaque.setCellValueFactory(new PropertyValueFactory<>("numeroPlaque"));
       capacite.setCellValueFactory(new PropertyValueFactory<>("capacite"));
        date_depart.setCellValueFactory(new PropertyValueFactory<>("arrivee"));
        date_arrive.setCellValueFactory(new PropertyValueFactory<>("depart"));
        destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        imageTv.setCellValueFactory(new PropertyValueFactory<>("image"));

        
 
                table.setItems(ListBus);
} catch (SQLException ex) {
             System.out.println("asslema "+ex);        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
            remplir();
//            String filename = bs.GenerateQrbus(b);
//            System.out.println("filename lenaaa " + filename);
//            String path1="C:\\xampp\\htdocs\\xchangex\\imgQr\\qrcode"+filename;
//            File file1=new File(path1);
//            Image img1 = new Image(file1.toURI().toString());
//            //Image image = new Image(getClass().getResourceAsStream("src/utils/img/" + filename));
//            QrCode.setImage(img1);  
//        } catch (IOException ex) {
//            Logger.getLogger(AfficherbusController.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
      void setdatabus1(bus b) { 
     }

    @FXML
    private void retouraff(ActionEvent event) throws IOException {
              
  FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouterbus.fxml"));
            Parent root = loader.load();
            AjouterbusController controller = loader.getController();
            controller.setdatabus(b);

            retour_aff.getScene().setRoot(root);
    }

    @FXML
    
       private void suppprimer_bus(ActionEvent event) throws SQLException {
    // Récupérer l'élément sélectionné dans la table
    bus b = table.getSelectionModel().getSelectedItem();
    if (b != null) {
        // Supprimer l'élément de la base de données
        bs.supprimer(b);
        // Supprimer l'élément de la liste observable et rafraîchir la table
        ListBus.remove(b);
        table.refresh();
    }
}

    @FXML
    void getSelected() {
                    System.out.println("rah il ghali rah");

        try{
    	index=table.getSelectionModel().getSelectedIndex();
    	if(index <=-1)
    	{
    		return;
    	}
        
        
        /*raison.setText(raison1.getCellData(index).toString());
    	mentent.setText(mentent1.getCellData(index).toString());
    	datepick.setValue(LocalDate.parse(date1.getCellData(index).toString()));
    	titre.setText(titre1.getCellData(index).toString());*/

System.out.println(index);}catch(Exception e){
            System.out.println(e);
            System.out.println("erreur");
}
    }

    @FXML
    private void modifier_bus(ActionEvent event) throws IOException, ParseException {
        
        FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("modifierbus.fxml"));
            DialogPane  detailPage=loader.load();
            ModifierbusController detailControlleur =loader.getController();
             detailControlleur. setListener(new ModifierbusController.PopupListener() {
                        @Override
                        public void onInfoSent( Boolean Rendez_vousInstance) {
                           table.getItems().clear();
                           remplir();
                }
                    });
            System.out.println("mchetttt lkhedma "+ListBus.get(index).getId_bus());
            System.out.println("rmazelt makhedmtech "+ListBus.get(index).getDepart());
            System.out.println("rahou makhedmetch"+ListBus.get(index).getArrivee());
            System.out.println("makhedmetch"+ListBus.get(index).getId_bus());
           detailControlleur.setAtrtribute( ListBus.get(index));
           // detailControlleur.setDialogPane(candidatureInstance);
            Dialog<ButtonType> dialog =new Dialog<>();
            dialog.setDialogPane(detailPage);
            Optional<ButtonType> clickButtonp=dialog.showAndWait();
            dialog.setTitle("detail");
           
        
    }

    @FXML
    private void pdf_button(ActionEvent event) {
    

      busService bs = new busService ();
           Document document = new Document();
        try { 
            
            String currentDateTime = ""  + (new java.util.Date().getTime()) ;
            PdfWriter.getInstance(document, new FileOutputStream("C://pdf2/bus"+ currentDateTime.replace(":","-") +".pdf"));
            ((com.itextpdf.text.Document)document).open();
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
            ((com.itextpdf.text.Document)document).add(ph1);
            ((com.itextpdf.text.Document)document).add(ph2);
            ((com.itextpdf.text.Document)document).add(table);
            ((com.itextpdf.text.Document)document).addAuthor("list bus");
        } catch (Exception e) {
            System.out.println(e);
        }
        (document).close();
     
    }

    private void recherche(ActionEvent event) throws SQLException {
   String modele = modeleField.getText();
        List<bus> list = bs.rechercher(modele);
        ListBus.clear();
        ListBus.addAll(list);
        table.setItems(ListBus);
}

    @FXML
    private void chercherBus(KeyEvent event) {
          busService bs=new busService(); 
        bus b= new bus();
        ObservableList<bus>filter= bs.chercherbus(modeleField.getText());
        populateTable(filter);
    }
    
    private void populateTable(ObservableList<bus> branlist){
       table.setItems(branlist);
   
       }
  
}



    
    

    
    
 
