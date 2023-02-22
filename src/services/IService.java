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
 * @author haifa
 */

    public interface IService <bus>  {
    public void ajouter(bus b) throws SQLException;
    public void modifier(bus b) throws SQLException;
    public void supprimer(bus b) throws SQLException;
    public List<bus> recuperer(bus b) throws SQLException;
}
    

