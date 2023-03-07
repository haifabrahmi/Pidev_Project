/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.reclammation;
import entities.reponse;
import entities.user;
import java.sql.Date;
import java.util.List;
import services.reclammationService;
import services.reponseService;

/**
 *
 * @author user
 */
public class test {
    public static void main(String[] args){
        String str="2019-08-09";
          Date date;//converting string into sql date  
        date = Date.valueOf(str);
        
      reclammation r = new reclammation(1,"mmm","nour",date);
      reclammationService rs= new reclammationService();
      //rs.ajouter(r);
     //rs.modifier(r);
      //rs.delete(1);
      System.out.println(rs.afficher());
      
      
      reponse r1 = new reponse(17,"letoiledawlaaaa1925",date,r);
      reponseService rps = new reponseService();
     //rps.ajouter(r1);
      rps.modifier(r1);
      //rps.delete(1);
      System.out.println(rps.afficher());
     


      
    
    }

    
}
