package ap.modelos;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="estado")
public abstract class Estado {

    //public ValorEstado estado;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_estado", nullable = false, length = 11)
    private int id;

    public abstract Date dameFechaFinalizacion(Incidente incidente);
    public abstract void actualizar(Incidente incidente);
    public abstract Estado dameEstado(Incidente incidente);
}
