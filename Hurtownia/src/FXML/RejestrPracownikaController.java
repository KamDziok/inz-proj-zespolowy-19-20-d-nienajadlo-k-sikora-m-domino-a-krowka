/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXButton;
import hibernate.Pracownik;
import hibernate.PracownikQuery;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class RejestrPracownikaController extends Logowanie implements
        Initializable {


    @FXML
    private Button sprawdzW;
    @FXML
    private JFXButton powrotW;
    @FXML
    private Label weryfikacja;
    @FXML
    private Label IDweryf;
    @FXML
    private TextField loginR;
    @FXML
    private PasswordField hasloR;
    @FXML
    private Button zarejestrujbtn;
    @FXML
    private TextField checkNazwisko;
    @FXML
    private TextField checkImie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void sprawdzZatrudnienie(ActionEvent event) {
        
        String imie = checkImie.getText();
        String nazwisko = checkNazwisko.getText();
        
        try{
              PracownikQuery pracownik = new PracownikQuery();
            Pracownik p = pracownik.wyszukanieZatrudnienie(nazwisko, imie);
             
            if(p != null){
                weryfikacja.setText("Jesteś zatrudniony w hurtowni!");
                
                int id = pracownik.wyszukanieZatrudnienie(nazwisko, imie).
                        getPracownikId();
                
               IDweryf.setText(Integer.toString(id));
               IDweryf.setVisible(false);
               
            }
            else{
                weryfikacja.setText("Nie jesteś zatrudniony w hurtowni!");
            }
              
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
      
       
    }

    @FXML
    private void powrotLogowanie(ActionEvent event) {

        String powrot = "/FXML/Login.fxml";
        wczytywanie(event, powrot);
        ramka(event);
    }

    @FXML
    private void zarejestruj(ActionEvent event) {
        
        int id = Integer.parseInt(IDweryf.getText());
        String login = loginR.getText();
        String haslo = hasloR.getText();
        
        try{
            PracownikQuery pracownik = new PracownikQuery();
            pracownik.dodanieDanych(login, haslo, id);
            String alert = "/FXML/Alert.fxml";
            wczytywanie(event, alert);
            ramka(event);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
