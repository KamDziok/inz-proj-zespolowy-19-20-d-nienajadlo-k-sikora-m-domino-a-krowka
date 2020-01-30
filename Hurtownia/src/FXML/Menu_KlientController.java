/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import static FXML.TabelaController.ID;
import Utils.Popup;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import hibernate.Adresy;
import hibernate.AdresyQuery;
import hibernate.Kategorie;
import hibernate.KategorieConverter;
import hibernate.KategorieQuery;
import hibernate.KlientQuery;
import hibernate.MagazynQuery;
import hibernate.ProduktQuery;
import hibernate.Produkty;
import hibernate.ProduktyConverter;
import hibernate.Towaryzamowienie;
import hibernate.TowaryzamowienieQuery;
import hibernate.Zamowienie;
import hibernate.ZamowienieQuery;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author monika
 */

 class ZamowienieID {
    Date zamID;
    Popup Popup = new Popup();
    
    ZamowienieID(Date zam) {
        this.zamID = zam;
    }

    public Date getZamIDDate() {
        return zamID;
    }
    
    

    public String getZamID() {
        
    return new SimpleDateFormat("HHmmssSSS").format(zamID);
    }

    public void setZamID(Date zamID) {
        this.zamID = zamID;
    }
    
    
    
}

public class Menu_KlientController extends Logowanie implements Initializable {
    
    @FXML
    private Label dostepne;
    

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
    private TableColumn<Zamowienie, Integer> id;
    @FXML
    private TableColumn<Zamowienie, Date> dataZamowienia;
    @FXML
    private TableColumn<Zamowienie, String> statusZaplaty;
    @FXML
    private TableColumn<Zamowienie, String> statusTransportu;
    @FXML
    private TableColumn<Zamowienie, Float> kosztZamowienia;
    @FXML
    private Label tabelaId;
    @FXML
    private TableView<Towaryzamowienie> zamowieniaZT;
    @FXML
    private TableColumn<Towaryzamowienie, String> nazwaZT;
    @FXML
    private TableColumn<Towaryzamowienie, Integer> iloscZT;
    @FXML
    private TableColumn<Towaryzamowienie, Float> kosztZT;
    @FXML
    private Button ButtonAnuluj;
    
    ArrayList<String> towary = new ArrayList<>();
    ZamowienieID zamID = new ZamowienieID(new Date());
    @FXML
    private Button zatwierdzBTN;
    
    
    @FXML
    private CheckBox anulowane;
    
    @FXML
    private CheckBox aktywne;
    
