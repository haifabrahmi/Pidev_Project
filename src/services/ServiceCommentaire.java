/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Commentaire;
import services.IservicesA;
import entities.Publication;
import utils.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Baha
 */
public class ServiceCommentaire implements IservicesA<Commentaire> {
Connection cnx = MyDB.getInstance().getCnx();
   
    @Override
    public void insert(Commentaire p) {
      try {
            String envoi = "INSERT INTO Commentaire (id_user, username, id_pub, suj_com, nb_reaction) VALUES (?,?,?,?,0)";
            PreparedStatement st1 = cnx.prepareStatement(envoi);
            st1.setInt(1, p.getId_user());
            st1.setString(2, p.getUsername());
            st1.setInt(3, p.getId_pub());
            st1.setString(4, p.getSuj_com());
            st1.executeUpdate();
            System.out.println("Commentaire envoyé");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }  
         
    }

   @Override
    public ArrayList <Commentaire> select_all(Commentaire p) {
        ArrayList <Commentaire> l4 = new ArrayList<>();
        try {
            String aff = "SELECT * FROM Commentaire";
            PreparedStatement st4 = cnx.prepareStatement(aff);
            ResultSet rs1 = st4.executeQuery();
            while (rs1.next()) {
                l4.add(new Commentaire(rs1.getInt("id_com"),rs1.getInt("id_user"),rs1.getString("username"), rs1.getInt("id_pub"),rs1.getInt("nb_reaction"),rs1.getString("suj_com"), rs1.getTimestamp("date_com"))); }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return l4;
    }
    
    
    
     public ArrayList <Commentaire> afficherCommPub(Publication p) {
        ArrayList <Commentaire> l4 = new ArrayList<>();
        try {
            String aff = "SELECT * FROM Commentaire where id_pub= "+p.getId();
            PreparedStatement st4 = cnx.prepareStatement(aff);
            ResultSet rs1 = st4.executeQuery();
            while (rs1.next()) {
                l4.add(new Commentaire(rs1.getInt("id_com"),rs1.getInt("id_user"),rs1.getString("username"), rs1.getInt("id_pub"),rs1.getInt("nb_reaction"),rs1.getString("suj_com"), rs1.getTimestamp("date_com"))); }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return l4;
    }
    
    
    
    
@Override
    public void delete(Commentaire p) {
        try {
            String supp = "DELETE FROM Commentaire WHERE id_com = ?";
            PreparedStatement pst = cnx.prepareStatement(supp);
            pst.setInt(1, p.getId_com());
            pst.executeUpdate();
            System.out.println("Commentaire supprimé");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

   @Override
   /**********************  feha mochkla   *********************/
   public void update(Commentaire p) {
        try {
            String mod = "UPDATE Commentaire SET suj_com=? WHERE id_com = ?";
            PreparedStatement st3 = cnx.prepareStatement(mod);
            st3.setString(1, p.getSuj_com());
            st3.setInt(2, p.getId_com());
            st3.executeUpdate();
            System.out.println("Commentaire modifié");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
    public ArrayList <Commentaire> tri_Date_Desc(){ 
        ArrayList<Commentaire> l5 = new ArrayList<>();
        try {
            String tri = "SELECT * FROM Commentaire order by date_com DESC";
            PreparedStatement st5 = cnx.prepareStatement(tri);
            ResultSet rs2=st5.executeQuery();
            while (rs2.next()) {
                System.out.println("//////////////////////////////////////////////////////");
                System.out.println("Id Commentaire: "+rs2.getInt("id_com"));
                System.out.println("Id User: "+rs2.getInt("id_user"));
                System.out.println("Id Publication: "+rs2.getInt("id_pub"));
                System.out.println("Sujet Commentaire: "+rs2.getString("suj_com"));
                System.out.println("Date: "+rs2.getString("date_com"));
                System.out.println("Nombre de reaction: "+rs2.getInt("nb_reaction"));
                System.out.println("//////////////////////////////////////////////////////");
                System.out.println();
                l5.add(new Commentaire(rs2.getInt("id_com"),rs2.getInt("id_user"), rs2.getString("username"), rs2.getInt("id_pub"),rs2.getInt("nb_reaction"),rs2.getString("suj_com"), rs2.getTimestamp("date_com")));
                
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return l5;
    }


 public void like(Commentaire p){
        try {
         String modreac = "UPDATE Commentaire SET nb_reaction = nb_reaction +1 WHERE id_com = ?";
            PreparedStatement st3 = cnx.prepareStatement(modreac);
            st3.setInt(1, p.getId_com());
            st3.executeUpdate();
            System.out.println("Reaction ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

  public List <Commentaire> afficher() {
        List <Commentaire> l4 = new ArrayList<>();
        try {
            String aff = "SELECT * FROM Commentaire";
            PreparedStatement st4 = cnx.prepareStatement(aff);
            ResultSet rs1 = st4.executeQuery();
            while (rs1.next()) {
                l4.add(new Commentaire(rs1.getInt("id_com"),rs1.getInt("id_user"),rs1.getString("username"), rs1.getInt("id_pub"),rs1.getInt("nb_reaction"),rs1.getString("suj_com"), rs1.getTimestamp("date_com"))); }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return l4;
    }



}
