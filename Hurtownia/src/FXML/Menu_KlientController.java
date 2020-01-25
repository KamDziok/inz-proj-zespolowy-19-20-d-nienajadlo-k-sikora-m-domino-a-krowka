/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import hibernate.Adresy;
import hibernate.AdresyQuery;
import hibernate.HibernateUtil;
import hibernate.Kategorie;
import hibernate.KategorieConverter;
import hibernate.KategorieQuery;
import hibernate.KlientQuery;
import hibernate.KsiegowoscQuery;
import hibernate.ProduktQuery;
import hibernate.Produkty;
import hibernate.ProduktyConverter;
import hibernate.ReklamaQuery;
import hibernate.Zamowienie;
import hibernate.ZamowienieQuery;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class Menu_KlientController extends Logowanie implements Initializable {

    @FXML
    private TableView<Zamowienie> zamowieniaK;

    @FXML
    private JFXButton wylogujTZ;

    @FXML
    private Label dane;

    @FXML
    private JFXButton wylogujDO1;

    @FXML
    private Button dodajAdresBtn;

    @FXML
    private JFXTextField ulicaDA;

    @FXML
    private Label miastoL;

    @FXML
    private Label telefonL;

    @FXML
    private Label ulicaL;

    @FXML
    private Label nrBudL;

    @FXML
    private Label nLokaLa;

    @FXML
    private Label krajL;

    @FXML
    private JFXTextField krajAD;

    @FXML
    private JFXTextField miastoAD;

    @FXML
    private JFXTextField numerBudynkuAD;

    @FXML
    private JFXTextField numerLokaluAD;

    @FXML
    private JFXTextField emailAD;

    @FXML
    private Label nazwiskoL;

    @FXML
    private Label imieL;

    @FXML
    private Label mailL;

    @FXML
    private JFXButton wylogujDO;

    @FXML
    private Button zamowBTN;
    @FXML
    private TextField ilosctxt;
    @FXML
    private ComboBox<Kategorie> kategoriaCombo;
    @FXML
    private ComboBox<Produkty> produktyCombo;
    @FXML
    private JFXButton wylogujZT;
    @FXML
    private Label kat;
    @FXML
    private Label prod;
    @FXML
    private Label statusZamowienia;
    @FXML
    private ImageView grafikaReklamy;
    @FXML
    private Text opisReklamy;
    @FXML
    private Button reklamaBtn;
    @FXML
    private TableColumn<Zamowienie, Integer> id;
    @FXML
    private TableColumn<Zamowienie, Date> dataZamowienia;
    @FXML
    private TableColumn<Zamowienie, String> statusZaplaty;
    @FXML
    private TableColumn<Zamowienie, String> statusTransportu;
    @FXML
    private Label tabelaId;
    @FXML
    private Button wczytajBtn;

    @FXML
    void DodajAdres(ActionEvent event) {

        String kraj = krajAD.getText();
        String miasto = miastoAD.getText();
        String ulica = ulicaDA.getText();
        String nB = numerBudynkuAD.getText();
        String nL = numerLokaluAD.getText();
        String email = emailAD.getText();

        int id = Integer.parseInt(dane.getText());

        AdresyQuery a = new AdresyQuery();
        Adresy adresZ = a.wyswietlAdres(id);
        System.out.println(id);
        if (adresZ == null) {
            try {
                AdresyQuery adres = new AdresyQuery();
                adres.dodajAdres(id, kraj, miasto, ulica, nB, nL, email);
                dodajAdresBtn.setText("Zmień Adres");
                    

                } 
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else{
            try {
                KlientQuery kl = new KlientQuery();
                kl.changeAddress(id, kraj, miasto, ulica, nB, nL, email);

                } 
            catch (Exception e) {  
                System.out.println(e.getMessage());
            }
        }
        
        adresZ = a.wyswietlAdres(id);
                    if (adresZ != null) {
                        this.adresDostawy(adresZ.getUlica(), 
                            adresZ.getMiasto(), adresZ.getKraj(), 
                            adresZ.getNumerBudynku(), adresZ.getNumerLokalu(),
                            adresZ.getEmail());
                            
                }
        
        

    }

    public void odczyt(int id) {
        dane.setText(Integer.toString(id));
        dane.setVisible(false);
    }

    
       
    
    public void daneOsobowe(String imie, String nazwisko, long telefon) {
        imieL.setText(imie);
        nazwiskoL.setText(nazwisko);
        telefonL.setText(Long.toString(telefon));
    }

    public void adresDostawy(String ulica, String miasto, String kraj,
            String numerB, int numerL, String email) {
        
        ulicaL.setText(ulica);
        miastoL.setText(miasto);
        nrBudL.setText(numerB);
        nLokaLa.setText(Integer.toString(numerL));
        krajL.setText(kraj);
        mailL.setText(email);

    }
    
    
    public void DodajAdresBTN(){
        dodajAdresBtn.setText("Dodaj Adres");
    }
    
    public void comboValueKT (ComboBox<Kategorie> kategoriaCombo){
        
        Kategorie k = kategoriaCombo.getValue();
        int idKat = k.getKategoriaId();
        kat.setText(Integer.toString(idKat));
        kat.setVisible(false);
        
    }
    
    public void ComboBoxK  (){
        kat.setText("");
        KategorieQuery kategoria = new KategorieQuery();
        
        kategoriaCombo.getItems().addAll(kategoria.KategorieSelectAll());
        
        kategoriaCombo.setConverter(new KategorieConverter());
        
         kategoriaCombo.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                comboValueKT(kategoriaCombo);
            
            
            if (!kat.getText().equals("")) {
            
        int idKategoria = Integer.parseInt(kat.getText());
            ProduktQuery produkty = new ProduktQuery();
        produktyCombo.getItems().clear();
        produktyCombo.getItems().addAll(produkty.
                produktySelectAllOnID(idKategoria));
        produktyCombo.setConverter(new ProduktyConverter());
        
          produktyCombo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comboValueProdukty(produktyCombo);

            }
        });
        }
            
            
            }
        });
        
        
    }

    @FXML
    void wyloguj(ActionEvent event) {

        String klientPanel = "/FXML/Login.fxml";
        wczytywanie(event, klientPanel);
        ramka(event);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ComboBoxK();
        zamowieniaTable();
        
    }

    @FXML
    private void zamowTowar(ActionEvent event) {
        
        int id = Integer.parseInt(dane.getText());
        int idProdukt = Integer.parseInt(prod.getText());
        int ilosc = Integer.parseInt(ilosctxt.getText());
        
        try{
            KlientQuery klient = new KlientQuery();
            klient.zamowTowar(ilosc, idProdukt, id);
            statusZamowienia.setText("Towar został zamówiony!");
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        

}
      public void comboValueProdukty (ComboBox<Produkty> produktyCombo){
        
        Produkty p = produktyCombo.getValue();
        int idP = p.getProduktId();
        prod.setText(Integer.toString(idP));
        prod.setVisible(false);
    }

    @FXML
    private void zobaczReklame(ActionEvent event) throws FileNotFoundException {
        
        int idProdukt = Integer.parseInt(prod.getText());
        
        ReklamaQuery reklama = new ReklamaQuery();
       
        String adres = reklama.wyszukiwanieID
        (idProdukt).getGrafika();
       Image image = new Image(new FileInputStream(adres));
        
       grafikaReklamy.setImage(image);
       
       opisReklamy.setText(reklama.wyszukiwanieID(idProdukt).getOpis().
               toString());
      
    }
    
    public void zamowieniaTable(){
        
        id.setCellValueFactory(new PropertyValueFactory<> ("zamowienieId"));
        dataZamowienia.setCellValueFactory(new PropertyValueFactory<> ("Data"));
        statusZaplaty.setCellValueFactory(new PropertyValueFactory<> 
        ("statusZaplaty"));
        statusTransportu.setCellValueFactory(new PropertyValueFactory<> 
        ("statusTransportu"));
       
    }

    
    public void wczytDoTabeli(int id){
        
        tabelaId.setText(Integer.toString(id));
        tabelaId.setVisible(false);
        
}

    @FXML
    private void wczytajDane(ActionEvent event) {
        int id = Integer.parseInt(tabelaId.getText());
        ZamowienieQuery zamow = new ZamowienieQuery();
        zamowieniaK.getItems().addAll(zamow.zamowieniaID(id));
      
    }


}