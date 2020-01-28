/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import hibernate.KlientQuery;
import hibernate.Towaryzamowienie;
import hibernate.TowaryzamowienieQuery;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class TabelaController implements Initializable {

    @FXML
    private TableView<Towaryzamowienie> zamowieniaSZ;
    @FXML
    private TableColumn<Towaryzamowienie, String> nazwaProduktuS;
    @FXML
    private TableColumn<Towaryzamowienie, Integer> iloscS;
    @FXML
    private TableColumn<Towaryzamowienie, Float> kosztS;
    
    
    public static String ID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayTowary();
        towaryDoZamowieniaTable();
        // TODO
    }
    
    
    private void towaryDoZamowieniaTable() {

       nazwaProduktuS.setCellValueFactory(new PropertyValueFactory<> ("produktName"));
        iloscS.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
        kosztS.setCellValueFactory(new PropertyValueFactory<>("koszt"));
        
    }
    
    
    public  void displayTowary() {
        TowaryzamowienieQuery towar = new TowaryzamowienieQuery();
            zamowieniaSZ.getItems().setAll(towar.zamowieniaID(ID));
            
           
    }
    
    
    

    

    
    
   
    
    
    
}
