/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.bus;
import entities.maintenance;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import static java.util.Collections.list;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import services.maintenanceService;

/**
 * FXML Controller class
 *
 * @author haifa
 */
public class AffichermainController implements Initializable {

    int index = 0;
    maintenanceService ms = new maintenanceService();
    @FXML
    private TableColumn<maintenance, Date> date_entretien;
    @FXML
    private TableColumn<maintenance, String> description;
    @FXML
    private TableView<maintenance> tab;
    maintenanceService mt = new maintenanceService();
    ObservableList<maintenance> Listmaintenance = FXCollections.observableArrayList();
    maintenance bs = new maintenance();
    @FXML
    private Button supprimermain;
    @FXML
    private Button Retourmain;
    @FXML
    private Button modifier;
    @FXML
    private TableColumn<maintenance, Integer> numero_de_plaque;
    @FXML
    private Button excelButton;

    public void remplir() {
        try {
            List<maintenance> list = ms.recuperer(bs);
            Listmaintenance.addAll(list);
            description.setCellValueFactory(new PropertyValueFactory<>("description"));
            date_entretien.setCellValueFactory(new PropertyValueFactory<>("date_entretien"));
            numero_de_plaque.setCellValueFactory(new PropertyValueFactory<>("numeroPlaqueBus"));

//         numero_de_plaque.setCellValueFactory(new PropertyValueFactory<>("bus.numeroPlaque"));
            tab.setItems(Listmaintenance);
        } catch (SQLException ex) {
            System.out.println("asslema " + ex);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        remplir();
    }

    void setdatamaintenance(maintenance bs) {
    }

    @FXML
    private void supprimer_main(ActionEvent event) throws SQLException {
        maintenance bs = tab.getSelectionModel().getSelectedItem();
        if (bs != null) {
            // Supprimer l'élément de la base de données
            ms.supprimer(bs);
            // Supprimer l'élément de la liste observable et rafraîchir la table
            Listmaintenance.remove(bs);
            tab.refresh();
        }
    }

    void getSelected() {
        System.out.println("rah il ghali rah");

        try {
            index = tab.getSelectionModel().getSelectedIndex();
            if (index <= 0) {
                return;
            }
            System.out.println(index);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("erreur");
        }
    }

    @FXML
    private void Retourmain(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ajoutermaintenance.fxml"));
        Parent root = loader.load();
        AjoutermaintenanceController controller = loader.getController();
        controller.setdatamaintenance(bs);

        Retourmain.getScene().setRoot(root);
    }

    @FXML
    private void modifiermain(ActionEvent event) throws IOException, ParseException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("modifiermaint.fxml"));
        DialogPane detailPage = loader.load();
        ModifiermaintController detailControlleur = loader.getController();
        detailControlleur.setListener(new ModifiermaintController.PopupListener() {
            @Override
            public void onInfoSent(Boolean Rendez_vousInstance) {
                tab.getItems().clear();
                remplir();
            }
        });
        index = tab.getSelectionModel().getSelectedIndex();
        System.out.println("mchetttt lkhedma " + Listmaintenance.get(index).getId_m());
        System.out.println("rmazelt makhedmtech " + Listmaintenance.get(index).getDescription());
        System.out.println("rahou makhedmetch" + Listmaintenance.get(index).getDate_entretien());
        System.out.println("rahou makhedmetch" + Listmaintenance.get(index).getNumeroPlaqueBus());

        detailControlleur.setAtrtribute(Listmaintenance.get(index));
        // detailControlleur.setDialogPane(candidatureInstance);
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(detailPage);
        Optional<ButtonType> clickButtonp = dialog.showAndWait();
        dialog.setTitle("detail");

    }

    @FXML
    private void excel(ActionEvent event) {

        
        try {
            String filename = "C:\\xampp1\\htdocs\\EXCEL\\dataEvent.xls";
            HSSFWorkbook hwb = new HSSFWorkbook();
            HSSFSheet sheet = hwb.createSheet("new sheet");
            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell((short) 0).setCellValue("nom evenement");
            rowhead.createCell((short) 1).setCellValue("type d'evenement");
            rowhead.createCell((short) 2).setCellValue("description ");
            List<maintenance> evenements = ms.recuperer(bs);
            for (int i = 0; i < evenements.size(); i++) {
                HSSFRow row = sheet.createRow((short) i);

                row.createCell((short) 0).setCellValue(evenements.get(i).getId_m());
                row.createCell((short) 1).setCellValue(evenements.get(i).getNumeroPlaqueBus());
                row.createCell((short) 2).setCellValue(evenements.get(i).getDescription());
//row.createCell((short) 3).setCellValue((evenements.get(i).getDate()));
                i++;
            }
            int i = 1;
            FileOutputStream fileOut = new FileOutputStream(filename);
            hwb.write(fileOut);
            fileOut.close();
            System.out.println("Your excel file has been generated!");
            File file = new File(filename);
            if (file.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(file);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

}

// TODO

