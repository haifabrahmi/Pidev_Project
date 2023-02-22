/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuni;

import entites.Comment;
import entites.Content;
import entites.Poste;
import entites.Utilisateur;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import services.CommentServices;
import services.PostServices;

/**
 *
 * @author 21651
 */
public class Tuni {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Utilisateur user = new Utilisateur(1, "baha","admin");
        PostServices ps = new PostServices();
        LocalDate currentDate = LocalDate.now();
        java.sql.Date d = java.sql.Date.valueOf(currentDate);

        Poste p = new Poste(7, 200, 2000, Content.text, d, "aaaaa", user, (byte) 0);


        //Poste p = new Poste(7,200, 2000, Content.text, formattedDate,"aaaaa", user,(byte)0);
     //   ps.ajouter(p);
     //  ps.modifier(p);
     //  ps.supprimer(p);
       // System.out.println(ps.lister());
        CommentServices cs= new CommentServices();
      //  Comment c =new Comment(Content.image, formattedDate, user, p);
     //  cs.ajouter(c);
       //cs.modifier(c);
     //  cs.supprimer(c);
       System.out.println(cs.listerC(p));
    }
    
}
