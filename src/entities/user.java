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
public class user {
    private int id_usr;
    private String nom;
    private String prenom;
    private int age;

    public int getId_usr() {
        return id_usr;
    }

    public void setId_usr(int id_usr) {
        this.id_usr = id_usr;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public user(int id_usr, String nom, String prenom, int age) {
        this.id_usr = id_usr;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    @Override
    public String toString() {
        return "user{" + "id_usr=" + id_usr + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + '}';
    }

    public user(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

   

   

    public user() {
    }

    
}
