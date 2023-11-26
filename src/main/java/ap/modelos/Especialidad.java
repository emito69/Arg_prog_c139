package ap.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data   // Getters y Setters
@AllArgsConstructor     // Todos los Constructores (con todas las combinaciones posibles)
@NoArgsConstructor
@Entity
@Table(name="especialidad")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private int id;   //acá usar Long no long

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="sistemaoperativo_id", referencedColumnName="id")
    private SistemaOperativo sistemaoperativo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="aplicacion_id", referencedColumnName="id")
    private Aplicacion aplicacion;

    /*
    @ManyToMany(cascade = CascadeType.ALL)   // varios Tecnicos pueden tener varias Especialidades
    private List<Tecnico> tecnicos;
    */

    public String toString() {
        return this.getId()+"-"+this.sistemaoperativo+"-"+this.aplicacion;
    }
}
