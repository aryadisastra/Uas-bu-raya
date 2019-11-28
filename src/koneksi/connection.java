/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.Alert;

public class connection {
   public Statement stat;
    
    public Connection conn ;
    /*public static Connection koneksi(){
        String driver = "com.mysql.jdbc.Driver";
        String host = "jdbc:mysql://localhost/db_arisrz";
        String user = "root";
        String pass = "";
        try{
            Class.forName(driver);
            Connection conn = (Connection) DriverManager.getConnection (host, user, pass);
            
            
            
            return conn;
        }catch (ClassNotFoundException | SQLException e){
            Alert peringatan = new Alert(Alert.AlertType.ERROR);
            peringatan.setTitle("Peringatan SQL Connection");
            peringatan.setHeaderText(null);
            peringatan.setContentText("+e");
            peringatan.showAndWait();
        }
        return null;
    }*/

    public  void config() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
           conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/db_arisrz", "root", "");
            stat = (Statement) conn.createStatement();
        }catch(Exception Ex)
        {
            Ex.printStackTrace();
            System.out.println("Controller.Koneksi.config()");
        }
        
    }
    

}
