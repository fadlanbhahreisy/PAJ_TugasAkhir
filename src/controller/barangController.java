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
import model.barangModel;
import database.koneksi;
import java.sql.*;
import java.util.*;
public class barangController {
    koneksi konek;
    ArrayList <barangModel>barang;
    public barangController(){
        konek = new koneksi();
        barang = new ArrayList();
    }
    public void insert_barang(Integer id_barang,String nama_barang,double harga_barang){
        konek.ManipulasiData("INSERT INTO BARANG VALUES("+id_barang+", '"+nama_barang+"', "+harga_barang+")");
    }
    public void update_barang(Integer id_barang,String nama_barang,double harga_barang){
        konek.ManipulasiData("UPDATE BARANG SET NAMA_BARANG= '"+nama_barang+"',"+
                "HARGA_BARANG = "+harga_barang+" WHERE ID_BARANG = "+id_barang);
    }
    public void delete_barang(Integer id_barang){
        konek.ManipulasiData("DELETE FROM BARANG WHERE ID_BARANG = "+id_barang);
    }
    public ArrayList <barangModel> getDataBarang() throws SQLException{
        barang.clear();
        ResultSet rs = konek.GetData("SELECT * FROM BARANG");
        while(rs.next()){
            barangModel bar = new barangModel();
            bar.setId_barang(rs.getInt("ID_BARANG"));
            bar.setNama_barang(rs.getString("NAMA_BARANG"));
            bar.setHarga_barang(rs.getDouble("HARGA_BARANG"));
            barang.add(bar);
        }
        return barang;
    } 
}
