/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Date;
/**
 *
 * @author alan
 */
public class transaksiModel {
    private Integer id_transaksi;
    private double total,bayar,kembali;
    private Date tanggal;
    private String nama_pelanggan;
    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }
    public String getNama_pelanggan() {
        return nama_pelanggan;
    }
    public void setId_transaksi(Integer id_transaksi) {
        this.id_transaksi = id_transaksi;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public void setBayar(double bayar) {
        this.bayar = bayar;
    }
    public void setKembali(double kembali) {
        this.kembali = kembali;
    }
    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    public Integer getId_transaksi() {
        return id_transaksi;
    }
    public double getTotal() {
        return total;
    }
    public double getBayar() {
        return bayar;
    }
    public double getKembali() {
        return kembali;
    }
    public Date getTanggal() {
        return tanggal;
    }
}
