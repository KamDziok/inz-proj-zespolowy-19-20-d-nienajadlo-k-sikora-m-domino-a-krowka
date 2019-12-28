/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class AlertController extends Logowanie implements Initializable {
      @FXML
    private Label poprawneR;

    @FXML
    private Button przejdzBtn;

    @FXML
    void logPrzejdz(ActionEvent event) {
        String logowanie = "/FXML/Login.fxml";
        wczytywanie(event, logowanie);
        ramka(event);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        poprawneR.setText("Rejestracja przebiegła pomyślnie!");
    }    
    
}
