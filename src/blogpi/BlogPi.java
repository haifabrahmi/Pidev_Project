/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blogpi;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import entities.Utilisateur;
import utils.MyDB;
import entities.Publication;
import entities.Photo;
import Services.*;
import entities.userclient;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
/**
 *
 * @author Baklouti
 */
public class BlogPi  {
     
    
    



   
    public static void main(String[] args){
     
        
       
      MyDB cnx = new MyDB(); 
     ServicesTags database = new ServicesTags();

    // Create a Publication object
    Publication p = new Publication();
   p.setId(133);
   p.setText("#pub");
    // Call the add_relation method
    boolean success = database.add_relation(p);

    // Check the result of the method call
    if (success) {
        System.out.println("Relation added successfully");
    } else {
        System.out.println("Failed to add relation");
    }
     
    }
   
}
