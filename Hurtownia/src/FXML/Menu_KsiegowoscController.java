/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXButton;
import hibernate.Pracownik;
import hibernate.PracownikQuery;
import hibernate.Wyplaty;
import hibernate.WyplatyQuery;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class Menu_KsiegowoscController extends Logowanie implements Initializable {
   
    @FXML
    private TableView<Pracownik> pracownicyTableP;

    @FXML
    private TableColumn<Pracownik, Integer> id;

    @FXML
    private TableColumn<Pracownik, String> imieP;

    @FXML
    private TableColumn<Pracownik, String> nazwiskoP;

    @FXML
    private TableColumn<Pracownik, String> stanowiskoP;

    @FXML
    private TableColumn<Pracownik, Float> placa;
    
    @FXML
    private TableView<Wyplaty> payCheckTable;
    
    @FXML
    private TableColumn<Wyplaty, Float> payCheck;
    
    @FXML
    private TableColumn<Wyplaty, Integer> idPrac;
    
    @FXML
    private TableColumn<Wyplaty, Date> payDate;
    
    @FXML
    private TextField szukajID1;

    @FXML
    private JFXButton wylogujP;

    @FXML
    private TextField idP;

    @FXML
    private DatePicker data;

    @FXML
    private TextField kwota;

    @FXML
    private TextField szukajID;

    @FXML
    private JFXButton wylogujDW;

    @FXML
    void wyloguj(ActionEvent event) {
        
        String ksiegi = "/FXML/Login.fxml";
        wczytywanie(event, ksiegi);
        ramka(event);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pracownicyTableP();
        payCheckTable();
        wyszukajPracownika(getPracownik());
    }    
    
        public ObservableList<Pracownik> getPracownik() {
        ObservableList<Pracownik> listaPracownikow = FXCollections.
                observableArrayList();
        Session session = hibernate.HibernateUtil.getSessionFactory().
                openSession();
        List<Pracownik> pList = session.createCriteria(Pracownik.class).list();

        for (Pracownik w : pList) {
            listaPracownikow.add(w);

        }
        return listaPracownikow;
    }
        
        public ObservableList<Wyplaty> getWyplaty() {
        ObservableList<Wyplaty> listaWyplat = FXCollections.
                observableArrayList();
        Session session = hibernate.HibernateUtil.getSessionFactory().
                openSession();
        List<Wyplaty> pList = session.createCriteria(Wyplaty.class).list();

        for (Wyplaty w : pList) {
            listaWyplat.add(w);

        }
        return listaWyplat;
    }
        
    public void pracownicyTableP() {

        id.setCellValueFactory(new PropertyValueFactory<>("pracownikId"));
        imieP.setCellValueFactory(new PropertyValueFactory<>("imie"));
        nazwiskoP.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        stanowiskoP.setCellValueFactory(new PropertyValueFactory<>
        ("stanowisko"));
        placa.setCellValueFactory(new PropertyValueFactory<>("placa"));
        
        PracownikQuery pracownik = new PracownikQuery();
        pracownicyTableP.getItems().setAll(pracownik.PracownikSelectAll());
     
    }
    
        public void payCheckTable() {

        idPrac.setCellValueFactory(new PropertyValueFactory<>("pracownikID"));
        payDate.setCellValueFactory(new PropertyValueFactory<>("data"));
        payCheck.setCellValueFactory(new PropertyValueFactory<>("kwota"));
        
        WyplatyQuery wyplaty = new WyplatyQuery();
        payCheckTable.getItems().setAll(wyplaty.WyplatySelectAll());
     
    }
        
    public void wyszukajPracownika(ObservableList<Pracownik> getPracownik) {
        FilteredList<Pracownik> filtrData = new FilteredList<>(getPracownik(),
                p -> true);

        szukajID1.textProperty().addListener((observable, oldValue,
                newValue) -> {
            filtrData.setPredicate(pracownik -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

              String lowerCaseFilter = newValue.toLowerCase();

                if (pracownik.getPracownikId().toString().
                        contains(lowerCaseFilter)) {
                    return true;
                }

                
                return false; // Does not match.
            });
        });

        SortedList<Pracownik> sortedData = new SortedList<>(filtrData);

        sortedData.comparatorProperty().bind(pracownicyTableP.
                comparatorProperty());
        pracownicyTableP.setItems(sortedData);
    }

    
}
