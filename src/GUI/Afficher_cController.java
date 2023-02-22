/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Comment;
import entites.Content;
import entites.Poste;
import entites.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.CommentServices;
import services.PostServices;

/**
 * FXML Controller class
 *
 * @author 21651
 */
public class Afficher_cController implements Initializable {

    public Poste poste;

    CommentServices cs = new CommentServices();
    ObservableList<Comment> ListComment = FXCollections.observableArrayList();
    @FXML
    private TableView<Comment> tvC;
    @FXML
    private TableColumn<Comment, Utilisateur> userC;
    @FXML
    private TableColumn<Comment, Date> dateC;
    @FXML
    private TableColumn<Comment, String> descriptionC;
   
    @FXML
    private TableColumn<Comment, Button> deleteC;
    @FXML
    private TableColumn<Comment, Button> modifierC;
    @FXML
    private Button retourP;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 

        /*Poste poste = (Poste) ((Node) label).getScene().getUserData();
        System.out.println(poste);*/
       Utilisateur user = new Utilisateur(1, "baha", "admin");
        LocalDate currentDate = LocalDate.now();
        Date d = Date.valueOf(currentDate);

        Poste p = new Poste(7, 200, 2000, Content.text, d, "aaaaa", user, (byte) 0);
        this.setPoste(p);
    }

    public void setPoste(Poste p) {
        List list = cs.listerC(p);
        ListComment.addAll(list);
        dateC.setCellValueFactory(new PropertyValueFactory<>("date_comment"));
        userC.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        /*     user.setCellValueFactory(cellData -> {
                          Utilisateur u = cellData.getValue().getUser();
            return new SimpleStringProperty(u.getNom());
        });*/

        descriptionC.setCellValueFactory(new PropertyValueFactory<>("descriptioncomment"));

        tvC.setItems(ListComment);
      
        this.delete();
        this.modifier();
    }

    private void delete() {
 deleteC.setCellFactory((param) -> {
            return new TableCell() {
                @Override
                protected void updateItem(Object item, boolean empty) {
                    setGraphic(null);
                    if (!empty) {
                        Button b = new Button("Delete");
                        b.setOnAction((event) -> {

                            if (cs.supprimer(tvC.getItems().get(getIndex()))) {
                                tvC.getItems().remove(getIndex());
                                tvC.refresh();
                            }

                        });
                        setGraphic(b);

                    }
                }
            };

        });    }

    private void modifier() {
 modifierC.setCellFactory((param) -> {
            return new TableCell() {
                protected void updateItem(Object item, boolean empty) {
                    setGraphic(null);
                    if (!empty) {
                        Button b = new Button("modifier");
                        b.setOnAction((event) -> {
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("modifier_c.fxml"));
                                Parent root = loader.load();
                                GUI.Modifier_cController modifiier = loader.getController();
                                Comment c = tvC.getItems().get(getIndex());

                                modifiier.setComment(c);
                                Scene scene = b.getScene();
                                scene.setRoot(root);
                            } catch (IOException ex) {
                                Logger.getLogger(Afficher_cController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        });
                        setGraphic(b);

                    }
                }
            };

        });
    }

    @FXML
    private void retourP(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("afficher_p.fxml"));
            Parent root = loader.load();
          
            Scene scene = retourP.getScene();
            scene.setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(Afficher_pController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
       }


   


