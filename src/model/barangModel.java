/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/**
 *
 * @author alan
 */
public class barangModel {
    private Integer id_barang;
    private String nama_barang;
    private double harga_barang;
    public void setId_barang(Integer id_barang) {
        this.id_barang = id_barang;
    }
    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }
    public void setHarga_barang(double harga_barang) {
        this.harga_barang = harga_barang;
    }
    public Integer getId_barang() {
        return id_barang;
    }
    public String getNama_barang() {
        return nama_barang;
    }
    public double getHarga_barang() {
        return harga_barang;
    }
}
