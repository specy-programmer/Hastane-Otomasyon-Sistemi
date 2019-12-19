package gazitfbm.proje.hastaEkranlari;

import gazitfbm.proje.doktorEkranlari.GirisEkrani;
import gazitfbm.proje.vt.VeriTabaniErisim;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HastaSilmePenceresi extends HastaKayitPenceresi {
    public static JFrame hastaKayitSilmePenceresi = new JFrame("Hasta Kayıt Silme Penceresi");
    public static JButton silmeButonu = new JButton("Kayıt Sil");
    public static JLabel tcSatiri = new JLabel("Tc no giriniz :");
    public static JLabel hastaAdi_satiri = new JLabel("Adınızı giriniz :");
    public static JLabel hastaSoyadi_satiri = new JLabel("Soyadınızı giriniz:");
    public static JTextField hastaAdiTextField = new JTextField();
    public static JTextField hastaSoyadiTextField = new JTextField();
    public static JTextField tcNumarasiTextField = new JTextField();
    static JButton menuButonu = new JButton("Ana Menü");

    public static void hastaSilmePenceresiGorunumu(){
        tcSatiri.setBounds(50, 20, 150, 30);
        hastaAdi_satiri.setBounds(50, 50, 150, 30);
        hastaSoyadi_satiri.setBounds(50,80,150,30);
        tcNumarasiTextField.setBounds(250, 20, 150, 30);
        hastaAdiTextField.setBounds(250, 50, 150, 30);
        hastaSoyadiTextField.setBounds(250,80,150,30);
        silmeButonu.setBounds(60,140,95,30);
        menuButonu.setBounds(600,50,150,30);

        silmeButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hastaTcNo , sql_sorguSilme;
                hastaTcNo = tcNumarasiTextField.getText();
                sql_sorguSilme = "DELETE FROM hastalar WHERE tcHasta_no="+hastaTcNo;
                System.out.println(sql_sorguSilme);
                VeriTabaniErisim objSil = new VeriTabaniErisim();
                objSil.veriSil(sql_sorguSilme);
                JOptionPane.showMessageDialog(null,"Randevunuz başarıyla silindi");
            }
        });

        menuButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hastaKayitSilmePenceresi.setVisible(false);
                GirisEkrani.giris_ekrani.setVisible(true);
            }
        });

        hastaKayitSilmePenceresi.add(menuButonu);
        hastaKayitSilmePenceresi.add(silmeButonu);
        hastaKayitSilmePenceresi.add(tcSatiri);
        hastaKayitSilmePenceresi.add(hastaAdi_satiri);
        hastaKayitSilmePenceresi.add(hastaSoyadi_satiri);
        hastaKayitSilmePenceresi.add(tcNumarasiTextField);
        hastaKayitSilmePenceresi.add(hastaAdiTextField);
        hastaKayitSilmePenceresi.add(hastaSoyadiTextField);
        hastaKayitSilmePenceresi.setSize(800,800);
        hastaKayitSilmePenceresi.setLayout(null);
        hastaKayitSilmePenceresi.setVisible(false);
        hastaKayitSilmePenceresi.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
