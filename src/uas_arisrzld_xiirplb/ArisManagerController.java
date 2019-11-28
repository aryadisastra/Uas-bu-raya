/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_arisrzld_xiirplb;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import koneksi.connection;

/**
 * FXML Controller class
 *
 * @author cover jok
 */
public class ArisManagerController implements Initializable {

    @FXML
    private AnchorPane paneManager;
    @FXML
    private Label lblnama;
    @FXML
    private Label lblkelas;
    @FXML
    private Label lblaks;
    @FXML
    private Label lblnis;
    @FXML
    private Label lblhal;
    @FXML
    private AnchorPane paneCrud;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;
    @FXML
    private TableView<DataSiswa> tablePegawai;
    @FXML
    private TableColumn<DataSiswa, String> columnID;
    @FXML
    private TableColumn<DataSiswa, String> columnNama;
    @FXML
    private TableColumn<DataSiswa, String> columnAlamat;
    @FXML
    private TableColumn<DataSiswa, String> columnNohp;
    @FXML
    private TableColumn<DataSiswa, String> columnJabatan;
    @FXML
    private TableColumn<DataSiswa, String> columnAgama;
    @FXML
    private Button btnKembali;
    @FXML
    private TextField fieldNama;
    @FXML
    private Button btnTampilkanData;
    @FXML
    private TextField fieldSearch;
    @FXML
    private Label tgl;
    @FXML
    private TextField fieldKelas;
    @FXML
    private ComboBox<String> jabatan;
    @FXML
    private TextField idJab;
    @FXML
    private TextField fieldID;
    @FXML
    private Button btnTambah;
    @FXML
    private RadioButton laki;
    @FXML
    private RadioButton perempuan;
    Stage closeStage = new Stage();
    Connection con ;
            Statement stm;
            ResultSet rs;
    @FXML
    private ToggleGroup gender;
    @FXML
    private Label lblgndr;
    @FXML
    private Label lbljurusan;
    Date tglk = new Date();
    SimpleDateFormat jam = new SimpleDateFormat("dd/MM/YYYY");
    String a=jam.format(tglk);
    @FXML
    private TextField dtepinjam;
    ObservableList<DataSiswa> listdata;
            

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        aksitabel();
        tabel();
        connection db = new connection();
        db.config();
        con = db.conn;
        stm = db.stat;
        dtepinjam.setEditable(false);
        fieldID.setDisable(false);
        fieldID.setEditable(true);
        dtepinjam.setText(a);
        jabatan.getItems().setAll("====JURUSAN====","MESIN","MULTI","ANIMASI","MEKA","RPL","KIMIA");
        jabatan.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                lbljurusan.setText(newValue);
            }
            
        });
        if(laki.isSelected())
        {
            lblgndr.setText("Laki-Laki");
        }
        if(perempuan.isSelected())
        {
            lblgndr.setText("Perempuan");
        }
    }    
    
    public void setAkses(String akses)
    {
        lblaks.setText(akses);
        lblhal.setText("*Hal "+akses);
        if(akses.equals("admin"))
        {
            paneCrud.setVisible(true);
        }
        else
        {
            paneCrud.setVisible(false);
        }
        
    }
    public void setNis(String nis)
    {
        lblnis.setText(nis);
    }
    public void setNama(String nama)
    {
        lblnama.setText(nama);
    }
    public void setKelas(String kelas)
    {
        lblkelas.setText(kelas);
    }

    private void KePaneHakAses(ActionEvent event) {
        try{
            AnchorPane pane =FXMLLoader.load(getClass().getResource("/fxmlhehe/ArisHakAkses.fxml"));
            paneManager.getChildren().setAll(pane);
        }
        catch (IOException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(""+e);
        }
    }

    @FXML
    private void deleteDataPegawaiDariDatabase(ActionEvent event) {
        try{
            String sql = "delete from siswa where id_siswa = '"+fieldID.getText()+"'";
            stm.execute(sql);
            tabel();
            aksitabel();
            fieldID.setText("");
            fieldKelas.setText("");
            fieldNama.setText("");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void updateDataPegawaiDariDatabase(ActionEvent event) {
        try{
            String sql = "update siswa set id_siswa = '"+fieldID.getText()+"', nama = '"+fieldNama.getText()+"', jurusan = '"+lbljurusan.getText()+"', gender = '"+lblgndr.getText()+"' where id = '"+fieldID.getText()+"'";
            stm.execute(sql);
            tabel();
            aksitabel();
            fieldID.setText("");
            fieldKelas.setText("");
            fieldNama.setText("");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void showOnClick(MouseEvent event) {
        DataSiswa ambil = tablePegawai.getSelectionModel().getSelectedItem();
        fieldID.setText(ambil.getId());
        fieldNama.setText(ambil.getNama());
        fieldKelas.setText(ambil.getKelas());
        
    }

    @FXML
    private void KePaneHadir(ActionEvent event) {
    }

    @FXML
    private void gaBisaKetikAngka(KeyEvent event) {
    }

    @FXML
    private void TampilkanDataDariDatabase(ActionEvent event) {
    }

    @FXML
    private void searchUser(InputMethodEvent event) {
    }

    @FXML
    private void searchUser(KeyEvent event) {
    }

    @FXML
    private void gaBisaKetikHuruf(KeyEvent event) {
    }

    @FXML
    private void jabatan(ActionEvent event) {
    }

    @FXML
    private void TambahDataKeDataBase(ActionEvent event) {
        try{
            String sql = "insert into siswa values('"+fieldID.getText()+"','"+fieldNama.getText()+"','"+lbljurusan.getText()+"','"+fieldKelas.getText()+"','"+lblgndr.getText()+"','"+a+"')";
            stm.execute(sql);
            aksitabel();
        tabel();
            JOptionPane.showMessageDialog(null, "Input Berhasil");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void outKlik(ActionEvent event) {
        Stage stage =new Stage();
        try{
        FXMLLoader fxmlloader= new
                FXMLLoader(getClass().getResource("/fxmlhehe/ArisLogin.fxml"));
                Parent root=(Parent) fxmlloader.load();
                Node node = (Node)event.getSource();
                closeStage =(Stage) node.getScene().getWindow();
                closeStage.close();
                stage.setScene(new Scene(root));
                stage.show();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    private void lakiklik(MouseEvent event) {
        lblgndr.setText("Laki-laki");
    }

    @FXML
    private void cwklik(MouseEvent event) {
        lblgndr.setText("Perempuan");
    }
    public ObservableList<DataSiswa> getDataAll()
    {
        ObservableList<DataSiswa> listdata =FXCollections.observableArrayList();
        try{
            connection db = new connection();
            db.config();
            con = db.conn;
            stm = db.stat;
            String sql = "Select * from siswa";
            rs= stm.executeQuery(sql);
            while(rs.next())
            {
                
                DataSiswa d = new DataSiswa();
                d.setId(rs.getString("id_siswa"));
                d.setNama(rs.getString("nama"));
                d.setJurusan(rs.getString("jurusan"));
                d.setKelas(rs.getString("kelas"));
                d.setGender(rs.getString("gender"));
                d.setPinjam(rs.getString("pinjam"));
                listdata.add(d);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return listdata;
    }
    private void tabel()
    {
        columnID.setCellValueFactory((TableColumn.CellDataFeatures<DataSiswa, String> celData) -> 
            celData.getValue().idProperty()
        );
        columnNama.setCellValueFactory((TableColumn.CellDataFeatures<DataSiswa, String> celData) -> 
            celData.getValue().namaProperty()
        );
        columnNohp.setCellValueFactory((TableColumn.CellDataFeatures<DataSiswa, String> celData) -> 
            celData.getValue().kelasProperty()
        );
        columnAlamat.setCellValueFactory((TableColumn.CellDataFeatures<DataSiswa, String> celData) -> 
            celData.getValue().jurusanProperty()
        );
        columnJabatan.setCellValueFactory((TableColumn.CellDataFeatures<DataSiswa, String> celData) -> 
            celData.getValue().genderProperty()
        );
        columnAgama.setCellValueFactory((TableColumn.CellDataFeatures<DataSiswa, String> celData) -> 
            celData.getValue().pinjamProperty()
        );
        listdata = FXCollections.observableArrayList();
        tablePegawai.getSelectionModel().clearSelection();
    }
    private void aksitabel()
    {
        listdata = getDataAll();
        tablePegawai.setItems(listdata);
    }

    @FXML
    private void klikWarung(ActionEvent event) {
        Stage stage =new Stage();
        try{
        FXMLLoader fxmlloader= new
                FXMLLoader(getClass().getResource("/fxmlhehe/Warung.fxml"));
                Parent root=(Parent) fxmlloader.load();
                Node node = (Node)event.getSource();
                stage.setScene(new Scene(root));
                stage.show();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
