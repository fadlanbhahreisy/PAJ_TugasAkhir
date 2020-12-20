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
public class pelangganModel {
    private Integer id_pelanggan;
    private String nama_pelanggan,password_pelanggan;
    public void setId_pelanggan(Integer id_pelanggan) {
        this.id_pelanggan = id_pelanggan;
    }
    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }
    public void setPassword_pelanggan(String password_pelanggan) {
        this.password_pelanggan = password_pelanggan;
    }
    public Integer getId_pelanggan() {
        return id_pelanggan;
    }
    public String getNama_pelanggan() {
        return nama_pelanggan;
    }
    public String getPassword_pelanggan() {
        return password_pelanggan;
    }
}
