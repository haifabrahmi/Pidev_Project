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
    private String modele;
    private Date date_depart ,date_arrive ;

    public bus() {
    }

    public bus(int id_bus, String modele, Date date_depart, Date date_arrive) {
        this.id_bus = id_bus;
        this.modele = modele;
        this.date_depart = date_depart;
        this.date_arrive = date_arrive;
    }

    public int getId_bus() {
        return id_bus;
    }

    public String getModele() {
        return modele;
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public Date getDate_arrive() {
        return date_arrive;
    }

    public void setId_bus(int id_bus) {
        this.id_bus = id_bus;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }

    public void setDate_arrive(Date date_arrive) {
        this.date_arrive = date_arrive;
    }

    @Override
    public String toString() {
        return "bus{" + "id_bus=" + id_bus + ", modele=" + modele + ", date_depart=" + date_depart + ", date_arrive=" + date_arrive + '}';
    }
    

}
