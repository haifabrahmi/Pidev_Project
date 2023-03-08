/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.main;

import edu.esprit.entities.Circuit;
import edu.esprit.entities.Station;
import edu.esprit.services.Service;
import edu.esprit.services.ServiceCircuit;

import edu.esprit.utils.DataSource;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author HP
 */
public class main {

    public static void main(String[] args) {

        DataSource.getInstance();
       Circuit c1 = new Circuit(23,"hrhrhr",2,13,Date.valueOf("2015-05-02"),"mm");
      Station s11 = new Station(785, "hhhhhhh", "jjjjjj", "eeee", Date.valueOf("2017-08-09"), "yyyy", "ooooo");
      Station s2 = new Station(666, "llllll", "mmmmmmmmm", "eeee", Date.valueOf("2017-08-09"), "yyyy", "ooooo");
     // Station s1 = new Station( "aziz", "kadeshi", "eeee", Date.valueOf("2017-08-09"), "yy", "ooooo");
      //Station s13 = new Station("aziz", "kadeshi", "eeee", Date.valueOf("2017-08-09"), "yy","ye rabyyyyy", c1);
     
     
      Service st = new Service();
      //st.ajouter(s13); 
//            st.ajouter(s1); 

      //st.supprimer(10);
      st.supprimer(8011);
      //st.supprimer(11);
       
       
//       Station s3 = new Station(10, "HAIFA", "maman", "", Date.valueOf("2017-08-09"), "yyyy", "ooooo");
//        st.modifier(s3);
//       Station s4 = new Station(56, "oumaima", "benhamouda", "hahahahah", Date.valueOf("2017-08-09"), "yyyy", "ooooo");
//       Station s5 = new Station(5886, "ahlem", "boshra", "ameni", Date.valueOf("2017-08-09"), "yyyy", "ooooo");
//       Station s7 = new Station( "Gare du Nord","10 Rue de Dunkerque", "",  Date.valueOf("2010-08-10"), "Escaliers","comment trial");
////        Station s14 = new Station( "Gare du Nord","10 Rue de Dunkerque", "",  Date.valueOf("2010-08-10"), "Escaliers","comment trial");
////        st.ajouter(s14);
////        if (s14.isValid()) {
////        System.out.println("Les valeurs saisies sont valides.");
////    } else
////        {        System.out.println("Les valeurs saisies sont invalides.");
////    }
 // controle de saisie 
          
      System.out.println(st.getAll());
//       
//       Station s6 = new Station( "Gare du Nord","10 Rue de Dunkerque", "",  Date.valueOf("2010-08-10"), "Escaliers","comment trial");
//    if (s6.isValid()) {
//        System.out.println("Les valeurs saisies sont valides.");
//    } else {
//        System.out.println("Les valeurs saisies sont invalides.");
//    }
//    //controle de saisie    
//        
////        
      // Circuit c1 = new Circuit(23,"hrhrhr",2,13,Date.valueOf("2015-05-02"),"mm");
       
       Circuit c2 = new Circuit(3,"hrhhhduhsrhr",2,13,Date.valueOf("2015-05-02"),"mnm");
       
     
        ServiceCircuit sc = new ServiceCircuit();
       //sc.ajouter(c3);
        sc.ajouter(c2);
        sc.supprimer(3);
    
            
                    

//     
//      sc.supprimer(10);
        Circuit c3 = new Circuit(10,"pppppppppp",5,10,Date.valueOf("2001-07-12"),"nawara");
        sc.ajouter(c3);
//        if (c3.isValid()) {
//        System.out.println("Les valeurs saisies sont valides.");
//    } else
//        {        System.out.println("Les valeurs saisies sont invalides.");
//    }
      sc.modifier(c3);
     Circuit c4 = new Circuit (30,"sabrine",6,11,Date.valueOf("2020-11-29"),"sabrinoush");
     Circuit c8 = new Circuit (20,"emna",6,11,Date.valueOf("2020-11-29"),"saboura");
      Circuit c7 = new Circuit (30,"achref",6,11,Date.valueOf("2020-11-29"),"achref");
       Circuit c5 = new Circuit (20,"haifa",8,12,Date.valueOf("2022-11-19"),"haifouf");
       sc.ajouter(c8);
       sc.modifier(c7);
        sc.modifier(c8);
      System.out.println(sc.getAll());
//     Service s = new Service();
//List <Station> e1=s.getAll();
//          for (Station s13:e1){
//        System.out.println("name :"+s13.getNom_s());
//        System.out.println("description : "+s13.getLigne_s());
//        System.out.println("Adresse : "+s13.getAdresse_s());
//        System.out.println("Ligne : "+s13.getLigne_s());
//        System.out.println("horaire : "+s13.getHoraire_s());
//        System.out.println("equipement : "+s13.getHoraire_s());
//       System.out.println("Commentaire: "+s13.getCommentaire_s());
//        //System.out.println("nom circuit"+s8.getCircuit().getNom_c());
//        System.out.println();
//  }        
//  
        
   }

}
