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
    private int idAvis;
    private String nomUser;
    private int note;
    private String commentaire;
    private int idUser;

    public Avis(int idAvis, String nomUser, int note, String commentaire, int idUser) {
        this.idAvis = idAvis;
        this.nomUser = nomUser;
        this.note = note;
        this.commentaire = commentaire;
        this.idUser = idUser;
    }

    public Avis(String nomUser, int note, String commentaire, int idUser) {
        this.nomUser = nomUser;
        this.note = note;
        this.commentaire = commentaire;
        this.idUser = idUser;
    }

    public Avis() {
    }

    public Avis(String nom, int note, String commentaire) {
    this.nomUser = nomUser;
        this.note = note;
        this.commentaire = commentaire;    }

    public int getIdAvis() {
        return idAvis;
    }

    public void setIdAvis(int idAvis) {
        this.idAvis = idAvis;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Avis{" + "idAvis=" + idAvis + ", nomUser=" + nomUser + ", note=" + note + ", commentaire=" + commentaire + ", idUser=" + idUser + '}';
    }
    
    
}
