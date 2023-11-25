package ap.modelos;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data   // Getters y Setters
@Entity
@Table(name="problema")
public class Problema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private int id;   //acá usar Long no long

    private Tipo tipo;
    private Timestamp tiempoResolucion;

    @ManyToMany(mappedBy="problemas", cascade = CascadeType.ALL)   // varios Tecnicos pueden aparecer en varios Incidentes
    private List<Incidente> incidentes;
}
