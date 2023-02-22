/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entites.Comment;
import entites.Content;
import entites.Poste;
import entites.Utilisateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author 21651
 */
public class CommentServices implements IServices<Comment> {

    Connection cnx;

    public CommentServices() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Comment t) {
        try {
            String sql = "INSERT INTO `comment`( `user_id`, `content_comment`, `date_comment`, `id_p`,`descriptioncomment`) VALUES (" + "'" + t.getUser_id().getId() + "','" + t.getContent_comment() + "','" + t.getDate_comment() + "','" + t.getId_p().getId_post() + "','" + t.getDescriptioncomment() + "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Comment t) {
        try {
            String sql = "UPDATE `comment` SET `user_id`='" + t.getUser_id().getId() + "',`content_comment`='" + t.getContent_comment() + "',`date_comment`='" + t.getDate_comment() + "',`id_p`='" + t.getId_p().getId_post() +"',`descriptioncomment`='"+t.getDescriptioncomment()+ "' WHERE id_comment = " + t.getId_comment() + "";
            Statement statement = cnx.createStatement();
            statement.executeUpdate(sql);
            System.out.println("modifier");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean supprimer(Comment t) {
        try {
            String sql = "DELETE FROM `comment` WHERE id_comment = " + t.getId_comment() + "";
            Statement statement = cnx.createStatement();
            statement.executeUpdate(sql);
            System.out.println("supprimer");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    
    public List<Comment> listerC(Poste p) {
        List<Comment> comments = new ArrayList<>();

        try {
            String sql = "SELECT comment.id_comment,comment.date_comment,comment.content_comment,comment.descriptioncomment,poste.id_post,poste.nb_likes,user.id_usr,user.nom "
                    + "FROM comment join poste on comment.id_p=poste.id_post "
                    + "JOIN user on comment.user_id=user.id_usr where id_p ="+p.getId_post()+"";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Comment c = new Comment();
                   c.setId_comment(rs.getInt("id_comment"));
                   c.setDate_comment(rs.getDate("date_comment"));
                String content = rs.getString("content_comment");
                                String des = rs.getString("descriptioncomment");

                Content cc = Content.valueOf(content);
                c.setContent_comment(cc);
                Utilisateur user = new Utilisateur();
                user.setId(rs.getInt("id_usr"));
                user.setNom(rs.getString("nom"));
                     c.setUser_id(user);
                     c.setDescriptioncomment(des);
                c.setId_p(p);
                comments.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return comments;
    }

    @Override
    public List<Comment> lister() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
