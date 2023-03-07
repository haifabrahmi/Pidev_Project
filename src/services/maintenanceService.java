/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.bus;
import entities.maintenance;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author haifa
 */
public class maintenanceService implements IService<maintenance> {
    Connection cnx;

    public maintenanceService() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(maintenance b) throws SQLException {
  try {
          String req = "INSERT INTO `maintenance`( `date_entretien`, `description`,`numero_de_plaque`) VALUES (?,?,?)";
        PreparedStatement bs = cnx.prepareStatement(req);
        bs.setDate(1,  b.getDate_entretien() );
        bs.setString(2, b.getDescription());
        bs.setInt(3, b.getbus().getNumeroPlaque());
                  bs.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    } 

    @Override
     public void modifier(maintenance b) throws SQLException {
         
        String req = "UPDATE Maintenance SET date_entretien = ?,description = ?,numero_de_plaque=? where id_m = ?";
        PreparedStatement bs = cnx.prepareStatement(req);
        bs.setDate(1, b.getDate_entretien());
        bs.setString(2, b.getDescription()); 
        bs.setInt(3, b.getbus().getNumeroPlaque());
        bs.setInt(4, b.getId_m());
        bs.executeUpdate();
        System.out.println("bus Updated");
        
    }

    @Override
    public void supprimer(maintenance b) throws SQLException {
        try {
            String req = "DELETE FROM maintenance WHERE id_m= ? ";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, b.getId_m());
            st.executeUpdate();
            System.out.println("maintenance deleted");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<maintenance> recuperer(maintenance b) throws SQLException {
        
        List<maintenance> maintenances = new ArrayList<>();
        String s = "select * from maintenance";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            maintenance t = new maintenance();
            t.setDate_entretien(rs.getDate("date_entretien"));
            t.setDescription(rs.getString("description"));
            t.setId_m(rs.getInt("id_m"));
            t.setbus( new bus(rs.getInt("numero_de_plaque")));
        
            
            
            maintenances.add(t);
            
        }
        return maintenances;
    }
 
    
    
            
            

     
     
    }

