/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import java.util.Date;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import static java.sql.JDBCType.DATE;
import static java.sql.Types.DATE;
import java.time.Instant;
import static java.util.Calendar.DATE;

import javafx.scene.shape.Rectangle;

/**
 *
 * @author HP
 */
public class Circuit {
     private int id_c;
    private String nom_c;
    private int liste_c;
    private int nbrbus_c;
    private Date horaire_c;
    private String distance_c;
    
    
   public Circuit() {
}

    public Circuit(String nom_c, int liste_c, int nbrbus_c, Date horaire_c, String distance_c) {
        this.nom_c = nom_c;
        this.liste_c = liste_c;
        this.nbrbus_c = nbrbus_c;
        this.horaire_c = horaire_c;
        this.distance_c = distance_c;
    }

    public Circuit(int id_c, String nom_c, int liste_c, int nbrbus_c, Date horaire_c, String distance_c) {
        this.id_c = id_c;
        this.nom_c = nom_c;
        this.liste_c = liste_c;
        this.nbrbus_c = nbrbus_c;
        this.horaire_c = horaire_c;
        this.distance_c = distance_c;
    }

    public Circuit(String string) {
    }

    

   
    @Override
    public String toString() {
        return "Circuit{" + "id_c=" + id_c + ", nom_c=" + nom_c + ", liste_c=" + liste_c + ", nbrbus_c=" + nbrbus_c + ", horaire_c=" + horaire_c + ", distance_c=" + distance_c + '}';
    }

    public int getId_c() {
        return id_c;
    }

    

    public String getNom_c() {
        return nom_c;
    }

    public void setNom_c(String nom_c) {
        this.nom_c = nom_c;
    }

    public int getListe_c() {
        return liste_c;
    }

    public void setListe_c(int liste_c) {
        this.liste_c = liste_c;
    }

    public int getNbrbus_c() {
        return nbrbus_c;
    }

    public void setNbrbus_c(int nbrbus_c) {
        this.nbrbus_c = nbrbus_c;
    }

    public Date getHoraire_c() {
        return horaire_c;
    }

    public void setHoraire_c(Date horaire_c) {
        this.horaire_c = horaire_c;
    }

    public String getDistance_c() {
        return distance_c;
    }

    public void setDistance_c(String distance_c) {
        this.distance_c = distance_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

//   public boolean isValid() {
//        
//        if (nom_c == null || nom_c.isEmpty()) {
//            return false;
//        }
//        if (liste_c == null || liste_c.isEmpty()) {
//            return false;
//        }
//        if (nbrbus_c == null || nbrbus_c.isEmpty()) {
//            return false;
//        }
//        if (distance_c == null || distance_c.isEmpty()) {
//            return false;
//        }
//        return true;
//    }
    
  
   

   
   
    
    
}
