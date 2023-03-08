package services;

import entities.Reservation;
import java.util.List;
import utils.MyDB;
import java.sql.*;
import java.util.ArrayList;

public class ReservationService implements IService_1<Reservation> {

    Connection cnx;

    public ReservationService() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Reservation r) throws SQLException {
        String res = "INSERT INTO reservation (id_res,date_res, heure_res, type_ticket, prix, nb_place, prix_totale) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = cnx.prepareStatement(res);
        ps.setInt (1, r.getId_res());
        ps.setDate(2, (Date) r.getDate_res());
        ps.setString(3, r.getHeure_res());
        ps.setString(4, r.getType_ticket());
        ps.setFloat(5, r.getPrix());        
        ps.setInt(6, r.getNb_place());
        ps.setFloat(7, r.getPrix_totale());

        ps.executeUpdate();
        System.out.println("Reservation ajoutée");
    }

    @Override
    public void modifier(Reservation r) throws SQLException {
        String req = "UPDATE reservation SET date_res=?, heure_res=?, nb_place=?, prix_totale=?, imatriculation=?, id_usr=? WHERE id_res=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setDate(1, (Date) r.getDate_res());
        ps.setString(2, r.getHeure_res());
        ps.setInt(3, r.getNb_place());
        ps.setFloat(4, r.getPrix_totale());
        ps.setInt(5, r.getId_res());
        ps.executeUpdate();
        System.out.println("Reservation modifiée");
    }

    @Override
    public void supprimer(Reservation r) throws SQLException {
        String req = "DELETE FROM reservation WHERE id_res=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, r.getId_res());
        ps.executeUpdate();
        System.out.println("Reservation supprimée");
    }

    public List<Reservation> recuperer() throws SQLException {
        String s = "SELECT * FROM reservation";
        List<Reservation> reservations = new ArrayList<>();

        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            Reservation r = new Reservation(); 
            r.setId_res(rs.getInt("id_res"));
            r.setDate_res(rs.getDate("date_res"));
            r.setHeure_res(rs.getString("heure_res"));
            r.setPrix(rs.getFloat("prix"));
            r.setNb_place(rs.getInt("nb_place"));
            r.setPrix_totale(rs.getFloat("prix_totale"));
            r.setType_ticket(rs.getString("Type_ticket"));

            reservations.add(r);
        }
        return reservations;
    }



public List<Reservation> rechercher(int id_res) throws SQLException {
    String s = "SELECT * FROM reservation WHERE id_res=?";
    List<Reservation> reservations = new ArrayList<>();
    PreparedStatement ps = cnx.prepareStatement(s);
    ps.setInt(1, id_res);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
        Reservation r = new Reservation(); 
        r.setId_res(rs.getInt("id_res"));
        r.setDate_res(rs.getDate("date_res"));
        r.setHeure_res(rs.getString("heure_res"));
        r.setNb_place(rs.getInt("nb_place"));
        r.setPrix_totale(rs.getFloat("prix_totale"));

        reservations.add(r);
    }
    return reservations;
}

  
    }
