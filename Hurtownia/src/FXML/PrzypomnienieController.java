/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

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
    void sprawdz(ActionEvent event) {

        KlientQuery klient = new KlientQuery();
        String login = loginSPR.getText();

        Klient k = klient.wyszukiwanie(login);
        try {
            if (k != null) {
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

        KlientQuery klient = new KlientQuery();
        String login = loginZH.getText();
        String nHaslo = noweHaslo.getText();

        try {

            klient.changePassword(login, nHaslo);
            String alert = "/FXML/Login.fxml";
            wczytywanie(event, alert);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
