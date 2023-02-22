/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author haifa
 */
public class user {
    private int id_usr;
    private String nom;
     private String prenom;  
     private int num;
     private String mot_de_passe;

    public user() {
    }

    public user(int id_usr, String nom, String prenom, int num, String mot_de_passe) {
        this.id_usr = id_usr;
        this.nom = nom;
        this.prenom = prenom;
        this.num = num;
        this.mot_de_passe = mot_de_passe;
    }

    public int getId_usr() {
        return id_usr;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNum() {
        return num;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setId_usr(int id_usr) {
        this.id_usr = id_usr;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    @Override
    public String toString() {
        return "user{" + "id_usr=" + id_usr + ", nom=" + nom + ", prenom=" + prenom + ", num=" + num + ", mot_de_passe=" + mot_de_passe + '}';
    }
     

    
}
