/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import hibernate.KierownikQuery;
import hibernate.Pracownik;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
    private TextField iloscP;

    @FXML
    private TextField cenaP;

    @FXML
    private Button DodajBTN;

    @FXML
    private TableView<?> produktyD;

    @FXML
    private ComboBox<?> katDcombo;

    @FXML
    private ComboBox<?> katCombo;

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
    private ComboBox<?> stanowiskoCombo;
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
    void wyloguj(ActionEvent event) {
        
        String wylogowywanie = "/FXML/Login.fxml";
        wczytywanie(event, wylogowywanie);
        ramka(event);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        pracownicyTable(); // wyświetlenie wszystkich pracowników
    }    
    
    
     public ObservableList <Pracownik> getPracownik(){
        ObservableList<Pracownik> listaPracownikow = FXCollections.
                observableArrayList();
        Session session = hibernate.HibernateUtil.getSessionFactory().
                openSession();
        List <Pracownik> pList = session.createCriteria(Pracownik.class).list();
        
        for(Pracownik p: pList){
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
    
    public void clearFields(){
        imieDP.setText(null);
        nazwiskoDP.setText(null);
        wynagrodzenieDP.setText(null);
        stanowiskoDP.setText(null);
    
    }
    
    public void pracownicyTable(){
        
        imieT.setCellValueFactory(new PropertyValueFactory<Pracownik, String> 
        ("imie"));
        nazwiskoT.setCellValueFactory(new PropertyValueFactory<Pracownik, 
                String> ("nazwisko"));
        stanowiskoT.setCellValueFactory(new PropertyValueFactory<Pracownik, 
                String>("stanowisko"));
        stawkaT.setCellValueFactory(new PropertyValueFactory<Pracownik, Float>
        ("placa"));
        
        pracownicyTable.setItems(getPracownik());
    }
}
