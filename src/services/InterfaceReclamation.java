/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reclamation;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface InterfaceReclamation {
   public void ajouterReclamation(Reclamation R);
    public void modifierReclamation(Reclamation R);
    public void supprimerReclamation(Reclamation R);
    public List<Reclamation> afficherReclamations();  

}
