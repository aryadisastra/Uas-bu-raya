/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_arisrzld_xiirplb;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import koneksi.connection;

/**
 * FXML Controller class
 *
 * @author cover jok
 */
public class ArisLoginController implements Initializable {

    @FXML
    private AnchorPane paneLogin;
    @FXML
    private TextField txtId;
    @FXML
    private PasswordField txtPass;
    @FXML
    private Button btnMasuk;
    @FXML
    private Label notif;
    @FXML
    private Button btnKembali;
    Connection con;
    Statement stm;
    ResultSet rs;
    Stage closeStage = new Stage();
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       connection db = new connection();
       db.config();
       con = db.conn;
       stm = db.stat;
    }    

    @FXML
    private void gaBisaKetikScript(KeyEvent event) {
    }

    @FXML
    private void gaBisaKetikScriptt(KeyEvent event) {
    }

    @FXML
    private void actionMasuk(ActionEvent event) {
        Stage stage = new Stage();
        try{
        String sql = "Select * from login where username = '"+txtId.getText()+"' AND password = '"+txtPass.getText()+"'";
        rs = stm.executeQuery(sql);
        if(rs.next())
        {
             FXMLLoader fxmlloader= new
                FXMLLoader(getClass().getResource("/fxmlhehe/ArisManager.fxml"));
                Parent root=(Parent) fxmlloader.load();
                Node node = (Node)event.getSource();
                closeStage =(Stage) node.getScene().getWindow();
                closeStage.close();
                ArisManagerController in = fxmlloader.getController();
                in.setAkses(rs.getString("akses"));
                in.setNis(rs.getString("nis"));
                in.setNama(rs.getString("nama"));
                in.setKelas(rs.getString("kelas"));
                stage.setScene(new Scene(root));
                stage.show();
        }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void KePaneHakAkses(ActionEvent event) {
    }
    
}
