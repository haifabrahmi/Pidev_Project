/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import entites.Content;
import entites.Poste;
import entites.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.PostServices;

/**
 * FXML Controller class
 *
 * @author 21651
 */
public class Afficher_pController implements Initializable {

    @FXML
    private TableView<Poste> tv;
    @FXML
    private TableColumn<Poste, Utilisateur> user;
    @FXML
    private TableColumn<Poste, Content> content;
    @FXML
    private TableColumn<Poste, Date> date;
    @FXML
    private TableColumn<Poste, Integer> nblike;
    @FXML
    private TableColumn<Poste, Integer> nbview;
    @FXML
    private TableColumn<Poste, String> description;
    @FXML
    private TableColumn<Poste, Byte> image;

    PostServices ps = new PostServices();
    ObservableList<Poste> ListPoste = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Poste, Button> Delete;
    @FXML
    private TableColumn<Poste, Button> modifier;
    @FXML
    private TableColumn<Poste, Button> afficherComment;
    @FXML
    private TableColumn<Poste, Button> ajouterComment;
    @FXML
    private Button ajouterP;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        List list = ps.lister();
        ListPoste.addAll(list);
        date.setCellValueFactory(new PropertyValueFactory<>("date_poste"));
        content.setCellValueFactory(new PropertyValueFactory<>("content"));
        user.setCellValueFactory(new PropertyValueFactory<>("user"));
        /*     user.setCellValueFactory(cellData -> {
                          Utilisateur u = cellData.getValue().getUser();
            return new SimpleStringProperty(u.getNom());
        });*/
        nblike.setCellValueFactory(new PropertyValueFactory<>("nb_likes"));
        nbview.setCellValueFactory(new PropertyValueFactory<>("nb_views"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        image.setCellValueFactory(new PropertyValueFactory<>("image"));

        tv.setItems(ListPoste);
        this.delete();
        this.modifier();
        this.afficherComment();
        this.ajouterComment();
    }

    private void delete() {

        Delete.setCellFactory((param) -> {
            return new TableCell() {
                @Override
                protected void updateItem(Object item, boolean empty) {
                    setGraphic(null);
                    if (!empty) {
                        Button b = new Button("Delete");
                        b.setOnAction((event) -> {

                            if (ps.supprimer(tv.getItems().get(getIndex()))) {
                                tv.getItems().remove(getIndex());
                                tv.refresh();
                            }

                        });
                        setGraphic(b);

                    }
                }
            };

        });
    }

    private void modifier() {
        modifier.setCellFactory((param) -> {
            return new TableCell() {
                protected void updateItem(Object item, boolean empty) {
                    setGraphic(null);
                    if (!empty) {
                        Button b = new Button("modifier");
                        b.setOnAction((event) -> {
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("modifier_p.fxml"));
                                Parent root = loader.load();
                                GUI.Modifier_pController modifiier = loader.getController();
                                Poste p = tv.getItems().get(getIndex());

                                modifiier.setPoste(p);
                                Scene scene = b.getScene();
                                scene.setRoot(root);
                            } catch (IOException ex) {
                                Logger.getLogger(Afficher_pController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        });
                        setGraphic(b);

                    }
                }
            };

        });
    }

    private void ajouterComment() {
        ajouterComment.setCellFactory((param) -> {
            return new TableCell() {
                protected void updateItem(Object item, boolean empty) {
                    setGraphic(null);
                    if (!empty) {
                        Button b = new Button("AjouterComment");
                        b.setOnAction((event) -> {
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouter_c.fxml"));
                                Parent root = loader.load();
                                GUI.Ajouter_cController ajouterc = loader.getController();
                                Poste p = tv.getItems().get(getIndex());
                                System.out.println(p);
                                ajouterc.setPoste(p);
                                Scene scene = b.getScene();
                                scene.setRoot(root);
                            } catch (IOException ex) {
                                Logger.getLogger(Afficher_pController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        });
                        setGraphic(b);

                    }
                }
            };

        });
    }

    private void afficherComment() {
        afficherComment.setCellFactory((param) -> {
            return new TableCell() {
                protected void updateItem(Object item, boolean empty) {
                    setGraphic(null);
                    if (!empty) {
                        Button b = new Button("View");
                        b.setOnAction((event) -> {
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("afficher_c.fxml"));
                                Parent root = loader.load();
                               /* GUI.Afficher_cController afficherc = loader.getController();
                                Poste p = tv.getItems().get(getIndex());
                                System.out.println(p);
                                //afficherc.poste=p;
                                root.setUserData(p);*/
                                 Scene scene = b.getScene();
                                scene.setRoot(root);
                            } catch (IOException ex) {
                                Logger.getLogger(Afficher_pController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        });
                        setGraphic(b);

                    }
                }
            };

        });
    }

    @FXML
    private void ajouterP(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouter_p.fxml"));
            Parent root = loader.load();
          
            Scene scene = ajouterP.getScene();
            scene.setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(Afficher_pController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
