/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.reponse;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.MyDB;

/**
 *
 * @author user
 */
public class reponseService implements InterfaceReponse {
    Connection cnx ;
    
    public reponseService(){
        cnx=MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(reponse rep) {
         try{
          
             
       String req = "INSERT INTO reponse(resolution_reclam,date_resolution) Values('"+rep.getResolution_reclam()+"','"+rep.getDate_resolution()+"')";
       Statement st = cnx.createStatement();
       st.executeUpdate(req); 
   }catch (SQLException ex){
            System.out.println(ex.getMessage());
}
     } 

    @Override
    public void modifier(reponse rep) {
        try{
        String req="UPDATE reclammation SET resolution_reclam = ?, where id_rec =?";
        PreparedStatement ps=cnx.prepareStatement(req);
        ps.setString(1,rep.getResolution_reclam());
        ps.setInt(2, rep.getId_rep());
        ps.setDate(3, (Date) rep.getDate_resolution());
        ps.executeUpdate();
       }catch(SQLException ex){
           System.out.println();
    }
    }

    @Override
         public void delete(int id){
       try{
            String req="DELETE FROM reponse where id_rep =?";
        PreparedStatement ps=cnx.prepareStatement(req);
        ps.setInt(1,id);
       
        ps.executeUpdate();
       }catch(SQLException ex){
           System.out.println();
    }
       


   
 }

    @Override
    public List<reponse> afficher() {
List<reponse> reponses = new ArrayList<>();
    try {
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM reponse");
        while (rs.next()) {
            reponse rep = new reponse();
            rep.setId_rep(rs.getInt("id_rep"));
            rep.setResolution_reclam(rs.getString("resolution_reclam"));
            rep.setDate_resolution(rs.getDate("date_resolution"));


            reponses.add(rep);
        }
    } catch (SQLException ex) {
        System.out.println(ex);
    }
    return reponses;
}
}
