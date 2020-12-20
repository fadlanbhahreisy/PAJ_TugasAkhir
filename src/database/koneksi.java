/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author alan
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class koneksi {
    private Connection connect;
    private Statement db;
    private String database = "toko";
    public koneksi(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("");
            try {
                connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "fadlan_bhahreisy",
                        "fadlan_bhahreisy");
                System.out.println("");
            } catch (SQLException se) {
                System.out.println("Koneksi Database Gagal : " + se);
            }
        } catch (ClassNotFoundException err) {
            System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan Pada : " + err);
        }
    }
    public ResultSet GetData(String sql) {
        try {
            db = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            return db.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
    }
    public int ManipulasiData(String sql) {
        try {
            db = connect.createStatement();
            return db.executeUpdate(sql);
        } catch (SQLException e) {
            return 0;
        }
    }
}
