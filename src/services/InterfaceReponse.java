/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.reponse;
import java.util.List;

/**
 *
 * @author user
 */
public interface InterfaceReponse {
    public void ajouter(reponse rep);
    public void modifier(reponse rep);
    public void delete(int id);
    public List <reponse> afficher();
}
