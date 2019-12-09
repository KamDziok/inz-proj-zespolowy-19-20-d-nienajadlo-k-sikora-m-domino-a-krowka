/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import java.net.URL;
import java.util.ResourceBundle;
import com.gluonhq.charm.glisten.control.ToggleButtonGroup;
import com.jfoenix.controls.JFXButton;
import hibernate.Klient;
import hibernate.KlientQuery;
import hibernate.Pracownik;
import hibernate.PracownikQuery;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class LoginController implements Initializable {

    @FXML
    private PasswordField passwd;

    @FXML
    private Button zalogujbtn;

    @FXML
    private Label status;

    @FXML
    private TextField login;

    @FXML
    private ToggleButtonGroup group;

    @FXML
    private RadioButton klientR;

    @FXML
    private RadioButton pracownikR;

    @FXML
    private JFXButton forgotPasswordBtn;

    @FXML
    private JFXButton rejestracjaH;

    @FXML
    void LogInAction(ActionEvent event) throws IOException {
        String log = login.getText();
        String pass = passwd.getText();

        if (pracownikR.isSelected()) {

            PracownikQuery pracownik = new PracownikQuery();

            Pracownik logowanie = pracownik.selectByLoginandPassword(log, pass);

            if (logowanie != null) {
                status.setText("Logowanie zakończone sukcesem!");

                if (logowanie.getStanowisko().equals("kierownik")) {

                    Stage PrimaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/FXML/Menu_Kierownik.fxml"));
                    Scene scene = new Scene(root, 700, 700);
                    PrimaryStage.setScene(scene);
                    PrimaryStage.show();
                    PrimaryStage.setResizable(false);

                }

                if (logowanie.getStanowisko().equals("ksiegowa")) {

                    Stage PrimaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/FXML/Menu_Ksiegowosc.fxml"));
                    Scene scene = new Scene(root, 900, 700);
                    PrimaryStage.setScene(scene);
                    PrimaryStage.show();
                    PrimaryStage.setResizable(false);
                }

                if (logowanie.getStanowisko().equals("magazynier")) {

                    Stage PrimaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/FXML/Magazyn_Menu.fxml"));
                    Scene scene = new Scene(root, 900, 700);
                    PrimaryStage.setScene(scene);
                    PrimaryStage.show();
                    PrimaryStage.setResizable(false);
                }

            }

        } else {
            status.setText("Logowanie się nie powiodło!");
        }

        //}
        if (klientR.isSelected()) {
            // if (login.getText().equals("klient") && passwd.getText().equals("test")) {
            KlientQuery klient = new KlientQuery();
            Klient logowanie = klient.selectByLoginandPassword(log, pass);
            if (logowanie != null) {

                status.setText("Logowanie zakończone sukcesem!");
                Stage PrimaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/FXML/Menu_Klient.fxml"));
                Scene scene = new Scene(root, 800, 480);
                PrimaryStage.setScene(scene);
                PrimaryStage.show();
                PrimaryStage.setResizable(false);

            } else {
                status.setText("Logowanie się nie powiodło!");
            }
        }
    }

    @FXML
    void RejestracjaAction(ActionEvent event) throws IOException {
        Stage PrimaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/Rejestracja.fxml"));
        Scene scene = new Scene(root, 500, 600);
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
        PrimaryStage.setResizable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        final ToggleGroup group = new ToggleGroup();
        klientR.setToggleGroup(group);
        pracownikR.setToggleGroup(group);
    }

}
