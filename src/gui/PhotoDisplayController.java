/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import entities.Publication;
import java.util.ArrayList;
import javafx.scene.input.KeyEvent;
import services.servicePhoto;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.lang.Math;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;

import javafx.stage.StageStyle;


import entities.Photo;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Baklouti
 */
public class PhotoDisplayController implements Initializable {
Image im;
    int pic_index;
    ArrayList<String> list_pics;
    
    int id_ph;
    int id_pub;
    
    private String url_ph;
    @FXML
    private ImageView iv_photo;
    @FXML
    private Button QR;
     
    public final int ID_user = 1;
    @FXML
    private Button btn_scaleDown;
    @FXML
    private Button btn_scaleUp;
    
    @FXML
    private AnchorPane ap_ph;
    @FXML
    private StackPane sp_photo;
    @FXML
    private Button btn_prev;
    @FXML
    private Button btn_next;
    
 public Image setURL(String url)
    {
        Image i = new Image(url);
        return i;
    }
 
  public void display()
    {
                try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PhotoDisplay.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setScene(new Scene(root1));
            stage.show();
            
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
            
    }

  public void load_pic(ArrayList<String> links)
    { 
        list_pics = links;
        Image img = new Image(links.get(pic_index));
        System.out.println("Index IS :" + pic_index);       
        ap_ph.setMaxSize(img.getWidth(),img.getHeight());
        ap_ph.setPrefSize(img.getWidth(),img.getHeight());
        sp_photo.setMaxSize(img.getWidth(),img.getHeight());
        sp_photo.setPrefSize(img.getWidth(),img.getHeight());
        iv_photo.setFitHeight(img.getHeight());
        iv_photo.setFitWidth(img.getWidth());
        iv_photo.setImage(img);
        im =img;
        System.out.println("Number of pics: " + list_pics.size());
        btn_scaleDown.setLayoutX((iv_photo.getFitWidth()/2)+15);
        btn_scaleDown.setLayoutY(iv_photo.getFitHeight()/2);
        btn_prev.setLayoutX(0);
        btn_prev.setLayoutY(iv_photo.getFitHeight()/2);
        btn_next.setLayoutX(iv_photo.getFitWidth());
        btn_next.setLayoutY(iv_photo.getFitHeight()/2);
        
        btn_scaleUp.setLayoutX((iv_photo.getFitWidth()/2)-15);
        btn_scaleUp.setLayoutY(iv_photo.getFitHeight()/2);
            
    }
    
     public void loadQR(String links)
    { 
        Image img = new Image(links);

        ap_ph.setMaxSize(img.getWidth(),img.getHeight());
        ap_ph.setPrefSize(img.getWidth(),img.getHeight());
        
        sp_photo.setMaxSize(img.getWidth(),img.getHeight());
        sp_photo.setPrefSize(img.getWidth(),img.getHeight());
        
        iv_photo.setFitHeight(img.getHeight());
        iv_photo.setFitWidth(img.getWidth());
        iv_photo.setImage(img);

        im =img;
        System.out.println("Number of pics: " + list_pics.size());
        btn_scaleDown.setLayoutX((iv_photo.getFitWidth()/2)+15);
        btn_scaleDown.setLayoutY(iv_photo.getFitHeight()/2);
        btn_prev.setLayoutX(0);
        btn_prev.setLayoutY(iv_photo.getFitHeight()/2);
        btn_next.setLayoutX(iv_photo.getFitWidth());
        btn_next.setLayoutY(iv_photo.getFitHeight()/2);
        
        btn_scaleUp.setLayoutX((iv_photo.getFitWidth()/2)-15);
        btn_scaleUp.setLayoutY(iv_photo.getFitHeight()/2);
            
    }
    
