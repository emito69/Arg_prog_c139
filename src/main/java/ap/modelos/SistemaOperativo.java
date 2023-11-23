package ap.modelos;

import lombok.Data;

import javax.persistence.*;

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

    @Override
    public String toString() {
        return "SistemaOperativo{" +
                "denominacion='" + denominacion + '\'' +
                '}';
    }
}
