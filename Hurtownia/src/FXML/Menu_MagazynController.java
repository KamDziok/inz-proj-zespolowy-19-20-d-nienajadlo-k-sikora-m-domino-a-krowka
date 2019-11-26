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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class Menu_MagazynController implements Initializable {
    @FXML
    private TableView<?> produktyM;
    @FXML
    private TableColumn<?, ?> idPM;
    @FXML
    private TableColumn<?, ?> nazwaPM;
    @FXML
    private TableColumn<?, ?> iloscPM;
    @FXML
    private TableColumn<?, ?> cenaPM;
    @FXML
    private TableColumn<?, ?> idZm;
    @FXML
    private TableColumn<?, ?> nazwaZM;
    @FXML
    private TableColumn<?, ?> iloscZm;
    @FXML
    private TextField wyszukajZM;
    @FXML
    private Label produktWcz;
    @FXML
    private Button btnSzukaj;
    @FXML
    private TextField iloscZM;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
