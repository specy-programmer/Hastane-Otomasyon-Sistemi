package gazitfbm.proje.doktorEkranlari;

import gazitfbm.proje.vt.VeriTabaniErisim;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoktorEkrani extends DoktorGirisEkrani {

    public static JFrame doktorEkrani = new JFrame("Doktor Kontrol Paneli");
    public static JButton listeleButonu = new JButton("Randevuları Listele");
    public static JLabel mesajKutusu = new JLabel();
    static JTable table = new JTable();
    static JButton menuButonu = new JButton("Ana Menü");
    public static void doktorEkraniGorunumu(){
        mesajKutusu.setBounds(50,50,300,50);
        listeleButonu.setBounds(50,150,150,30);
        menuButonu.setBounds(600,50,150,30);

        DefaultTableModel modelim = new DefaultTableModel();
        Object[] kolonlar = {"İsim","Soyisim","Poliklinik","Doktor","Randevu Saati"};
        modelim.setColumnIdentifiers(kolonlar);
        Object[] satirlar = new Object[6];
        table.setBounds(50,300,700,300);
        table.setModel(modelim);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        listeleButonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(mesaj);
                VeriTabaniErisim obj = new VeriTabaniErisim();
                ResultSet myRs;
                myRs = obj.veriListeleme();

               try {
                   while (myRs.next()) {
                        satirlar[0] = myRs.getString("hasta_adi");
                        satirlar[1] = myRs.getString("hasta_soyad");
                        satirlar[2] = myRs.getString("hasta_poliklinik");
                        satirlar[3] = myRs.getString("hasta_doktor");
                        satirlar[4] = myRs.getString("hasta_randevuSaati");
                        modelim.addRow(satirlar);
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
                doktorEkrani.setVisible(false);
                GirisEkrani.giris_ekrani.setVisible(true);
            }
        });

        doktorEkrani.add(menuButonu);
        doktorEkrani.add(scrollPane);
        doktorEkrani.add(table);
        doktorEkrani.add(mesajKutusu);
        doktorEkrani.add(listeleButonu);
        doktorEkrani.setVisible(false);
        doktorEkrani.setLayout(null);
        doktorEkrani.setSize(800,800);
        doktorEkrani.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
