/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

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
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void zarejestruj(ActionEvent event) {

        String imie = imieR.getText();
        String nazwisko = nazwiskoR.getText();
        long telefon = Long.parseLong(telefonR.getText());

        String login = loginR.getText();
        String haslo = hasloR.getText();

        Klient k = new Klient(imie, nazwisko, telefon, login, haslo);

        KlientQuery queryK = new KlientQuery();

        try {
            queryK.rejestracja(imie, nazwisko, telefon, login, haslo);
            status.setText("Rejestracja udana!");
             String alert = "/FXML/Alert.fxml";
            wczytywanie(event, alert);
            
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
       
    }

}
