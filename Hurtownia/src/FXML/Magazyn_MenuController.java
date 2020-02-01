/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import hibernate.Kategorie;
import hibernate.Magazyn;
import hibernate.MagazynQuery;
import hibernate.Towaryzamowienie;
import hibernate.Zamowienie;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class Magazyn_MenuController extends Logowanie implements Initializable {

 
    
    
    // Zakładka produktów na magazynie
    @FXML
    private TableView<Magazyn> towaryMagazyn;
    @FXML
    private TableColumn<Magazyn, Integer> produktID;
    @FXML
    private TableColumn<Magazyn, Integer> iloscProdukt;
    @FXML
    private TableColumn<Magazyn, String> produktNazwa;
    
    
    
    
    // Zakładka Wyślij Towar
    @FXML
    private TableView<Zamowienie> zamowienia;
    @FXML
    private TableColumn<Zamowienie, Integer> idZamowienia;
    @FXML
    private TableColumn<Zamowienie, String> statusTransportu;
    
    // Zakładka Zwrot towaru Towar
    @FXML
    private TableView<Zamowienie> zwroty;
    @FXML
    private TableColumn<Zamowienie, Integer> idZamowieniaZwrot;
    @FXML
    private TableColumn<Zamowienie, String> statusTransportuZwrot;
    
    

    @FXML
    void wyloguj(ActionEvent event) {

        String wylogowanie = "/FXML/Login.fxml";
        wczytywanie(event, wylogowanie);
        ramka(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        statusZamowienTable();
        statusZwrotTable();
        setTowaryMagazynTable();
    }
    
     public ObservableList<Magazyn> getMagazyn() {
        ObservableList<Magazyn> maga = FXCollections.
                observableArrayList();
        Session session = hibernate.HibernateUtil.getSessionFactory().
                openSession();
        List<Magazyn> pList = session.createCriteria(Magazyn.class).list();

        for (Magazyn m : pList) {
            maga.add(m);

        }
        return maga;
    }
     
     
     
    public void setTowaryMagazynTable() {
        produktID.setCellValueFactory(new PropertyValueFactory<>("ProductId"));
        iloscProdukt.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
        produktNazwa.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        towaryMagazyn.setItems(getMagazyn());
    } 
     
     
    
    public void statusZamowienTable() {

        idZamowienia.setCellValueFactory(new PropertyValueFactory<>("ZamowienieId"));
        statusTransportu.setCellValueFactory(new PropertyValueFactory<>("statusTransportu"));

        zamowienia.setItems(getNieWyslaneZamowienia());
        zamowienia.setRowFactory( tv -> {
            TableRow<Zamowienie> row = new TableRow<>();
            row.getContextMenu();
            final ContextMenu contextMenu = new ContextMenu();
                    MenuItem tow = new MenuItem("Wyświetl dane");
                    MenuItem send = new MenuItem("Wyślij towar");
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
            send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
                public void handle(ActionEvent event) {
                    try {
                        MagazynQuery mg = new MagazynQuery();
                        mg.wyslijZamowienie(row.getItem().getZamowienieId());
                        statusZamowienTable();
                        setTowaryMagazynTable();

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
            });
                contextMenu.getItems().addAll(tow , send);
                
                
            row.setContextMenu(contextMenu);
            return row ;
        });

    }
     
    
    public void statusZwrotTable() {

        idZamowieniaZwrot.setCellValueFactory(new PropertyValueFactory<>("ZamowienieId"));
        statusTransportuZwrot.setCellValueFactory(new PropertyValueFactory<>("statusTransportu"));

        zwroty.setItems(getZwroty());
        zwroty.setRowFactory( tv -> {
            TableRow<Zamowienie> row = new TableRow<>();
            row.getContextMenu();
            final ContextMenu contextMenu = new ContextMenu();
                    MenuItem tow = new MenuItem("Wyświetl dane");
                    MenuItem send = new MenuItem("Odbierz towar");
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
            send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
                public void handle(ActionEvent event) {
                    try {
                        MagazynQuery mg = new MagazynQuery();
                        mg.odbierzZwrot(row.getItem().getZamowienieId());
                        statusZwrotTable();
                        setTowaryMagazynTable();

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
            });
                contextMenu.getItems().addAll(tow , send);
                
                
            row.setContextMenu(contextMenu);
            return row ;
        });

    }
    
    public ObservableList<Zamowienie> getNieWyslaneZamowienia() {
        ObservableList<Zamowienie> listaZamowien = FXCollections.
                observableArrayList();
        Session session = hibernate.HibernateUtil.getSessionFactory().
                openSession();
        List<Zamowienie> pList = session.createCriteria(Zamowienie.class).list();

        for (Zamowienie z : pList) {
            if(z.getStatusTransportu().equals("w trakcie realizacji"))
            listaZamowien.add(z);

        }
        return listaZamowien;
    }
    public ObservableList<Zamowienie> getZwroty() {
        ObservableList<Zamowienie> listaZamowien = FXCollections.
                observableArrayList();
        Session session = hibernate.HibernateUtil.getSessionFactory().
                openSession();
        List<Zamowienie> pList = session.createCriteria(Zamowienie.class).list();

        for (Zamowienie z : pList) {
            if(z.getStatusTransportu().equals("zwrot"))
            listaZamowien.add(z);

        }
        
        return listaZamowien;
    }
    

}
