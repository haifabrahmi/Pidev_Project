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

//      Station s11 = new Station(785, "hhhhhhh", "jjjjjj", "eeee", Date.valueOf("2017-08-09"), "yyyy", "ooooo");
//     Station s2 = new Station(666, "llllll", "mmmmmmmmm", "eeee", Date.valueOf("2017-08-09"), "yyyy", "ooooo");
//     Service st = new Service();
//      st.ajouter(s11);
//       st.ajouter(s2);       st.supprimer(10);
//       Station s3 = new Station(10, "HAIFA", "maman", "ena", Date.valueOf("2017-08-09"), "yyyy", "ooooo");
//        st.modifier(s3);
//       Station s4 = new Station(56, "oumaima", "benhamouda", "hahahahah", Date.valueOf("2017-08-09"), "yyyy", "ooooo");
//       Station s5 = new Station(5886, "ahlem", "boshra", "ameni", Date.valueOf("2017-08-09"), "yyyy", "ooooo");
//       System.out.println(st.getAll());
       
       Station s6 = new Station( "Gare du Nord","10 Rue de Dunkerque", "Ligne 2",  Date.valueOf("2010-08-10"), "Escaliers","comment trial");
    if (s6.isValid()) {
        System.out.println("Les valeurs saisies sont valides.");
    } else {
        System.out.println("Les valeurs saisies sont invalides.");
    }
        
        
//        
//       Circuit c1 = new Circuit(23,"hrhrhr",2,13,Date.valueOf("2015-05-02"),"mm");
//        Circuit c7=new Circuit("hayfa", 8, 7, Date.valueOf("2015-05-02"), "mmmm");
//       Circuit c2 = new Circuit(3,"hrhhhduhsrhr",2,13,Date.valueOf("2015-05-02"),"mnm");
//     
//        ServiceCircuit sc = new ServiceCircuit();
//       sc.ajouter(c1);
//        sc.ajouter(c2);
//      sc.ajouter(c7);
//     
//      sc.supprimer(10);
//        Circuit c3 = new Circuit(10,"pppppppppp",5,10,Date.valueOf("2001-07-12"),"nawara");
//      sc.modifier(c3);
//     Circuit c4 = new Circuit (30,"sabrine",6,11,Date.valueOf("2020-11-29"),"sabrinoush");
//       Circuit c5 = new Circuit (20,"haifa",8,12,Date.valueOf("2022-11-19"),"haifouf");
//     System.out.println(sc.getAll());
//     Service s = new Service();
//List <Station> e1=s.getAll();
//          for (Station s1:e1){
//        System.out.println("name :"+s1.getNom_s());
//        System.out.println("description : "+s1.getLigne_s());
//        System.out.println("Adresse : "+s1.getAdresse_s());
//        System.out.println("Ligne : "+s1.getLigne_s());
//        System.out.println("horaire : "+s1.getHoraire_s());
//        System.out.println("equipement : "+s1.getHoraire_s());
//       System.out.println("Commentaire: "+s1.getCommentaire_s());
//        System.out.println("nom circuit"+s1.getCircuit().getNom_c());
//        System.out.println();
//  }        
//  
//        
   }

}
