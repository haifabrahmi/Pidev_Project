/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.bus;
import entities.maintenance;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.activation.DataSource;
import utils.MyDB;

/**
 *
 * @author haifa
 */
public class busService implements IService<bus> {
    Connection cnx;
  public busService() {
        cnx = MyDB.getInstance().getCnx();
  }
  File imageFile = new File("path/to/image/file");
    @Override
    public void ajouter(bus b) throws SQLException {
        
       
       String req = "INSERT INTO `bus`( `modele`, `numero_de_plaque`, `capacite`, `date_depart`, `date_arrive`, `destination`,`image`) VALUES (?,?,?,?,?,?,?)";
      PreparedStatement bs = cnx.prepareStatement(req);
        bs.setString(1,  b.getModele() );
        ///bs.setString(2,  b.getImage_bus() );
        bs.setInt(2, b.getNumeroPlaque());
         bs.setInt(3, b.getCapacite());
          bs.setDate(4, (Date) b.getDepart());
          bs.setDate(5, (Date) b.getArrivee());
            bs.setString(6,  b.getDestination() );
            bs.setString(7, b.getImage());
           bs.executeUpdate();

    }

    @Override
   public void modifier(bus b) throws SQLException {
        System.out.println("khhhhhhhhh2"+b.getId_bus());
        System.out.println("khhhhhhhhhhhhhhhhhhhh"+b.getModele());
         String req = "UPDATE bus SET modele = ?,numero_de_plaque =?,capacite =?,date_depart =?,date_arrive =?,destination =? where id_bus =?";
        PreparedStatement bs = cnx.prepareStatement(req);
        bs.setString(1, b.getModele());
        bs.setInt(2, b.getNumeroPlaque());
        bs.setInt(3, b.getCapacite());
        bs.setDate(4, (Date) b.getDepart());
        bs.setDate(5, (Date) b.getArrivee());
        bs.setString(6, b.getDestination());
        bs.setInt(7, b.getId_bus());
        
        bs.executeUpdate();
    }


    @Override
    public void supprimer(bus b) throws SQLException {
        try {
            String req = "DELETE FROM bus WHERE id_bus= ? ";
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, b.getId_bus());
            st.executeUpdate();
            System.out.println("bus deleted");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    @Override
      public List<bus> recuperer(bus b)throws SQLException {
                List<bus> buses = new ArrayList<>();
        String s = "select * from bus ";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            bus t = new bus();
            t.setId_bus(rs.getInt("id_bus"));
            t.setModele(rs.getString("modele"));
            t.setNumeroPlaque(rs.getInt("numero_de_plaque"));
            t.setCapacite(rs.getInt("capacite"));
            t.setDepart(rs.getDate("date_depart"));
            t.setArrivee(rs.getDate("date_arrive"));
            t.setDestination(rs.getString("destination"));
            t.setImage(rs.getString("image"));
  
            buses.add(t);
        }
        return buses;

    }
         public List<Integer> getNumeroDePlaquesUnique() throws SQLException {
         
           List<maintenance> maintenances = new ArrayList<>();
        String s = "SELECT DISTINCT numero_de_plaque FROM `bus` ORDER BY `bus`.`numero_de_plaque` ASC;";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        List<Integer> numPlaques = new ArrayList<>();
        while(rs.next()){
            numPlaques.add(rs.getInt("numero_de_plaque"));
            
        }
        
        return numPlaques;
     } 
         
      public List<bus> rechercher(String modele) throws SQLException {
    List<bus> list = new ArrayList<>();
    //Connection cnx = DataSource.getInstance().getConnection();
    String query =  "SELECT * FROM bus WHERE modele LIKE ?";
    if (!modele.isEmpty()) {
        query += "AND modele LIKE '%" + modele + "%' ";
    }
   
    PreparedStatement pst = cnx.prepareStatement(query);
    ResultSet rs = pst.executeQuery();
    while (rs.next()) {
        bus b = new bus();
        b.setId_bus(rs.getInt("id_bus"));
        b.setModele(rs.getString("modele"));
        b.setNumeroPlaque(rs.getInt("numero_de_plaque"));
        b.setCapacite(rs.getInt("capacite"));
        b.setDepart(rs.getDate("date_depart"));
        b.setArrivee(rs.getDate("date_arrive"));
        b.setDestination(rs.getString("destination"));
        list.add(b);
    }
    return list;
}
      
      
          public ObservableList<bus> chercherEvent(String chaine) {
        String sql = "SELECT * FROM bus WHERE (modele LIKE ? or destination LIKE ?  )  ";
        //Connection cnx= Maconnexion.getInstance().getCnx();
        String ch = "%" + chaine + "%";
        ObservableList<bus> myList = FXCollections.observableArrayList();
        try {

            Statement ste = cnx.createStatement();
            // PreparedStatement pst = myCNX.getCnx().prepareStatement(requete6);
            PreparedStatement stee = cnx.prepareStatement(sql);
            stee.setString(1, ch);
            stee.setString(2, ch);

            ResultSet rs = stee.executeQuery();
            while (rs.next()) {
               bus b = new bus();
                b.setId_bus(rs.getInt("id_bus"));
                b.setModele(rs.getString("modele"));
                b.setNumeroPlaque(rs.getInt("numero_de_plaque"));
                b.setCapacite(rs.getInt("capacite"));
                b.setDepart(rs.getDate("date_depart"));
                b.setArrivee(rs.getDate("date_arrive"));
                b.setDestination(rs.getString("destination"));
                b.setImage(rs.getString("image"));

                myList.add(b);
                System.out.println("event trouvé! ");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }

      
      
}
