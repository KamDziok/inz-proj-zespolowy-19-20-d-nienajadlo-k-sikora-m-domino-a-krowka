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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class Menu_KsiegowoscController extends Logowanie implements Initializable {
   
    @FXML
    private TableView<?> pracownicy;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> imieP;

    @FXML
    private TableColumn<?, ?> nazwiskoP;

    @FXML
    private TableColumn<?, ?> stanowiskoP;

    @FXML
    private TableColumn<?, ?> placa;

    @FXML
    private TextField szukajID1;

    @FXML
    private JFXButton wylogujP;

    @FXML
    private TextField idP;

    @FXML
    private DatePicker data;

    @FXML
    private TextField kwota;

    @FXML
    private TextField szukajID;

    @FXML
    private JFXButton wylogujDW;

    @FXML
    void wyloguj(ActionEvent event) {
        
        String ksiegi = "/FXML/Login.fxml";
        wczytywanie(event, ksiegi);
        ramka(event);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
