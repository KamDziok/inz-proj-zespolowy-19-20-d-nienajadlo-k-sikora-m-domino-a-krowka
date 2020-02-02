/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Utils.Popup;
import hibernate.Pracownik;
import hibernate.PracownikQuery;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author adamk
 */
public class ChangeSalaryWindowController implements Initializable {

    private PracownikQuery worker = new PracownikQuery();
    
    @FXML
    public Label title;
    @FXML
    public TextField newSalary;
    
    static Pracownik pracownik;
    static Stage stage;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        title.setText(pracownik.getImieNazwisko());
    }    
   
    public boolean changeSalaryHandler(){
       float salary = 0;
       int workerId = pracownik.getPracownikId();
       
       try{
           salary = Float.parseFloat(newSalary.getText());
       } catch(Exception e){
           Popup.show("Wprowadzono niepoprawne dane!");
       }
       
       try{
           worker.changeSalary(workerId, salary);
           Popup.show("Pomyślnie zmieniono wypłatę dla tego pracownika! Uruchom ponownie progam aby zobaczyć zmiany.");
           stage.close();
       } catch(Exception e){
           Popup.show("Nie można zmienić wypłaty dla tego pracownika!");
       }
        
        return false;
    }
    
}
