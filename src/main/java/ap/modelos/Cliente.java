package ap.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data   // Getters y Setters
@AllArgsConstructor     // Todos los Constructores (con todas las combinaciones posibles)
//@NoArgsConstructor
@Entity
@Table(name="cliente")
//@Table(name="persona")
public class Cliente extends Persona{

    /* LE SACO ESTE ID PORQUE PERSONA YA TIENE 1
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private int id;   //acá usar Long no long
    */

    @Column(name = "razon_social", nullable = false, length = 45)
    //@NotBlank (message = "La razon social no puede estar vacía")
    //@NotNull (message = "La razon social no puede estar vacía")
    private String razon_social;

    @Column(name = "cuit", nullable = false, length = 45)
    //@NotBlank (message = "El cuit no puede estar vacía")
    //@NotNull (message = "El cuit no puede estar vacía")
    private String cuit;

    /* CREO QUE TIENE QUE SE MANYtoMANY
    @OneToMany(cascade = CascadeType.PERSIST)     // un Tecnico puede tener varias Especialidades // PERSIST: cuando creo un Tecnico debería crear en el mismo momento la/las Especialidades
    @JoinColumn(name="tecnico_id", referencedColumnName="id") //nombre de la foreing key en tabla Especialidad
    private List<Servicio> servicios;
    */

    /* tampoco me anduvo así -- prueba con Unidireccional
    @ManyToMany(mappedBy="clientes", cascade = CascadeType.ALL)   // varios Clientes pueden tener varios Servicios
    private List<Servicio> servicios;
    */

    @ManyToMany   // varios Clientes pueden tener varios Servicios
    @JoinTable(
            name = "servicio_cliente",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id"))
    private List<Servicio> servicios;


    @ManyToMany(mappedBy="clientes", cascade = CascadeType.ALL)   // varios Clientes pueden aparecer en varios Incidentes
    private List<Incidente> incidentes;

    public Cliente(){
        this.servicios = new ArrayList<Servicio>();
        //this.incidentes = new ArrayList<Incidente>();
    }

    public String toString() {
        return this.getId()+"-"+this.getNombre()+"-"+this.servicios.isEmpty()+"-"+this.incidentes;
    }
}
