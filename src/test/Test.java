/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Avis;
import entities.Role;
import entities.User;
import java.sql.SQLException;
import services.AvisServices;
import services.UserServices;


/**
 *
 * @author Skander
 */
public class Test {
    
    
    public static void main(String[] args) {
       
   
        try {
        User u = new User( "mmmmmmmmmm","a",555, "a@esprit.tn","aaa",Role.admin);
        User u1=new User( 103,   "mmmmmm", "cc", 25825822, "ccc@esprit.tn", "cccc", Role.chauffeur) ;
        UserServices us = new UserServices() {};
        
       //******************************************************************
       AvisServices as = new AvisServices() {
            
           
        };
       Avis a = new Avis( "sabrine",16,"wwwwww",1);
        Avis a1 = new Avis(11,"sabrine", 12,"bbbbbbbbbbbbb ",1);
        //******************************************************************

       //us.ajouter(u);
       //us.modifier(u1);
       //us.delete(102);
       System.out.println(us.recuperer(u));
        
       //--------------------------------------------
       
        //as.ajouter(a);    
        //as.modifier(a1);
        //as.delete(9);
        System.out.println(as.recuperer(a));
        
       //--------------------------------------------
       
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        
    }
    }
    
