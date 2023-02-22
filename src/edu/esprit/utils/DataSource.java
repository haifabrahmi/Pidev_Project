/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.utils;

/**
 *
 * @author HP
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    
    
    private static DataSource instance;
    private Connection cnx;
    private final String USER = "root";
    private final String PWD = "";
    private final String URL = "jdbc:mysql://localhost:3306/pidev";
 

    private DataSource() {
        try {
            cnx = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("Connected !");
           /* // préparation de la requête SQL
            String sql = "SELECT *  FROM Station s JOIN Circuit ON s.id_c = Circuit.id_c";
            Preparedstatement stmt = cnx.prepareStatement(sql);
            
            // exécution de la requête
            ResultSet rs = stmt.executeQuery();
            
            // traitement des résultats
            while (rs.next()) {
                String nomStation = rs.getString("nom_station");
                String nomCircuit = rs.getString("nom_circuit");
                System.out.println(nomStation + " - " + nomCircuit);
            }
            
            // fermeture des ressources
            rs.close();
            stmt.close();
            cnx.close();/*/
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
public Connection getCnx() {
        return cnx;
    }
   
    public static DataSource getInstance() {
        if(instance == null)
            instance = new DataSource();
         
        return instance;
    }

   
}
