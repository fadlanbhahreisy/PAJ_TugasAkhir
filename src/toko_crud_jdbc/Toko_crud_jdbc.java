/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko_crud_jdbc;

/**
 *
 * @author alan
 */
import controller.*;
import java.sql.SQLException;
import java.util.*;
import model.barangModel;
public class Toko_crud_jdbc {
    /**
     * @param args the command line arguments
     */
    static Scanner input = new Scanner(System.in);
    static barangController bar = new barangController();
    static pelangganController pel = new pelangganController();
    static transaksiController tran = new transaksiController();
    static ArrayList<barangModel> keranjang = new ArrayList();
    public static void main(String[] args) throws SQLException {
        int pilih;
        do{
            System.out.println("1. Login");
            System.out.println("2. Registrasi");
            System.out.println("0. exit");
            System.out.print("Pilih = ");
            pilih = input.nextInt();
            if(pilih == 1){
                System.out.println("1. login Admin");
                System.out.println("2. login user");
                System.out.print("pilih = ");
                int pil = input.nextInt();
                if(pil == 1){
                    System.out.print("username admin = ");
                    String username = input.next();
                    System.out.print("password admin = ");
                    String password = input.next();
                    if(username.equals("admin")&&password.equals("pass")){
                        System.out.println("1. manage barang ");
                        System.out.println("2. view record transaksi");
                        System.out.print("pilih  = ");
                        int pill = input.nextInt();
                        if(pill==1){
                            manage_barang();
                        }else if(pill==2){
                            view_transaksi();
                        }
                    }
                }else if(pil==2){
                    transaksi();
                }
            }else if(pilih==2){
                registrasi();
            }
        }while(pilih!=0);
        
    }
    static void manage_barang() throws SQLException{
        int pil;
        do{
            System.out.println("1. input_barang");
            System.out.println("2. update barang");
            System.out.println("3. delete barang");
            System.out.println("0. exit");
            System.out.print("pilih = ");
            pil = input.nextInt();
            switch(pil){
                case 1:
                    view_barang();
                    input_barang();
                    view_barang();
                    break;
                case 2:
                    view_barang();
                    update_barang();
                    view_barang();
                    break;
                case 3:
                    view_barang();
                    delete_barang();
                    view_barang();
                    break;
            }
        }while(pil!=0);
        
    }
        static void registrasi() throws SQLException{
        System.out.print("Nama Anda = ");
        String nama = input.next();
        System.out.print("Password = ");
        String pass = input.next();
        pel.registrasi(pel.getDataPelanggan().size()+1, nama, pass);
    }
    static void input_barang(){
        System.out.print("Id barang = ");
        Integer id_barang = input.nextInt();
        System.out.print("Nama Barang = ");
        String nama_barang = input.next();
        System.out.print("Harga Barang = ");
        double harga_barang = input.nextDouble();
        bar.insert_barang(id_barang, nama_barang, harga_barang);
    }
    static void update_barang(){
        System.out.print("Id barang = ");
        Integer id_barang = input.nextInt();
        System.out.print("Nama Barang = ");
        String nama_barang = input.next();
        System.out.print("Harga Barang = ");
        double harga_barang = input.nextDouble();
        bar.update_barang(id_barang, nama_barang, harga_barang);
    }
    static void delete_barang(){
        System.out.print("Id barang = ");
        Integer id_barang = input.nextInt();
        bar.delete_barang(id_barang);
    }
    static void view_barang() throws SQLException{
        for(int i=0;i<bar.getDataBarang().size();i++){
            System.out.println(i+" "
                    + ""+bar.getDataBarang().get(i).getNama_barang()+""
                    + " "+bar.getDataBarang().get(i).getHarga_barang());
        }
    }

    static public void transaksi() throws SQLException{
        String ulang,tanggal;
        double total=0,bayar,kembali;
        Integer id_pelanggan = null;
        boolean ketemu = false;
        System.out.println("tanggal = ");
        tanggal = input.next();
        System.out.print("Nama Anda = ");
        String nama = input.next();
        System.out.print("Password = ");
        String pass = input.next();
        for(int i=0;i<pel.getDataPelanggan().size();i++){
            if(nama.equals(pel.getDataPelanggan().get(i).getNama_pelanggan())&&
                    pass.equals(pel.getDataPelanggan().get(i).getPassword_pelanggan())){
                ketemu = true;
                id_pelanggan = pel.getDataPelanggan().get(i).getId_pelanggan();
                System.out.println(id_pelanggan);
            }
        }
        if (ketemu == true){
            keranjang = new ArrayList();
            view_barang();
            do{
                System.out.print("Pilih no Barang = ");
                Integer id_barang = input.nextInt();
                keranjang.add(bar.getDataBarang().get(id_barang));
                for(int i=0;i<keranjang.size();i++){
                    System.out.println(keranjang.get(i).getNama_barang());
                }
                System.out.print("Beli Lagi(y/n)?");
                ulang = input.next();
            }while(ulang.equals("y")||ulang.equals("Y"));
            for(int i=0;i<keranjang.size();i++){
                total = total + keranjang.get(i).getHarga_barang();
            }
            System.out.println("Total belanja anda = "+total);
            System.out.print("bayar = ");
            bayar = input.nextDouble();
            kembali = bayar - total;
            System.out.println("kembali = "+kembali);
            tran.insert_transaksi(tran.getTransaksi().size()+1, total, bayar, kembali, tanggal, id_pelanggan);
        }else{
            System.out.println("akun tidak ada");
        }
    }
    static public void view_transaksi() throws SQLException{
        for(int i=0;i<tran.getTransaksi().size();i++){
            System.out.println(tran.getTransaksi().get(i).getId_transaksi()+" "
                    + tran.getTransaksi().get(i).getTotal()+" "
                    + tran.getTransaksi().get(i).getBayar()+" "
                    + tran.getTransaksi().get(i).getKembali()+" "
                    + tran.getTransaksi().get(i).getTanggal()+" "
                    + tran.getTransaksi().get(i).getNama_pelanggan());
        }
    }
}