    @FXML
    private CheckBox zakonczone;
    
    
    
    

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
        if (k!= null) {
            int idKat = k.getKategoriaId();
            kat.setText(Integer.toString(idKat));
        }
        kat.setVisible(false);
        
    }
    
    public void ComboBoxK  (){
        kat.setText("");
        kategoriaCombo.getItems().clear();
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
        produktyCombo.getItems().addAll(produkty.produktySelectAvailable(idKategoria));
        produktyCombo.setConverter(new ProduktyConverter());
        
          produktyCombo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comboValueProdukty(produktyCombo);
                if (produktyCombo.getValue() != null) {
                    
                int p =  new MagazynQuery().dostepneTowary(produktyCombo.getValue().getProduktId());
                dostepne.setText("Dostępne:    " + p);
                }

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
        new KlientQuery().usunNieZapZam(dane.getText());
        app.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                new KlientQuery().usunNieZapZam(dane.getText());
            }
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        aktywne.setSelected(true);
        ComboBoxK();
        zamowieniaTable();
        towaryDoZamowieniaTable();
    }

    @FXML
    private void zamowTowar(ActionEvent event) {
        int id = Integer.parseInt(dane.getText());
        int idProdukt = Integer.parseInt(prod.getText());
        int ilosc = Integer.parseInt(ilosctxt.getText());
        
        try{
            KlientQuery klient = new KlientQuery();
            if (towary.size() == 0)
            zamID.setZamID(new Date());
            
            if (new MagazynQuery().dostepneTowary(idProdukt) >= ilosc) {
                klient.zamowTowar(ilosc, idProdukt, id , towary , zamID.getZamIDDate());
                TowaryzamowienieQuery towar = new TowaryzamowienieQuery();
                displayTowary();
                statusZamowienia.setText("Towar dodany do zamówienia!");
                int p =  new MagazynQuery().dostepneTowary(produktyCombo.getValue().getProduktId());
                dostepne.setText("Dostępne:    " + p);
            }
            else{
                statusZamowienia.setText("Zbyt mało towaru na magazynie");
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        

}
      public void comboValueProdukty (ComboBox<Produkty> produktyCombo){
        
        Produkty p = produktyCombo.getValue();
        int idP = 0;
          if (p != null) {
        idP = p.getProduktId();
          }
        prod.setText(Integer.toString(idP));
        prod.setVisible(false);
    }

 
    public void zamowieniaTable(){
        
        id.setCellValueFactory(new PropertyValueFactory<> ("zamowienieId"));
        dataZamowienia.setCellValueFactory(new PropertyValueFactory<> ("Data"));
        statusZaplaty.setCellValueFactory(new PropertyValueFactory<> 
        ("statusZaplaty"));
        statusTransportu.setCellValueFactory(new PropertyValueFactory<> 
        ("statusTransportu"));
        kosztZamowienia.setCellValueFactory(new PropertyValueFactory<> 
        ("koszt"));
       
    }

    
    public void wczytDoTabeli(int id){
        
        tabelaId.setText(Integer.toString(id));
        tabelaId.setVisible(false);
        
}

    public void wczytajDane() {
        zamowieniaK.getItems().clear();
        int id = Integer.parseInt(tabelaId.getText());
        ZamowienieQuery zamow = new ZamowienieQuery();
        zamowieniaK.getItems().addAll(getZamowienia(aktywne.isSelected()
                ,anulowane.isSelected(),zakonczone.isSelected()));
        
//         zamowieniaK.getItems().addAll(zamow.wszystkieZamowienia());
        zamowieniaK.setRowFactory( tv -> {
    TableRow<Zamowienie> row = new TableRow<>();
    row.getContextMenu();
    
    
    
    final ContextMenu contextMenu = new ContextMenu();
            MenuItem tow = new MenuItem("Wyświetl dane");
            MenuItem faktura = new MenuItem("Generuj fakturę");
            MenuItem zwrot = new MenuItem("Zwróć zamówienie");
            MenuItem zaplac = new MenuItem("Zapłać");
            

            tow.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        try {
            TabelaController.ID = String.valueOf(row.getItem().getZamowienieId());
            Stage PrimaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML"
                + "/Tabela.fxml"));
            Scene scene = new Scene(root);
            PrimaryStage.setScene(scene);
            PrimaryStage.show();
            PrimaryStage.setResizable(true);
            
             
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
});
    
faktura.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        
        try {
            KlientQuery klient = new KlientQuery();
            klient.pobierzFakture( "" +row.getItem().getZamowienieId());   
            Popup.show("Wygenerowano fakturę w katalogu Invoices.");
        } catch (Exception e) {
            Popup.show("Nie udało się wygenerować faktury");
            System.err.println(e.getMessage());
        }
        
    }
});
            
