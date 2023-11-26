package ap.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Period;
import java.util.List;

@Data   // Getters y Setters
@Entity
@Table(name="problema")
public class Problema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private int id;   //acá usar Long no long

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="tipo_id", referencedColumnName="id")
    private Tipo tipo;

    private Period tiempoResolucion;

    /*
    @ManyToMany(mappedBy="problemas", cascade = CascadeType.ALL)   // varios Tecnicos pueden aparecer en varios Incidentes
    private List<Incidente> incidentes;
     */
    @OneToMany
    private List<Incidente> incidentes;

    public String toString() {
        return this.getId()+"-"+this.tipo+"-"+this.tiempoResolucion+"-"+this.incidentes;
    }
}
