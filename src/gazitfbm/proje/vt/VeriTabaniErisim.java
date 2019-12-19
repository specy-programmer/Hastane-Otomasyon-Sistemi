package gazitfbm.proje.vt;

import gazitfbm.proje.vt.IVeriTabaniErisim;

import javax.swing.*;
import java.sql.*;

public class VeriTabaniErisim implements IVeriTabaniErisim {

   static Connection myConn;

    @Override
    public void baglantiKurulumu() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            myConn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hastane?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void veriEkle(String sql_sorguEkle) {
        baglantiKurulumu();
        try {
            PreparedStatement posted = myConn.prepareStatement(sql_sorguEkle);
            posted.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Bilgileri Hatalı Girdiniz");
            System.out.println(e); }
        finally {
            System.out.println("Veri ekleme başarılı.");
        }
    }

    @Override
    public void veriSil(String sql_sorguSilme) {
        baglantiKurulumu();
        try {
            PreparedStatement posted = myConn.prepareStatement(sql_sorguSilme);
            posted.executeUpdate();
        } catch (Exception e) {
            System.out.println(e); }
        finally {
            System.out.println("Veri silme başarılı.");
        }
    }

    @Override
    public ResultSet girisSorgula(String sqlGirisi_sorgu){
        baglantiKurulumu();
        ResultSet myRs = null;
        try{
            PreparedStatement posted = myConn.prepareStatement(sqlGirisi_sorgu);
            myRs = posted.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return myRs;
    }

    @Override
    public void veriGuncelle(String sql_sorguGuncelle) {
        try {
            PreparedStatement posted = myConn.prepareStatement(sql_sorguGuncelle);
            posted.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Veri güncelleme başarılı.");
        }
    }

    public ResultSet veriListeleme(){
        baglantiKurulumu();
        ResultSet myRs = null;
        try {
            PreparedStatement posted = myConn.prepareStatement("SELECT * FROM hastalar");
            myRs = posted.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myRs ;
    }
}