package ap.modelos;

import ap.app.Util;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="estado")
public class RESUELTO extends Estado{

    @Override
    public Date dameFechaFinalizacion(Incidente incidente) {
        Util util = new Util();

        LocalDate fechaFinalizadoL = util.convertToLocalDate(incidente.getFechaFinalizado());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Incidente resuelto en fecha: "+ fechaFinalizadoL);
        //System.out.println(fechaFinalizacionL.format(dateTimeFormatter));

        return util.convertToDate(fechaFinalizadoL);
    }

    @Override
    public void actualizar(Incidente incidente) {
        if (incidente.isFinalizado()){
            System.out.println("El incidente ya ha sido resuelto en fecha: "+ incidente.getFechaFinalizado());;
        }
    }

    @Override
    public Estado dameEstado(Incidente incidente) {
        System.out.println(incidente.getEstado());
        return incidente.getEstado();
    }
}
