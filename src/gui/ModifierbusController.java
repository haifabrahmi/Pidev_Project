/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.bus;
import java.io.File;
import java.net.URL;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import services.busService;

/**
 * FXML Controller class
 *
 * @author haifa
 */
public class ModifierbusController implements Initializable {
@FXML
    private Button closeButon;
   @FXML
    private Button enregistreButton;
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
    private ImageView imageView;
    public interface PopupListener {
        void onInfoSent( Boolean value);
    }
    private PopupListener listener;

    public void setListener(PopupListener listener) {
        this.listener = listener;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    bus b=new bus();
    public void setAtrtribute(bus b) throws ParseException{
        this.b=b;
        System.out.println("salekneha bb"+ b.getId_bus());
        System.out.println("salekneha bb"+ b.getDepart());
        sai_modele.setText(b.getModele());
        sai_numero_plaque.setText(String.valueOf(b.getNumeroPlaque()));
      sai_capacite.setText(String.valueOf(b.getCapacite()));
       sai_destin.setText(b.getDestination());
           System.out.println(b.getDepart().getClass());
        java.util.Date utilDate = new java.util.Date(b.getDepart().getTime());

                LocalDate localDate = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate localDate1 = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  
      System.out.println(localDate);
        // format the date using the formatter
            sai_datedep.setValue(localDate);
              sai_datearriv.setValue(localDate1);
              
               String path = b.getImage();
               File file=new File(path);
              Image img = new Image(file.toURI().toString());
                imageView.setImage(img);
                
            
            //b.setArrivee(new java.util.Date(b.getArrivee().getTime())); 

    }
    @FXML
    void close(ActionEvent event) {
   Stage stage = (Stage) closeButon.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void enregistrer(ActionEvent event) throws SQLException {
        bus bus =new bus();
      bus.setModele(  sai_modele.getText());
      bus.setNumeroPlaque(Integer.parseInt( sai_numero_plaque.getText()));
      bus.setCapacite(Integer.parseInt(sai_capacite.getText()));
      bus.setDestination(sai_destin.getText());
      bus.setId_bus(b.getId_bus());
       java.sql.Date date = java.sql.Date.valueOf(sai_datedep.getValue());
            bus.setDepart(date);
             java.sql.Date date1 = java.sql.Date.valueOf(sai_datearriv.getValue());
            bus.setArrivee(date1);
            
            busService bs=new busService();
            bs.modifier(bus);
           try{
               System.out.println(listener);
        if (listener != null) {
            listener.onInfoSent(true);
        }
           }catch(Exception e){
               System.out.println(e);
           }
Stage stage = (Stage) enregistreButton.getScene().getWindow();
        stage.close();
        
          
    }
    
}
