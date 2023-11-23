package ap.modelos;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data   // Getters y Setters
@Entity
@Table(name="incidente")
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;   //acá usar Long no long

    @Column(name = "fechaCreacion")
    //@NotBlank (message = "La fechaCreacion no puede estar vacía")
    //@NotNull (message = "La fechaCreacion no puede estar vacía")
    private Timestamp fechaCreacion;

    @ManyToOne(cascade = CascadeType.MERGE)     // cada Incidente es por un Servicio
    @JoinColumn(
            name="servicio_id",
            referencedColumnName="id")  //nombre de la foreing key en tabla Incidente
    private Servicio servicio;

    @ManyToMany(cascade = CascadeType.MERGE)   // varios Incidente pueden tener los mismo Consumidores
    private List<Cliente> clientes;

    @ManyToMany(cascade = CascadeType.MERGE)   // varios Incidente pueden tener los mismo Prestadores
    private List<Tecnico> tecnicos;

    @ManyToMany(cascade = CascadeType.MERGE)   // varios Incidente pueden tener los mismo Problemas
    private List<Problema> problemas;

    @Column(name = "descripcion")
    //@NotBlank (message = "descripcion no puede estar vacía")
    //@NotNull (message = "descripcion no puede estar vacía")
    private String descripcion;

    @Column(name = "complejidad")
    //@NotBlank (message = "El tipo no puede estar vacía")
    //@NotNull (message = "El tipo no puede estar vacía")
    private Complejidad complejidad;

    @Column(name = "tiempoResolucion")
    //@NotBlank (message = "La fechaCreacion no puede estar vacía")
    //@NotNull (message = "La fechaCreacion no puede estar vacía")
    private Timestamp tiempoResolucion;

    @Column(name = "estado")
    //@NotBlank (message = "estado no puede estar vacía")
    //@NotNull (message = "estado no puede estar vacía")
    private Estado estado;

    @Column(name = "comentario_tec")
    //@NotBlank (message = "descripcion no puede estar vacía")
    //@NotNull (message = "descripcion no puede estar vacía")
    private String comentario_tec;

}
