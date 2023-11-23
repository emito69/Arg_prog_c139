package ap.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Data   // Getters y Setters
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Persona {

    @Id
    @GeneratedValue
    @Column(name = "id_Persona")
    private int id;   //acá usar Long no long

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fechaNacim")
    //private Timestamp fechaNacim;
    private Date fechaNacim;

    //@Column(name = "infoContacto", nullable = false, length = 45)
    @OneToOne
    @JoinColumn(name="infoContacto_id", referencedColumnName="id")
    private InfoContacto infoContacto;
}
