/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.reclammation;
import entities.reponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import utils.MyDB;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class reponseService implements InterfaceReponse {
    
     Connection cnx ;
    
    public reponseService(){
    cnx=MyDB.getInstance().getCnx();
    }
    
    Statement ste;
        

    @Override
    public void ajouter(reponse rep) {
     try {
        String req = "INSERT INTO reponse(resolution_reclam,date_reponse,nom_voyageur) VALUES (?,?,?)";
        PreparedStatement ps = cnx.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, rep.getResolution_reclam());
        ps.setDate(2, new Date(rep.getDate_reponse().getTime()));
        ps.setString(3, rep.getReclammation().getNom_voyageur());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            rep.setId_rep(id);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }

        
    }

    @Override
    public void modifier(reponse rep) {
  try {
        String req = "UPDATE reponse SET resolution_reclam = ?, nom_voyageur = ? WHERE id_rep = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, rep.getResolution_reclam());
        ps.setString(2, rep.getReclammation().getNom_voyageur());
        ps.setInt(3, rep.getId_rep());
        ps.executeUpdate();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    }

    @Override
    public void delete(int id) {
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
            rep.setDate_reponse(rs.getDate("date_reponse"));
//            rep.getReclammation().setNom_voyageur(rs.getString("nom_voyageur"));
            reponses.add(rep);
        }
    } catch (SQLException ex) {
        System.out.println("Erreur lors de l'affichage des réponses: " + ex.getMessage());
    }
    return reponses;

    }
    }
  

