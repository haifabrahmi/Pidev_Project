
package test;


import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Skander
 */
public class Fxmain extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/Gestionbus.fxml"));
            Parent root = loader.load();
            Scene sc = new Scene(root);
            primaryStage.setTitle("Reservation");
            primaryStage.setScene(sc);
            primaryStage.show();
        } catch (IOException s) {
            System.out.println(s.getMessage());
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args)  ;
    }

}
