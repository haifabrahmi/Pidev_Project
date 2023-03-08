package gui;

import entities.Ticket;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import services.TicketService;

import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

public class Modifier_TicketController implements Initializable {

    @FXML
    private TextField prix;
    private Ticket ticket;


    public interface PopupListener {
        void onInfoSent(Boolean value);
    }

    private PopupListener Listener;

    TicketService ts = new TicketService();
    Ticket t = new Ticket();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

  public void setAtrtribute(Ticket c) throws ParseException {
    this.ticket = c;
    // Remplir les champs de texte avec les données de la station
    // type_ticket.setText(c.getType_ticket());
    prix.setText(Float.toString(ticket.getPrix()));   
}


    public void setListener(Modifier_TicketController.PopupListener listener) {
        this.Listener = listener;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
        // Populate the fields with the current ticket data
        prix.setText(Float.toString(ticket.getPrix()));
        //type_ticket.setText(ticket.getType_ticket());
    }

    @FXML
    private void modifier(ActionEvent event) throws SQLException {
        t.setPrix(Float.parseFloat(prix.getText()));
        ts.modifier(t);
        if (Listener != null) {
            Listener.onInfoSent(true);
        }
    }
}