     public void load_pic_index(ArrayList<String> links, int index)
    { 
         if (links.isEmpty()) {
 System.out.println("Error: There are no pictures to display.");        
 return;
    }
        
        Image img = new Image(links.get(index));
        System.out.println("Index IS :" + pic_index);
                
       ap_ph.setMaxSize(img.getWidth(),img.getHeight());
        ap_ph.setPrefSize(img.getWidth(),img.getHeight());
        
        sp_photo.setMaxSize(img.getWidth(),img.getHeight());
        sp_photo.setPrefSize(img.getWidth(),img.getHeight());
        
        iv_photo.setFitHeight(img.getHeight());
        iv_photo.setFitWidth(img.getWidth());
        iv_photo.setImage(img);

        System.out.println("Number of pics: " + list_pics.size());
        btn_scaleDown.setLayoutX((iv_photo.getFitWidth()/2)+10);
        btn_scaleDown.setLayoutY(iv_photo.getFitHeight()/2);
        btn_prev.setLayoutX(0);
        btn_prev.setLayoutY(iv_photo.getFitHeight()/2);
        btn_next.setLayoutX(iv_photo.getFitWidth()-60);
        btn_next.setLayoutY(iv_photo.getFitHeight()/2);
        
        btn_scaleUp.setLayoutX((iv_photo.getFitWidth()/2)-25);
        btn_scaleUp.setLayoutY(iv_photo.getFitHeight()/2);
            
        list_pics = links;
        pic_index = index;
        
        
            
            QR.setLayoutX(0);
            QR.setLayoutY(iv_photo.getLayoutY()- QR.getHeight());
            
            
    }
    
     public void display_ph_index(ArrayList<String> links, int index)
    {
     try{
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("PhotoDisplay.fxml"));
         Parent photo_view = loader.load();
         
            Scene photo_view_scene = new Scene(photo_view);
            
            PhotoDisplayController con = loader.getController();
            
            con.list_pics = links;
            con.pic_index = pic_index;
            con.load_pic_index(links, pic_index);
           
            
            Stage stage = new Stage();
            stage.setScene(photo_view_scene);
            stage.setResizable(false);
            stage.setTitle("Photo");
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
            
    }
     
