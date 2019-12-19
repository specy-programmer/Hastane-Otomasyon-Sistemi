package gazitfbm.proje.doktorEkranlari;

import gazitfbm.proje.hastaEkranlari.HastaSecimEkrani;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GirisEkrani {
   public static JFrame giris_ekrani = new JFrame("Hastane Otomasyon Sistemi");
   public static JButton hasta_butonu = new JButton("Hasta");
   public static JButton doktor_butonu = new JButton("Doktor");
   static JLabel mesaj = new JLabel("Hoşgeldiniz giriş durumunuzu seçiniz.");
   public static void girisEkraniGorunumu(){
        hasta_butonu.setBounds(200,350,100,30);
        doktor_butonu.setBounds(450,350,100,30);
        mesaj.setBounds(200,250,250,75);
        hasta_butonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HastaSecimEkrani.hastaSecimEkrani.setVisible(true);
                giris_ekrani.setVisible(false);
            }
        });

        doktor_butonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoktorGirisEkrani.doktorGirisPenceresi.setVisible(true);
                giris_ekrani.setVisible(false);
            }
        });

        giris_ekrani.add(mesaj);
        giris_ekrani.add(hasta_butonu);
        giris_ekrani.add(doktor_butonu);
        giris_ekrani.setSize(800,800);
        giris_ekrani.setLayout(null);
        giris_ekrani.setVisible(true);
        giris_ekrani.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
