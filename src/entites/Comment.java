/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Date;

/**
 *
 * @author 21651
 */
public class Comment {
     private int id_comment;
    private Content content_comment;
    private Date date_comment;
    private Utilisateur user_id;
    private Poste id_p;
    private String descriptioncomment;

    public Comment() {
    }

    public Comment(Content content_comment, Date date_comment, Utilisateur user_id, Poste id_p,String descriptioncomment) {
        this.content_comment = content_comment;
        this.date_comment = date_comment;
        this.user_id = user_id;
        this.id_p = id_p;
        this.descriptioncomment=descriptioncomment;
    }

    public Comment(int id_comment, Content content_comment, Date date_comment, Utilisateur user_id, Poste id_p,String descriptioncomment) {
        this.id_comment = id_comment;
        this.content_comment = content_comment;
        this.date_comment = date_comment;
        this.user_id = user_id;
        this.id_p = id_p;
        this.descriptioncomment=descriptioncomment;
    }

   

    public int getId_comment() {
        return id_comment;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }

    public Content getContent_comment() {
        return content_comment;
    }

    public void setContent_comment(Content content_comment) {
        this.content_comment = content_comment;
    }

    public Date getDate_comment() {
        return date_comment;
    }

    public void setDate_comment(Date date_comment) {
        this.date_comment = date_comment;
    }

    public Utilisateur getUser_id() {
        return user_id;
    }

    public void setUser_id(Utilisateur user_id) {
        this.user_id = user_id;
    }

    public Poste getId_p() {
        return id_p;
    }
public void setId_p(Poste id_p) {
        this.id_p = id_p;
    }
    public String getDescriptioncomment() {
        return descriptioncomment;
    }

    public void setDescriptioncomment(String descriptioncomment) {
        this.descriptioncomment = descriptioncomment;
    }

    

    @Override
    public String toString() {
        return "Comment{" + "id_comment=" + id_comment + ", content_comment=" + content_comment + ", date_comment=" + date_comment + ", user_id=" + user_id + ", id_p=" + id_p + ", descriptioncomment=" + descriptioncomment+ '}';
    }
}
