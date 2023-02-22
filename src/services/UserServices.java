/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

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
public class UserServices implements IService<User>{
     Connection cnx;
     

    public UserServices( ) {
        this.cnx = MyDB.getInstance().getCnx();
      //  System.out.println("ffff"+cnx);
    }

   
     @Override
    public void ajouter(User t) throws SQLException {
 
         
try{
        String req = "INSERT INTO user(nom,prenom,number,email,password,role) VALUES("
                + "'" + t.getNom() + "','" + t.getPrenom() + "','" + t.getNumber() +"','" + t.getEmail() +"','" + t.getPassword() +"','" + t.getRole() + "')";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);}
catch(Exception e){
            System.out.println("hello"+e);
        }
    }

    @Override
    public void modifier(User t)  {
       /* try{
        String req = "UPDATE user SET nom = ?,prenom = ?,email = ?, number = ?,password = ?,role = ? where idUser = ?";
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
    }*/
       try {
            String sql = "UPDATE `user` SET `idUser`='" + t.getIdUser()+ "',`nom`='" + t.getNom() + "',`prenom`='" + t.getPrenom() + "',`email`='" + t.getEmail() + "',`number`='" 
                    + t.getNumber() + "',`password`='" + t.getPassword() + "',`role`='" + t.getRole() + "' WHERE user.idUser = " + t.getIdUser() ;
            
            Statement statement = cnx.createStatement();
            statement.executeUpdate(sql);
            System.out.println("modifier");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void delete(int id){
       try{
            String req="DELETE FROM user where idUser =?";
        PreparedStatement ps=cnx.prepareStatement(req);
        ps.setInt(1,id);
       
        ps.executeUpdate();
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
        //    u.setRole(rs.getEnum("role"));
            u.setIdUser(rs.getInt("idUser"));
            
            
            user.add(u);
            
        }
        return user;
    }

}
