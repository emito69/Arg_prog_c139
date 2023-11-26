package ap.modelos;

import ap.app.Util;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="estado")
public class INGRESADO extends Estado{

    @Override
    public Date dameFechaFinalizacion(Incidente incidente) {
        Util util = new Util();

        LocalDate fechaCreacionL = util.convertToLocalDate(incidente.getFechaCreacion());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate fechaFinalizacionL = fechaCreacionL.plus(incidente.getTiempoResolucion()).plus(incidente.getTiempoColchon());

        System.out.println(fechaFinalizacionL);
        //System.out.println(fechaFinalizacionL.format(dateTimeFormatter));

        return util.convertToDate(fechaFinalizacionL);
    }

    @Override
    public void actualizar(Incidente incidente) {
        if (incidente.isFinalizado()){
            incidente.setEstado(new RESUELTO());
        }
    }

    @Override
    public Estado dameEstado(Incidente incidente) {
        System.out.println(incidente.getEstado());
        return incidente.getEstado();
    }
}
