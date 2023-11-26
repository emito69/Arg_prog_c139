package ap.app;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import org.hibernate.type.DurationType;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class pruebas {
    public static void main(String[] args) {

        Date fecha = Date.valueOf(LocalDate.now());
        Util util = new Util();

        LocalDate fechaL = util.convertToLocalDate(fecha);

        Period colchonDias = Period.ofDays(3);

        System.out.println(fecha);
        System.out.println(fechaL);
        System.out.println(colchonDias);
        System.out.println(fechaL.plus(colchonDias));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println(fechaL.plus(colchonDias).format(dateTimeFormatter));


    }
}
