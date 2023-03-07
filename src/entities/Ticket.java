/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

public class Ticket {
    private int id_ticket;
    private float prix;
    private Date date_achat;
    private String type_ticket;

  

   

    public Ticket() {
 this.id_ticket = id_ticket;
        this.prix = prix;
        this.type_ticket = type_ticket;      }

    public Ticket(int id_ticket, float prix, String type_ticket) {
        this.id_ticket = id_ticket;
        this.prix = prix;
        this.type_ticket = type_ticket;
    }


    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Date getDate_achat() {
        return date_achat;
    }

  
    public String getType_ticket() {
        return type_ticket;
    }

    public void setType_ticket(String type_ticket) {
        this.type_ticket = type_ticket;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id_ticket=" + id_ticket + ", prix=" + prix + ", type_ticket=" + type_ticket + '}';
    }
    
    
}