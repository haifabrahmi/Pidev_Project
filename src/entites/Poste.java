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
public class Poste {
    private int id_post, nb_likes, nb_views;
    private Content content;
    private String description;
      private Date date_poste;
    private Utilisateur user;
    private byte[] image;
    

    public Poste() {
    }

    public Poste(int nb_likes, int nb_views, Content content, Date date_poste,String description, Utilisateur user,byte image) {
        this.nb_likes = nb_likes;
        this.nb_views = nb_views;
        this.content = content;
        this.date_poste = date_poste;
                this.description=description;

        this.user = user;
    }

    public Poste(int id_post, int nb_likes, int nb_views, Content content, Date date_poste,String description, Utilisateur user,byte image) {
        this.id_post = id_post;
        this.nb_likes = nb_likes;
        this.nb_views = nb_views;
        this.content = content;
        this.description=description;
        this.date_poste = date_poste;
        this.user = user;
    }

  
    

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public int getNb_likes() {
        return nb_likes;
    }

    public void setNb_likes(int nb_likes) {
        this.nb_likes = nb_likes;
    }

    public int getNb_views() {
        return nb_views;
    }

    public void setNb_views(int nb_views) {
        this.nb_views = nb_views;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Date getDate_poste() {
        return date_poste;
    }

    public void setDate_poste(Date date_poste) {
        this.date_poste = date_poste;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Poste{" + "id_post=" + id_post + ", nb_likes=" + nb_likes + ", nb_views=" + nb_views + ", content=" + content + ", date_poste=" + date_poste + ", description=" + description + ", user=" + user + ", image=" + image + '}';
    }
    
    

    

}
