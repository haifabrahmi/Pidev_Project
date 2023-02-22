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
import utils.MyDB;


/**
 *
 * @author Skander
 */
public class Test {
    

    public static void main(String[] args) {
       
        try {
        User u = new User( 3333, "safa","racheh","safa@esprit.tn","kkk",Role.voyageur);
        User u1=new User( 1,  33333, "sab", "zek", "s", "aaa", Role.admin) ;
        UserServices us = new UserServices();
        AvisServices as = new AvisServices();
       // Avis a = new Avis(16,"mazlla jaw","heey",1 );
        Avis a1 = new Avis(3, 12,"nchallah takhteff","sabrine",1);

       as.delete(3);
        //as.modifier(a1);
        //as.ajouter(a);
        System.out.println(as.recuperer(a1));
        
        
        //--------------
       //us.ajouter(u);
       us.modifier(u1);
       //us.delete(13);
       System.out.println(us.recuperer(u));
       }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       /*   try {
            User u = new User( 54009665, "brahgfdgfsmi","haifa","haifa.brahmi@esprit.tn","ccc",Role.voyageur);
            User u1 = new User( 54009665, "brayhfhezhmi","nour","haifa.brahmi@esprit.tn","ccc",Role.voyageur);
            User u2=new User( 1,  55555555, "sab", "zek", "s", "aaa", Role.admin) ;
            // public User(int idUser, int number, String nom, String prenom, String email, String password, Role role)
            //public User(int number, String nom, String prenom, String email, String password, Role role)
            UserServices us = new UserServices();
            //us.ajouter(u);
         //  us.supprimer(u);
           //  System.out.println(us.recuperer(u));
           // us.ajouter(u);
            us.modifier(u2);
            System.out.println(us.recuperer(u));
          } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
        
    }
    
}

