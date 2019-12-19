package gazitfbm.proje;

import javax.swing.*;

public abstract class EkranAyarlari {

    static JFrame doktorGirisPenceresi = new JFrame("Doktor Giriş Ekranı");
    private static JLabel tcSatiri = new JLabel("Tc no giriniz :");
    private static JLabel doktorAdi_satiri = new JLabel("Adınızı giriniz :");
    private static JLabel doktorSoyadi_satiri = new JLabel("Soyadınızı giriniz:");
    public static JButton doktorGiris_butonu = new JButton("Giriş");
    public static JTextField doktorAdiTextField = new JTextField();
    public static JTextField doktorSoyadiTextField = new JTextField();
    private static JTextField tcNumarasiTextField = new JTextField();

    public abstract  void doktorrGirisEkraniGorunumu();
}
