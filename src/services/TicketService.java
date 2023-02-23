/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reservation;
import entities.Ticket;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author BouheniMed
 */
public class TicketService implements IService<Ticket> {

    Connection cnx;

    public TicketService() {
        cnx = MyDB.getInstance().getCnx();
    }

    
    @Override
    public void ajouter(Ticket t) throws SQLException {
 String res = "INSERT INTO Ticket (id_ticket,prix, date_achat, type_ticket) VALUES (?, ?,?,?,)";
        PreparedStatement ps = cnx.prepareStatement(res);
         ps.setInt(1, t.getId_ticket());
    ps.setFloat(2, t.getPrix());
    ps.setDate(3, t.getDate_achat());
    ps.setString(4, t.getType_ticket());
    ps.executeUpdate();
    System.out.println("Ticket ajouté");
    }

    @Override
    public void modifier(Ticket t) throws SQLException {
 String req = "UPDATE ticket SET prix=?, date_achat=?, type_ticket=? WHERE id_ticket=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setFloat(1, t.getPrix());
        ps.setDate(2, t.getDate_achat());
        ps.setString(3, t.getType_ticket());
        ps.setInt(4, t.getId_ticket());
        ps.executeUpdate();
        System.out.println("Ticket modifié");    }

    @Override
    public void supprimer(Ticket t) throws SQLException {
    String req = "DELETE FROM Ticket WHERE id_ticket=?";
    PreparedStatement ps = cnx.prepareStatement(req);
    ps.setInt(1, t.getId_ticket());
    ps.executeUpdate();
    System.out.println("Ticket supprimé avec succès");   
}

    @Override
    public List<Ticket> recuperer() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   

}
