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
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class Menu_KlientController extends Logowanie implements Initializable {

   @FXML
    private TableView<?> zamowieniaK;

    @FXML
    private JFXButton wylogujTZ;

    @FXML
    private Label nazwiskoL;

    @FXML
    private Label imieL;

    @FXML
    private Label mailL;

    @FXML
    private Label telefonL;

    @FXML
    private JFXButton wylogujDO;

    @FXML
    void wyloguj(ActionEvent event) {

        String klientPanel = "/FXML/Login.fxml";
        wczytywanie(event, klientPanel);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
