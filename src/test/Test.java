
package test;

import entities.Reservation;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ReservationService;

/**
 *
 * @author BouheniMed
 */
public class Test {
    public static void main(String[] args) {
        try {
            Reservation r;
           //Reservation u;
            //Reservation s;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = new Date(format.parse("2023-03-01").getTime());
        } catch (ParseException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
            r = new Reservation(0,date,"rrrr","2 stations",1.0f,3,3.2f,34,222);
            //u = new Reservation(318,date,"14:40","",2,3.2f,34,22,222);
           //s = new Reservation(33,date,"qsdqsdqsd",666,34,22,222);
            ReservationService rs = new ReservationService();
          rs.ajouter(r);
            //rs.modifier(u);
           // rs.supprimer(s);
           List<Reservation> res = rs.recuperer();
            System.out.println("Liste res");
            for ( Reservation ress: res){
            System.out.println(ress.toString());
        }
           // System.out.println(rs.recuperer(r));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

