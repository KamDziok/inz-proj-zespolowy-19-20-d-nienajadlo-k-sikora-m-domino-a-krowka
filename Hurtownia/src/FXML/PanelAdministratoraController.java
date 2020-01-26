/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import com.jfoenix.controls.JFXButton;
import hibernate.HibernateUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author monika
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
    
}
