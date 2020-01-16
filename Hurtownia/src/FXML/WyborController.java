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

/**
 * FXML Controller class
 *
 * @author monika
 */
public class WyborController extends Logowanie implements Initializable {

    @FXML
    private JFXButton klientBtn;
    @FXML
    private JFXButton wyvorPracownikR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void wczytajRejestracjaKlienta(ActionEvent event) {
        
        String wybor ="/FXML/Rejestracja.fxml";
        wczytywanie(event, wybor);
        ramka(event);
    }

    @FXML
    private void wczytajRejestracjaPracownika(ActionEvent event) {
        
        String wybor ="/FXML/RejestrPracownika.fxml";
        wczytywanie(event, wybor);
        ramka(event);
    }
    
    
}
