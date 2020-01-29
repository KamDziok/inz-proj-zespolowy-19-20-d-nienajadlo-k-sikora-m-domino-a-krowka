/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import hibernate.StanowiskoConverter;
import hibernate.HibernateUtil;
import hibernate.Magazyn;
import hibernate.MagazynQuery;
import hibernate.Kategorie;
import hibernate.KategorieConverter;
import hibernate.KategorieQuery;
import hibernate.KierownikQuery;
import hibernate.MagazynQuery;
import hibernate.Pracownik;
import hibernate.PracownikConverter;
import hibernate.PracownikQuery;
import hibernate.ProduktQuery;
import hibernate.Produkty;
import hibernate.ProduktyConverter;
import hibernate.Zamowienie;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class Menu_KierownikController extends Logowanie implements Initializable
{

    @FXML
    private TableView<Zamowienie> zamowieniaTable;

    @FXML
    private TableColumn<Zamowienie, Integer> id;


    @FXML
    private JFXButton wylogujZA;

    @FXML
    private TextField nazwaP;

    @FXML
    private TextArea opisP;

    @FXML
    private TextField cenaP;

    @FXML
    private Button DodajBTN;

    @FXML
    private TableView<Produkty> produktyD;

    @FXML
    private ComboBox<Kategorie> katDcombo;

    @FXML
    private ComboBox<Kategorie> katCombo;

    @FXML
    private JFXButton wylogujbtn;
    @FXML
    private JFXButton wylogujKPr;
    @FXML
    private TableView<Pracownik> pracownicyTable;
    @FXML
    private TableColumn<Pracownik, String> imieT;
    @FXML
    private TableColumn<Pracownik, String> nazwiskoT;
    @FXML
    private TableColumn<Pracownik, String> stanowiskoT;
    @FXML
    private TableColumn<Pracownik, Float> stawkaT;
    @FXML
    private JFXTextField imieDP;
    @FXML
    private JFXTextField nazwiskoDP;
    @FXML
    private JFXTextField wynagrodzenieDP;
    @FXML
    private Button DodajP;
    @FXML
    private Label status_zatrudnienia;
    @FXML
    private Label pracownikLabel;
    @FXML
    private Label wyborCombo;
    @FXML
    private Label katWybor;
    @FXML
    private Label statusDodajP;
    @FXML
    private TextField wyszukajField;
    private TextField wyszukajFileldZ;
    @FXML
    private TableColumn<Produkty, String> nazwaTD;
    @FXML
    private TableColumn<Produkty, Float> cenaTD;
    @FXML
    private TableColumn<Produkty, String> opisTD;
    @FXML
    private Button wczytajBtn;
    @FXML
    private Label wczytajLabel;
    @FXML
    private JFXButton wylogujDTM;
    @FXML
    private ComboBox<Kategorie> katComboTM;
    @FXML
    private Label wczytKMCombo;
    @FXML
    private ComboBox<Produkty> produktyComboTM;
    @FXML
    private Label wczytP;
    @FXML
    private TextField cenaST;
    @FXML
    private TextField iloscT;
    @FXML
    private Button dodajMagazynbtn;
    @FXML
    private Label magazyn_status;
    @FXML
    private JFXComboBox<Produkty> PcomboT;
    @FXML
    private JFXButton wczytajTabela;
    @FXML
    private JFXComboBox<Kategorie> KcomboT;
    @FXML
    private Label kat;
    @FXML
    private Label pro;
    @FXML
    private TableView<Magazyn> towary;
    @FXML
    private TableColumn<Magazyn, Float> cenaSTable;
    @FXML
    private TableColumn<Magazyn, Integer> iloscTable;
    @FXML
    private TableColumn<Zamowienie, Date> data;
   
    @FXML
    private TableColumn<Zamowienie, String> zaplata;
    @FXML
    private TableColumn<Zamowienie, String> transport;
    @FXML
    private TableColumn<Magazyn, String> nazwaProduktu;
    @FXML
    private Label zwolnieniaStatus;
    @FXML
    private Label wyborStanowiska;
    @FXML
    private ComboBox<Pracownik> stanowiskoCombo;

    @FXML
    void wyloguj(ActionEvent event) {

        String wylogowywanie = "/FXML/Login.fxml";
        wczytywanie(event, wylogowywanie);
        ramka(event);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        pracownicyTable();
        produktyTable();
        magazynTable();
        comboBoxK();
        comboStanowisko();
        zamowieniaStatusTable();
        wyszukaj(getPracownik());
        

    }

    public ObservableList<Pracownik> getPracownik() {
        ObservableList<Pracownik> listaPracownikow = FXCollections.
                observableArrayList();
        Session session = hibernate.HibernateUtil.getSessionFactory().
                openSession();
        List<Pracownik> pList = session.createCriteria(Pracownik.class).list();

        for (Pracownik p : pList) {
            listaPracownikow.add(p);

        }
        return listaPracownikow;
    }
    
    public ObservableList<Zamowienie> zamowienia() {
        ObservableList<Zamowienie> zamowieniaK = FXCollections.
                observableArrayList();
        Session session = hibernate.HibernateUtil.getSessionFactory().
                openSession();
        List<Zamowienie> zList = session.createCriteria(Zamowienie.class).
                list();

        for (Zamowienie z : zList) {
            zamowieniaK.add(z);

        }
        return zamowieniaK;
    }

     public ObservableList<Pracownik> stanowisko() {
        ObservableList<Pracownik> stanowiskoP = FXCollections.
                observableArrayList();
        Session session = hibernate.HibernateUtil.getSessionFactory().
                openSession();
        Criteria crit = (Criteria)session.createCriteria(Pracownik.class);
        //Criterion price = Restrictions.gt("stanowisko",new String());
        crit.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
        
        List <Pracownik> stanowisko = crit.list();
                
       
        for (Pracownik s : stanowisko) {
            stanowiskoP.add(s);

        }
        return stanowiskoP;
    }
    
    @FXML
    private void Dodaj_Pracownika(ActionEvent event) {

        String imie = imieDP.getText();
        String nazwisko = nazwiskoDP.getText();
        float wyplata = Float.parseFloat(wynagrodzenieDP.getText());
        String posada = wyborStanowiska.getText();

        try {
            KierownikQuery kierownik = new KierownikQuery();
            kierownik.dodajPracownika(imie, nazwisko, wyplata, posada);
            clearFields();
            status_zatrudnienia.setText("Pracownik został zatrudniony!");
            pracownicyTable.setItems(getPracownik());
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void clearFields() {
        imieDP.setText(null);
        nazwiskoDP.setText(null);
        wynagrodzenieDP.setText(null);
        cenaP.setText(null);
        nazwaP.setText(null);
        opisP.setText(null);
      //  stanowiskoCombo.getItems().clear();
        

    }

    public void pracownicyTable() {

        imieT.setCellValueFactory(new PropertyValueFactory<>("imie"));
        nazwiskoT.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        stanowiskoT.setCellValueFactory(new PropertyValueFactory<>("stanowisko"));
        stawkaT.setCellValueFactory(new PropertyValueFactory<>("placa"));

        
        pracownicyTable.getItems().setAll(getPracownik());
        pracownicyTable.setRowFactory( tv -> {
    TableRow<Pracownik> row = new TableRow<>();
    row.getContextMenu();
    
    
    
    final ContextMenu contextMenu = new ContextMenu();
            MenuItem del = new MenuItem("Usuń");

            del.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        try {
            KierownikQuery kierownik = new KierownikQuery();
            kierownik.zwolnijPracownika(row.getItem().getPracownikId());
            
          //pracownicyTableZ.setItems(getPracownik());
          pracownicyTable.setItems(getPracownik());
            zwolnieniaStatus.setText("Pracownik został zwolniony!");
             
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



    public void produktyTable() {

        nazwaTD.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        cenaTD.setCellValueFactory(new PropertyValueFactory<>("cenaKupna"));
        opisTD.setCellValueFactory(new PropertyValueFactory<>("opis"));
        

    }
    
    public void magazynTable() {
        
        nazwaProduktu.setCellValueFactory(new PropertyValueFactory<>
        ("ProduktName"));
        cenaSTable.setCellValueFactory(new PropertyValueFactory<>
        ("cenaSprzedazy"));
        iloscTable.setCellValueFactory(new PropertyValueFactory<>("Ilosc"));
      
    }
    
    public void zamowieniaStatusTable (){
        
        id.setCellValueFactory(new PropertyValueFactory<> ("zamowienieId"));
        data.setCellValueFactory(new PropertyValueFactory<> ("Data"));
        zaplata.setCellValueFactory(new PropertyValueFactory<> 
        ("statusZaplaty"));
        transport.setCellValueFactory(new PropertyValueFactory<> 
        ("statusTransportu"));
        
        zamowieniaTable.setItems(zamowienia());
        
    }


    
    public void comboValueProdukty (ComboBox<Produkty> produktyComboTM){
        
        Produkty p = produktyComboTM.getValue();
        int idP = p.getProduktId();
        wczytP.setText(Integer.toString(idP));
        wczytP.setVisible(false);
    }
    
      public void comboValueProduktyK (ComboBox<Produkty> PcomboT){
        
        Produkty p = PcomboT.getValue();
        int idPa = p.getProduktId();
        pro.setText(Integer.toString(idPa));
        pro.setVisible(false);
    }
    
    public void comboValueKT (ComboBox<Kategorie> KcomboT){
        
        Kategorie k = KcomboT.getValue();
        int idKat = k.getKategoriaId();
        kat.setText(Integer.toString(idKat));
        kat.setVisible(false);
        
    }
    
    public void comboValueKTM (ComboBox<Kategorie> katComboTM){
        
        Kategorie k = katComboTM.getValue();
        int idKat = k.getKategoriaId();
        wczytKMCombo.setText(Integer.toString(idKat));
        wczytKMCombo.setVisible(false);
        
    }

    public void comboValueKD(ComboBox<Kategorie> katDcombo) {

        Kategorie k = katDcombo.getValue();
        int idKat = k.getKategoriaId();
        katWybor.setText(Integer.toString(idKat));
        katWybor.setVisible(false);
    }

    public void comboValueK(ComboBox<Kategorie> katCombo) {

        Kategorie k = katCombo.getValue();
        int idKat = k.getKategoriaId();
        wczytajLabel.setText(Integer.toString(idKat));
        wczytajLabel.setVisible(false);
    }
    
    public void comboValueS (ComboBox<Pracownik> stanowiskoCombo){
        Pracownik sp = stanowiskoCombo.getValue();
        String stanowisko = sp.getStanowisko();
        wyborStanowiska.setText(stanowisko);
        wyborStanowiska.setVisible(false);
    }
    
    public void comboStanowisko(){
        
        stanowiskoCombo.setItems(stanowisko());
        stanowiskoCombo.setConverter(new StanowiskoConverter());
        
        stanowiskoCombo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comboValueS(stanowiskoCombo);
            }
        });
        
        
        
    }

    public void comboBoxK() {

        KategorieQuery kategoria = new KategorieQuery();
        
        katDcombo.getItems().addAll(kategoria.KategorieSelectAll());
        katCombo.getItems().addAll(kategoria.KategorieSelectAll());
        katComboTM.getItems().addAll(kategoria.KategorieSelectAll());
        KcomboT.getItems().addAll(kategoria.KategorieSelectAll());

        katDcombo.setConverter(new KategorieConverter());
        katCombo.setConverter(new KategorieConverter());
        katComboTM.setConverter(new KategorieConverter());
        KcomboT.setConverter(new KategorieConverter());

        katCombo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comboValueK(katCombo);

            }
        });

        katDcombo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comboValueKD(katDcombo);

            }
        });
        
        katComboTM.setOnAction(new EventHandler<ActionEvent> () {
             @Override
            public void handle(ActionEvent event) {
                 comboValueKTM(katComboTM);
                 
                 if(!wczytKMCombo.equals("")){
                     int idKategoria = Integer.parseInt(wczytKMCombo.getText());
                      ProduktQuery produkty = new ProduktQuery();
        produktyComboTM.getItems().clear();
        produktyComboTM.getItems().addAll(produkty.
                produktySelectAllOnID(idKategoria));
        produktyComboTM.setConverter(new ProduktyConverter());
         produktyComboTM.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comboValueProdukty(produktyComboTM);

                 }
                });
            }
            }
        });
        
        KcomboT.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
                comboValueKT(KcomboT);
                
             if(!kat.equals("")){   
          int Kategoria = Integer.parseInt(kat.getText());        
        ProduktQuery p = new ProduktQuery();
        
        PcomboT.getItems().addAll(p.produktySelectAllOnID(Kategoria));
        PcomboT.setConverter(new ProduktyConverter());
        
        PcomboT.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comboValueProduktyK(PcomboT);
          }
                });
            }
            }
        });
        

    }

    @FXML
    private void dodajProdukt(ActionEvent event) {

        int idKategorii = Integer.parseInt(katWybor.getText());
        String nazwa = nazwaP.getText();
        float cena = Float.parseFloat(cenaP.getText());
        String opis = opisP.getText();

        try {
            KierownikQuery kierownik = new KierownikQuery();
            kierownik.dodajProdukt(nazwa, cena, opis, idKategorii);
            statusDodajP.setText("Produkt został dodany do danej kategorii");
            clearFields();
            produktyTable();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }


    public void wyszukaj(ObservableList<Pracownik> getPracownik) {
        FilteredList<Pracownik> filtrData = new FilteredList<>(getPracownik(),
                p -> true);

        wyszukajField.textProperty().addListener((observable, oldValue,
                newValue) -> {
            filtrData.setPredicate(pracownik -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (pracownik.getStanowisko().toLowerCase().
                        contains(lowerCaseFilter)) {
                    return true;
                }

                return false; // Does not match.
            });
        });

        SortedList<Pracownik> sortedData = new SortedList<>(filtrData);

        sortedData.comparatorProperty().bind(pracownicyTable.
                comparatorProperty());
        pracownicyTable.setItems(sortedData);
    }

    @FXML
    private void wczytajDane(ActionEvent event) {

        int idKat = Integer.parseInt(wczytajLabel.getText());

        ProduktQuery produkt = new ProduktQuery();

        try {
            produktyD.getItems().setAll(produkt.produktySelectAllOnID(idKat));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @FXML
    private void dodajNaMagazyn(ActionEvent event) {
        
        int idP = Integer.parseInt(wczytP.getText());
        float cenaS = Float.parseFloat(cenaST.getText());
        int ilosc = Integer.parseInt(iloscT.getText());
        
        try{
            KierownikQuery kierownik = new KierownikQuery();
            kierownik.dodajProduktNaMagazyn(ilosc, cenaS, idP);
            magazyn_status.setText("Produkt został dodany na magazyn!");
            cenaST.setText(null);
            iloscT.setText(null);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void wczytajTabele(ActionEvent event) {
        
        int idP = Integer.parseInt(pro.getText());

        MagazynQuery magazyn = new MagazynQuery();

        try {
            towary.getItems().setAll(magazyn.produktySelectAllOnID(idP));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
