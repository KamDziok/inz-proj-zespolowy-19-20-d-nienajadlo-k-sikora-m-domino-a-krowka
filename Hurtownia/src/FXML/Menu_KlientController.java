/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import hibernate.Adresy;
import hibernate.AdresyQuery;
import hibernate.KlientQuery;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class Menu_KlientController extends Logowanie implements Initializable {

      @FXML
    private TableView<?> zamowieniaK;

    @FXML
    private JFXButton wylogujTZ;

    @FXML
    private Label dane;

    @FXML
    private JFXButton wylogujDO1;

    @FXML
    private Button dodajAdresBtn;

    @FXML
    private JFXTextField ulicaDA;

    @FXML
    private JFXTextField krajAD;

    @FXML
    private JFXTextField miastoAD;

    @FXML
    private JFXTextField numerBudynkuAD;

    @FXML
    private JFXTextField numerLokaluAD;

    @FXML
    private JFXTextField emailAD;

    @FXML
    private Label nazwiskoL;

    @FXML
    private Label imieL;

    @FXML
    private Label mailL;

    @FXML
    private Label telefonL;

    @FXML
    private JFXButton wylogujDO;



    @FXML
    void DodajAdres(ActionEvent event) {

        String kraj = krajAD.getText();
        String miasto = miastoAD.getText();
        String ulica = ulicaDA.getText();
        String nB = numerBudynkuAD.getText();
        String nL = numerLokaluAD.getText();
        String email = emailAD.getText();
        
        int id = Integer.parseInt(dane.getText());
       
        

        try {
            AdresyQuery adres = new AdresyQuery();
            adres.dodajAdres(id, kraj, miasto, ulica, nB, nL, email);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void odczyt(int id) {
        dane.setText(Integer.toString(id));
        dane.setVisible(false);
    }
    
    public void daneOsobowe (String imie, String nazwisko, long telefon){
        imieL.setText(imie);
        nazwiskoL.setText(nazwisko);
        telefonL.setText(Long.toString(telefon));
    }
    
    @FXML
    void wyloguj(ActionEvent event) {

        String klientPanel = "/FXML/Login.fxml";
        wczytywanie(event, klientPanel);
        ramka(event);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
