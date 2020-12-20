/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
/**
 *
 * @author alan
 */
import model.pelangganModel;
import database.koneksi;
import java.sql.*;
import java.util.*;
public class pelangganController {
    koneksi konek;
    ArrayList <pelangganModel>pelanggan;
    public pelangganController(){
        konek = new koneksi();
        pelanggan = new ArrayList();
    }
    public ArrayList <pelangganModel> getDataPelanggan() throws SQLException{
        pelanggan.clear();
        ResultSet rs = konek.GetData("SELECT * FROM PELANGGAN");
        while(rs.next()){
            pelangganModel pel = new pelangganModel();
            pel.setId_pelanggan(rs.getInt("ID_PELANGGAN"));
            pel.setNama_pelanggan(rs.getString("NAMA_PELANGGAN"));
            pel.setPassword_pelanggan(rs.getString("PASSWORD"));
            pelanggan.add(pel);
        }
        return pelanggan;
    }
    public void registrasi(Integer id_pelanggan,String nama_pelanggan,String password){
        konek.ManipulasiData("INSERT INTO PELANGGAN VALUES("+id_pelanggan+
                ", '"+nama_pelanggan+"', '"+password+"')");
    }
   
}
