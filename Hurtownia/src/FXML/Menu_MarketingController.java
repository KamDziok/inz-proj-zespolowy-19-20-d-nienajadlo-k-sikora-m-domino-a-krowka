/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class Menu_MarketingController extends Logowanie implements 
        Initializable {

    @FXML
    private TextField tytulD;
    
    @FXML
    private DatePicker dataD;
    
    @FXML
    private TextArea opisD;
    
    @FXML
    private ImageView grafika;
    
    @FXML
    private Button dodajbtn;
    
    @FXML
    private JFXButton wylogujDR;
    
    @FXML
    void wyloguj(ActionEvent event) {
        
        String reklama = "/FXML/Login.fxml";
        wczytywanie(event, reklama);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
