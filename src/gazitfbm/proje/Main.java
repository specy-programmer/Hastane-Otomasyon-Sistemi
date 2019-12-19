package gazitfbm.proje;

import gazitfbm.proje.doktorEkranlari.DoktorEkrani;
import gazitfbm.proje.doktorEkranlari.DoktorGirisEkrani;
import gazitfbm.proje.doktorEkranlari.GirisEkrani;
import gazitfbm.proje.hastaEkranlari.*;

public final class Main {
    public static void main ( String [] args) {

        /*
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hastane?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","root");
            Statement stmt=(Statement) con.createStatement();
            ResultSet rs=((java.sql.Statement) stmt).executeQuery("select * from hastalar");
            con.close();
        }catch(Exception e){ System.out.println(e);}

        */

        GirisEkrani.girisEkraniGorunumu();
        HastaSecimEkrani.hastaSecimEkraniGorunumu();
        HastaKayitPenceresi.hastaPenceresiGorunumu();
        HastaSilmePenceresi.hastaSilmePenceresiGorunumu();
        DoktorGirisEkrani.doktorGirisEkraniGorunumu();
        DoktorEkrani.doktorEkraniGorunumu();
        HastaSorgulamaPenceresi.hastaSorgulamaPenceresiGorunumu();
        HastaGuncellePenceresi.hastaGuncellePenceresiGorunumu();


    }
}
