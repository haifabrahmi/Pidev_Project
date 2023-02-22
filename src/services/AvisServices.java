/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Avis;
import entities.User;
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
public class AvisServices implements IService<Avis>{
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
catch(Exception e){
            System.out.println("hello"+e);
        }
    }
    @Override
    public void modifier(Avis t)  {
     /*   try{
        String req = "UPDATE avis SET nomUser = ?,note = ?,commentaire = ? where idAvis =?";
        PreparedStatement us = cnx.prepareStatement(req);
        
        us.setString(1, t.getNomUser());
        us.setInt(2, t.getNote());
        us.setString(3, t.getCommentaire());
        us.setInt(4, t.getIdAvis());
        us.executeUpdate();
        }catch(SQLException ex){
           System.out.println();*/
    
        try {
            String sql = "UPDATE `avis` SET `idAvis`='" + t.getIdAvis()+ "',`nomUser`='" + t.getNomUser() + "',`note`='" + t.getNote() + "',`commentaire`='" + t.getCommentaire() +  "',`idUser`='" + t.getIdUser() +"' WHERE avis.idAvis = " + t.getIdAvis() ;
            Statement statement = cnx.createStatement();
            statement.executeUpdate(sql);
            System.out.println("modifier");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void delete(int id){
       try{
            String req="DELETE FROM avis where idAvis =?";
        PreparedStatement ps=cnx.prepareStatement(req);
        ps.setInt(1,id);
       
        ps.executeUpdate();
       }catch(SQLException ex){
           System.out.println();
    }
    }
    @Override
    public List<Avis> recuperer(Avis t) throws SQLException {
        List<Avis> avis = new ArrayList<>();
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
        return avis;
    }
/*
    @Override
    public void modifier(User t)  {
        try{
        String req = "UPDATE avis SET nom = ?,prenom = ?,email = ?, number = ?,password = ?,role = ? where idUser = ?";
        PreparedStatement us = cnx.prepareStatement(req);
        
        us.setString(1, t.getNom());
        us.setString(2, t.getPrenom());
        us.setString(3, t.getEmail());
        us.setString(4, t.getPassword());
        us.setInt(5, t.getNumber());
        us.setObject(6, t.getRole()); //us.setObject(6, t.getRole(), java.sql.Types.OTHER);
        us.setInt(7, t.getIdUser());
        us.executeUpdate();
        }catch(SQLException ex){
           System.out.println();
    }
    }
    
     @Override
    public List<User> recuperer(User t) throws SQLException {
        List<User> user = new ArrayList<>();
        String s = "select * from user";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            User u = new User();
            u.setNumber(rs.getInt("number"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setEmail(rs.getString("email"));
            u.setPassword(rs.getString("password"));
            u.setPrenom(rs.getString("role"));
            u.setIdUser(rs.getInt("idUser"));
            
            
            user.add(u);
            
        }
        return user;
    }

    @Override
    public void modifier(Avis t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Avis> recuperer(Avis t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    
    
   
}
