/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author BouheniMed
 */
    public interface IService<T> {
    
    public void ajouter(T r) throws SQLException;
    public void modifier(T r) throws SQLException;
    public void supprimer(T r) throws SQLException;
    public List<T> recuperer() throws SQLException;
    
    }

