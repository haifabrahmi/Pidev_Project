/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.reclammation;
import java.util.List;

/**
 *
 * @author user
 */
public interface InterfaceReclammation {
    public void ajouter(reclammation r);
    public void modifier(reclammation r);
    public void delete(int id);
    public List <reclammation> afficher();
}
