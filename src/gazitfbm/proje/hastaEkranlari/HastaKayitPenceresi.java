package gazitfbm.proje.hastaEkranlari;

import gazitfbm.proje.doktorEkranlari.GirisEkrani;
import gazitfbm.proje.TarihAyari;
import gazitfbm.proje.vt.VeriTabaniErisim;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Calendar;

public class HastaKayitPenceresi {
   static JFrame hasta_penceresi = new JFrame("Hasta Kayıt");
   private static JButton girisButonu = new JButton("Randevu al");
   private static JLabel tcSatiri = new JLabel("Tc no giriniz :");
   private static JLabel hastaAdi_satiri = new JLabel("Adınızı giriniz :");
   private static JLabel hastaSoyadi_satiri = new JLabel("Soyadınızı giriniz :");
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
   public static void hastaPenceresiGorunumu() {

        tarihAyari();
        gorunumAyari();

        poliklinikSecenegi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (poliklinikSecenegi.getItemAt(poliklinikSecenegi.getSelectedIndex()) == "Kalp ve Damar Cerrahisi Polikliniği") {
                    yeniDoktor_secenegi1 = new JComboBox(new String[]{"Op. Dr. Yılmaz Durmuş","Dr. Necati Korkmaz"});
                    yeniDoktor_secenegi1.setBounds(250, 160, 150, 30);
                    hasta_penceresi.add(yeniDoktor_secenegi1);
                    hastaDoktor_secenegi.setVisible(false);
                    yeniDoktor_secenegi2.setVisible(false);
                    yeniDoktor_secenegi1.setVisible(true);
                    hastaSecilen_doktor = (String) yeniDoktor_secenegi1.getItemAt(yeniDoktor_secenegi1.getSelectedIndex());
                }

                if (poliklinikSecenegi.getItemAt(poliklinikSecenegi.getSelectedIndex()) == "Nöroloji Polikliniği") {
                    yeniDoktor_secenegi2 = new JComboBox(new String[]{"Dr. Ömer Kargı","Doç. Dr. Ahmet Gürbüz"});
                    yeniDoktor_secenegi2.setBounds(250, 160, 150, 30);
                    hasta_penceresi.add(yeniDoktor_secenegi2);
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

        girisButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String hastaTcNo, hastaAd, hastaSoyad, hastaSecilen_poliklinik , sql_sorguEkle , hastaRandevu;
                hastaTcNo = tcNumarasiTextField.getText();
                hastaAd = hastaAdiTextField.getText();
                hastaSoyad = hastaSoyadiTextField.getText();
                hastaRandevu = (String) secilenRandevu_tarihleri.getItemAt(secilenRandevu_tarihleri.getSelectedIndex());
                hastaSecilen_poliklinik = (String)  poliklinikSecenegi.getItemAt( poliklinikSecenegi.getSelectedIndex());
                sql_sorguEkle = "INSERT INTO hastalar (tcHasta_no,hasta_adi,hasta_soyad,hasta_poliklinik,hasta_doktor,hasta_randevuSaati) VALUES (" + hastaTcNo + ",'" + hastaAd +"','"
                        + hastaSoyad +"','" + hastaSecilen_poliklinik +"','" + hastaSecilen_doktor +"','"+ hastaRandevu +"')";

                System.out.println(sql_sorguEkle);
                VeriTabaniErisim objEkle = new VeriTabaniErisim();
                objEkle.veriEkle(sql_sorguEkle);
                JOptionPane.showMessageDialog(null,"Randevunuz Kaydedildi");
            }
        });

       menuButonu.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               hasta_penceresi.setVisible(false);
               GirisEkrani.giris_ekrani.setVisible(true);
           }
       });
        hasta_penceresi.add(poliklinikMesaj);
        hasta_penceresi.add(doktorMesaj);
        hasta_penceresi.add(tarihMesaj);
        hasta_penceresi.add(menuButonu);
        hasta_penceresi.add(girisButonu);
        hasta_penceresi.add(tcSatiri);
        hasta_penceresi.add(hastaAdi_satiri);
        hasta_penceresi.add(hastaSoyadi_satiri);
        hasta_penceresi.add(poliklinikSecenegi);
        hasta_penceresi.add(hastaDoktor_secenegi);
        hasta_penceresi.add(tcNumarasiTextField);
        hasta_penceresi.add(hastaAdiTextField);
        hasta_penceresi.add(hastaSoyadiTextField);
        hasta_penceresi.add(secilenRandevu_tarihleri);
        hasta_penceresi.setSize(800, 800);
        hasta_penceresi.setLayout(null);
        hasta_penceresi.setVisible(false);
        hasta_penceresi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void tarihAyari(){
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
    }

    private static void gorunumAyari(){
        menuButonu.setBounds(600,50,150,30);
        tcSatiri.setBounds(50, 20, 150, 30);
        hastaAdi_satiri.setBounds(50, 50, 150, 30);
        hastaSoyadi_satiri.setBounds(50,80,150,30);
        poliklinikSecenegi.setBounds(250,120,150,30);
        poliklinikMesaj.setBounds(50,120,150,30);
        doktorMesaj.setBounds(50,160,150,30);
        tarihMesaj.setBounds(50,200,210,30);
        hastaDoktor_secenegi.setBounds(250,160,150,30);
        tcNumarasiTextField.setBounds(250, 20, 150, 30);
        hastaAdiTextField.setBounds(250, 50, 150, 30);
        hastaSoyadiTextField.setBounds(250,80,150,30);
        secilenRandevu_tarihleri.setBounds(280,200,180,30);
        girisButonu.setBounds(50, 265, 120, 30);
    }

}
