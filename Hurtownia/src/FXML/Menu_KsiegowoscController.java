/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Utils.Popup;
import com.jfoenix.controls.JFXButton;
import hibernate.KierownikQuery;
import hibernate.KsiegowoscQuery;
import hibernate.Pracownik;
import hibernate.PracownikConverter;
import hibernate.PracownikQuery;
import hibernate.Towaryzamowienie;
import hibernate.Wyplaty;
import hibernate.WyplatyPracownik;
import hibernate.WyplatyQuery;
import hibernate.Zamowienie;
import hibernate.ZamowienieQuery;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import static javafx.scene.input.KeyCode.S;
import javafx.stage.Stage;

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
    private TableView<WyplatyPracownik> payCheckTable;
    
    @FXML
    private TableColumn<WyplatyPracownik, Float> payCheck;
    
    
    @FXML
    private TableColumn<WyplatyPracownik, Date> payDate;
    
    @FXML
    private TableColumn<WyplatyPracownik, String> payCheckEmployeeName;
    
    @FXML
    private TextField szukajID1;

    @FXML
    private JFXButton wylogujP;



    @FXML
    private JFXButton wylogujDW; 

    @FXML
    private TableView<Zamowienie> zamowienieFaktura;
    @FXML
    private TableColumn<Zamowienie, Integer> idZamowienia;
    @FXML
    private TableColumn<Zamowienie, Date> dataZamowienia;
    @FXML
    private TableColumn<Zamowienie, String> statusZaplaty;
    @FXML
    private TableColumn<Zamowienie, Float> kosztZamowienia;

    @FXML
    private TableView<Zamowienie> zamowienieZwrot;
    @FXML
    private TableColumn<Zamowienie, Integer> idZamowieniaZwrot;
    @FXML
    private TableColumn<Zamowienie, Date> dataZamowieniaZwrot;
    @FXML
    private TableColumn<Zamowienie, String> statusZaplatyZwrot;
    @FXML
    private TableColumn<Zamowienie, Float> kosztZamowieniaZwrot;
    @FXML
    private TableColumn<Zamowienie, Integer> idZam;

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
        comboPracownik();
        fakturyTable();
        zwrotTable();
        
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
        
         public ObservableList<Zamowienie> zaplata(String status) {
        ObservableList<Zamowienie> zam = FXCollections.
                observableArrayList();
        Session session = hibernate.HibernateUtil.getSessionFactory().
                openSession();
        List<Zamowienie> pList = session.createCriteria(Zamowienie.class).list();

        for (Zamowienie z : pList) {
            if(status.equals("faktura") 
                    && !z.getStatusZaplaty().equals("anulowane") 
                     && !z.getStatusZaplaty().equals("zwrot"))
                zam.add(z);
                
            
                else if (status.equals("zwrot") && z.getStatusZaplaty().equals("zwrot") )
                    zam.add(z);
                

        }
        return zam;
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
    
      public void fakturyTable() {

        idZamowienia.setCellValueFactory(new PropertyValueFactory<>("zamowienieId"));
        dataZamowienia.setCellValueFactory(new PropertyValueFactory<>("data"));
        statusZaplaty.setCellValueFactory(new PropertyValueFactory<>("statusZaplaty"));
        kosztZamowienia.setCellValueFactory(new PropertyValueFactory<>("koszt"));
        
        zamowienieFaktura.getItems().setAll(zaplata("faktura"));
        zamowienieFaktura.setRowFactory(tv -> {
            TableRow<Zamowienie> row = new TableRow<>();
            row.getContextMenu();
            
              final ContextMenu contextMenu = new ContextMenu();
            MenuItem faktura = new MenuItem("Wystaw fakture");

            faktura.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        try {
            KsiegowoscQuery ksiegowosc = new KsiegowoscQuery();
            ksiegowosc.pobierzFakture(Integer.toString(row.getItem().getZamowienieId()));
            
             
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
        });
            contextMenu.getItems().addAll(faktura);

row.setContextMenu(contextMenu);
    
            return row;
                
        });
    
                }
    
      public void zwrotTable() {

        idZamowieniaZwrot.setCellValueFactory(new PropertyValueFactory<>("zamowienieId"));
        dataZamowieniaZwrot.setCellValueFactory(new PropertyValueFactory<>("data"));
        statusZaplatyZwrot.setCellValueFactory(new PropertyValueFactory<>("statusZaplaty"));
        kosztZamowieniaZwrot.setCellValueFactory(new PropertyValueFactory<>("koszt"));
        
        zamowienieZwrot.getItems().setAll(zaplata("zwrot"));
        zamowienieZwrot.setRowFactory(tv -> {
            TableRow<Zamowienie> row = new TableRow<>();
            row.getContextMenu();
            
              final ContextMenu contextMenu = new ContextMenu();
            MenuItem zwrot = new MenuItem("Zwróć pieniądze");

            zwrot.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        try {
            new KsiegowoscQuery().odbierzZwrot(row.getItem());
            zwrotTable();
            
             
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
        });
            contextMenu.getItems().addAll(zwrot);

row.setContextMenu(contextMenu);
    
            return row;
                
        });
    
                }
    
      
    
        public void payCheckTable() {
        payDate.setCellValueFactory(new PropertyValueFactory<>("data"));
        payCheck.setCellValueFactory(new PropertyValueFactory<>("kwota"));
        payCheckEmployeeName.setCellValueFactory(new PropertyValueFactory<>("pracownikName"));
        payCheckTable.getItems().setAll(new KsiegowoscQuery().wszystkieWyplaty());
        payCheckTable.setRowFactory( tv -> {
    TableRow<WyplatyPracownik> row = new TableRow<>();
    row.getContextMenu();
    
    
    
    final ContextMenu contextMenu = new ContextMenu();
            MenuItem pay = new MenuItem("Zapłać");
            

            pay.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        try {
             int wyplataID = row.getItem().getWyplataId();
             new WyplatyQuery().wyplacDlaKlienta(wyplataID);
             payCheckTable();
             Popup.show("Wypłata zapłacona dla: " + row.getItem().pracownikName);
             
             
        } catch (Exception e) {
            Popup.show("Problem z wypłaceniem wypłaty");
        }
        
    }
});
            
            contextMenu.getItems().addAll(pay);

