/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import hibernate.Pracownik;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;
import javax.swing.GroupLayout;

/**
 * FXML Controller class
 *
 * @author adamk
 */
public class ChangeSalaryWindowController implements Initializable {

    @FXML
    public Label title;
    static Pracownik pracownik;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        title.setText(pracownik.getImieNazwisko());
    }    
   
}
