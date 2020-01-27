/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import hibernate.Kategorie;
import hibernate.KategorieConverter;
import hibernate.KategorieQuery;
import hibernate.Magazyn;
import hibernate.MagazynQuery;
import hibernate.ProduktQuery;
import hibernate.Produkty;
import hibernate.ProduktyConverter;
import hibernate.Zamowienie;
import hibernate.ZamowienieQuery;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class Magazyn_MenuController extends Logowanie implements Initializable {

    @FXML
    private TableView<Magazyn> produktyW;
    @FXML
    private TableColumn<?, ?> IdProdukt;
    @FXML
    private TableColumn<?, ?> cenaP;
 
    @FXML
    private Button wylogujBtnP;
    @FXML
    private TableView<?> produkty;
    @FXML
    private TableColumn<?, ?> iloscP;
    @FXML
    private TableView<Zamowienie> zamowienia;
    @FXML
    private TableColumn<Zamowienie, Integer> idZamowienia;
    @FXML
    private TableColumn<Zamowienie, String> statusZaplaty;
    @FXML
    private TableColumn<Zamowienie, String> statusTransportu;
    @FXML
    private JFXButton wylogujBtn;
    @FXML
    private Button zmianaSbtn;
    @FXML
    private TextField zmianaSZ;
    @FXML
    private TextField zmianaST;
    @FXML
    private Label idZa;
    @FXML
    private TableColumn<Magazyn, String> idProduktuZI;
    @FXML
    private TableColumn<Magazyn, String> nazwaZI;
    @FXML
    private TableColumn<Magazyn, Integer> iloscZI;
    @FXML
    private JFXButton wylogujBtn1;
    @FXML
    private Label nazwaProduktuL;
    @FXML
    private TextField iloscZmiana;
    @FXML
    private Button zmianaIloBTN;
    @FXML
    private JFXButton wczytajBTN;
    @FXML
    private Label idZI;
    @FXML
    private Label idKategorii;
    @FXML
    private JFXComboBox<Kategorie> kategorieCOmbo;
    @FXML
    private JFXComboBox<Produkty> produktyDcombo;
    @FXML
    private Label produktyId;

    @FXML
    void wyloguj(ActionEvent event) {

        String wylogowanie = "/FXML/Login.fxml";
        wczytywanie(event, wylogowanie);
        ramka(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        statusZamowienTable();
         ProduktyIlosc ();
         KategoriaCombo ();
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

    public void statusZamowienTable() {

        idZamowienia.setCellValueFactory(new PropertyValueFactory<>("ZamowienieId"));
        statusZaplaty.setCellValueFactory(new PropertyValueFactory<>("statusZaplaty"));
        statusTransportu.setCellValueFactory(new PropertyValueFactory<>("statusTransportu"));

        zamowienia.setItems(getZamowienie());

        zamowienia.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Zamowienie z = zamowienia.getItems().get(zamowienia.
                        getSelectionModel().getSelectedIndex());
                idZa.setText(Integer.toString(z.getZamowienieId()));
                idZa.setVisible(false);
            }
        });

    }
    
       public void comboValueKT (ComboBox<Kategorie> kategorieCOmbo){
        
        Kategorie k = kategorieCOmbo.getValue();
        int idKat = k.getKategoriaId();
        idKategorii.setText(Integer.toString(idKat));
        idKategorii.setVisible(false);
        
    }
    
    public void KategoriaCombo (){
        
         idKategorii.setText("");
         
          kategorieCOmbo.setItems(getKategoria());
        kategorieCOmbo.setConverter(new KategorieConverter());
        
        kategorieCOmbo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comboValueKT(kategorieCOmbo);
            
           
            if (!idKategorii.getText().equals("")) {
            
        int idKategoria = Integer.parseInt(idKategorii.getText());
            ProduktQuery produkty = new ProduktQuery();
        produktyDcombo.getItems().clear();
        produktyDcombo.getItems().addAll(produkty.
                produktySelectAllOnID(idKategoria));
     
       
      produktyDcombo.setConverter(new ProduktyConverter());
        
          produktyDcombo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                comboValueProdukty(produktyDcombo);

            }
        });
        }
            
            
            }
        });
        
        
    }
    
     public void comboValueProdukty (ComboBox<Produkty>  produktyDcombo){
        
        Produkty p =  produktyDcombo.getValue();
        int idP = p.getProduktId();
        produktyId.setText(Integer.toString(idP));
        produktyId.setVisible(false);
    }
    
    public void ProduktyIlosc (){
        
        idProduktuZI.setCellValueFactory(new PropertyValueFactory<>("ProduktId"));
        nazwaZI.setCellValueFactory(new PropertyValueFactory<>("ProduktName"));
        iloscZI.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
        
        produktyW.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                Magazyn m = produktyW.getItems().get(produktyW.
                        getSelectionModel().getSelectedIndex());
                idZI.setText(Integer.toString(m.getProductId()));
                idZI.setVisible(false);
                nazwaProduktuL.setText(m.getProduktName());
            }
            
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

    @FXML
    private void zmianaStatusu(ActionEvent event) {

        int id = Integer.parseInt(idZa.getText());

        String statusT = zmianaST.getText();
        String statusZap = zmianaSZ.getText();

        try {
            ZamowienieQuery zamow = new ZamowienieQuery();
            Zamowienie zam = new Zamowienie();

            zamow.changeStatus(id,statusZap, statusT);

            zamowienia.setItems(getZamowienie());
            zmianaST.setText(null);
            zmianaSZ.setText(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void zmianaIlosci(ActionEvent event) {
        
        try{
            MagazynQuery maga = new MagazynQuery();
            int id = Integer.parseInt(idZI.getText());
            int ilosc = Integer.parseInt(iloscZmiana.getText());
            maga.zmianaIlosci(id, ilosc);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void wczytajProdukty(ActionEvent event) {
        
        int idProduktu = Integer.parseInt(produktyId.getText());
        
        MagazynQuery magazyn = new MagazynQuery();
        
        try{
            produktyW.getItems().addAll(magazyn.produktySelectAllOnID(idProduktu));
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        
    }

}
