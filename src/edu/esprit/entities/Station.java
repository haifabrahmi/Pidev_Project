/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import static java.sql.JDBCType.DATE;
import static java.sql.Types.DATE;
import java.time.Instant;
import static java.util.Calendar.DATE;
import java.util.Date;

/**
 *
 * @author HP
 */
public class Station {

    private int id_s;
    private String nom_s;
    private String adresse_s;
    private String ligne_s;
    private Date horaire_s;
    private String equipement_s;
    private String commentaire_s;
    private Circuit circuit ;

    public Station() {

    }

    public Station(String nom_s, String adresse_s, String ligne_s, Date horaire_s, String equipement_s, String commentaire_s) {
        this.nom_s = nom_s;
        this.adresse_s = adresse_s;
        this.ligne_s = ligne_s;
        this.horaire_s = horaire_s;
        this.equipement_s = equipement_s;
        this.commentaire_s = commentaire_s;
    }

    public Station(int id_s, String nom_s, String adresse_s, String ligne_s, Date horaire_s, String equipement_s, String commentaire_s) {
        this.id_s = id_s;
        this.nom_s = nom_s;
        this.adresse_s = adresse_s;
        this.ligne_s = ligne_s;
        this.horaire_s = horaire_s;
        this.equipement_s = equipement_s;
        this.commentaire_s = commentaire_s;
    }

    @Override
    public String toString() {
        return "Station{" + "id_s=" + id_s + ", nom_s=" + nom_s + ", adresse_s=" + adresse_s + ", ligne_s=" + ligne_s + ", horaire_s=" + horaire_s + ", equipement_s=" + equipement_s + ", commentaire_s=" + commentaire_s + '}';
    }

    public Station(String nom_s, String adresse_s, String ligne_s, Date horaire_s, String equipement_s, String commentaire_s, Circuit circuit) {
        this.nom_s = nom_s;
        this.adresse_s = adresse_s;
        this.ligne_s = ligne_s;
        this.horaire_s = horaire_s;
        this.equipement_s = equipement_s;
        this.commentaire_s = commentaire_s;
        this.circuit = circuit;
    }

    public Circuit getCircuit() {
        return circuit;
    }

    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }


    public int getId_s() {
        return id_s;
    }

    public String getNom_s() {
        return nom_s;
    }

    public void setNom_s(String nom_s) {
        this.nom_s = nom_s;
    }

    public String getAdresse_s() {
        return adresse_s;
    }

    public void setAdresse_s(String adresse_s) {
        this.adresse_s = adresse_s;
    }

    public String getLigne_s() {
        return ligne_s;
    }

    public void setLigne_s(String ligne_s) {
        this.ligne_s = ligne_s;
    }

    public Date getHoraire_s() {
        return horaire_s;
    }

    public void setHoraire_s(Date horaire_s) {
        this.horaire_s = horaire_s;
    }

    public String getEquipement_s() {
        return equipement_s;
    }

    public void setEquipement_s(String equipement_s) {
        this.equipement_s = equipement_s;
    }

    public String getCommentaire_s() {
        return commentaire_s;
    }

    public void setCommentaire_s(String commentaire_s) {
        this.commentaire_s = commentaire_s;
    }
   public boolean isValid() {
        
        if (nom_s == null || nom_s.isEmpty()) {
            return false;
        }
        if (ligne_s == null || ligne_s.isEmpty()) {
            return false;
        }
        if (adresse_s == null || adresse_s.isEmpty()) {
            return false;
        }
        if (equipement_s == null || equipement_s.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean isValidd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
