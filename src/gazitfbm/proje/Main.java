package gazitfbm.proje;

import gazitfbm.proje.doktorEkranlari.DoktorEkrani;
import gazitfbm.proje.doktorEkranlari.DoktorGirisEkrani;
import gazitfbm.proje.doktorEkranlari.GirisEkrani;
import gazitfbm.proje.hastaEkranlari.*;

public final class Main {
    public static void main ( String [] args) {

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
