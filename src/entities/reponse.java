/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author user
 */
public class reponse {
    private int id_rep;
    private String resolution_reclam;
    private Date date_reponse;
    private reclammation reclammation;
    

    public reponse() {
    }

    public reponse(int id_rep, String resolution_reclam, Date date_reponse, reclammation reclammation) {
        this.id_rep = id_rep;
        this.resolution_reclam = resolution_reclam;
        this.date_reponse = date_reponse;
        this.reclammation = reclammation;
    }

    public reponse(String resolution_reclam, Date date_reponse, reclammation reclammation) {
        this.resolution_reclam = resolution_reclam;
        this.date_reponse = date_reponse;
        this.reclammation = reclammation;
    }

    public reponse(int id_rep, String resolution_reclam, Date date_reponse) {
        this.id_rep = id_rep;
        this.resolution_reclam = resolution_reclam;
        this.date_reponse = date_reponse;
    }
    

    public int getId_rep() {
        return id_rep;
    }

    public void setId_rep(int id_rep) {
        this.id_rep = id_rep;
    }

    public String getResolution_reclam() {
        return resolution_reclam;
    }

    public void setResolution_reclam(String resolution_reclam) {
        this.resolution_reclam = resolution_reclam;
    }

    public Date getDate_reponse() {
        return date_reponse;
    }

    public void setDate_reponse(Date date_reponse) {
        this.date_reponse = date_reponse;
    }

    public reclammation getReclammation() {
        return reclammation;
    }

    public void setReclammation(reclammation reclammation) {
        this.reclammation = reclammation;
    }

    @Override
    public String toString() {
        return "reponse{" + "id_rep=" + id_rep + ", resolution_reclam=" + resolution_reclam + ", date_reponse=" + date_reponse + ", reclammation=" + reclammation + '}';
    }

    public reponse(reclammation reclammation) {
        this.reclammation = reclammation;
    }

   
    
    
    
    
    

    
    
}