zwrot.setOnAction(new EventHandler<ActionEvent>() {
    @Override
        public void handle(ActionEvent event) {
            new KlientQuery().zwrocTowar(row.getItem());
            wczytajDane();

 }
    });            


    zaplac.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            new KlientQuery().zaplac(row.getItem());
            wczytajDane();
        }
    });


    contextMenu.getItems().addAll(tow , faktura , zwrot , zaplac);

    row.setContextMenu(contextMenu);

        return row ;
    });
}
      
        
        
    
    
     @FXML
    private void aktywneSelect(ActionEvent event) {
        wczytajDane();
    }
     @FXML
    private void zakonczoneSelect(ActionEvent event) {
        wczytajDane();
    }
     @FXML
    private void anulowaneSelect(ActionEvent event) {
        wczytajDane();
    }
    

   
    @FXML
    private void anuluj(ActionEvent event) {
        
        try{
            KlientQuery klient = new KlientQuery();
            if (towary.size() == 0){
                zamID.setZamID(new Date());
                statusZamowienia.setText("");
                }
            else{
                klient.anulujZamowienie(zamID.getZamID());
                TowaryzamowienieQuery towar = new TowaryzamowienieQuery();
                displayTowary();

                statusZamowienia.setText("Zamowienie zostało anulowane");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        towary.clear();
        clearForm();
        
        
    }
    
    public void clearForm(){
        dostepne.setText("");
        ilosctxt.setText("");
        produktyCombo.getItems().clear();
        ComboBoxK();
        zamowieniaTable();
        towaryDoZamowieniaTable();};

    @FXML
    private void zatwierdz(ActionEvent event) {
        try{
            KlientQuery klient = new KlientQuery();
            if (towary.size() == 0){
            klient.anulujZamowienie(zamID.getZamID());
            statusZamowienia.setText("Brak Towarów w zamówieniu");
            }
            
            else {
            klient.zatwierdzZamowienie(zamID.getZamID());
            TowaryzamowienieQuery towar = new TowaryzamowienieQuery();
            zamID.setZamID(new Date());
            displayTowary();
            statusZamowienia.setText("Zamowienie zostało potwierdzone");
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        towary.clear();
        clearForm();
    }
    
    
 
    private void towaryDoZamowieniaTable() {

       
        nazwaZT.setCellValueFactory(new PropertyValueFactory<> ("produktName"));
       iloscZT.setCellValueFactory(new PropertyValueFactory<> ("ilosc"));
        kosztZT.setCellValueFactory(new PropertyValueFactory<> 
        ("koszt"));
        
    }
    
    
    private void displayTowary() {
        TowaryzamowienieQuery towar = new TowaryzamowienieQuery();
            zamowieniaZT.getItems().setAll(towar.zamowieniaID(zamID.getZamID()));
            
            zamowieniaZT.setRowFactory( tv -> {
    TableRow<Towaryzamowienie> row = new TableRow<>();
    row.getContextMenu();
    
    
    
    final ContextMenu contextMenu = new ContextMenu();
            MenuItem del = new MenuItem("Usuń");

            del.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        try {
            KlientQuery klient = new KlientQuery();
            
            klient.usunProdukt(row.getItem().getTowaryZamowienieId());
            
            statusZamowienia.setText("Produkt "+ row.getItem().getProduktName() 
                    + " został usunięty!");
            
                int p =  new MagazynQuery().dostepneTowary(produktyCombo.getValue().getProduktId());
                dostepne.setText("Dostępne:    " + p);
                towary.remove(0);
             
            displayTowary();
             
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
});
contextMenu.getItems().addAll(del);

row.setContextMenu(contextMenu);
    
    return row ;
});
            wczytajDane();
    }
    
    public ObservableList<Zamowienie> getZamowienia(boolean aktywne,boolean anulowane,boolean zakonczone) {
        ObservableList<Zamowienie> listaZamowien = FXCollections.
                observableArrayList();
        Session session = hibernate.HibernateUtil.getSessionFactory().
                openSession();
        List<Zamowienie> pList = session.createCriteria(Zamowienie.class).list();

        for (Zamowienie z : pList) {
            
            if(aktywne)
                if (!(z.getStatusTransportu().equals("anulowane") 
                        && z.getStatusZaplaty().equals("anulowane"))
                        && !(z.getStatusTransportu().equals("wysłane") 
                        && z.getStatusZaplaty().equals("zapłacone")))
                    listaZamowien.add(z);
            if(anulowane)
                if(z.getStatusTransportu().equals("anulowane") 
                        && z.getStatusZaplaty().equals("anulowane"))
                        listaZamowien.add(z);
            if(zakonczone)
                if(z.getStatusTransportu().equals("wysłane") 
                        && z.getStatusZaplaty().equals("zapłacone"))
                        listaZamowien.add(z);
            }
                

        
        return listaZamowien;
    }
    
    
 

  


}