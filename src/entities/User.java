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
public class User {
    private int idUser, number;
    private String nom, prenom, email, password;
    private Role role;
    
    
    public User() {
    }

    public User(int idUser, int number, String nom, String prenom, String email, String password, Role role) {
        this.idUser = idUser;
        this.number = number;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(int number, String nom, String prenom, String email, String password, Role role) {
        this.number = number;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", number=" + number + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password + ", role=" + role + '}';
    }
   
}
