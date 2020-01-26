/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import hibernate.Zamowienie;
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
    private TableView<?> produktyW;
    @FXML
    private TableColumn<?, ?> IdProdukt;
    @FXML
    private TableColumn<?, ?> nazwaPK;
    @FXML
    private TableColumn<?, ?> iloscPK;
    @FXML
    private TableColumn<?, ?> cenaP;
    @FXML
    private JFXComboBox<?> kategoriaCombo;
    @FXML
    private Button wylogujBtnP;
    @FXML
    private TableColumn<?, ?> idP;
    @FXML
    private JFXTextField idWysz;
    @FXML
    private Button Szukajbtn;
    @FXML
    private Label idProdukty;
    @FXML
    private Label idKategoria;
    @FXML
    private Label nazwaProdukty;
    @FXML
    private TextField ilosctxt;
    @FXML
    private Button zmienBtn;
    @FXML
    private Button wylogujBtnZ;
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
    void wyloguj(ActionEvent event) {
         
        String wylogowanie = "/FXML/Login.fxml";
           wczytywanie(event, wylogowanie);
           ramka(event);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        statusZamowienTable();
    }    

    public void statusZamowienTable(){
        
          idZamowienia.setCellValueFactory(new PropertyValueFactory<>
        ("ZamowienieId"));
         statusZaplaty.setCellValueFactory(new PropertyValueFactory<>
        ("statusZaplaty"));
       statusTransportu.setCellValueFactory(new PropertyValueFactory<>
        ("statusTransportu"));
         
         zamowienia.setItems(getZamowienie());
         
           zamowienia.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
               Zamowienie z = zamowienia.getItems().get(zamowienia.
                       getSelectionModel().getSelectedIndex());
                idZa.setText(Integer.toString(z.getZamowienieId()));
                idZa.setVisible(false);
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
    }
    
}
