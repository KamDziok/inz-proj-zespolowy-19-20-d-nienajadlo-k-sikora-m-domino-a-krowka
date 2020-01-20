/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import java.net.URL;
import java.util.ResourceBundle;
import com.gluonhq.charm.glisten.control.ToggleButtonGroup;
import com.jfoenix.controls.JFXButton;
import hibernate.Adresy;
import hibernate.AdresyQuery;
import hibernate.Klient;
import hibernate.KlientQuery;
import hibernate.Pracownik;
import hibernate.PracownikQuery;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author monika
 */
public class LoginController extends Logowanie implements Initializable {
    
   
    Klient klientZ;
    Parent home;

    @FXML
    private PasswordField passwd;

    @FXML
    private Button zalogujbtn;
    
    @FXML
    private Button db_script;

    @FXML
    private Label status;

    @FXML
    private TextField login;

    @FXML
    private ToggleButtonGroup group;

    @FXML
    private RadioButton klientR;

    @FXML
    private RadioButton pracownikR;

    @FXML
    private JFXButton forgotPasswordBtn;

    @FXML
    private JFXButton rejestracjaH;

    @FXML
    void LogInAction(ActionEvent event) throws IOException {
        
        
        
        
        
        
        
        String log = login.getText();
        String pass = passwd.getText();

        if (pracownikR.isSelected()) {

            PracownikQuery pracownik = new PracownikQuery();

            Pracownik logowanie = pracownik.selectByLoginandPassword(log, pass);

            if (logowanie != null) {
                status.setText("Logowanie zakończone sukcesem!");

                if (logowanie.getStanowisko().equals("kierownik")) {
                    
                    String kierownik = "/FXML/Menu_Kierownik.fxml";
                    wczytywanie(event, kierownik);
                    ramka(event);
                    /*Stage PrimaryStage = new Stage();
                     Parent root = FXMLLoader.load(getClass().getResource("/FXML"
                     + "/Menu_Kierownik.fxml"));
                     Scene scene = new Scene(root, 750, 600);
                     PrimaryStage.setScene(scene);
                     PrimaryStage.show();
                     PrimaryStage.setResizable(false);*/
                }

                if (logowanie.getStanowisko().equals("ksiegowa")) {
                    
                    String ksiegowy = "/FXML/Menu_Ksiegowosc.fxml";
                    wczytywanie(event, ksiegowy);
                    ramka(event);
                    /*Stage PrimaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/FXML"
                            + "/Menu_Ksiegowosc.fxml"));
                    Scene scene = new Scene(root, 900, 700);
                    PrimaryStage.setScene(scene);
                    PrimaryStage.show();
                    PrimaryStage.setResizable(false);     */
                }

                if (logowanie.getStanowisko().equals("magazynier")) {
                    
                    String magazynier = "/FXML/Magazyn_Menu.fxml";
                    wczytywanie(event, magazynier);
                    ramka(event);
                    /* Stage PrimaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/FXML"
                            + "/Magazyn_Menu.fxml"));
                    Scene scene = new Scene(root, 900, 700);
                    PrimaryStage.setScene(scene);
                    PrimaryStage.show();
                    PrimaryStage.setResizable(false); */
                            
                }

                if (logowanie.getStanowisko().equals("marketing")) {

                    String marketing = "/FXML/Menu_Marketing.fxml";
                    wczytywanie(event, marketing);
                    ramka(event);
                  /*  Stage PrimaryStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("/FXML"
                            + "/Menu_Marketing.fxml"));
                    Scene scene = new Scene(root, 900, 700);
                    PrimaryStage.setScene(scene);
                    PrimaryStage.show();
                    PrimaryStage.setResizable(false); */
                }

            }

        } else {
            status.setText("Logowanie się nie powiodło!");
        }

        //}
        if (klientR.isSelected()) {
            // if (login.getText().equals("klient") && passwd.getText().equals("test")) {
            KlientQuery klient = new KlientQuery();
            Klient logowanie = klient.selectByLoginandPassword(log, pass);
            if (logowanie != null) {
                status.setText("Logowanie zakończone sukcesem!");
                 klientZ = logowanie;
                String adres = "/FXML/Menu_Klient.fxml";
                wczytywanie(event, adres);
                
                Menu_KlientController menuKlient = wczytaj.getController();
                menuKlient.odczyt(klientZ.getKlientId());
                ramka(event);
                menuKlient.daneOsobowe(klientZ.getImie(),
                            klientZ.getNazwisko(), klientZ.getTelefon());
                
                AdresyQuery a = new AdresyQuery();
                    Adresy adresZ = a.wyswietlAdres(klientZ.getKlientId());
                    if (adresZ != null) {
                        menuKlient.adresDostawy(adresZ.getUlica(), 
                            adresZ.getMiasto(), adresZ.getKraj(), 
                            adresZ.getNumerBudynku(), adresZ.getNumerLokalu(),
                            adresZ.getEmail());
                            
                }
                    else if (adresZ == null){
                    menuKlient.DodajAdresBTN();
                    }
                    
                    
                    
                    
                
                
                    
                /*Stage PrimaryStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/FXML/Menu_Klient.fxml"));
                Scene scene = new Scene(root, 800, 480);
                PrimaryStage.setScene(scene);
                PrimaryStage.show();
                PrimaryStage.setResizable(false); */
                
            } else {
                status.setText("Logowanie się nie powiodło!");
            }
        }
    }

    @FXML
    void RejestracjaAction(ActionEvent event) throws IOException {
        
        String wybor ="/FXML/Wybor.fxml";
        wczytywanie(event, wybor);
        ramka(event);
       /* Stage PrimaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/FXML"
                + "/Rejestracja.fxml"));
        Scene scene = new Scene(root, 500, 600);
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
        PrimaryStage.setResizable(false);*/
    }

    @FXML
    void PrzypomnienieHaslaOnAction(ActionEvent event) throws IOException {
        
        String przypomnienieH = "/FXML/Przypomnienie.fxml";
        wczytywanie(event, przypomnienieH);
        ramka(event);
       
        /*Stage PrimaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/FXML"
                + "/Przypomnienie.fxml"));
        Scene scene = new Scene(root, 500, 400);
        PrimaryStage.setScene(scene);
        PrimaryStage.show();
        PrimaryStage.setResizable(false); */

    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        final ToggleGroup group = new ToggleGroup();
        klientR.setToggleGroup(group);
        pracownikR.setToggleGroup(group);
    }
    
    @FXML
    void DbCreate(ActionEvent event) throws IOException, InterruptedException {
         Runtime run = Runtime.getRuntime();  
   Process p = null;  
        String cmd = "db_create.cmd";  
        try {  
           p = run.exec(cmd);
            p.waitFor();
            System.out.println(p.exitValue()); 
            System.out.println("Skrypt run"); 
        }  
        catch (IOException e) {  
            e.printStackTrace();  
            System.out.println("ERROR.RUNNING.CMD");  
            p.destroy();  
        }  
        
        
    
    }
}
