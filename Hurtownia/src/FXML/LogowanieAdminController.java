/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class LogowanieAdminController extends Logowanie implements Initializable 
{

    @FXML
    private JFXTextField loginA;
    @FXML
    private Button zalogujAdmin;
    @FXML
    private JFXPasswordField passw;
    @FXML
    private JFXButton powrot;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void zalogujsięAdministrator(ActionEvent event) {
        if (loginA.getText().equals("admin") && passw.getText().
                equals("admin")) {
            String admin = "/FXML/PanelAdministratora.fxml";
            wczytywanie(event, admin);
            ramka(event);
        }
    }

    @FXML
    private void wroc(ActionEvent event) {
        
        String admin = "/FXML/Login.fxml";
            wczytywanie(event, admin);
            ramka(event);
    }
    

}
