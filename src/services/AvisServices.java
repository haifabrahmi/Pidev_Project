/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Avis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextField;
import static jdk.nashorn.internal.runtime.Debug.id;
import utils.MyDB;
/**
 *
 * @author user
 */
public abstract class AvisServices implements IService<Avis>{
    Connection cnx;
     

    public AvisServices( ) {
        this.cnx = MyDB.getInstance().getCnx();
      //  System.out.println("ffff"+cnx);
    }
    
    
    @Override
    public void ajouter(Avis t) throws SQLException {
    try{
        String req = "INSERT INTO avis(nomUser,note,Commentaire,idUser) VALUES("
                + "'" + t.getNomUser() + "','" + t.getNote() + "','" + t.getCommentaire() +"','" + t.getIdUser() + "')";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);}
    catch(SQLException e){
            System.out.println("ajout avis"+e);
        }    }

    @Override
    public void modifier(Avis t) throws SQLException {
try {
            String sql = "UPDATE `avis` SET `idAvis`='" + t.getIdAvis()+ "',`nomUser`='" + t.getNomUser() + "',`note`='" + t.getNote() + "',`commentaire`='" + t.getCommentaire() +  "',`idUser`='" + t.getIdUser() +"' WHERE avis.idAvis = " + t.getIdAvis() ;
            Statement statement = cnx.createStatement();
            statement.executeUpdate(sql);
            System.out.println("modifier avis");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }

    @Override
    public void delete( int id)  {
try{
            String req="DELETE FROM avis where idAvis =?";
        PreparedStatement ps=cnx.prepareStatement(req);
        ps.setInt(1,id);
       
        ps.executeUpdate();
       }catch(SQLException ex){
           System.out.println();
    }    }

    @Override
    public List<Avis> recuperer(Avis t) throws SQLException {
List<Avis> avis;
         avis = new ArrayList<>();
        String s = "select * from avis";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Avis a = new Avis();
            a.setNomUser(rs.getString("nomUser"));
            a.setNote(rs.getInt("note"));
            a.setCommentaire(rs.getString("Commentaire"));
            a.setIdUser(rs.getInt("idUser"));
            a.setIdAvis(rs.getInt("idAvis"));
            
            avis.add(a);
            
        }
        return avis;    }

    
    
}
