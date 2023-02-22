/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Circuit;

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
public class ServiceCircuit implements IService<Circuit> {

    Connection cnx = DataSource.getInstance().getCnx();

    {
    }

    @Override
    public void ajouter(Circuit t) {
        try {
            String req = "INSERT INTO circuit(id_c ,nom_c  , liste_c , nbrbus_c , horaire_c , distance_c) VALUES ('" + t.getId_c() + "','" + t.getNom_c() + "','" + t.getListe_c() + "','" + t.getNbrbus_c() + "','" + t.getHoraire_c() + "','" + t.getDistance_c() + "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM circuit WHERE id_c = ? ";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("circuit deleted");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

  

           

      @Override
    public void modifier(Circuit t) {
        try{

           String req = "UPDATE circuit SET id_c = '" + t.getId_c() + "', nom_c = '" + t.getNom_c() + "', liste_c = '" + t.getListe_c() + "', nbrbus_c = '" + t.getNbrbus_c() + "',horaire_c  = '" + t.getHoraire_c() + "',distance_c   = '" + t.getDistance_c() + "' WHERE circuit.`id_c` = " + t.getId_c();

            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("circuit updated ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public List<Circuit> getAll() {
        List<Circuit> list = new ArrayList<>();
        try {
            String req = "SELECT *  FROM Station s JOIN Circuit ON s.id_c = Circuit.id_c";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Circuit t = new Circuit(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getString(6));
                list.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

}
