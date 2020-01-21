/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hurtownia;

import Utils.pdfCreator;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author monika
 */
public class Hurtownia extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
          try{
           Parent root = FXMLLoader.load(getClass().getResource("/FXML/"
                   + "Login.fxml"));
           Scene scene = new Scene(root, 400, 415);
           primaryStage.setScene(scene);
           primaryStage.show();
           primaryStage.setResizable(false);
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        pdfCreator pdf = new pdfCreator();
        pdf.createInvoice("123",23);
//        launch(args);
    }
    
}
