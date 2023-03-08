/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.MyDB;

/**
 *
 * @author lenovo
 */
public class CRUDReponse implements InterfaceReponse{

    Connection cnx1;
    public CRUDReponse() {
        cnx1=MyDB.getInstance().getCnx();
    }
    
    @Override
    public void ajouterReponse(Reponse Rp) {
        try {
            
            String requete="INSERT INTO `reponse`(`id_reponse`, `id_reclamation`, `description_reponse`) VALUES (?,?,?)";
            PreparedStatement pst2=cnx1.prepareStatement(requete);
            pst2.setInt(1, Rp.getId_Reponse());
            pst2.setInt(2, Rp.getId_Reclamation());
            pst2.setString(3, Rp.getDescription_Reponse());
            
            pst2.executeUpdate();
            System.out.println("Reponse ajoutée avec succès");//}

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());        }
    }

    @Override
    public void modifierReponse(Reponse Rp) {
        try {
            String requete="UPDATE `reponse` SET `id_reponse`=?,`id_reclamation`=?,`description_reponse`=? WHERE `id_reclamation`=?";
            PreparedStatement pst=cnx1.prepareStatement(requete);
            pst.setInt(1, Rp.getId_Reponse());
            pst.setInt(2, Rp.getId_Reclamation());
            pst.setString(3, Rp.getDescription_Reponse());
            pst.setInt(4, Rp.getId_Reclamation());
   
            
            pst.executeUpdate();
            System.out.println("Reponse modifiée avec succès");
        } 
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerReponse(Reponse Rp) {
        try {
            String requete="DELETE FROM `reponse` WHERE `id_reponse`=?";
            PreparedStatement pst=cnx1.prepareStatement(requete);
            pst.setInt(1, Rp.getId_Reponse());
            pst.executeUpdate();
            System.out.println("Reponse supprimée avec succès");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Reponse> afficherReponses() {
        List<Reponse> ReponseList=new ArrayList<>();
        try {
            String requete="SELECT * FROM reponse";
            Statement st=cnx1.createStatement();
            ResultSet rs=st.executeQuery(requete);
            while(rs.next()){
                Reponse Reponse=new Reponse();
                Reponse.setId_Reponse(rs.getInt(1));
                Reponse.setId_Reclamation(rs.getInt(2));
                Reponse.setDescription_Reponse(rs.getString(3));
              
                
              ReponseList.add(Reponse);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage()); 
        }
        return ReponseList;
    }

    public ObservableList<Reponse> afficherReponsesClient() {
        ObservableList<Reponse> ReclamationList=FXCollections.observableArrayList();
        try {
            String requete="SELECT * FROM reponse where id_reclamation=?";
            Statement st=cnx1.createStatement();
            ResultSet rs=st.executeQuery(requete);
            while(rs.next()){
                Reponse Rp=new Reponse();
                
                
                Rp.setDescription_Reponse(rs.getString(3));
                
                ReclamationList.add(Rp);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage()); 
        }
        return ReclamationList;
    }
    
    public ObservableList<Reponse> afficherReponses2() {
        ObservableList<Reponse> ReponseList=FXCollections.observableArrayList();
        try {
            String requete="SELECT * FROM reponse ";
            Statement st=cnx1.createStatement();
            ResultSet rs=st.executeQuery(requete);
            while(rs.next()){
                Reponse Rp=new Reponse();
                
               Rp.setId_Reponse(rs.getInt(1));
                Rp.setId_Reclamation(rs.getInt(2));
                Rp.setDescription_Reponse(rs.getString(3));
                
                ReponseList.add(Rp);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage()); 
        }
        return ReponseList;
    }

    
    
}
