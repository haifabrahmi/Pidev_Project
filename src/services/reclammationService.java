/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.reclammation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author user
 */
public class reclammationService implements InterfaceReclammation{
     Connection cnx;
    
    
   public reclammationService(){
       cnx=MyDB.getInstance().getCnx();       
       
   } 
   
   
   
    @Override
   public void ajouter(reclammation r){
           try{
               //vérifier que la description contient au moins 20 caracteres
               if(r.getDescription().length()<20){
                   System.out.println("La description doit contenir au moins 20 caracteres");
                   return;
               }
               
               
      String req = "INSERT INTO reclammation(nom_voyageur, description, id_usr) VALUES (?, ?, ?)";
      PreparedStatement ps = cnx.prepareStatement(req);
      ps.setString(1, r.getNom_voyageur());

      ps.setString(2, r.getDescription());
//               System.out.println(r.getUser().getId_usr());
    //  ps.setInt(3, r.getUser().getId_usr());

   }catch (SQLException ex){
            System.out.println(ex.getMessage());
}
     } 
     @Override
    public void modifier(reclammation r){
       try{
            String req="UPDATE reclammation SET nom_voyageur = ?,description = ? where id_rec =?";
        PreparedStatement ps=cnx.prepareStatement(req);
        ps.setString(1,r.getNom_voyageur());
        ps.setString(2,r.getDescription());
        //ps.setString(3, r.getDate_depot());
        ps.setInt(3, r.getId_rec());
        ps.executeUpdate();
       }catch(SQLException ex){
           System.out.println();
    }
    } 
    @Override
         public void delete(int id){
       try{
            String req="DELETE FROM reclammation where id_rec =?";
        PreparedStatement ps=cnx.prepareStatement(req);
        ps.setInt(1,id);
       
        ps.executeUpdate();
       }catch(SQLException ex){
           System.out.println();
    }
       
       

       
      
   }

    @Override
    public List<reclammation> afficher() {
        List<reclammation> reclamations = new ArrayList<>();
    try {
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM reclammation");
        while (rs.next()) {
            reclammation rec = new reclammation();
            rec.setDescription(rs.getString("description"));
            rec.setNom_voyageur(rs.getString("nom_voyageur"));
            rec.setId_rec(rs.getInt("id_rec"));
            rec.setDate_depot(rs.getDate("date_depot"));
            reclamations.add(rec);
        }
    } catch (SQLException ex) {
        System.out.println(ex);
    }
    return reclamations;
}
}
