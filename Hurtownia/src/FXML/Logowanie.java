/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author monika
 */
public abstract class Logowanie {
// metoda wczytywania FXML

    public void wczytywanie(ActionEvent event, String adres) {

        try {
            Parent home = FXMLLoader.load(getClass().getResource(adres));
            Scene homeScene = new Scene(home);
            Stage app = (Stage) ((Node) event.getSource()).getScene().
                    getWindow();
            app.hide(); //ukrywanie Stage
            app.setScene(homeScene);
            app.show();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

}
