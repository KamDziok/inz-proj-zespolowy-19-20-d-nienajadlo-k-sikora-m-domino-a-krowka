package FXML;

import Utils.Popup;
import hibernate.PracownikQuery;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class RejestrPracownikaController extends Logowanie implements
        Initializable {

    @FXML
    private TextField loginR;
    @FXML
    private PasswordField hasloR;
    @FXML
    private TextField workerCode;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void powrotLogowanie(ActionEvent event) {

        String powrot = "/FXML/Login.fxml";
        wczytywanie(event, powrot);
        ramka(event);
    }
    
    private void clearFields(){
        loginR.setText("");
        hasloR.setText("");
        workerCode.setText("");
    }

    @FXML
    private void zarejestruj(ActionEvent event) throws Exception {
        PracownikQuery pracownik = new PracownikQuery();
        String login = loginR.getText();
        String haslo = hasloR.getText();
        int code = Integer.parseInt(workerCode.getText());
        
        if(pracownik.wyszukiwanieID(code).getLogin() != null){
            clearFields();
            Popup.show("Nie można zarejestrować się z tym kodem, ponieważ zostal on już użyty!");
            throw new Exception();
        } else if(pracownik.wyszukiwanieID(code).getPassword() != null){
            clearFields();
            Popup.show("Nie można zarejestrować się z tym kodem, ponieważ zostal on już użyty!");
            throw new Exception();
        }
        
        try{
            pracownik.dodanieDanych(login, haslo, code);
            String alert = "/FXML/Login.fxml";
            wczytywanie(event, alert);
            ramka(event);
            Popup.show("Rejestracja przebiegła pomyslnie! Możesz się teraz zalogować.");
        }catch(Exception e){
            loginR.setText("");
            hasloR.setText("");
            Popup.show("Nie można zalogować się z tym kodem!");
        }
    }

}
