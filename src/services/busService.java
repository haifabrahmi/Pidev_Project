     /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.bus;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static jdk.nashorn.internal.runtime.Debug.id;
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
    @Override
    public void ajouter(bus b) throws SQLException {
       
       String req = "INSERT INTO `bus`( `modele`, `numero_de_plaque`, `capacite`, `date_depart`, `date_arrive`) VALUES (?,?,?,?,?)";
      PreparedStatement bs = cnx.prepareStatement(req);
        bs.setString(1,  b.getModele() );
        bs.setInt(2, b.getNumeroPlaque());
         bs.setInt(3, b.getCapacite());
          bs.setDate(4, (Date) b.getDepart());
          bs.setDate(5, (Date) b.getArrivee());
//        bs.setInt(6, b.getuser().getId_usr());
           bs.executeUpdate();

       
    

       
    /*   PreparedStatement stmt=cnx.prepareStatement("INSERT INTO bus(modele,numero_de_plaque,capacite,date_depart,date_arrive,id_usr) VALUES (?,?,?,?,?,?)");  
stmt.setString(1,b.getModele());//1 specifies the first parameter in the query  
stmt.setInt(2,b.getNumeroPlaque());  
stmt.setInt(3,b.getCapacite());  
stmt.setDate(4, (Date) b.getDepart());  
stmt.setDate(5, (Date) b.getArrivee()); 
 stmt.setInt(3, b.getuser().getId_usr());
  
int i=stmt.executeUpdate();  */
    }

    @Override
    


   public void modifier(bus b) throws SQLException {
         String req = "UPDATE bus SET modele = ?,numero_de_plaque = ?,capacite = ?,date_depart = ?,date_arrive = ?  where id_bus = ?";
        PreparedStatement bs = cnx.prepareStatement(req);
        bs.setString(1, b.getModele());
        bs.setInt(2, b.getNumeroPlaque());
        bs.setInt(3, b.getCapacite());
        bs.setDate(4, (Date) b.getDepart());
        bs.setDate(5, (Date) b.getArrivee());
        bs.setInt(6, b.getId_bus());
        bs.executeUpdate();
    }

    
  

    @Override
        public List<bus> recuperer(bus b) throws SQLException {
        List<bus> buses = new ArrayList<>();
        String s = "select * from bus";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            bus t = new bus();
            t.setModele(rs.getString("modele"));
            t.setNumeroPlaque(rs.getInt("numero_de_plaque"));
            t.setCapacite(rs.getInt("capacite"));
            t.setDepart(rs.getDate("date_depart"));
            t.setArrivee(rs.getDate("date_arrive"));
            t.setId_bus(rs.getInt("id_bus"));
            
            
            buses.add(t);
            
        }
        return buses;
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
    }

  
    

    

