/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Utils.Popup;
import com.jfoenix.controls.JFXButton;
import hibernate.Klient;
import hibernate.KlientQuery;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class RejestracjaController extends Logowanie implements Initializable {

  
    @FXML
    private TextField imieR;

    @FXML
    private TextField nazwiskoR;

    @FXML
    private TextField telefonR;

    @FXML
    private TextField loginR;

    @FXML
    private Button zarejestrujBtn;

    @FXML
    private PasswordField hasloR;

    @FXML
    private Label status;

    @FXML
    private JFXButton backButton;

    @FXML
    void backInto(ActionEvent event) {
        
        String powrot = "/FXML/Login.fxml";
        wczytywanie(event, powrot);
        ramka(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void zarejestruj(ActionEvent event) throws Exception {

        String imie = imieR.getText();
        String nazwisko = nazwiskoR.getText();
        

        
        if(imie.length() < 2){
            Popup.show("Wprowadź poprawne imie!");
            throw new Exception();
        }
        
         if(nazwisko.length() < 2){
            Popup.show("Wprowadź poprawne nazwisko!");
            throw new Exception();
        }
         
        if(telefonR.getText().length() != 9){
            Popup.show("Numer telefonu jest wymagany i musi mieć 9 cyfr!");
            throw new Exception();
        }
         
         
        long telefon = Long.parseLong(telefonR.getText());
        String login = loginR.getText();
        String haslo = hasloR.getText();
        
         if(login.length() < 5){
            Popup.show("Login musi mieć conajmniej 6 znaków!");
            throw new Exception();
        }
         
        if(haslo.length() < 5){
            Popup.show("Hasło musi mieć conajmniej 6 znaków!");
            throw new Exception();
        }

        Klient k = new Klient(imie, nazwisko, telefon, login, haslo);

        KlientQuery queryK = new KlientQuery();

        try {
            queryK.rejestracja(imie, nazwisko, telefon, login, haslo);
            Popup.show("Rejestracja przebiegła pomyślnie. Możesz się teraz zalogować.");
            String alert = "/FXML/Login.fxml";
            wczytywanie(event, alert);
            ramka(event);
            
        } catch (Exception e) {
            Popup.show("Coś poszło nie tak! Skontaktuj się z pomocą techniczną systemu.");
        }
        
       
    }

}
