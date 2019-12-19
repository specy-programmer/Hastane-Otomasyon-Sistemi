package gazitfbm.proje.vt;

import java.sql.ResultSet;

public interface IVeriTabaniErisim {

    void baglantiKurulumu();

    void veriEkle(String sql_sorguEkle);

    void veriSil(String sql_sorguSilme);

    ResultSet girisSorgula(String sqlGirisi_sorgu);

    void veriGuncelle(String sql_sorguGuncelle);
}
