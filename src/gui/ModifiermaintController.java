/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.bus;
import entities.maintenance;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.busService;
import services.maintenanceService;

/**
 * FXML Controller class
 *
 * @author haifa
 */
public class ModifiermaintController implements Initializable {

    @FXML
    private TextField sai_description;
    @FXML
    private DatePicker sai_dateentretien;
    @FXML
    private Button enregistrer;
    @FXML
    private ComboBox<Integer> numPlaqueCombo;
    
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
          List<Integer> numPlaques;
        try {
            numPlaques = new busService().getNumeroDePlaquesUnique();
            this.numPlaqueCombo.getItems().addAll(numPlaques);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
    maintenance m =new maintenance ();
    
    
    public void setAtrtribute(maintenance m) throws ParseException{
    
      this.m = m;
    sai_description.setText(m.getDescription());
       System.out.println("salekneha bb"+ m.getId_m());
        System.out.println("salekneha bb"+ m.getDate_entretien());       
        sai_description.setText(m.getDescription());
          this.numPlaqueCombo.setValue(m.getbus().getNumeroPlaque());
        
         System.out.println(m.getDate_entretien().getClass());
        java.util.Date utilDate = new java.util.Date(m.getDate_entretien().getTime());
               LocalDate localDate = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
               LocalDate localDate1 = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
 
     System.out.println(localDate);
      // format the date using the formatter
            sai_dateentretien.setValue(localDate);
     
    }
    

    @FXML
    private void enreg(ActionEvent event) throws SQLException {
       m.setDescription(sai_description.getText());
       java.sql.Date date = java.sql.Date.valueOf(sai_dateentretien.getValue());
            m.setDate_entretien(date);
//            this.numPlaqueCombo.setValue(m.getbus().getNumeroPlaque());
              m.setbus(new bus(numPlaqueCombo.getValue()));
             maintenanceService ms = new maintenanceService();
        try {
            
            ms.modifier(m);
            
                try{
               System.out.println(listener);
        if (listener != null) {
            listener.onInfoSent(true);
        }
           }catch(Exception e){
               System.out.println(e);
           }
            Stage stage = (Stage) enregistrer.getScene().getWindow();
        stage.close();
            
            //b.setArrivee(new java.util.Date(b.getArrivee().getTime())); 
        } catch (SQLException ex) {
            Logger.getLogger(ModifiermaintController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    }
    
