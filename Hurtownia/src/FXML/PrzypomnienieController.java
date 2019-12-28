/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXButton;
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
        
        
    

    @FXML
    void zmianaHasla(ActionEvent event) {
        
        String login = loginZH.getText();
        String nHaslo = noweHaslo.getText();
        String pHaslo = powtorzH.getText();
        
        if(pHaslo.equals(nHaslo)){
            potwierdzenie.setText("Hasła się zgadzają!");
        }

        //zmiana hasła dla klienta przez formularz ZmianaHasła
        KlientQuery klient = new KlientQuery();
        try {
            
            klient.changePassword(login, nHaslo);
            String alert = "/FXML/Login.fxml";
            wczytywanie(event, alert);
            ramka(event);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        //zmiana hasła dla obsługi przez formularz ZmianaHasła
        PracownikQuery pracownik = new PracownikQuery();
        try {

            pracownik.changePassword(login, nHaslo);
            String alert = "/FXML/Login.fxml";
            wczytywanie(event, alert);
            ramka(event);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
