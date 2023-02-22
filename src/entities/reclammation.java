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
    private String nom_voyageur,description;
    private Date date_depot;
    static user user;

    public reclammation(int id_rec, String nom_voyageur, String description, Date date_depot, user user) {
        this.id_rec = id_rec;
        this.nom_voyageur = nom_voyageur;
        this.description = description;
        this.date_depot = date_depot;
        this.user = user;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    
   

    public reclammation(int id_rec, String nom_voyageur, String description, Date date_depot) {
        this.id_rec = id_rec;
        this.nom_voyageur = nom_voyageur;
        this.description = description;
        this.date_depot = date_depot;
    }

    public reclammation(int id_rec, String nom_voyageur, String description) {
        this.id_rec = id_rec;
        this.nom_voyageur = nom_voyageur;
        this.description = description;
    }

    public reclammation(String nom_voyageur, String description) {
        this.nom_voyageur = nom_voyageur;
        this.description = description;
    }

    public reclammation(String nom_voyageur, String description, Date date_depot) {
        this.nom_voyageur = nom_voyageur;
        this.description = description;
        this.date_depot = date_depot;
    }

    public reclammation() {
    }
    

    public int getId_rec() {
        return id_rec;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public String getNom_voyageur() {
        return nom_voyageur;
    }

    public void setNom_voyageur(String nom_voyageur) {
        this.nom_voyageur = nom_voyageur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_depot() {
        return date_depot;
    }

    public void setDate_depot(Date date_depot) {
        this.date_depot = date_depot;
    }

    @Override
    public String toString() {
        return "reclammation{" + "id_rec=" + id_rec + ", nom_voyageur=" + nom_voyageur + ", description=" + description + ", date_depot=" + date_depot + '}';
    }
}
