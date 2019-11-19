/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class LoginController implements Initializable {

    @FXML
    private PasswordField passwd;

    @FXML
    private TextField login;

    @FXML
    private RadioButton klientR;

    @FXML
    private RadioButton pracownikR;

    @FXML
    private Button zalogujbtn;

    @FXML
    private Label status;

    @FXML
    void LogInAction(ActionEvent event) {
        if (pracownikR.isSelected()) {
            if (login.getText().equals("pracownik") && passwd.getText().equals("test")) {
                status.setText("Logowanie zakończone sukcesem!");
            } else {
                status.setText("Logowanie się nie powiodło!");
            }
        }
        if (klientR.isSelected()) {
            if (login.getText().equals("klient") && passwd.getText().equals("test")) {
                status.setText("Logowanie zakończone sukcesem!");
            } else {
                status.setText("Logowanie się nie powiodło!");
            }
        }
    }

    @FXML
    void Select(ActionEvent event) {
        if (event.getSource().equals(klientR)) {
            pracownikR.setSelected(false);
        } else {
            klientR.setSelected(false);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        // TODO
    }

}
