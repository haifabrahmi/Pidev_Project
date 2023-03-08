/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reponse;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface InterfaceReponse {
    public void ajouterReponse(Reponse Rp);
    public void modifierReponse(Reponse Rp);
    public void supprimerReponse(Reponse Rp);
    public List<Reponse> afficherReponses();
}
