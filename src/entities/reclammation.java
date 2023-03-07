/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author user
 */
public class reclammation {
    private int id_rec;
    private String description;
    private String nom_voyageur;
    private Date date_depot;
    //private user user;

   
    
    
    

    public reclammation() {
    }

    public reclammation(int id_rec, String description, String nom_voyageur, Date date_depot, user user) {
        this.id_rec = id_rec;
        this.description = description;
        this.nom_voyageur = nom_voyageur;
        this.date_depot = date_depot;
    }

    public reclammation(String description, String nom_voyageur, Date date_depot) {
        this.description = description;
        this.nom_voyageur = nom_voyageur;
        this.date_depot = date_depot;
    }

    public reclammation(int id_rec, String description, String nom_voyageur, Date date_depot) {
        this.id_rec = id_rec;
        this.description = description;
        this.nom_voyageur = nom_voyageur;
        this.date_depot = date_depot;
    }

    public reclammation(String nom, String description) {
    }

   

    public int getId_rec() {
        return id_rec;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom_voyageur() {
        return nom_voyageur;
    }

    public void setNom_voyageur(String nom_voyageur) {
        this.nom_voyageur = nom_voyageur;
    }

    public Date getDate_depot() {
        return date_depot;
    }

    public void setDate_depot(Date date_depot) {
        this.date_depot = date_depot;
    }

    @Override
    public String toString() {
        return "reclammation{" + "id_rec=" + id_rec + ", description=" + description + ", nom_voyageur=" + nom_voyageur + ", date_depot=" + date_depot + '}';
    }

    

   
    
}
