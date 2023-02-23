
package entities;

import java.util.Date;

public class Reservation {
    private int id_res;
    private Date date_res;
    private String heure_res;
    private int nb_place;
    private int imatriculation;
    private int id_ticket;
    private int id_usr;
    
    public Reservation() {
    }

    // Constructor
    public Reservation(int id_res, Date date_res, String heure_res, int nb_place, int imatriculation, int id_ticket, int id_usr) {
        this.id_res = id_res;
        this.date_res = date_res;
        this.heure_res = heure_res;
        this.nb_place = nb_place;
        this.imatriculation = imatriculation;
        this.id_ticket = id_ticket;
        this.id_usr = id_usr;
    }

    public int getId_res() {
        return id_res;
    }

    public void setId_res(int id_res) {
        this.id_res = id_res;
    }

    public Date getDate_res() {
        return date_res;
    }

    public void setDate_res(Date date_res) {
        this.date_res = date_res;
    }

    public String getHeure_res() {
        return heure_res;
    }

    public void setHeure_res(String heure_res) {
        this.heure_res = heure_res;
    }

    public int getNb_place() {
        return nb_place;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    public int getImatriculation() {
        return imatriculation;
    }

    public void setImatriculation(int imatriculation) {
        this.imatriculation = imatriculation;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public int getId_usr() {
        return id_usr;
    }

    public void setId_usr(int id_usr) {
        this.id_usr = id_usr;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id_res=" + id_res + ", date_res=" + date_res + ", heure_res=" + heure_res + ", nb_place=" + nb_place + ", imatriculation=" + imatriculation + ", id_ticket=" + id_ticket + ", id_usr=" + id_usr + '}';
    }

    public void setImmatriculation(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setImmat(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setnbplace(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  


    
    
   
    
}
