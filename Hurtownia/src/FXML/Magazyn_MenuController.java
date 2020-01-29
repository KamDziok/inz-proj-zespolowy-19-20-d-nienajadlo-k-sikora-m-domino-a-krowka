/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXButton;
import hibernate.Kategorie;
import hibernate.Magazyn;
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

 
    @FXML
    private Button wylogujBtnP;
    @FXML
    private TableColumn<Towaryzamowienie, Integer> iloscP;
    @FXML
    private TableView<Zamowienie> zamowienia;
    @FXML
    private TableColumn<Zamowienie, Integer> idZamowienia;
    @FXML
    private TableColumn<Zamowienie, String> statusTransportu;
    @FXML
    private JFXButton wylogujBtn;

    @FXML
    void wyloguj(ActionEvent event) {

        String wylogowanie = "/FXML/Login.fxml";
        wczytywanie(event, wylogowanie);
        ramka(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        statusZamowienTable();
    }
    
     public ObservableList<Kategorie> getKategoria() {
        ObservableList<Kategorie> kategorie = FXCollections.
                observableArrayList();
        Session session = hibernate.HibernateUtil.getSessionFactory().
                openSession();
        List<Kategorie> pList = session.createCriteria(Kategorie.class).list();

        for (Kategorie k : pList) {
            kategorie.add(k);

        }
        return kategorie;
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

    public void statusZamowienTable() {

        idZamowienia.setCellValueFactory(new PropertyValueFactory<>("ZamowienieId"));
        statusTransportu.setCellValueFactory(new PropertyValueFactory<>("statusTransportu"));

        zamowienia.setItems(getZamowienie());

                zamowienia.setRowFactory( tv -> {
            TableRow<Zamowienie> row = new TableRow<>();
            row.getContextMenu();

            final ContextMenu contextMenu = new ContextMenu();
                    MenuItem tow = new MenuItem("Wyświetl dane");
                    MenuItem faktura = new MenuItem("Wyślij towar");

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
                    // Wysyłanie towaru


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        });
        contextMenu.getItems().addAll(tow , faktura);

        row.setContextMenu(contextMenu);

            return row ;
        });

    }
    
    public ObservableList<Zamowienie> getZamowienie() {
        ObservableList<Zamowienie> listaZamowien = FXCollections.
                observableArrayList();
        Session session = hibernate.HibernateUtil.getSessionFactory().
                openSession();
        List<Zamowienie> pList = session.createCriteria(Zamowienie.class).list();

        for (Zamowienie z : pList) {
            listaZamowien.add(z);

        }
        return listaZamowien;
    }
    
       public ObservableList<Towaryzamowienie> getTowarZamowienie() {
        ObservableList<Towaryzamowienie> listaZamowien = FXCollections.
                observableArrayList();
        Session session = hibernate.HibernateUtil.getSessionFactory().
                openSession();
        List<Towaryzamowienie> pList = session.createCriteria(
                Towaryzamowienie.class).list();

        for (Towaryzamowienie tz : pList) {
            listaZamowien.add(tz);

        }
        return listaZamowien;
    }

}
