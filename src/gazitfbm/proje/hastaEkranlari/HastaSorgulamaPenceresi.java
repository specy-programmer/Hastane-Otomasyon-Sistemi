package gazitfbm.proje.hastaEkranlari;

import gazitfbm.proje.doktorEkranlari.GirisEkrani;
import gazitfbm.proje.vt.VeriTabaniErisim;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HastaSorgulamaPenceresi  {
    static JFrame hastaSorgulamaPenceresi = new JFrame("Hasta Sorgulama Penceresi");
    private static JLabel tcSatiri = new JLabel("Tc no giriniz :");
    private static JLabel hastaAdi_satiri = new JLabel("Adınızı giriniz :");
    private static JLabel hastaSoyadi_satiri = new JLabel("Soyadınızı giriniz:");
    private static JTextField hastaAdiTextField = new JTextField();
    private static JTextField hastaSoyadiTextField = new JTextField();
    private static JTextField tcNumarasiTextField = new JTextField();
    private static JButton sorgulamaButonu = new JButton("Sorgula");
    static JButton menuButonu = new JButton("Ana Menü");
    static JTable table = new JTable();
    public static void hastaSorgulamaPenceresiGorunumu(){
        tcSatiri.setBounds(50, 20, 150, 30);
        hastaAdi_satiri.setBounds(50, 50, 150, 30);
        hastaSoyadi_satiri.setBounds(50,80,150,30);
        tcNumarasiTextField.setBounds(250, 20, 150, 30);
        hastaAdiTextField.setBounds(250, 50, 150, 30);
        hastaSoyadiTextField.setBounds(250,80,150,30);
        sorgulamaButonu.setBounds(50, 140, 95, 30);
        table.setBounds(50,200,710,150);
        menuButonu.setBounds(600,50,150,30);

        Object[] kolonlar = {"İsim","Soyisim","Poliklinik","Doktor","Randevu Saati"};
        Object[] satirlar = new Object[6];
        DefaultTableModel modelim = new DefaultTableModel();
        modelim.setColumnIdentifiers(kolonlar);
        table.setModel(modelim);

        sorgulamaButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql_sorgu,tcNo;
                tcNo = tcNumarasiTextField.getText();
                sql_sorgu = "SELECT * FROM hastalar WHERE tcHasta_no="+tcNo;
                VeriTabaniErisim obj = new VeriTabaniErisim();
                ResultSet myRs;
                myRs = obj.girisSorgula(sql_sorgu);

                try {
                    while (myRs.next()) {
                        satirlar[0] = myRs.getString("hasta_adi");
                        satirlar[1] = myRs.getString("hasta_soyad");
                        satirlar[2] = myRs.getString("hasta_poliklinik");
                        satirlar[3] = myRs.getString("hasta_doktor");
                        satirlar[4] = myRs.getString("hasta_randevuSaati");
                        modelim.addRow(satirlar);
                    }

                    if (myRs.next()==false){
                        JOptionPane.showMessageDialog(null,"Kaydınız bulunamamaktadır.");
                    }
                } catch (SQLException ex){
                    ex.printStackTrace();
                }

                table.setModel(modelim);

            }
        });

        menuButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hastaSorgulamaPenceresi.setVisible(false);
                GirisEkrani.giris_ekrani.setVisible(true);
            }
        });

        hastaSorgulamaPenceresi.add(menuButonu);
        hastaSorgulamaPenceresi.add(table);
        hastaSorgulamaPenceresi.add(tcSatiri);
        hastaSorgulamaPenceresi.add(tcNumarasiTextField);
        hastaSorgulamaPenceresi.add(hastaAdi_satiri);
        hastaSorgulamaPenceresi.add(hastaAdiTextField);
        hastaSorgulamaPenceresi.add(hastaSoyadi_satiri);
        hastaSorgulamaPenceresi.add(hastaSoyadiTextField);
        hastaSorgulamaPenceresi.add(sorgulamaButonu);
        hastaSorgulamaPenceresi.setSize(800,800);
        hastaSorgulamaPenceresi.setLayout(null);
        hastaSorgulamaPenceresi.setVisible(false);
        hastaSorgulamaPenceresi.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }
}
