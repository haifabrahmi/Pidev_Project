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
 * @author Skander
 * @param <T>
 */
public interface IService_2<T> {
    
    public void ajouter(T t) throws SQLException;
    public void modifier(T t) throws SQLException;
    public void delete(int id) throws SQLException;
    public List<T> recuperer(T t) throws SQLException;
}