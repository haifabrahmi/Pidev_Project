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
public enum Role {
    chauffeur,admin,voyageur;

    public static Role getChauffeur() {
        return chauffeur;
    }

    public static Role getAdmin() {
        return admin;
    }

    public static Role getVoyageur() {
        return voyageur;
    }
}
