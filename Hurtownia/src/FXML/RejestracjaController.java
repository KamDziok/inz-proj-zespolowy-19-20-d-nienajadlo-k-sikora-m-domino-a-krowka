/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class RejestracjaController implements Initializable {
    @FXML
    private TextField imieR;
    @FXML
    private TextField nazwiskoR;
    @FXML
    private TextField telefonR;
    @FXML
    private TextField emailR;
    @FXML
    private TextField loginR;
    @FXML
    private Button zarejestrujBtn;
    @FXML
    private PasswordField hasloR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
