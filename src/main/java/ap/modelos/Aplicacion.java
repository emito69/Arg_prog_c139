package ap.modelos;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data   // Getters y Setters
@Entity
@Table(name="aplicacion")
public class Aplicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private int id;   //acá usar Long no long

    @Column(name = "denominacion", nullable = false, length = 45)
    //@NotBlank (message = "La denominacion no puede estar vacía")
    //@NotNull (message = "La denominacion no puede estar vacía")
    private String denominacion;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="aplicacion_id", referencedColumnName="id")
    private List<Especialidad> especialidades;


    @Override
    public String toString() {
        return this.getId() +"-"+ this.getDenominacion();
    }
}
