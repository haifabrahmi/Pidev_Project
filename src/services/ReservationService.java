
package services;

import entities.Reservation;
import java.util.List;
import utils.MyDB;
import java.sql.*;
import java.util.ArrayList;



/**
 *
 * @author Skander
 */
public class ReservationService implements IService<Reservation> {

    Connection cnx;

    public ReservationService() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Reservation r) throws SQLException {
        String res = "INSERT INTO reservation (id_res,date_res, heure_res, nb_place, imatriculation, id_ticket, id_usr) VALUES (?, ?,?, ?,?,?,?)";
        PreparedStatement ps = cnx.prepareStatement(res);
        ps.setInt (1, r.getId_res());
        ps.setDate(2, (Date) r.getDate_res());
        ps.setString(3, r.getHeure_res());
        ps.setInt(4, r.getNb_place());
        ps.setInt(5, r.getImatriculation());
        ps.setInt(6, r.getId_ticket());
        ps.setInt(7, r.getId_usr());
        ps.executeUpdate();
        System.out.println("Reservation Ajouté");

        
    }

    @Override
     public void modifier (Reservation r) throws SQLException {
       String req = "UPDATE reservation SET date_res=?, heure_res=?, nb_place=?, imatriculation =?, id_ticket=?, id_usr=? WHERE id_res=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setDate(1, (Date) r.getDate_res());
        ps.setString(2, r.getHeure_res());
        ps.setInt(3, r.getNb_place());
        ps.setInt(4, r.getImatriculation());
        ps.setInt(5, r.getId_ticket());
        ps.setInt(6, r.getId_usr());
        ps.setInt(7, r.getId_res());
        ps.executeUpdate();
        System.out.println("Reservation Modifié");
        /* try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(res)) {
            ps.setDate(1, reservation.getDate_res());
            ps.setTime(2, reservation.getHeure_res());
            ps.setInt(3, reservation.getNb_Place());
            ps.setString(4, reservation.get_Imatriculation ());
            ps.setInt(5, reservation.getId_ticket());
            ps.setInt(6, reservation.getId_usr());
            ps.setInt(7, reservation.getId_res());
            ps.executeUpdate();
        }*/
     }

    @Override
    public void supprimer(Reservation r) throws SQLException {
String req = "DELETE FROM reservation WHERE id_res=?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, r.getId_res());
        ps.executeUpdate();
        System.out.println("Reservation Supprimé");   
    }





  public List<Reservation> recuperer() throws SQLException {
    String s = "SELECT * FROM reservation";
    List<Reservation> Reservation = new ArrayList<>();

    Statement st = cnx.createStatement();
    ResultSet rs = st.executeQuery(s);
    while (rs.next()) {
        Reservation r = new Reservation(); 
        r.setId_res(rs.getInt("id_res"));
        r.setDate_res(rs.getDate("date_res"));
        r.setHeure_res(rs.getString("heure_res"));
        r.setNb_place(rs.getInt("nb_place"));
        r.setImatriculation(rs.getInt("imatriculation"));
        r.setId_ticket(rs.getInt("id_ticket"));
        r.setId_usr(rs.getInt("id_usr"));

        Reservation.add(r);

    }
    return Reservation;
}







 

}

       

    /*@Override
    public void supprimer(Reservation r) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reservation> recuperer() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    */
  

    /*@Override
    public List<Reservation> recuperer(Reservation r) throws SQLException {
        List<Reservation> Reservation = new ArrayList<>();
        String s = "select * from reservation";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Reservation r = new Reservation();
            r.setId_res(rs.getInt("id_res"));
            r.setDate_res(rs.getString("date_res"));
            r.setHeure_res(rs.getString("heure_res"));
            r.setImmat(rs.getString("immat"));
            r.setId_ticket(rs.getInt("id_ticket"));
            r.setId_usr(rs.getInt("id_usr"));

        reservation.add(r);
            
        }
        return reservation;
    }*/

    