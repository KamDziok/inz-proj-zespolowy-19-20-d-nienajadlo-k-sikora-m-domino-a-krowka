/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXButton;
import hibernate.Kategorie;
import hibernate.KategorieConverter;
import hibernate.KategorieQuery;
import hibernate.ProduktQuery;
import hibernate.Produkty;
import hibernate.ProduktyConverter;
import hibernate.ReklamaQuery;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class Menu_MarketingController extends Logowanie implements 
        Initializable {

    @FXML
    private TextField tytulD;
    
    private DatePicker dataD;
    
    @FXML
    private TextArea opisD;
    
    @FXML
    private ImageView grafika;
    
    @FXML
    private Button dodajbtn;
    
    @FXML
    private JFXButton wylogujDR;
    @FXML
    private TextField URLgrafiki;
    @FXML
    private Button loadBtn;
    
    Stage stage;
    @FXML
    private ComboBox<Kategorie> katDcomo;
    @FXML
    private ComboBox<Produkty> produktyDcombo;
    @FXML
    private Label prod;
    @FXML
    private Label kat;
    @FXML
    private Label statusDodania;

    
    @FXML
    void wyloguj(ActionEvent event) {
        
        String reklama = "/FXML/Login.fxml";
        wczytywanie(event, reklama);
        ramka(event);
        
    }
    
    public void clearField (){
        tytulD.setText(null);
        URLgrafiki.setText(null);
        opisD.setText(null);
}
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboBoxK ();
    }    

    @FXML
    private void wczytajGrafike(ActionEvent event) throws FileNotFoundException {
        
      
      try{
          FileChooser fc = new FileChooser();
          fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter
        ("Image Files", "*.png", "*.jpg", "*.gif"));
          File selectedFile = fc.showOpenDialog(stage);
          URLgrafiki.setText(selectedFile.toString());
           String adresURL = URLgrafiki.getText();
               Image image = new Image(new FileInputStream(adresURL));
        
        grafika.setImage(image);
          
      }catch(Exception e){
          System.out.println(e.getMessage());
      }
    }

    @FXML
    private void dodajReklame(ActionEvent event) {
      
        int ProduktId = Integer.parseInt(prod.getText());
        String tytul = tytulD.getText();
        String opis = opisD.getText();
        String obrazek = URLgrafiki.getText();
        
        try{
            ReklamaQuery r = new ReklamaQuery();
            r.addNewAdvert(ProduktId, tytul, opis, obrazek);
            clearField();
            statusDodania.setText("Reklama została stworzona");
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
    }
    
    public void comboValueKT (ComboBox<Kategorie> katDcomo){
        
        Kategorie k = katDcomo.getValue();
        int idKat = k.getKategoriaId();
        kat.setText(Integer.toString(idKat));
        kat.setVisible(false);
        
    }
    
    public void ComboBoxK (){
        kat.setText("");
        KategorieQuery kategoria = new KategorieQuery();
        
        katDcomo.getItems().addAll(kategoria.KategorieSelectAll());
        
        katDcomo.setConverter(new KategorieConverter());
        
         katDcomo.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                comboValueKT(katDcomo);
            
            
            if (!kat.getText().equals("")) {
            
        int idKategoria = Integer.parseInt(kat.getText());
            ProduktQuery produkty = new ProduktQuery();
        produktyDcombo.getItems().clear();
        produktyDcombo.getItems().addAll(produkty.
                produktySelectAllOnID(idKategoria));
        produktyDcombo.setConverter(new ProduktyConverter());
        
          produktyDcombo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comboValueProdukty(produktyDcombo);

            }
        });
        }
            
            
            }
        });
        
        
    }
     public void comboValueProdukty (ComboBox<Produkty>  produktyDcombo){
        
        Produkty p =  produktyDcombo.getValue();
        int idP = p.getProduktId();
        prod.setText(Integer.toString(idP));
        prod.setVisible(false);
    }
    
}
