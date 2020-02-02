/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Utils.Popup;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import hibernate.StanowiskoConverter;
import hibernate.HibernateUtil;
import hibernate.Magazyn;
import hibernate.Kategorie;
import hibernate.KategorieConverter;
import hibernate.KategorieQuery;
import hibernate.KierownikQuery;
import hibernate.Pracownik;
import hibernate.ProduktQuery;
import hibernate.Produkty;
import hibernate.ProduktyConverter;
import hibernate.Zamowienie;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.stage.Stage;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
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
    private TextField nazwaP;
    @FXML
    private TextArea opisP;
    @FXML
    private TextField cenaP;
    @FXML
    private TableView<Produkty> produktyD;
    @FXML
    private ComboBox<Kategorie> katDcombo;
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
    private Label katWybor;
    @FXML
    private Label statusDodajP;
    @FXML
    private TextField wyszukajField;
    @FXML
    private TableColumn<Produkty, String> nazwaTD;
    @FXML
    private TableColumn<Produkty, Float> cenaTD;
    @FXML
    private TableColumn<Produkty, String> opisTD;
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
    private TextField nowaKategoria;
    @FXML
    private Label magazyn_status;
    @FXML
    private TableView<Magazyn> tabelaMagazyn;
    @FXML
    private TableColumn<Magazyn, Float> cenaSTable;
    @FXML
    private TableColumn<Magazyn, Integer> iloscTable;
    @FXML
    private TableColumn<Zamowienie, Date> data;
    @FXML
    private TableColumn<Zamowienie, Float> cenaZakupuMagazyn;
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
    private TextArea kategoriaOpis;
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
        
        cenaST.setPromptText("Zmień Cenę");
        

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
        crit.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
        List <Pracownik> stanowisko = crit.list();
        
        Boolean kierownik = false;
        Boolean magazynier = false;
        Boolean ksiegowa = false;
                
        for (Pracownik s : stanowisko) {
            if(s.getStanowisko().equals("kierownik") && !kierownik){
               stanowiskoP.add(s);
               kierownik = !kierownik;
            }
            
            if(s.getStanowisko().equals("ksiegowa") && !ksiegowa){
               stanowiskoP.add(s);
               ksiegowa = !ksiegowa;
            }
            
            if(s.getStanowisko().equals("magazynier") && !ksiegowa){
               stanowiskoP.add(s);
               magazynier = !magazynier;
            }
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
            long workerId = kierownik.dodajPracownika(imie, nazwisko, wyplata, posada);
            clearFields();
            Popup.show("Pracownik został dodany!");
            pracownicyTable.setItems(getPracownik());
            Popup.show("Kod nowego pracownika to: \n" + workerId);
        } catch (Exception e) {
            Popup.show("Nie można dodać pracownika!");
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
            MenuItem del = new MenuItem("Zwolnij Pracownika");
            MenuItem salary = new MenuItem("Zmień wynagrodzenie");

            del.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        try {
            KierownikQuery kierownik = new KierownikQuery();
            kierownik.zwolnijPracownika(row.getItem().getPracownikId());
            
          pracownicyTable.setItems(getPracownik());
            zwolnieniaStatus.setText("Pracownik został zwolniony!");
             
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
});
            
            salary.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        try {
            ChangeSalaryWindowController.pracownik = row.getItem();
           Stage PrimaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML"
                + "/ChangeSalaryWindow.fxml"));
            
            Scene scene = new Scene(root);
            PrimaryStage.setScene(scene);
            PrimaryStage.show();
            PrimaryStage.setResizable(false);
             
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
});
contextMenu.getItems().addAll(del , salary);

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
        ("productName"));
        cenaSTable.setCellValueFactory(new PropertyValueFactory<>
        ("cenaSprzedazy"));
        iloscTable.setCellValueFactory(new PropertyValueFactory<>("Ilosc"));
        
        cenaZakupuMagazyn.setCellValueFactory(new PropertyValueFactory<>
        ("cenaZakupu"));
      
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
        if(produktyComboTM.getValue() != null){
        Produkty p = produktyComboTM.getValue();
        int idP = p.getProduktId();
        wczytP.setText(Integer.toString(idP));
        wczytP.setVisible(false);
        }
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
        katDcombo.getItems().clear();
        katDcombo.getItems().addAll(kategoria.KategorieSelectAll());
        katComboTM.getItems().clear();
        katComboTM.getItems().addAll(kategoria.KategorieSelectAll());

        katDcombo.setConverter(new KategorieConverter());
        katComboTM.setConverter(new KategorieConverter());



        katDcombo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comboValueKD(katDcombo);
                produktyD.getItems().clear();
                produktyD.setItems(getTowaryZKategorii(Integer.parseInt(katWybor.getText())));

            }
        });
        
        katComboTM.setOnAction(new EventHandler<ActionEvent> () {
             @Override
            public void handle(ActionEvent event) {
                 comboValueKTM(katComboTM);
                produktyComboTM.getItems().clear();
                 
                 if(!wczytKMCombo.equals("")){
                     int idKategoria = Integer.parseInt(wczytKMCombo.getText());
                     tabelaMagazyn.getItems().clear();
                     tabelaMagazyn.getItems().addAll(getTowaryZMagazynu(idKategoria));
                      ProduktQuery produkty = new ProduktQuery();
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
            
                produktyD.getItems().clear();
                produktyD.setItems(getTowaryZKategorii(Integer.parseInt(katWybor.getText())));
                Popup.show("Produkt został dodany.");

        } catch (Exception e) {
            Popup.show("Nie można dodać produktu!");
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
    private void dodajKategorie(ActionEvent event) {
        comboBoxK();
        new KategorieQuery().nowaKategoria(nowaKategoria.getText() , kategoriaOpis.getText());
        Popup.show("Kategoria została dodana!");
    }
    
    @FXML
    private void dodajNaMagazyn(ActionEvent event) {
        
        int idP = Integer.parseInt(wczytP.getText());
        float cenaS = 0;
        if(!cenaST.getText().equals(""))
            cenaS = Float.parseFloat(cenaST.getText());
        int ilosc = Integer.parseInt(iloscT.getText());
        try{
            System.out.println(cenaS);
            Session session;
            Magazyn magazyn = null;
        session = HibernateUtil.getSessionFactory().openSession();
        String hql = "From Magazyn WHERE ProduktID  = " + idP;
        Query query = session.createQuery(hql);
        magazyn = (Magazyn) query.uniqueResult();
        session.close();
            
            if(cenaS == 0 && magazyn == null)
            {Popup.show("Nowy Produkt - Podaj Cenę");}
            else {
            KierownikQuery kierownik = new KierownikQuery();
            kierownik.dodajProduktNaMagazyn(ilosc, cenaS, idP);
            magazyn_status.setText("Produkt został dodany na magazyn!");
            cenaST.setText(null);
            iloscT.setText(null);
            }
            Popup.show("Dodano na magazyn!");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Popup.show("Nie można dodać na magazyn!");
        }
        
        int idKategoria = Integer.parseInt(wczytKMCombo.getText());
        tabelaMagazyn.getItems().clear();
        tabelaMagazyn.getItems().addAll(getTowaryZMagazynu(idKategoria));
    }

    public ObservableList<Produkty> getTowaryZKategorii(int katID) {
        ObservableList<Produkty> listaZamowien = FXCollections.
        observableArrayList();
        Session session = hibernate.HibernateUtil.getSessionFactory().
        openSession();
        List<Produkty> pList = session.createCriteria(Produkty.class).list();
        for (Produkty z : pList) {
            
            if(katID == z.getKategorie().getKategoriaId())
                listaZamowien.add(z);
            }
        return listaZamowien;
    }
    
    public ObservableList<Magazyn> getTowaryZMagazynu(int katID) {
        ObservableList<Magazyn> listaZamowien = FXCollections.
                observableArrayList();
        Session session = hibernate.HibernateUtil.getSessionFactory().
                openSession();
        List<Magazyn> pList = session.createCriteria(Magazyn.class).list();

        for (Magazyn z : pList) {
            
            if(katID == z.getProdukty().getKategorie().getKategoriaId())
                listaZamowien.add(z);
            }
                

        
        return listaZamowien;
    }

}



// wczytKMCombo wartość kategori 