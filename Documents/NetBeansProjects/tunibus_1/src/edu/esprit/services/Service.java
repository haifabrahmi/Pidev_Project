/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

 import java.util.Properties;
 import com.twilio.Twilio;
 import com.twilio.rest.api.v2010.account.Message;
 import com.twilio.type.PhoneNumber;
import com.twilio.Twilio;
import edu.esprit.entities.Circuit;
import edu.esprit.entities.Station;
import edu.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
/**
 *
 * @author HP
 */
public class Service implements IService<Station> {

    Connection cnx ;

    public Service() {
        cnx= DataSource.getInstance().getCnx();
    }
    

    @Override
    public void ajouter(Station t) {
//       

        try {
            String req = "INSERT INTO station( `nom_s`  , `adresse_s` , `ligne_s` , `horaire_s` , `equipement_s` , `commentaire_s`) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
           
            ps.setString(1, t.getNom_s());
            ps.setString(2, t.getAdresse_s());
            ps.setString(3, t.getLigne_s());
            ps.setDate(4, (Date) t.getHoraire_s());
            ps.setString(5, t.getEquipement_s());
            ps.setString(6, t.getCommentaire_s());
            //ps.setInt(7, t.getCircuit().getId_c());
            //ps.setInt(7,23);
            ps.executeUpdate();
            System.out.println("station added ");
                // Send SMS to user
        String accountSid = "AC6fc38d4e14a29ab0cdd952421202a88a";
        String authToken = "f35b87a43d0906fb7b4c20e4b1cfbb6f";
        Twilio.init(accountSid, authToken);
        String fromPhoneNumber = "+15076093288"; // Change this to your Twilio phone number
        String toPhoneNumber = "+21652666542"; // Change this to the user's phone number
        String smsBody = "Bonjour, une nouvelle station a été ajoutée . Cordialement, L'équipe de support";
        Message message = Message.creator(new PhoneNumber(toPhoneNumber), new PhoneNumber(fromPhoneNumber), smsBody).create();
        System.out.println("SMS sent successfully to " + toPhoneNumber);
        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
  
    
    }
    

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM station WHERE id_s = ? ";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("station deleted");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }      

    @Override
    public void modifier(Station t) {
        try{

String req = "UPDATE station SET id_s = '" + t.getId_s() + "', nom_s = '" + t.getNom_s() + "', adresse_s = '" + t.getAdresse_s() + "', ligne_s = '" + t.getLigne_s() + "',horaire_s  = '" + t.getHoraire_s() + "',equipement_s   = '" + t.getEquipement_s() + "' ,commentaire_s  = '" + t.getCommentaire_s()+ "' WHERE station.`id_s` = " + t.getId_s();

            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Station updated ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        @Override
    public List<Station> getAll() {
        List<Station> list = new ArrayList<>();
        try {
            String req = "Select * from Station";
//            String req = "Select   s.nom_s, s.adresse_s , s.ligne_s , s.horaire_s , s.equipement_s , s.commentaire_s ";
//             from circuit c "+"JOIN station s ON c.id_c = s.id_C"
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            
            while (rs.next()) {
                Station t = new Station();
                t.setNom_s(rs.getString("nom_s"));
                t.setAdresse_s(rs.getString("adresse_s"));
                t.setLigne_s(rs.getString("ligne_s"));
                t.setHoraire_s(rs.getDate("horaire_s"));
                t.setEquipement_s(rs.getString("equipement_s"));
                t.setCommentaire_s(rs.getString("commentaire_s"));
                //Circuit c = new Circuit(rs.getString("nom_c"));
                ///t.setCircuit(c);
                list.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public void supprimerStation(Station station) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
