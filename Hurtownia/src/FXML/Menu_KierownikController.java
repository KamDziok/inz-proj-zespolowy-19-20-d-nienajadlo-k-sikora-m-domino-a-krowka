/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    void wyloguj(ActionEvent event) {
        
        String wylogowywanie = "/FXML/Login.fxml";
        wczytywanie(event, wylogowywanie);
        ramka(event);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
