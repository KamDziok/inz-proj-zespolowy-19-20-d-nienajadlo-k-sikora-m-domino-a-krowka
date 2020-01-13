/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import hibernate.HibernateUtil;
import hibernate.Kategorie;
import hibernate.KategorieConverter;
import hibernate.KategorieQuery;
import hibernate.KierownikQuery;
import hibernate.Pracownik;
import hibernate.PracownikConverter;
import hibernate.PracownikQuery;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class Menu_KierownikController extends Logowanie implements Initializable {

    @FXML
    private TableView<?> zamowieniaTable;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> dane;

    @FXML
    private TableColumn<?, ?> kategoria;

    @FXML
    private TableColumn<?, ?> produkt;

    @FXML
    private TableColumn<?, ?> ilosc;

    @FXML
    private TableColumn<?, ?> cena;

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
    private TableView<?> produktyD;

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
    private JFXTextField stanowiskoDP;
    @FXML
    private JFXTextField wynagrodzenieDP;
    @FXML
    private Button DodajP;
    @FXML
    private Label status_zatrudnienia;
    @FXML
    private Label pracownikLabel;
    @FXML
    private TableView<Pracownik> pracownicyTableZ;
    @FXML
    private TableColumn<Pracownik, Integer> idZw;
    @FXML
    private TableColumn<Pracownik, String> imieZw;
    @FXML
    private TableColumn<Pracownik, String> nazwiskoZ;
    @FXML
    private TableColumn<Pracownik, String> stanowiskoZ;
    @FXML
    private TableColumn<Pracownik, Float> stawkaZ;
    @FXML
    private TextField IdUsuntxt;
    @FXML
    private Button zwolnijP;
    @FXML
    private JFXButton wylogujKPr1;
    @FXML
    private Label zwolnienieStatus;
    @FXML
    private Label wyborCombo;
    @FXML
    private Label katWybor;
    @FXML
    private Label statusDodajP;
    @FXML
    private TextField wyszukajField;
    @FXML
    private TextField wyszukajFileldZ;

    @FXML
    void wyloguj(ActionEvent event) {

        String wylogowywanie = "/FXML/Login.fxml";
        wczytywanie(event, wylogowywanie);
        ramka(event);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        pracownicyTable();
        pracownicyTableZ(); // wyświetlenie wszystkich pracowników
        comboBoxK();
        wyszukaj(getPracownik());
        wyszukajZwolnienia(getPracownik());

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
    

    @FXML
    private void Dodaj_Pracownika(ActionEvent event) {

        String imie = imieDP.getText();
        String nazwisko = nazwiskoDP.getText();
        float wyplata = Float.parseFloat(wynagrodzenieDP.getText());
        String posada = stanowiskoDP.getText();

        try {
            KierownikQuery kierownik = new KierownikQuery();
            kierownik.dodajPracownika(imie, nazwisko, wyplata, posada);
            clearFields();
            status_zatrudnienia.setText("Pracownik został zatrudniony!");
            pracownicyTable();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void clearFields() {
        imieDP.setText(null);
        nazwiskoDP.setText(null);
        wynagrodzenieDP.setText(null);
        stanowiskoDP.setText(null);
        cenaP.setText(null);
        nazwaP.setText(null);
        opisP.setText(null);

    }

    public void pracownicyTable() {

        imieT.setCellValueFactory(new PropertyValueFactory<>("imie"));
        nazwiskoT.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        stanowiskoT.setCellValueFactory(new PropertyValueFactory<>
        ("stanowisko"));
        stawkaT.setCellValueFactory(new PropertyValueFactory<>("placa"));
        
        pracownicyTableZ.setItems(getPracownik());
        
    }

    public void pracownicyTableZ() {

        idZw.setCellValueFactory(new PropertyValueFactory<>("pracownikId"));
        imieZw.setCellValueFactory(new PropertyValueFactory<>("imie"));
        nazwiskoZ.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        stanowiskoZ.setCellValueFactory(new PropertyValueFactory<>
        ("stanowisko"));
        stawkaZ.setCellValueFactory(new PropertyValueFactory<>("placa"));

        pracownicyTableZ.setItems(getPracownik());

    }

    @FXML
    private void zwolnijPracownika(ActionEvent event) {

        int id = Integer.parseInt(IdUsuntxt.getText());

        try {
            KierownikQuery kierownik = new KierownikQuery();
            kierownik.zwolnijPracownika(id);
            zwolnienieStatus.setText("Pracownik został zwolniony!");
            IdUsuntxt.setText(null);
            pracownicyTableZ();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

  
      public void comboValueK(ComboBox<Kategorie> katDcombo){

       Kategorie k = katDcombo.getValue();
       int idKat = k.getKategoriaId();
       katWybor.setText(Integer.toString(idKat));
       katWybor.setVisible(false);
}

    
    public void comboBoxK() {
        
        KategorieQuery kategoria = new KategorieQuery();
        katDcombo.getItems().addAll(kategoria.KategorieSelectAll());
        katCombo.getItems().addAll(kategoria.KategorieSelectAll());
        
        katDcombo.setConverter(new KategorieConverter());
        katCombo.setConverter(new KategorieConverter());
        
        katCombo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comboValueK(katCombo);
                
            }
        });
        
      katDcombo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comboValueK(katDcombo);
                
            }
        });
    

}
    @FXML
    private void dodajProdukt(ActionEvent event) {
        
        int idKategorii = Integer.parseInt(katWybor.getText());
        String nazwa = nazwaP.getText();
        float cena = Float.parseFloat(cenaP.getText());
        String opis = opisP.getText();
        
        try{
            KierownikQuery kierownik = new KierownikQuery();
            kierownik.dodajProdukt(nazwa, cena, opis, idKategorii);
            statusDodajP.setText("Produkt został dodany do danej kategorii");
            clearFields();
            
        }catch (Exception e) {
            
            System.out.println(e.getMessage());
            
        }
        
    }

    public void wyszukajZwolnienia (ObservableList<Pracownik> getPracownik){
        FilteredList<Pracownik> filtrData = new FilteredList<>(getPracownik(), 
        p -> true);
        
          wyszukajFileldZ.textProperty().addListener((observable, oldValue, newValue) -> {
            filtrData.setPredicate(pracownik -> {
               
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                String lowerCaseFilter = newValue.toLowerCase();
                
                if (pracownik.getStanowisko().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                } 
                  
                return false; // Does not match.
            });
        });
        
        SortedList<Pracownik> sortedData = new SortedList<>(filtrData);
     
        sortedData.comparatorProperty().bind(pracownicyTableZ.comparatorProperty());
       pracownicyTableZ.setItems(sortedData);
    }
    
    public void wyszukaj (ObservableList<Pracownik> getPracownik){
        FilteredList<Pracownik> filtrData = new FilteredList<>(getPracownik(), 
        p -> true);
        
          wyszukajField.textProperty().addListener((observable, oldValue, newValue) -> {
            filtrData.setPredicate(pracownik -> {
               
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                String lowerCaseFilter = newValue.toLowerCase();
                
                if (pracownik.getStanowisko().toLowerCase().contains(lowerCaseFilter)) {
                    return true; 
                } 
                  
                return false; // Does not match.
            });
        });
        
        SortedList<Pracownik> sortedData = new SortedList<>(filtrData);
     
        sortedData.comparatorProperty().bind(pracownicyTable.comparatorProperty());
       pracownicyTable.setItems(sortedData);
    }
}
        
    

