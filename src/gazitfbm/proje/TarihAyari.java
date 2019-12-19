package gazitfbm.proje;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class TarihAyari {
    private Date mDate;

    public TarihAyari(Date date) {
        mDate = date;
    }

    public Date getDate() {
        return mDate;
    }

    @Override
    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        return sdf.format(mDate);
    }
}