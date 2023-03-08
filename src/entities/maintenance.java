/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author haifa
 */
public class maintenance {
    
    private int id_m;
    private Date date_entretien;
    private String description;
    private bus bus;
  
    public maintenance() {
        bus = new bus();
    }

    public maintenance(int id_m, Date date_entretien, String description, bus bus) {
        this.id_m = id_m;
        this.date_entretien = date_entretien;
        this.description = description;
        this.bus = bus;
    }

    public maintenance(int id_m) {
        this.id_m = id_m;
    }

   
    
    

    public maintenance(Date date_entretien, String description, bus bus) {
        this.date_entretien = date_entretien;
        this.description = description;
        this.bus = bus;
    }
    
    

    public int getId_m() {
        return id_m;
    }

    public Date getDate_entretien() {
        return date_entretien;
    }

    public String getDescription() {
        return description;
    }

    public bus getbus() {
        return bus;
    }

  

    public void setId_m(int id_m) {
        this.id_m = id_m;
    }

    public void setDate_entretien(Date date_entretien) {
        this.date_entretien = date_entretien;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setbus(bus bus) {
        this.bus = bus;
    }
     
      public int getNumeroPlaqueBus() {
    return this.bus.getNumeroPlaque();
          }
    
    public void setNumPlaqueOfBus(int numPlaque){
        this.bus.setNumeroPlaque(numPlaque);
    }
    

    @Override
    public String toString() {
        return "maintenance{" + "id_m=" + id_m + ", date_entretien=" + date_entretien + ", description=" + description + ",bus=" + bus + '}';
  }
    
    

}
