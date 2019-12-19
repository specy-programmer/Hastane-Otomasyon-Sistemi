package gazitfbm.proje.doktorEkranlari;

import gazitfbm.proje.EkranAyarlari;
import gazitfbm.proje.vt.VeriTabaniErisim;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoktorGirisEkrani extends EkranAyarlari {
    static JFrame doktorGirisPenceresi = new JFrame("Doktor Giriş Ekranı");
    private static JLabel tcSatiri = new JLabel("Tc no giriniz :");
    private static JLabel doktorAdi_satiri = new JLabel("Adınızı giriniz :");
    private static JLabel doktorSoyadi_satiri = new JLabel("Soyadınızı giriniz:");
    public static JButton doktorGiris_butonu = new JButton("Giriş");
    public static JTextField doktorAdiTextField = new JTextField();
    public static JTextField doktorSoyadiTextField = new JTextField();
    private static JTextField tcNumarasiTextField = new JTextField();
    public static String mesaj;
    static JButton menuButonu = new JButton("Ana Menü");
    public static void doktorGirisEkraniGorunumu(){
        tcSatiri.setBounds(50, 20, 150, 30);
        doktorAdi_satiri.setBounds(50, 50, 150, 30);
        doktorSoyadi_satiri.setBounds(50,80,150,30);
        tcNumarasiTextField.setBounds(250, 20, 150, 30);
        doktorAdiTextField.setBounds(250, 50, 150, 30);
        doktorSoyadiTextField.setBounds(250,80,150,30);
        doktorGiris_butonu.setBounds(50,140,95,30);
        menuButonu.setBounds(600,50,150,30);

        doktorGiris_butonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String  doktorAdi , doktorSoyadi ;
                String tcNo ;
                String sqlDoktorGirisi_sorgu;
                tcNo = tcNumarasiTextField.getText();
                doktorAdi = doktorAdiTextField.getText();
                doktorSoyadi = doktorSoyadiTextField.getText();
                mesaj = "Hoşgeldiniz "+doktorAdi+" "+doktorSoyadi;
                DoktorEkrani.mesajKutusu.setText(mesaj);

                sqlDoktorGirisi_sorgu = "SELECT * FROM doktorlar WHERE doktorTc_no="+tcNo;
                VeriTabaniErisim obj = new VeriTabaniErisim();
                ResultSet myRs;
                myRs =  obj.girisSorgula(sqlDoktorGirisi_sorgu);
                System.out.println(sqlDoktorGirisi_sorgu);
                try {
                    if(myRs.next()){
                        doktorGirisPenceresi.setVisible(false);
                        DoktorEkrani.doktorEkrani.setVisible(true);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Hatalı bilgi girdiniz.");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        menuButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doktorGirisPenceresi.setVisible(false);
                GirisEkrani.giris_ekrani.setVisible(true);
            }
        });

        doktorGirisPenceresi.add(menuButonu);
        doktorGirisPenceresi.add(tcSatiri);
        doktorGirisPenceresi.add(doktorAdi_satiri);
        doktorGirisPenceresi.add(doktorSoyadi_satiri);
        doktorGirisPenceresi.add(doktorGiris_butonu);
        doktorGirisPenceresi.add(tcNumarasiTextField);
        doktorGirisPenceresi.add(doktorAdiTextField);
        doktorGirisPenceresi.add(doktorSoyadiTextField);
        doktorGirisPenceresi.add(tcNumarasiTextField);
        doktorGirisPenceresi.setSize(800,800);
        doktorGirisPenceresi.setLayout(null);
        doktorGirisPenceresi.setVisible(false);
        doktorGirisPenceresi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void doktorrGirisEkraniGorunumu() {
        doktorGirisEkraniGorunumu();
    }
}
