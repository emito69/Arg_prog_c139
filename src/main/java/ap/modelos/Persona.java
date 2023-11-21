package ap.modelos;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Persona {

    @Id
    @GeneratedValue
    @Column(name = "id_Persona", nullable = false, length = 11)
    private int id;   //acá usar Long no long

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;

    @Column(name = "fechaNacim", nullable = false)
    private Timestamp fechaNacim;

    //@Column(name = "infoContacto", nullable = false, length = 45)
    @OneToOne
    @JoinColumn(name="infoContacto_id", referencedColumnName="id")
    private InfoContacto infoContacto;
}
