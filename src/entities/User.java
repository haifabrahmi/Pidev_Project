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
    private int idUser;
    private String nom;
    private String prenom;
    private int number;
    private String email;
    private String password;
    private Role role;

    public User(int idUser, String nom, String prenom, int number, String email, String password, Role role) {
        this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.number = number;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public User(String nom, String prenom, int number, String email, String password, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.number = number;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", nom=" + nom + ", prenom=" + prenom + ", number=" + number + ", email=" + email + ", password=" + password + ", role=" + role + '}';
    }
    
    public String getRoleAsString() {
        return role.toString();
    }
    
    
    
    
}
