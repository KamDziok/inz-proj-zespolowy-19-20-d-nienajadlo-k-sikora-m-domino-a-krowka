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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class Menu_KsiegowoscController implements Initializable {
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
    private TextField idP;
    @FXML
    private DatePicker data;
    @FXML
    private TextField kwota;
    @FXML
    private TextField szukajID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
