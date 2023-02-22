/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Content;
import entites.Poste;
import entites.Utilisateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author 21651
 */
public class PostServices implements IServices<Poste> {

    Connection cnx;

    public PostServices() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Poste t) {
        try {
            if(t.getContent().equals("image")){
            String sql = "INSERT INTO `poste`( `user_id`, `content`, `date_poste`, `nb_likes`, `nb_views`, `image`) VALUES (" + "'" + t.getUser().getId() + "','" + t.getContent() + "','" + t.getDate_poste() + "','" + t.getNb_likes() + "','" + t.getNb_views() + "','" + t.getImage()+ "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(sql);}
            else{
                 String sql = "INSERT INTO `poste`( `user_id`, `content`, `date_poste`, `nb_likes`, `nb_views`, `description`) VALUES (" + "'" + t.getUser().getId() + "','" + t.getContent() + "','" + t.getDate_poste() + "','" + t.getNb_likes() + "','" + t.getNb_views() + "','" + t.getDescription()+ "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(sql);
            }
            System.out.println("ajouter");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Poste t) {
        try {
            String sql = "UPDATE `poste` SET `user_id`='" + t.getUser().getId() + "',`content`='" + t.getContent() + "',`date_poste`='" + t.getDate_poste() + "',`nb_likes`='" + t.getNb_likes() + "',`nb_views`='" + t.getNb_views() +  "',`description`='" + t.getDescription()+ "',`image`='" + t.getImage()+ "' WHERE id_post = " + t.getId_post() + "";
            Statement statement = cnx.createStatement();
            statement.executeUpdate(sql);
            System.out.println("modifier");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean supprimer(Poste t) {
        try {
            String sql = "DELETE FROM `poste` WHERE id_post = " + t.getId_post() + "";
            Statement statement = cnx.createStatement();
            statement.executeUpdate(sql);
            System.out.println("supprimer");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Poste> lister() {
        List<Poste> postes = new ArrayList<>();

        try {
            String sql = "select * from poste JOIN user on user.id_usr=poste.user_id";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Poste p = new Poste();
                p.setId_post(rs.getInt("id_post"));
                p.setDate_poste(rs.getDate("Date_poste"));
                p.setNb_likes(rs.getInt("nb_likes"));
                p.setNb_views(rs.getInt("nb_views"));
                String content = rs.getString("content");
                Content cp = Content.valueOf(content);
                p.setContent(cp);
                String description;
                
                description = rs.getString("description");
                p.setDescription(description);
                Utilisateur user = new Utilisateur();
                user.setId(rs.getInt("user_id"));
                user.setNom(rs.getString("nom"));
                user.setRole(rs.getString("role"));
                p.setUser(user);
                postes.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return postes;
    }

}
