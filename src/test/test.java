/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.bus;
import entities.maintenance;

import entities.user;
import java.io.File;
import java.sql.Date;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import services.busService;
import services.maintenanceService;

import utils.MyDB;

/**
 *
 * @author haifa
 */
public class test {
    public static void main(String[] args) {
         try {
             Date
             d=Date.valueOf("2022-06-11");
             Date
              d1=Date.valueOf("2022-04-12");
             Date
             d2=Date.valueOf("2022-04-12");
             Date
             d3=Date.valueOf("2022-05-12");
             //Date date1=new SimpleDateFormat("dd/MM/yyyy").parse((("15-05-2013")));  
            //System.out.println(date1);
           
           // user u2 = new user (2,"hayfa","brahmi",54524600,"haifa.brahmi@gmail.com"); pour tester la clé etranger
           //bus b = new bus(12, d3, d3, "modele", 0, 0, "destination");
           
           //bus b5 = new bus(8, d3, d3, "kkkk", 0, 0, "destination");
          //bus b2 =new bus(11, d3, d3, "update", 0, 0, "destination");
          //bus b = new bus(d3, d3, "mle", 0, 0, "destination");
          bus b = new bus(0, d3, d3, "modele", 0, 0, "destination", "image.jpg");
         
          
          
           
         
            
            busService bs = new busService();
            //System.out.println(bs.recuperer(b5));
             maintenanceService ms = new maintenanceService();
            //bs.ajouter(b5);
            bs.ajouter(b);
            //bs.modifier(b2);
           //bs.supprimer(b2);
            
          //maintenance m = new maintenance
            // maintenance m3 = new maintenance(4, d3, "description", b1);
            maintenance m1 = new maintenance (d3, "description", b);
              maintenance m2 = new maintenance(1, d3, "panne", b);
            
         // ms.modifier(m2);
            //ms.ajouter(m);
          // ms.ajouter(m1);
         // ms.supprimer(m2);
          System.out.println(ms.recuperer(m1));
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
        }
    }
}
   
