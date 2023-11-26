package ap.modelos;

import ap.app.Util;
import ap.modelos.Estado;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data   // Getters y Setters
@Entity
@Table(name="incidente")
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private int id;   //acá usar Long no long

    @Column(name = "fechaCreacion", nullable = false, length = 45)
    private Date fechaCreacion;

    @ManyToOne(cascade = CascadeType.ALL)     // cada Incidente es por un Servicio
    @JoinColumn(
            name="servicio_id",
            referencedColumnName="id")  //nombre de la foreing key en tabla Incidente
    private Servicio servicio;

    /*
    @ManyToMany(cascade = CascadeType.ALL)   // varios Incidente pueden tener los mismo Problemas
    private List<Problema> problemas;
    */

    @ManyToOne(cascade = CascadeType.ALL)     // cada Incidente es por un Problema
    @JoinColumn(
            name="problema_id",
            referencedColumnName="id")
    private Problema problema;


    @ManyToOne(cascade = CascadeType.ALL)     // cada Incidente es para un CLiente
    @JoinColumn(name="cliente_id")             // le saco el referencedColumnName="id" PORQUE CAUSABA PROBLEMA CON LA HERENCIA
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.ALL)     // cada Incidente es para un Tecnico
    @JoinColumn(name="tecnico_id")     // le saco el referencedColumnName="id" PORQUE CAUSABA PROBLEMA CON LA HERENCIA
    private Tecnico tecnico;


    //**************************
    @Column(name = "descripcion", nullable = true, length = 511)
    private String descripcion;

    @Column(name = "complejidad", nullable = true)
    private Complejidad complejidad = Complejidad.NORMAL;

    @Column(name = "tiempoResolucion", nullable = false, length = 45)
    private Period tiempoResolucion;

    @Column(name = "tiempoColchon", nullable = false, length = 45)
    private Period tiempoColchon = Period.ofDays(0);

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="estado_id", nullable = true)
    private Estado estado = new INGRESADO();

    @Column(name = "finalizado", nullable = false)
    private boolean finalizado = false;

    @Column(name = "comentario_tec", nullable = true, length = 511)

    public String toString() {
        return this.getId()+"\n- FECHA: \n"+this.fechaCreacion+"\n- SERVICIO: \n"+this.servicio+
                "\n- PROBLEMA \n"+this.problema+"\n- CLIENTE: \n"+this.cliente+"\n-TECNICO: \n"+this.tecnico+
                "\n-COMPLEJIDAD: \n"+this.complejidad+"\n- TIEMPO RES.:\n"+this.tiempoResolucion+"\n- COMPLEJIDAD.:\n"+this.complejidad+
                "\n- TIEMPO COLCH.:\n"+this.tiempoColchon+"\n- ESTADO: \n"+this.estado;
    }


    public Date dameFechaFinalizacion (){

        /*
        Util util = new Util();

        LocalDate fechaCreacionL = util.convertToLocalDate(this.fechaCreacion);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate fechaFinalizacionL = fechaCreacionL.plus(this.tiempoResolucion).plus(this.tiempoColchon);

        System.out.println(fechaFinalizacionL);
        //System.out.println(fechaFinalizacionL.format(dateTimeFormatter));

        return util.convertToDate(fechaFinalizacionL);
        */

        return estado.dameFechaFinalizacion(this);
    }

    public void actualizarEstado(){
         this.estado.actualizar(this);
    }

    public void dameEstado(){
        this.estado.dameEstado(this);
    }

    public void setTiempoColchon(int dias) {
        this.tiempoColchon = Period.ofDays(dias);
    }
}
