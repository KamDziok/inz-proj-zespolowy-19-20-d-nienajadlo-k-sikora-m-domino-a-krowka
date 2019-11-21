/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import java.net.URL;
import java.util.ResourceBundle;
import com.gluonhq.charm.glisten.control.ToggleButtonGroup;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private TextField login;
    
    @FXML
    private RadioButton klientR;
    
    @FXML
    private RadioButton pracownikR;
    
    @FXML
    private Button zalogujbtn;
    
    @FXML
    private ToggleButtonGroup group;
    
    @FXML
    private Label status;
    
    @FXML
    void LogInAction(ActionEvent event) throws IOException {
        if (pracownikR.isSelected()) {
            if (login.getText().equals("kierownik") && passwd.getText().equals("test")) {
                status.setText("Logowanie zakończone sukcesem!");
                
             Stage PrimaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/Menu_Kierownik.fxml"));
            Scene scene = new Scene(root, 800, 480);
            PrimaryStage.setScene(scene);
            PrimaryStage.show();
            PrimaryStage.setResizable(false);
            } else {
                status.setText("Logowanie się nie powiodło!");
            }
        }
        if (klientR.isSelected()) {
            if (login.getText().equals("klient") && passwd.getText().equals("test")) {
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      final ToggleGroup  group = new ToggleGroup();
        klientR.setToggleGroup(group);
        pracownikR.setToggleGroup(group);
    }
    
}
