package ap.modelos;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data   // Getters y Setters
@Entity
@Table(name="sistemaoperativo")
public class SistemaOperativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;   //acá usar Long no long

    @Column(name = "denominacion")
    //@NotBlank (message = "La denominacion no puede estar vacía")
    //@NotNull (message = "La denominacion no puede estar vacía")
    private String denominacion;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="sistOp_id", referencedColumnName="id")
    private List<Especialidad> especialidades;
    @Override
    public String toString() {
        return "SistemaOperativo{" +
                "denominacion='" + denominacion + '\'' +
                '}';
    }
}
