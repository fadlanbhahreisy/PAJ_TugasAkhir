/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import database.koneksi;
import java.sql.*;
import java.util.ArrayList;
import model.transaksiModel;
/**
 *
 * @author alan
 */
public class transaksiController {
    koneksi konek;
    ArrayList<transaksiModel> transaksi;
    public transaksiController(){
        konek = new koneksi();
        transaksi = new ArrayList();
    }
    public void insert_transaksi(Integer id_transaksi,double total,double bayar,
            double kembali,String tanggal,Integer id_pelanggan){
        konek.ManipulasiData("INSERT INTO TRANSAKSI VALUES("+id_transaksi+", "+total+", "+bayar
        +", "+kembali+", "+"TO_DATE('"+tanggal+"','DD/MM/YYYY') ,"+id_pelanggan+")");
    }
    public ArrayList<transaksiModel> getTransaksi() throws SQLException{
        transaksi.clear();
        ResultSet rs = konek.GetData("SELECT * FROM TRANSAKSI JOIN PELANGGAN ON TRANSAKSI.ID_PELANGGAN = PELANGGAN.ID_PELANGGAN");
        while(rs.next()){
            transaksiModel tran = new transaksiModel();
            tran.setId_transaksi(rs.getInt("ID_TRANSAKSI"));
            tran.setTotal(rs.getDouble("TOTAL"));
            tran.setBayar(rs.getDouble("BAYAR"));
            tran.setKembali(rs.getDouble("KEMBALI"));
            tran.setTanggal(rs.getDate("TANGGAL"));
            tran.setNama_pelanggan(rs.getString("NAMA_PELANGGAN"));
            transaksi.add(tran);
        }
        return transaksi;
    }
}
