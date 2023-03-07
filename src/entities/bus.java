/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author haifa
 */
public class bus {
    private int id_bus;
   private Date depart; 
    private Date arrivee;
    private String modele;
    private int numeroPlaque;
    private int capacite;
    private byte[] imageBytes;
   
    private String destination;
    private String image;
    

    public bus() {
    }

    public bus(int id_bus, Date depart, Date arrivee, String modele, int numeroPlaque, int capacite, String destination,String image) {
        this.id_bus = id_bus;
        this.depart = depart;
        this.arrivee = arrivee;
        this.modele = modele;
        this.numeroPlaque = numeroPlaque;
        this.capacite = capacite;
        this.destination = destination;
        this.image= image;
    }

    public bus(Date depart, Date arrivee, String modele, int numeroPlaque, int capacite, String destination,String image) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.modele = modele;
        this.numeroPlaque = numeroPlaque;
        this.capacite = capacite;
        this.destination = destination;
        this.image= image;
    }

    public bus(int numeroPlaque) {
        this.numeroPlaque = numeroPlaque;
    }
    
    

    public int getId_bus() {
        return id_bus;
    }

    public java.util.Date getDepart() {
        return depart;
    }

    public Date getArrivee() {
        return arrivee;
    }

    public String getModele() {
        return modele;
    }



    public int getNumeroPlaque() {
        return numeroPlaque;
    }

    public int getCapacite() {
        return capacite;
    }

    public String getDestination() {
        return destination;
    }

    public String getImage() {
        return image;
    }
    

    public void setId_bus(int id_bus) {
        this.id_bus = id_bus;
    }

    public void setDepart(Date depart) {
        this.depart = depart;
    }

    public void setArrivee(Date arrivee) {
        this.arrivee = arrivee;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public void setNumeroPlaque(int numeroPlaque) {
        this.numeroPlaque = numeroPlaque;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
     public void setImageBytes(byte[] bytes) {
        this.imageBytes = bytes;
    }
      public byte[] getImageBytes() {
        return imageBytes;
    }

    @Override
    public String toString() {
        return "bus{" + "id_bus=" + id_bus + ", depart=" + depart + ", arrivee=" + arrivee + ", modele=" + modele + ", numeroPlaque=" + numeroPlaque + ", capacite=" + capacite + ", destination=" + destination + ", image=" + image + '}';
    }

   


    


  
   
    

    
    
    
}
