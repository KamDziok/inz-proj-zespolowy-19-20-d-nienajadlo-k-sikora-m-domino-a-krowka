/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import hibernate.Towaryzamowienie;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class TabelaController implements Initializable {

    @FXML
    private TableView<Towaryzamowienie> zamowieniaSZ;
    @FXML
    private TableColumn<Towaryzamowienie, Integer> idZamowieniaS;
    @FXML
    private TableColumn<Towaryzamowienie, String> nazwaProduktuS;
    @FXML
    private TableColumn<Towaryzamowienie, Integer> iloscS;
    @FXML
    private TableColumn<Towaryzamowienie, Float> kosztS;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
