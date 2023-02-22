/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

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
    private user user;
    public bus() {
    }

    public bus(int id_bus, String modele, int numeroPlaque, int capacite,Date depart ,Date arrivee,user user) {
        this.id_bus = id_bus;
       this.depart = depart;
        this.arrivee = arrivee;
        this.modele = modele;
        this.numeroPlaque = numeroPlaque;
        this.capacite = capacite;
        this.user=user;
    }

    public bus(Date depart, Date arrivee, String modele, int numeroPlaque, int capacite,user user) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.modele = modele;
        this.numeroPlaque = numeroPlaque;
        this.capacite = capacite;
        this.user=user;

        
    }
    

    

    public int getId_bus() {
        return id_bus;
    }

    public Date getDepart() {
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
    public user getuser(){
        return user;
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

    public void setNumeroPlaque(int numeroPlaque) {
        this.numeroPlaque = numeroPlaque;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    public void setuser(user user){
        this.user =user;
    }

    @Override
    public String toString() {
        return "bus{" + "id_bus=" + id_bus + ", depart=" + depart + ", arrivee=" + arrivee + ", modele=" + modele + ", numeroPlaque=" + numeroPlaque + ", capacite=" + capacite + ", user=" + user + '}';
    }

    

    
   
   
    
}
