/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author BouheniMed
 */
public class TicketService implements IService_1<Ticket> {

    Connection cnx;

    public TicketService() {
        cnx = MyDB.getInstance().getCnx();
    }

    
    @Override
    public void ajouter(Ticket t) throws SQLException {
 String res = "INSERT INTO Ticket (id_ticket, prix, type_ticket) VALUES (?, ?, ?)";
    PreparedStatement ps = cnx.prepareStatement(res);
    ps.setInt(1, t.getId_ticket());
    ps.setFloat(2, t.getPrix());
    ps.setString(3, t.getType_ticket());
    ps.executeUpdate();
    System.out.println("Ticket ajouté");
    }

    @Override
    public void modifier(Ticket t) throws SQLException {
 String req = "UPDATE ticket SET prix=?, Type_ticket=? WHERE id_ticket=?";
        PreparedStatement ps = cnx.prepareStatement(req);
         ps.setInt(1, t.getId_ticket());
        ps.setFloat(2, t.getPrix());
        ps.setString(3, t.getType_ticket());
       
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

    List<Ticket> tickets = new ArrayList<>();
    String req = "SELECT * FROM Ticket";
    PreparedStatement ps = cnx.prepareStatement(req);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
        Ticket ticket = new Ticket();
        ticket.setId_ticket(rs.getInt("id_ticket"));
        ticket.setPrix(rs.getFloat("prix"));
        ticket.setType_ticket(rs.getString("type_ticket"));
        tickets.add(ticket);
    }
    return tickets;
}

    public Ticket getTicketByType(String newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public double getPrixByType(String type_ticket) throws SQLException {
    String query = "SELECT prix FROM ticket WHERE type_ticket = ?";
    try (PreparedStatement pstmt = cnx.prepareStatement(query)) {
        pstmt.setString(1, type_ticket);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getDouble("prix");
        } else {
            throw new SQLException("Ticket with type '" + type_ticket + "' not found.");
        }
    }
}

    
    
    
    
    
    
 }
    
   