    @FXML
    public void get_next()
    {
        if(pic_index != list_pics.size()-1)
        {
            pic_index ++;
            Stage stage = (Stage) btn_next.getScene().getWindow();
            stage.close();
            
            
            display_ph_index(list_pics, pic_index);
            load_pic(list_pics);
        }
    }
    @FXML
    public void get_prev()
    {
         if(pic_index != 0)
        {
            pic_index --;
            Stage stage = (Stage) btn_next.getScene().getWindow();
            stage.close();
            
            
            display_ph_index(list_pics, pic_index);
            load_pic(list_pics);
        }
    }
    
    
    @FXML
           public void Scale_down()
           {
               iv_photo.setFitHeight(iv_photo.getFitHeight()-100);
               iv_photo.setFitWidth(iv_photo.getFitWidth()-100);
               
               sp_photo.setMaxSize(iv_photo.getFitWidth(), iv_photo.getFitHeight());
           }
    @FXML
           public void Scale_up()
           {
               iv_photo.setFitHeight(iv_photo.getFitHeight()+100);
               iv_photo.setFitWidth(iv_photo.getFitWidth()+100);
               
                              sp_photo.setMaxSize(iv_photo.getFitWidth(), iv_photo.getFitHeight());
           
                            }
 
     
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        ContextMenu contextMenuPub = new ContextMenu();
        MenuItem QRPhoto = new MenuItem("QR Code");
                  QRPhoto.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event)
            {
               
            }
        }); 
        
       EventHandler<MouseEvent> MouseHandler = new EventHandler<MouseEvent>() 
       {  
        @Override  
        public void handle(MouseEvent event) 
        {
            double distance = (Math.abs(btn_scaleDown.getLayoutX()-event.getX()) + Math.abs(btn_scaleDown.getLayoutY()-event.getY()))/2;
            double distance2 = (Math.abs(btn_scaleUp.getLayoutX()-event.getX()) + Math.abs(btn_scaleUp.getLayoutY()-event.getY()))/2;
            double distance3 = (Math.abs(btn_next.getLayoutX()-event.getX()) + Math.abs(btn_next.getLayoutY()-event.getY()))/2;
            double distance4 = (Math.abs(btn_prev.getLayoutX()-event.getX()) + Math.abs(btn_prev.getLayoutY()-event.getY()))/2;
            btn_scaleDown.setOpacity((1/distance)*13.5);
            btn_scaleUp.setOpacity((1/distance2)*13.5);
            btn_next.setOpacity((1/distance3)*13.5);
            btn_prev.setOpacity((1/distance4)*13.5);

            //System.out.println(distance);
        }        
       };
              EventHandler<MouseEvent> MouseHandler2 = new EventHandler<MouseEvent>() 
       {  
        @Override  
        public void handle(MouseEvent event) 
        {   
            btn_scaleUp.setOpacity(0);
            btn_scaleDown.setOpacity(0);
            btn_next.setOpacity(0);
            btn_prev.setOpacity(0);

            sp_photo.setLayoutX(event.getSceneX()/2);
            sp_photo.setLayoutY(event.getSceneY()/2);
             System.out.println("Mouse X: " + event.getSceneX()+" //Mouse Y: " + event.getSceneY());
             System.out.println("IMG X: " + sp_photo.getLayoutX() + " //IMG Y: " + sp_photo.getLayoutY());
        }        
       };
              EventHandler<KeyEvent> KEvent = new EventHandler<KeyEvent>()
              {
                 @Override
                 public void handle(KeyEvent event)
                 {
                     System.out.println(event.getCode());
                     switch(event.getCode())
                     {
                         case RIGHT:
                                if(pic_index != list_pics.size()-1)
        {
            pic_index ++;
            load_pic(list_pics);
        }
                             break;
                         case LEFT:
                             if(pic_index != 0)
        {
            pic_index --;
            load_pic(list_pics);
        }
                             break;
                             
                     }
                 }
              };
              
              
      ap_ph.setOnMousePressed(MouseHandler2);
      ap_ph.setOnMouseDragged(MouseHandler2);
      ap_ph.setOnMouseMoved(MouseHandler);
      ap_ph.setOnKeyPressed(KEvent);
      sp_photo.setOnKeyPressed(KEvent);
    }    

    @FXML
    private void AddQR(ActionEvent event) throws FileNotFoundException, IOException {
      /*  FileOutputStream fos = null;
    
        ByteArrayOutputStream out = QRCode.from(list_pics.get(pic_index)).to(ImageType.JPG).stream();
        //String path = "C:\\xampp\\htdocs\\Photos\\QR:"+ list_pics.get(pic_index);
        File f = new File("D:\\ImageQR\\imgQR.jpg");
        fos = new FileOutputStream(f);
        fos.write(out.toByteArray());
        fos.flush();
        Desktop desktop = Desktop.getDesktop();
        desktop.open(f);
        notif("QR","Image saved in Desktop");*/

        QRCodeWriter QRCodeWriter;
    
    QRCodeWriter qrCodeWriter = new QRCodeWriter();
    String myWeb = list_pics.toString();
    int width = 300;
    int height = 300;
    String fileType = "png";
    
        BufferedImage bufferedImage = null;
    try {
        BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
        //BitMatrix byteMatrix = qrCodeWriter.encode(myData, BarcodeFormat.QR_CODE, width, height);
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        bufferedImage.createGraphics();
        
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(Color.BLACK);
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (byteMatrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }

        ImageView qrView = new ImageView();
        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));

        StackPane root = new StackPane();
        root.getChildren().add(qrView);

        Scene scene = new Scene(root, 350, 350);

        Stage stage = new Stage();
        stage.setTitle("QR Code");
        stage.setScene(scene);
        stage.show();

        System.out.println("Success...");
        
    } catch (WriterException ex) {
        Logger.getLogger(PhotoDisplayController.class.getName()).log(Level.SEVERE, null, ex);
    }

 
 
    }
    
      public void notif(String title, String text)
{
    Notifications notificationBuilder = Notifications.create()
    .title(title)
    .text(text)
    .hideAfter(javafx.util.Duration.seconds(5))
    .position(Pos.TOP_CENTER);
    notificationBuilder.show();
}
     public void displayQR(String link)
    {
        try{
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("PhotoDisplay.fxml"));
         Parent photo_view = loader.load();
         
            Scene photo_view_scene = new Scene(photo_view);
            
            PhotoDisplayController con = loader.getController();
           
            
            Stage stage = new Stage();
            stage.setScene(photo_view_scene);
            stage.setResizable(false);
            stage.setTitle("Photo");
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            con.loadQR(link);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    } 
}
