/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Role;
import entities.User;
import gui.AdminController;
import gui.AvisController;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.event.ActionEvent;

import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import utils.MyDB;

/**
 *
 * @author user
 */
public abstract class UserServices implements IService<User> {
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
        catch(SQLException e){
            System.out.println("ajouter"+e);
        }
    }
    
    @Override
    public void modifier(User t)  {
      
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
            u.setRole(Role.valueOf(rs.getObject("role").toString()));
            u.setIdUser(rs.getInt("idUser"));
            
            
            user.add(u);
            
        }
        return user;
    }
    
    public void login(TextField nomLogin, PasswordField mdpLogin) throws IOException{
        String uname = nomLogin.getText();
        String pass = mdpLogin.getText(); 
        if(uname.isEmpty() || pass.isEmpty()){
        JOptionPane.showMessageDialog(null,"les champs vides");
        }
        else{
       try{
            String req="select * from user where nom=? and password=?";
        PreparedStatement ps=cnx.prepareStatement(req);
        ps.setString(1, uname);
        ps.setString(2, pass);
        ResultSet rs =  ps.executeQuery();
        
       if(rs.next())
            {
                 User user = new User();
                user.setIdUser(rs.getInt("idUser"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setNumber(rs.getInt("number"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(Role.valueOf(rs.getString("role")));

                if (user.getRole() == Role.admin) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Admin.fxml"));
                    Parent root = loader.load();
                    AdminController AdminController = loader.getController();
                    AdminController.setIdUser(user);
                    Stage stage = (Stage) ((Node) nomLogin).getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.setResizable(false);
                    stage.show();
                } else  {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/Avis.fxml"));
                    Parent root = loader.load();
                    AvisController avisController = loader.getController();
                    avisController.setIdUser(user);
                    Stage stage = (Stage) ((Node) nomLogin).getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.setResizable(false);
                    stage.show();
                }
            }
                
                
                
                
                /*
                if (verifLogin(uname,pass)==1) {
                Parent page = FXMLLoader.load(getClass().getResource("Admin.fxml"));
    Scene scene = new Scene(page);
    Stage stage = (Stage) nomLogin.getScene().getWindow().getScene().getRoot().getScene().getWindow();
    stage.setScene(scene);
    stage.setResizable(false);
    stage.show();
                }else if(verifLogin(uname,pass)==2) 
                {
                   Parent page = FXMLLoader.load(getClass().getResource("Avis.fxml"));
    Scene scene = new Scene(page);
    Stage stage = (Stage) nomLogin.getScene().getWindow().getScene().getRoot().getScene().getWindow();
    stage.setScene(scene);
    stage.setResizable(false);
    stage.show(); 
                }
        } */
            else
            {
                JOptionPane.showMessageDialog(null,"login failed");
                nomLogin.setText("");
                mdpLogin.setText("");
                nomLogin.requestFocus();
            }
        
        
       }catch(SQLException ex){
           System.out.println();
    }
    }
        
    }
    
    
    public int verifLogin(String nom,String pass ){
        int v=0;
        try{
            
        String req = "SELECT role FROM user WHERE nom = ? AND password = ?";

PreparedStatement ps=cnx.prepareStatement(req);

        ps.setString(1, nom);
        ps.setString(2, pass);
        
        ResultSet rs =  ps.executeQuery(req);

if (rs.next()) {
    String role = rs.getString("role");
    
    if ("Admin".equals(role)){
    v=1;
    }else{
        v=2;    
}
    return v;
}
        
       }catch(SQLException ex){
           System.out.println();
    }
        return v;
        
    
        
    
    
    }
    

}