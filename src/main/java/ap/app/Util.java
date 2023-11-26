package ap.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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

    public LocalDate convertToLocalDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

    public java.sql.Date convertToDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    /*
    public java.sql.Date formatToSQLDate(LocalDate fecha) {

        try {
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = fecha.format(pattern);
            date = getSQLDate(formattedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }*/
}
