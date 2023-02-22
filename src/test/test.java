/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entites.bus;
import entites.maintenance;
import entites.user;
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
            
            user u = new user (1,"hayfa","brahmi",54524600,"haifa.brahmi@gmail.com");
           // user u2 = new user (2,"hayfa","brahmi",54524600,"haifa.brahmi@gmail.com"); pour tester la clé etranger
           bus b = new bus(d3, d3, "oooo", 4, 7, u);
          //bus b5 =new bus(21, "ooooo", 7, 12, d3, d3, u);
           //bus b2 = new bus(d3, d2, "bus", 6, 9);
            ///bus b1 = new bus(6,"mercedes", 9, 9, d,d2);
            
            busService bs = new busService();
             maintenanceService ms = new maintenanceService();
            bs.ajouter(b);
            //bs.ajouter(b2);
            //bs.modifier(b5);
           // bs.supprimer(b5);
            System.out.println(bs.recuperer(b));
          // maintenance m = new maintenance(d3, "vvv", b1);
            // maintenance m3 = new maintenance(4, d3, "description", b1);
            //maintenance m1 = new maintenance(d1, "en route", b2);
              //maintenance m2 = new maintenance(3, d3, "des", b1);
            
          // ms.modifier(m2);
            //ms.ajouter(m);
           //ms.ajouter(m1);
         // ms.supprimer(m3);
          // System.out.println(ms.recuperer(m));
        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
        }
    }
}
        




