/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
public class Magazyn_MenuController extends Logowanie implements Initializable {
    @FXML
    private TableView<?> produktyW;
    @FXML
    private TableColumn<?, ?> IdProdukt;
    @FXML
    private TableColumn<?, ?> nazwaPK;
    @FXML
    private TableColumn<?, ?> iloscPK;
    @FXML
    private TableColumn<?, ?> cenaP;
    @FXML
    private JFXComboBox<?> kategoriaCombo;
    @FXML
    private Button wylogujBtnP;
    @FXML
    private TableColumn<?, ?> idP;
    @FXML
    private JFXTextField idWysz;
    @FXML
    private Button Szukajbtn;
    @FXML
    private Label idProdukty;
    @FXML
    private Label idKategoria;
    @FXML
    private Label nazwaProdukty;
    @FXML
    private TextField ilosctxt;
    @FXML
    private Button zmienBtn;
    @FXML
    private Button wylogujBtnZ;

       @FXML
    void wyloguj(ActionEvent event) {
         
        String wylogowanie = "/FXML/Login.fxml";
           wczytywanie(event, wylogowanie);
           ramka(event);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
