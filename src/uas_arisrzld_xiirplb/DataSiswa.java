/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_arisrzld_xiirplb;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author cover jok
 */
public class DataSiswa {
    SimpleStringProperty id = new SimpleStringProperty();
    SimpleStringProperty nama = new SimpleStringProperty();
    SimpleStringProperty jurusan = new SimpleStringProperty();
    SimpleStringProperty kelas = new SimpleStringProperty();
    SimpleStringProperty gender = new SimpleStringProperty();
    SimpleStringProperty pinjam = new SimpleStringProperty();
    
    public String getId()
    {
        return    id.get();
    }
    public void setId(String nilai)
    {
        id.set(nilai);
    }
    public StringProperty idProperty()
    {
        return id;
    }
    public String getNama()
    {
        return    nama.get();
    }
    public void setNama(String nilai)
    {
        nama.set(nilai);
    }
    public StringProperty namaProperty()
    {
        return nama;
    }
    public String getJurusan()
    {
        return    jurusan.get();
    }
    public void setJurusan(String nilai)
    {
        jurusan.set(nilai);
    }
    public StringProperty jurusanProperty()
    {
        return jurusan;
    }
    public String getGender()
    {
        return    gender.get();
    }
    public void setGender(String nilai)
    {
        gender.set(nilai);
    }
    public StringProperty genderProperty()
    {
        return gender;
    }
    public String getKelas()
    {
        return    kelas.get();
    }
    public void setKelas(String nilai)
    {
        kelas.set(nilai);
    }
    public StringProperty kelasProperty()
    {
        return kelas;
    }
    public String getPinjam()
    {
        return    pinjam.get();
    }
    public void setPinjam(String nilai)
    {
        pinjam.set(nilai);
    }
    public StringProperty pinjamProperty()
    {
        return pinjam;
    }
}
