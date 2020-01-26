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
import hibernate.KierownikQuery;
import hibernate.Pracownik;
import hibernate.PracownikQuery;
import hibernate.ProduktQuery;
import hibernate.Produkty;
import hibernate.ProduktyConverter;
import hibernate.Reklama;
import hibernate.ReklamaQuery;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.hibernate.Session;

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
    private JFXButton wylogujDR1;
    @FXML
    private TableView<Reklama> reklamy;
    @FXML
    private TableColumn<Reklama, Integer> IdReklamy;
    @FXML
    private TableColumn<Reklama, String> TytulReklamy;
    @FXML
    private TableColumn<Reklama, String> OpisReklamy;
    @FXML
    private Label status;
    @FXML
    private TableView<Reklama> reklamyZ;
    @FXML
    private TableColumn<Reklama, Integer> idReklamyZ;
    @FXML
    private TableColumn<Reklama, String> TytulReklamyZ;
    @FXML
    private TableColumn<Reklama, String> OpisReklamyZ;
    @FXML
    private JFXButton wylogujDR11;
    @FXML
    private TextField tytulModyfikacja;
    @FXML
    private Label idZ;
    @FXML
    private Button zmianaDanychR;
    @FXML
    private TextField opisModyfikacja;

    
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
        grafika.setImage(null);
}
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboBoxK ();
        reklamyTable();
        reklamyTableZ();
        setCellValueFromTableToTextField();
        
    }    

    @FXML
    private void wczytajGrafike(ActionEvent event) throws FileNotFoundException {
        
      
      try{
          FileChooser fc = new FileChooser();
          fc.setInitialDirectory(new File("../Hurtownia/obrazki"));
          fc.getExtensionFilters().addAll(new FileChooser.
                  ExtensionFilter
        ("Image Files", "*.png", "*.jpg", "*.gif"));
          File selectedFile = fc.showOpenDialog(stage);
          URLgrafiki.setText(selectedFile.getAbsolutePath());
           String adresURL = URLgrafiki.getText();
               Image image = new Image(new FileInputStream(adresURL));
               
        
        grafika.setImage(image);
          
      }catch(Exception e){
          System.out.println(e.getMessage());
      }
    }

    @FXML
    private void dodajReklame(ActionEvent event) throws MalformedURLException {
      
        int ProduktId = Integer.parseInt(prod.getText());
        String tytul = tytulD.getText();
        String opis = opisD.getText();
        String obrazek = URLgrafiki.getText();
        
        try{
            ReklamaQuery r = new ReklamaQuery();
            r.addNewAdvert(ProduktId, tytul, opis, obrazek);
            clearField();
            reklamy.getItems().setAll(getReklama());
            statusDodania.setText("Reklama została stworzona");
             reklamy.getItems().setAll(getReklama());
    
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
    }
    
     public void reklamyTableZ(){
         idReklamyZ.setCellValueFactory(new PropertyValueFactory<>("ReklamaId"));
         TytulReklamyZ.setCellValueFactory(new PropertyValueFactory<>("Tytul"));
        OpisReklamyZ.setCellValueFactory(new PropertyValueFactory<>("Opis"));
         
         reklamyZ.getItems().addAll(getReklama());
         
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
     
     public ObservableList<Reklama> getReklama() {
        ObservableList<Reklama> listaReklam = FXCollections.
                observableArrayList();
        Session session = hibernate.HibernateUtil.getSessionFactory().
                openSession();
        List<Reklama> pList = session.createCriteria(Reklama.class).list();

        for (Reklama r : pList) {
            listaReklam.add(r);

        }
        return listaReklam;
    }
     
     public void reklamyTable(){
         IdReklamy.setCellValueFactory(new PropertyValueFactory<>("ReklamaId"));
         TytulReklamy.setCellValueFactory(new PropertyValueFactory<>("Tytul"));
         OpisReklamy.setCellValueFactory(new PropertyValueFactory<>("Opis"));
         
         ReklamaQuery reklama = new ReklamaQuery();
         
         reklamy.getItems().setAll(getReklama());
         reklamy.setRowFactory( tv -> {
    TableRow<Reklama> row = new TableRow<>();
    row.getContextMenu();
    
         final ContextMenu contextMenu = new ContextMenu();
            MenuItem del = new MenuItem("Usuń");

            del.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        try {
            
            reklama.removeAdvert(row.getItem().getReklamaId());
            
         reklamy.getItems().setAll(getReklama());
           status.setText("Reklama została usunięta");
             
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
});
contextMenu.getItems().addAll(del);

row.setContextMenu(contextMenu);
    
    return row ;
});
    
     }

    @FXML
    private void modyfikacjaReklamy(ActionEvent event) {
        
        int id = Integer.parseInt(idZ.getText());
        String tytul = tytulModyfikacja.getText();
        String opis = opisModyfikacja.getText();
        
        try{
            ReklamaQuery zmianaR = new ReklamaQuery();
            zmianaR.changeAdvert(id, tytul, opis);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    private void setCellValueFromTableToTextField(){
        reklamyZ.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Reklama r = reklamyZ.getItems().get(reklamyZ.getSelectionModel()
                        .getSelectedIndex());
                idZ.setText(Integer.toString(r.getReklamaId()));
                idZ.setVisible(false);
                tytulModyfikacja.setText(r.getTytul());
                opisModyfikacja.setText(r.getOpis());
            
            }  
    });

}
}