row.setContextMenu(contextMenu);
    
    return row ;
});
        
     
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
                        contains(lowerCaseFilter) 
                        || pracownik.getImie().toLowerCase().contains(lowerCaseFilter) 
                        || pracownik.getNazwisko().toLowerCase().contains(lowerCaseFilter)
                        || pracownik.getStanowisko().toLowerCase().contains(lowerCaseFilter)
                        || pracownik.getImieNazwisko().toLowerCase().contains(lowerCaseFilter)
                        || pracownik.getNazwiskoImie().toLowerCase().contains(lowerCaseFilter)){
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

   
    
    public void comboPracownik(){
        
        PracownikQuery praca = new PracownikQuery();
        
    }
    
    public void comboValueP (ComboBox <Pracownik> szukajPracownikaCombo){
        
        Pracownik p = szukajPracownikaCombo.getValue();
        int PracownikId = p.getPracownikId();
    }
//    }

    @FXML
    private void wyszukajPracownikaPoID(ActionEvent event) {
//         int idPracownika = Integer.parseInt(pracownikIDLabel.getText());
        
        WyplatyQuery wyplata = new WyplatyQuery();
        
        try{
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    @FXML
    private void zaplacWynagrodzenie(ActionEvent event){
// int id = Integer.parseInt(idPracownika.getText());
      try{
        List<Wyplaty> wyplaty  = new WyplatyQuery().WyplatySelectAll();
        
        for (Wyplaty wyplata : wyplaty){
            new WyplatyQuery().wyplacDlaKlienta(wyplata.getWyplataId());
             Popup.show("Wypłacono Wynagrodzenia wszystkim pracownikom.");
        
        }
      }catch(Exception e){
          
             Popup.show("Problem z wypłaceniem wynagrodzeń.");
               }
        
    }
    


    @FXML
    private void onEditChange(TableColumn.CellEditEvent<Zamowienie, String> event) {
//        Zamowienie zam = zaplateTable.getSelectionModel().getSelectedItem();
//        zam.setStatusZaplaty(event.getNewValue());
    }

    
}
