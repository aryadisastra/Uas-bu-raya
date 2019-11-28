/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_arisrzld_xiirplb;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author arzz
 */
public class ArisHakAksesController implements Initializable {
    @FXML
    private AnchorPane paneHakAkses;
    @FXML
    private Button btnAdmin;
    @FXML
    private Button btnSiswa;
    @FXML
    private Button btnManager;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void KePaneAdmin(ActionEvent event) {
        try{
            AnchorPane pane =FXMLLoader.load(getClass().getResource("/fxmlhehe/ArisAdmin.fxml"));
            paneHakAkses.getChildren().setAll(pane);
        }
        catch (IOException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(""+e);
        }
    }

    @FXML
    private void KePaneSiswa(ActionEvent event) {
        try{
            AnchorPane pane =FXMLLoader.load(getClass().getResource("/fxmlhehe/ArisSiswa.fxml"));
            paneHakAkses.getChildren().setAll(pane);
        }
        catch (IOException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(""+e);
        }
    }

    @FXML
    private void KePaneManager(ActionEvent event) {
        try{
            AnchorPane pane =FXMLLoader.load(getClass().getResource("/fxmlhehe/ArisManager.fxml"));
            paneHakAkses.getChildren().setAll(pane);
        }
        catch (IOException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(""+e);
        }
    }
    
}
