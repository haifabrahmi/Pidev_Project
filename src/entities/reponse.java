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
public class reponse {
     private int id_rep;
    private String resolution_reclam;
    private Date date_resolution;
    
  public reponse(){
      
  } 

    public reponse(int id_rep, String resolution_reclam, Date date_resolution) {
        this.id_rep = id_rep;
        this.resolution_reclam = resolution_reclam;
        this.date_resolution = date_resolution;
    }

    public reponse(String resolution_reclam, Date date_resolution) {
        this.resolution_reclam = resolution_reclam;
        this.date_resolution = date_resolution;
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

    public Date getDate_resolution() {
        return date_resolution;
    }

    public void setDate_resolution(Date date_resolution) {
        this.date_resolution = date_resolution;
    }

    @Override
    public String toString() {
        return "reponse{" + "id_rep=" + id_rep + ", resolution_reclam=" + resolution_reclam + ", date_resolution=" + date_resolution + '}';
    }
}
