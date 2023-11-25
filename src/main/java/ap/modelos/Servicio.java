package ap.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data   // Getters y Setters
@AllArgsConstructor     // Todos los Constructores (con todas las combinaciones posibles)
//@NoArgsConstructor
@Entity
@Table(name="servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private int id;   //acá usar Long no long

    /* ANTES
    @OneToMany(cascade = CascadeType.ALL)     // un Servicio puede tenes varios Sistemas_Operativos   // PERSIST: cuando creo Servicio debería crear en el mismo momento la/las Aplicaciones
    @JoinColumn(name="servicio_id", referencedColumnName="id") //nombre de la foreing key en tabla sistema_operativos
    private List<SistemaOperativo> sist_operativos;
    */

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="sistemaoperativo_id", referencedColumnName="id")
    private SistemaOperativo sistemaoperativo;

    /* ANTES
    @OneToMany(cascade = CascadeType.ALL)     // un Servicio puede tenes varias Aplicaciones   // PERSIST: cuando creo Servicio debería crear en el mismo momento la/las Aplicaciones
    @JoinColumn(name="servicio_id", referencedColumnName="id") //nombre de la foreing key en tabla aplicaciones
    private List<Aplicacion> aplicaciones;
    */

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="aplicacion_id", referencedColumnName="id")
    private Aplicacion aplicacion;

    /* tampoco me anduvo así -- prueba con Unidireccional
    @ManyToMany(cascade = CascadeType.ALL)   // varios Clientes pueden tener varios Servicios
    private List<Cliente> clientes;
     */

    public Servicio(){
        //this.clientes = new ArrayList<Cliente>();
        //this.aplicaciones = new ArrayList<Aplicacion>();
        //this.sist_operativos = new ArrayList<SistemaOperativo>();
    }

    public String toString() {
        return this.getId()+"-"+this.sistemaoperativo+"-"+this.aplicacion;
    }
}
