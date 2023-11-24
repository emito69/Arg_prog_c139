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
    @Column(name = "id", nullable = false, length = 11)
    private int id;   //acá usar Long no long

    @Column(name = "fechaCreacion", nullable = false, length = 45)
    //@NotBlank (message = "La fechaCreacion no puede estar vacía")
    //@NotNull (message = "La fechaCreacion no puede estar vacía")
    private Timestamp fechaCreacion;

    @ManyToOne(cascade = CascadeType.ALL)     // cada Incidente es por un Servicio
    @JoinColumn(
            name="servicio_id",
            referencedColumnName="id")  //nombre de la foreing key en tabla Incidente
    private Servicio servicio;

    @ManyToMany(cascade = CascadeType.ALL)   // varios Incidente pueden tener los mismo Consumidores
    private List<Cliente> clientes;

    @ManyToMany(cascade = CascadeType.ALL)   // varios Incidente pueden tener los mismo Prestadores
    private List<Tecnico> tecnicos;

    @ManyToMany(cascade = CascadeType.ALL)   // varios Incidente pueden tener los mismo Problemas
    private List<Problema> problemas;

    @Column(name = "descripcion", nullable = false, length = 511)
    //@NotBlank (message = "descripcion no puede estar vacía")
    //@NotNull (message = "descripcion no puede estar vacía")
    private String descripcion;

    @Column(name = "complejidad", nullable = false)
    //@NotBlank (message = "El tipo no puede estar vacía")
    //@NotNull (message = "El tipo no puede estar vacía")
    private Complejidad complejidad;

    @Column(name = "tiempoResolucion", nullable = false, length = 45)
    //@NotBlank (message = "La fechaCreacion no puede estar vacía")
    //@NotNull (message = "La fechaCreacion no puede estar vacía")
    private Timestamp tiempoResolucion;

    @Column(name = "estado", nullable = false)
    //@NotBlank (message = "estado no puede estar vacía")
    //@NotNull (message = "estado no puede estar vacía")
    private Estado estado;

    @Column(name = "comentario_tec", nullable = false, length = 511)
    //@NotBlank (message = "descripcion no puede estar vacía")
    //@NotNull (message = "descripcion no puede estar vacía")
    private String comentario_tec;

}
