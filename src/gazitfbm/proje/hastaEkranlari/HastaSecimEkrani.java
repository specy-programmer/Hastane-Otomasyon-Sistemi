package gazitfbm.proje.hastaEkranlari;

import gazitfbm.proje.doktorEkranlari.GirisEkrani;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class HastaSecimEkrani {
    public static JFrame hastaSecimEkrani = new JFrame("Hasta Seçim Ekranı");
    public static JButton hastaKayitButonu = new JButton("Hasta Kayıt");
    public static JButton hastaKayitSilmeButonu = new JButton("Hasta Kaydı Silme");
    public static JButton hastaBilgerileriGostermeButonu = new JButton("Hasta Bilgilerini/Randevuyu görüntüle ");
    public static JButton hastaBilgileriGuncelleButonu = new JButton("Hasta Bilgilerini Güncelle");
    static JButton menuButonu = new JButton("Ana Menü");

    public static void hastaSecimEkraniGorunumu(){
        hastaKayitButonu.setBounds(50,350,100,30);
        hastaKayitSilmeButonu.setBounds(200,350,180,30);
        hastaBilgerileriGostermeButonu.setBounds(430,350,280,30);
        hastaBilgileriGuncelleButonu.setBounds(270,430,190,30);
        menuButonu.setBounds(600,50,150,30);
        hastaKayitButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hastaSecimEkrani.setVisible(false);
                HastaKayitPenceresi.hasta_penceresi.setVisible(true);
            }
        });

        hastaKayitSilmeButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hastaSecimEkrani.setVisible(false);
                HastaSilmePenceresi.hastaKayitSilmePenceresi.setVisible(true);

            }
        });

        hastaBilgerileriGostermeButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hastaSecimEkrani.setVisible(false);
                HastaSorgulamaPenceresi.hastaSorgulamaPenceresi.setVisible(true);
            }
        });

        hastaBilgileriGuncelleButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hastaSecimEkrani.setVisible(false);
                HastaGuncellePenceresi.hastaKayitGuncellePenceresi.setVisible(true);
            }
        });

        menuButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hastaSecimEkrani.setVisible(false);
                GirisEkrani.giris_ekrani.setVisible(true);
            }
        });

        hastaSecimEkrani.add(hastaBilgileriGuncelleButonu);
        hastaSecimEkrani.add(menuButonu);
        hastaSecimEkrani.add(hastaKayitButonu);
        hastaSecimEkrani.add(hastaKayitSilmeButonu);
        hastaSecimEkrani.add(hastaBilgerileriGostermeButonu);
        hastaSecimEkrani.setSize(800,800);
        hastaSecimEkrani.setLayout(null);
        hastaSecimEkrani.setVisible(false);
        hastaSecimEkrani.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
