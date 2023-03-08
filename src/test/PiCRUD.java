/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Reclamation;
import entities.Reponse;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.CRUDReclamation;
import services.CRUDReponse;
import utils.MyConnection;

/**
 *
 * @author lenovo
 */
public class PiCRUD extends Application {
    public static void main(String[] args) {
         MyConnection mc = MyConnection.getInstance();
      launch(args);
       
       Reclamation R1 = new Reclamation(15,"kn", "bonjour", " la vie",1);
//        Reclamation R2 = new Reclamation(2,"hedhi", "dedicace", "likom",0);
        CRUDReclamation cr = new CRUDReclamation();
        cr.ajouterReclamation(R1);
       //cr.RechercherReclamation("Produit");
       // cr.modifierReclamation(R1);
        //cr.supprimerReclamation(R1);
       //cr.afficherReclamations();*/
        
    //Reponse Rp1 = new Reponse(1,1, "aaslemaaaaaaaaaa");
       Reponse Rp2 = new Reponse(7,6,"aaslema");
      CRUDReponse cre = new CRUDReponse();
        cre.ajouterReponse(Rp2);
        //cr.ajouterReponse(Rp2);
        //cr.modifierReponse(Rp1);
//       cr.supprimerReponse(Rp2);
        //cr.afficherReponses();
        
    }

   @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Menu.fxml")) ;
Scene scene = new Scene(root);

primaryStage.setTitle("VOS RECLAMATIONS");
primaryStage.setScene(scene);
primaryStage.show();
    }
}
