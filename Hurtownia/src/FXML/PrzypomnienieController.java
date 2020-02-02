/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Utils.Popup;
import com.jfoenix.controls.JFXButton;
import hibernate.Adresy;
import hibernate.AdresyQuery;
import hibernate.Klient;
import hibernate.KlientQuery;
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

/**
 * FXML Controller class
 *
 * @author monika
 */
public class PrzypomnienieController extends Logowanie implements Initializable {

   
    @FXML
    private TextField loginSPR;

    @FXML
    private Button sprawdzBtn;

    @FXML
    private Label statusSPR;

    @FXML
    private PasswordField noweHaslo;

    @FXML
    private Button zmienBtn;

    @FXML
    private TextField loginZH;
    
     @FXML
    private TextField email;

    @FXML
    private PasswordField powtorzH;

    @FXML
    private JFXButton backButton;
    
     @FXML
    private Label potwierdzenie;

    @FXML
    void backInto(ActionEvent event) {
        
        String powrot = "/FXML/Login.fxml";
        wczytywanie(event, powrot);
        ramka(event);

    }

    
    private static PracownikQuery worker = new PracownikQuery();
    private static KlientQuery client = new KlientQuery();
    private static AdresyQuery addressQuery = new AdresyQuery();
    private static Adresy address = new Adresy();
    
    @FXML
    void sprawdz(ActionEvent event) {

        String login = loginSPR.getText();
        
        KlientQuery klient = new KlientQuery();
        Klient k = klient.wyszukiwanie(login);
        
        PracownikQuery pracownik = new PracownikQuery();
        Pracownik p = pracownik.wyszukiwanie(login);
        
        try {
            if (k != null || p !=null) {
                statusSPR.setText("Login istnieje w bazie!");
            } else {
                statusSPR.setText("Login nie odnaleziono w bazie!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
        
     private void clearFields(){
         loginZH.setText("");
         noweHaslo.setText("");
         email.setText("");
         powtorzH.setText("");
     }
    

    @FXML
    void zmianaHasla(ActionEvent event) throws Exception {
        
        String login = loginZH.getText();
        String password = noweHaslo.getText();
        String repeatedPassword = powtorzH.getText();
        String emailAddress = email.getText();
        
        Klient clientFromPanel = client.wyszukiwanie(login);
        Adresy addressFromDb = addressQuery.wyswietlAdres(clientFromPanel.getKlientId());
        
        boolean validLogin = clientFromPanel.getLogin().equals(login);
        boolean validEmail = addressFromDb.getEmail().equals(emailAddress);
        boolean formValid = validLogin && validEmail;
        
        if(!formValid){
            Popup.show("Niepoprawny login lub email!!");
            clearFields();
            throw new Exception();
        }
        
        if(password.length() < 6){
            Popup.show("Hasło musi mieć conajmniej 6 znaków!");
            throw new Exception();
        }
        
        if(!password.equals(repeatedPassword)){
            Popup.show("Wprowadzone hasła nie są takie same!");
            throw new Exception();
        }
        
        try{
            client.changePassword(login, password);
            Popup.show("Hasło zostało zmienione! Uruchom aplikacje ponownie aby dane zostały poprawnie wprowadzone!");
            String alert = "/FXML/Login.fxml";
            wczytywanie(event, alert);
            ramka(event);
        } catch(Exception e){
            Popup.show("Nie można zmienić hasła! Nastąpił błąd!");
            throw new Exception();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
