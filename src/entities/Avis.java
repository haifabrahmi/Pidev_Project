/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author user
 */
public class Avis {
    private int idAvis, note, idUser;
    private String commentaire,nomUser;

    public Avis() {
    }

    public Avis(int idAvis, int note, String commentaire, String nomUser,int idUser) {
        this.idAvis = idAvis;
        this.note = note;
        this.commentaire = commentaire;
        this.nomUser = nomUser;
        this.idUser = idUser;
    }

    public Avis(int note, String commentaire, String nomUser, int idUser) {
        this.note = note;
        this.commentaire = commentaire;
        this.nomUser = nomUser;
        this.idUser = idUser;
    }
    
    public int getIdAvis() {
        return idAvis;
    }
    
    public int getIdUser() {
        return idUser;
    }

    public int getNote() {
        return note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    public void setIdAvis(int idAvis) {
        this.idAvis = idAvis;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    @Override
    public String toString() {
        return "Avis{" + "idAvis=" + idAvis + ", note=" + note + ", commentaire=" + commentaire + ", nomUser=" + nomUser + ", idUser=" + idUser + '}';
    }

    

    
    
}
