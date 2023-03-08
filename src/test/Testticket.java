
package test;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import entities.Ticket;
import java.sql.SQLException;
import java.util.List;
import services.TicketService;

/**
 *
 * @author BouheniMed
 */
public class Testticket {
    public static void main(String[] args) {
     try {
           Ticket t;
            TicketService ts = new TicketService();
            
          
                        t = new Ticket (0,0.84f,"3 stations");
                        ts.ajouter(t);

            // Retrieve all tickets
            List<Ticket> tickets = ts.recuperer();
            System.out.println("Liste des tickets");
            for (Ticket ticket : tickets) {
                System.out.println(ticket.toString());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }}


 