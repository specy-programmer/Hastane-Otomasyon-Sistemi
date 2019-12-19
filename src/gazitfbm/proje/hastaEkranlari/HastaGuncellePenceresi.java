package gazitfbm.proje.hastaEkranlari;

import gazitfbm.proje.doktorEkranlari.GirisEkrani;
import gazitfbm.proje.TarihAyari;
import gazitfbm.proje.vt.VeriTabaniErisim;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class HastaGuncellePenceresi extends HastaKayitPenceresi {
    public static JFrame hastaKayitGuncellePenceresi = new JFrame();
    private static JButton guncelleButonu = new JButton("Randevu Güncelle");
    private static JLabel tcSatiri = new JLabel("Tc no giriniz : (Tc no güncellenemez)");
    private static JLabel hastaAdi_satiri = new JLabel("Adınızı giriniz : (Ad güncellenemez)");
    private static JLabel hastaSoyadi_satiri = new JLabel("Soyadınızı giriniz : (Soyad güncellenemez)");
    private static JLabel poliklinikMesaj = new JLabel("Polikliniği seçiniz :");
    private static JLabel doktorMesaj = new JLabel("Doktor seçiniz :");
    private static JLabel tarihMesaj = new JLabel("Randevu tarihini ve saatini seçiniz :");
    private static JTextField hastaAdiTextField = new JTextField();
    private static JTextField hastaSoyadiTextField = new JTextField();
    private static JTextField tcNumarasiTextField = new JTextField();
    private static String poliklinikler[] = {"Beyin Cerrahisi Polikliniği","Kalp ve Damar Cerrahisi Polikliniği","Nöroloji Polikliniği"};
    private static JComboBox poliklinikSecenegi = new JComboBox(poliklinikler);
    private static String hastaSecilen_doktorlar[] = {"Doç. Dr. Mehmet Yıldız","Dr. Mert Gördü"};
    private static JComboBox hastaDoktor_secenegi = new JComboBox(hastaSecilen_doktorlar);
    private static String hastaSecilen_doktor;
    private static JComboBox secilenRandevu_tarihleri = new JComboBox();
    private static JComboBox yeniDoktor_secenegi1 = new JComboBox<>();
    private static JComboBox yeniDoktor_secenegi2 = new JComboBox<>();
    static JButton menuButonu = new JButton("Ana Menü");
    public static void hastaGuncellePenceresiGorunumu(){
        menuButonu.setBounds(600,50,150,30);
        tcSatiri.setBounds(50, 20, 220, 30);
        hastaAdi_satiri.setBounds(50, 50, 200, 30);
        hastaSoyadi_satiri.setBounds(50,80,250,30);
        poliklinikSecenegi.setBounds(250,120,150,30);
        poliklinikMesaj.setBounds(50,120,150,30);
        doktorMesaj.setBounds(50,160,150,30);
        tarihMesaj.setBounds(50,200,210,30);
        hastaDoktor_secenegi.setBounds(250,160,150,30);
        tcNumarasiTextField.setBounds(350, 20, 150, 30);
        hastaAdiTextField.setBounds(350, 50, 150, 30);
        hastaSoyadiTextField.setBounds(350,80,150,30);
        secilenRandevu_tarihleri.setBounds(280,200,180,30);
        guncelleButonu.setBounds(50, 265, 170, 30);

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        Calendar cal3 = Calendar.getInstance();
        cal1.add(Calendar.DATE,10);
        cal2.add(Calendar.DATE,5);
        cal3.add(Calendar.DATE,3);
        secilenRandevu_tarihleri.addItem(new TarihAyari(cal1.getTime())+" 10:00");
        secilenRandevu_tarihleri.addItem(new TarihAyari(cal1.getTime())+" 12:00");
        secilenRandevu_tarihleri.addItem(new TarihAyari(cal2.getTime())+" 10:00");
        secilenRandevu_tarihleri.addItem(new TarihAyari(cal2.getTime())+" 12:00");
        secilenRandevu_tarihleri.addItem(new TarihAyari(cal3.getTime())+" 9:00");
        secilenRandevu_tarihleri.addItem(new TarihAyari(cal3.getTime())+" 14:00");

        poliklinikSecenegi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (poliklinikSecenegi.getItemAt(poliklinikSecenegi.getSelectedIndex()) == "Kalp ve Damar Cerrahisi Polikliniği") {
                    yeniDoktor_secenegi1 = new JComboBox(new String[]{"Op. Dr. Yılmaz Durmuş","Dr. Necati Korkmaz"});
                    yeniDoktor_secenegi1.setBounds(250, 160, 150, 30);
                    hastaKayitGuncellePenceresi.add(yeniDoktor_secenegi1);
                    hastaDoktor_secenegi.setVisible(false);
                    yeniDoktor_secenegi2.setVisible(false);
                    yeniDoktor_secenegi1.setVisible(true);
                    hastaSecilen_doktor = (String) yeniDoktor_secenegi1.getItemAt(yeniDoktor_secenegi1.getSelectedIndex());
                }

                if (poliklinikSecenegi.getItemAt(poliklinikSecenegi.getSelectedIndex()) == "Nöroloji Polikliniği") {
                    yeniDoktor_secenegi2 = new JComboBox(new String[]{"Dr. Ömer Kargı","Doç. Dr. Ahmet Gürbüz"});
                    yeniDoktor_secenegi2.setBounds(250, 160, 150, 30);
                    hastaKayitGuncellePenceresi.add(yeniDoktor_secenegi2);
                    hastaDoktor_secenegi.setVisible(false);
                    yeniDoktor_secenegi1.setVisible(false);
                    yeniDoktor_secenegi2.setVisible(true);
                    hastaSecilen_doktor = (String) yeniDoktor_secenegi2.getItemAt(yeniDoktor_secenegi2.getSelectedIndex());
                }

                if (poliklinikSecenegi.getItemAt(poliklinikSecenegi.getSelectedIndex()) == "Beyin Cerrahisi Polikliniği") {
                    hastaDoktor_secenegi.setVisible(true);
                    yeniDoktor_secenegi1.setVisible(false);
                    yeniDoktor_secenegi2.setVisible(false);
                    hastaSecilen_doktor = (String) hastaDoktor_secenegi.getItemAt(hastaDoktor_secenegi.getSelectedIndex());
                }
            }
        });

        guncelleButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tc, hastaAd, hastaSoyad, hastaSecilen_poliklinik , sql_sorguGiris , hastaRandevu, sql_sorguGuncelle;
                hastaAd = hastaAdiTextField.getText();
                hastaSoyad = hastaSoyadiTextField.getText();
                hastaRandevu = (String) secilenRandevu_tarihleri.getItemAt(secilenRandevu_tarihleri.getSelectedIndex());
                hastaSecilen_poliklinik = (String)  poliklinikSecenegi.getItemAt( poliklinikSecenegi.getSelectedIndex());
                tc = tcNumarasiTextField.getText();
                sql_sorguGiris =  "SELECT * FROM hastalar WHERE tcHasta_no="+tc;
                VeriTabaniErisim obj = new VeriTabaniErisim();
                ResultSet myRs;
                myRs = obj.girisSorgula(sql_sorguGiris);
                sql_sorguGuncelle = "UPDATE hastalar SET hasta_poliklinik='"+hastaSecilen_poliklinik+"',hasta_doktor='"
                +hastaSecilen_doktor+"',hasta_randevuSaati='"+hastaRandevu+"' WHERE tcHasta_no="+tc;

                try {
                    if (myRs.next()){
                        System.out.println(sql_sorguGuncelle);
                        obj.veriGuncelle(sql_sorguGuncelle);
                        JOptionPane.showMessageDialog(null,"Kayıt başarıyla güncellendi");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Kayıt bulunamadığından işlem gerçekleşmedi");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        menuButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hastaKayitGuncellePenceresi.setVisible(false);
                GirisEkrani.giris_ekrani.setVisible(true);
            }
        });

        hastaKayitGuncellePenceresi.add(poliklinikMesaj);
        hastaKayitGuncellePenceresi.add(doktorMesaj);
        hastaKayitGuncellePenceresi.add(tarihMesaj);
        hastaKayitGuncellePenceresi.add(menuButonu);
        hastaKayitGuncellePenceresi.add(guncelleButonu);
        hastaKayitGuncellePenceresi.add(tcSatiri);
        hastaKayitGuncellePenceresi.add(hastaAdi_satiri);
        hastaKayitGuncellePenceresi.add(hastaSoyadi_satiri);
        hastaKayitGuncellePenceresi.add(poliklinikSecenegi);
        hastaKayitGuncellePenceresi.add(hastaDoktor_secenegi);
        hastaKayitGuncellePenceresi.add(tcNumarasiTextField);
        hastaKayitGuncellePenceresi.add(hastaAdiTextField);
        hastaKayitGuncellePenceresi.add(hastaSoyadiTextField);
        hastaKayitGuncellePenceresi.add(secilenRandevu_tarihleri);
        hastaKayitGuncellePenceresi.setSize(800, 800);
        hastaKayitGuncellePenceresi.setLayout(null);
        hastaKayitGuncellePenceresi.setVisible(false);
        hastaKayitGuncellePenceresi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
