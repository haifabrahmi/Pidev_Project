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
import services.reclammationService;
import services.reponseService;

/**
 *
 * @author user
 */
public class test {
    public static void main(String[] args)  {
     
                
   String str="2019-08-09"; 
   
   Date date;//converting string into sql date  
        date = Date.valueOf(str);
   // System.out.println(date); 
       //public reclammation(int id_rec, String nom_voyageur, String description, java.util.Date date_depot, user user) {

                        user u= new user(1,"nour","messioui",24);
                        reclammation r = new reclammation(89,"sabrine","messiohikkkkkkkkkkkkkkkkkuhbxkji",date,u);
                        reclammationService rs= new reclammationService();
                        rs.ajouter(r);
                        //rs.modifier(r);
                        rs.delete(89);
                       System.out.println(rs.afficher());
                       
                       reponse rep = new reponse(1,"eqhfidqb",date);
                       reponseService rps= new reponseService();
                       rps.ajouter(rep);
                       //rps.modifier(rep);
                       //rps.delete(1);
                       System.out.println(rps.afficher());
                    
                    
                        
                        
                        
                    }
    }


