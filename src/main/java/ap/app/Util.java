package ap.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public String getTimeStamp(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        ParsePosition pos = new ParsePosition(0);
        Date d = formatter.parse(date, pos);
        return String.valueOf(d.getTime());
    }

    public java.sql.Date getSQLDate(String dateString) {
        Date date = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            date = sdf.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new java.sql.Date(date.getTime());
    }

}
