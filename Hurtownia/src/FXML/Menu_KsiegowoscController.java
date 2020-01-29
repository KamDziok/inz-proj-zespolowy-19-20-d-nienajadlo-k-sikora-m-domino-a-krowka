/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXButton;
import hibernate.KsiegowoscQuery;
import hibernate.Pracownik;
import hibernate.PracownikConverter;
import hibernate.PracownikQuery;
import hibernate.Towaryzamowienie;
import hibernate.Wyplaty;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import static javafx.scene.input.KeyCode.S;

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
    private TableColumn<Wyplaty, Date> payDate;
    
    @FXML
    private TextField szukajID1;

    @FXML
    private JFXButton wylogujP;


    @FXML
    private DatePicker data;

    @FXML
    private TextField kwota;


    @FXML
    private JFXButton wylogujDW;
    @FXML
    private ComboBox<Pracownik> szukajPracownikaCombo;
    @FXML
    private Button wyszukajPracownikaID;
    @FXML
    private Label pracownikIDLabel;
    @FXML
    private ComboBox<Pracownik> pracownikCombo;
    @FXML
    private Label idPracownika;
    
    @FXML
    private Label labelID;
    
    @FXML
    private TableColumn<Integer, Towaryzamowienie> idZamowienia;
    @FXML
    private TableColumn<Integer, Towaryzamowienie> ilosc;
    @FXML
    private TableColumn<Float, Towaryzamowienie> koszt;
    @FXML
    private JFXButton wylogujDW1;
    @FXML
    private TableView<Towaryzamowienie> zamowienieFaktura;
    @FXML
    private TableView<Zamowienie> zaplateTable;
    @FXML
    private TableColumn<Zamowienie, String> statusZaplaty;
    @FXML
    private JFXButton wylogujDW11;
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
        statusZaplaty ();
        fakturyTable();
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
        
         public ObservableList<Zamowienie> zaplata() {
        ObservableList<Zamowienie> zam = FXCollections.
                observableArrayList();
        Session session = hibernate.HibernateUtil.getSessionFactory().
                openSession();
        List<Zamowienie> pList = session.createCriteria(Zamowienie.class).list();

        for (Zamowienie z : pList) {
            zam.add(z);

        }
        return zam;
    }
       
        
        public ObservableList<Towaryzamowienie> getTowary() {
        ObservableList<Towaryzamowienie> listaZamowienia = FXCollections.
                observableArrayList();
        Session session = hibernate.HibernateUtil.getSessionFactory().
                openSession();
        List<Towaryzamowienie> pList = session.
                createCriteria(Towaryzamowienie.class).list();

        for (Towaryzamowienie t : pList) {
            listaZamowienia.add(t);

        }
        return listaZamowienia;
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

        idZamowienia.setCellValueFactory(new PropertyValueFactory<>("zamowienieID"));
        ilosc.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
        koszt.setCellValueFactory(new PropertyValueFactory<>("koszt"));
        
        zamowienieFaktura.getItems().setAll(getTowary());
        zamowienieFaktura.setRowFactory(tv -> {
            TableRow<Towaryzamowienie> row = new TableRow<>();
            row.getContextMenu();
            
              final ContextMenu contextMenu = new ContextMenu();
            MenuItem faktura = new MenuItem("Wystaw fakture");

            faktura.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        try {
            KsiegowoscQuery ksiegowosc = new KsiegowoscQuery();
            ksiegowosc.pobierzFakture(Integer.toString(row.getItem().
                    getZamowienieID()));
            
             
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
    
      
    
        public void payCheckTable() {
        payDate.setCellValueFactory(new PropertyValueFactory<>("data"));
        payCheck.setCellValueFactory(new PropertyValueFactory<>("kwota"));
        
     
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

   
    
    public void comboPracownik(){
        
        PracownikQuery praca = new PracownikQuery();
        
        szukajPracownikaCombo.getItems().addAll(praca.PracownikSelectAll());
        szukajPracownikaCombo.setConverter(new PracownikConverter());
        pracownikCombo.getItems().addAll(praca.PracownikSelectAll());
        pracownikCombo.setConverter(new PracownikConverter());
        
        pracownikCombo.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                comboValuePD(pracownikCombo);
            }
            
        });
        
        szukajPracownikaCombo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comboValueP(szukajPracownikaCombo);
            }
            
        });
    }
    
    public void comboValueP (ComboBox <Pracownik> szukajPracownikaCombo){
        
        Pracownik p = szukajPracownikaCombo.getValue();
        int PracownikId = p.getPracownikId();
        pracownikIDLabel.setText(Integer.toString(PracownikId));
        pracownikIDLabel.setVisible(false);
    }
    
    public void comboValuePD (ComboBox <Pracownik> pracownikCombo){
        
        Pracownik p = pracownikCombo.getValue();
        int PracownikId = p.getPracownikId();
        idPracownika.setText(Integer.toString(PracownikId));
        idPracownika.setVisible(false);
       labelID.setText(Integer.toString(PracownikId));
       labelID.setVisible(false);
    }

    @FXML
    private void wyszukajPracownikaPoID(ActionEvent event) {
         int idPracownika = Integer.parseInt(pracownikIDLabel.getText());
        
        WyplatyQuery wyplata = new WyplatyQuery();
        
        try{
            payCheckTable.getItems().setAll(wyplata.wyplatyID(idPracownika));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    @FXML
    private void dodajWyplate(ActionEvent event){
 //INSERT INTO `wyplaty` (`WyplataID`, `Data`, `Kwota`, `PracownikID`) VALUES (NULL, '2020-01-21', '1299', '3');
 //SET @p0='1500'; SET @p1='3'; CALL `dodajWyplate`(@p0, @p1);
//valueStr = valueStr.replace(',', '.');        
 float wyplataKwota = Float.parseFloat(kwota.getText().replace(',', '.'));
 int id = Integer.parseInt(idPracownika.getText());
      WyplatyQuery wyplataa = new WyplatyQuery();
      try{
       wyplataa.dodajWyplate(wyplataKwota, id);
       System.out.println("Wyplata run");
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Wyplata dodana!");
            alert.showAndWait();
      }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Wyplata error!");
            Alert alert2 = new Alert(Alert.AlertType.WARNING);
            alert2.setTitle("Informacja");
            alert2.setHeaderText(null);
            alert2.setContentText("Coś jest nie tak...");
            alert2.showAndWait();
               }
        
    }
    
    public void statusZaplaty (){
        
        idZam.setCellValueFactory(new PropertyValueFactory<>("ZamowienieId"));
        statusZaplaty.setCellValueFactory
       (new PropertyValueFactory<>("statusZaplaty"));
         zaplateTable.getItems().setAll(zaplata());
         
           zaplateTable.setEditable(true);
           statusZaplaty.setCellFactory(TextFieldTableCell.forTableColumn());
           zaplateTable.setRowFactory( tv -> {
    TableRow<Zamowienie> row = new TableRow<>();
    row.getContextMenu();
    
    
    
    final ContextMenu contextMenu = new ContextMenu();
            MenuItem change = new MenuItem("Zmien status");

           change.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        try {
            ZamowienieQuery zamow = new ZamowienieQuery();
            zamow.changeStatus(row.getItem().getZamowienieId(), row.getItem().getStatusZaplaty());
            
            zaplateTable.setItems(zaplata());
        
             
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
});
contextMenu.getItems().addAll(change);

row.setContextMenu(contextMenu);
    
    return row ;
});
        
        
    }

    @FXML
    private void onEditChange(TableColumn.CellEditEvent<Zamowienie, String> event) {
        Zamowienie zam = zaplateTable.getSelectionModel().getSelectedItem();
        zam.setStatusZaplaty(event.getNewValue());
    }

    
}
