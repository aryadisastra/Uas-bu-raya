/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_arisrzld_xiirplb;

import java.sql.Connection;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import koneksi.connection;

/**
 *
 * @author cover jok
 */
public class UAS_ArisRzld_XIIRPLB extends Application {
    Connection conn = null;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxmlhehe/ArisLogin.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void showInformationAlertField(String pesan)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("iNFORMATION DIALOGE");
        alert.setHeaderText(null);
        alert.setContentText(pesan);
        alert.showAndWait();
    }
}
