package ap.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Data   // Getters y Setters
@AllArgsConstructor     // Todos los Constructores (con todas las combinaciones posibles)
@Entity
@Table(name="servicio")
public class Servicio {

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

    public Servicio(){
        //this.clientes = new ArrayList<Cliente>();
        //this.aplicaciones = new ArrayList<Aplicacion>();
        //this.sist_operativos = new ArrayList<SistemaOperativo>();
    }

    public String toString() {
        return this.getId()+"-"+this.sistemaoperativo+"-"+this.aplicacion;
    }
}
