/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXButton;
import hibernate.HibernateUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author monika
 * 
 */
public class PanelAdministratoraController extends Logowanie implements Initializable {

    static Session session = null;
    Criteria criteria = null;
    static Query query = null;
    
    @FXML
    private Button przycisk;
    @FXML
    private JFXButton wyloujBtn;
    @FXML
    private TextArea adminTextArea;
    @FXML
    private Button db_script;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void executeQuery(ActionEvent event) {
          String query = adminTextArea.getText();
          session = HibernateUtil.getSessionFactory().openSession();
          adminTextArea.setText("");
          
          try {
              session.getTransaction().begin();
              session.createSQLQuery(query).executeUpdate();
              session.getTransaction().commit();
              adminTextArea.setText("Query executed");
              session.close();
          } catch (HibernateException error) {
              session.getTransaction().rollback();
              adminTextArea.setText("Cannot execute query.");
              session.close();
          }
    }

    @FXML
    private void wyloguj(ActionEvent event) {
        
        String admin = "/FXML/Login.fxml";
            wczytywanie(event, admin);
            ramka(event);
    }

    @FXML
    private void DbCreate(ActionEvent event) throws InterruptedException {
         Runtime run = Runtime.getRuntime();
        Process p = null;
        String cmd = "db_create.cmd";
        try {
            p = run.exec(cmd);
            p.waitFor();
            System.out.println(p.exitValue());
            System.out.println("Skrypt run");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informacja");
            alert.setHeaderText(null);
            alert.setContentText("Skrypt uruchomiony poprawnie!");

            alert.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR.RUNNING.CMD");
            Alert alert2 = new Alert(Alert.AlertType.WARNING);
            alert2.setTitle("Informacja");
            alert2.setHeaderText(null);
            alert2.setContentText("Coś jest nie tak...");

            alert2.showAndWait();
            p.destroy();
        }

    }
    
}
