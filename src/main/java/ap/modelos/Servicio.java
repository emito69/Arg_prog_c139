package ap.modelos;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data   // Getters y Setters
@Entity
@Table(name="servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private int id;   //acá usar Long no long

    @ManyToMany(cascade = CascadeType.ALL)   // varios Clientes pueden tener varios Servicios
    private List<Cliente> clientes;

    @OneToMany(cascade = CascadeType.ALL)     // un Servicio puede tenes varias Aplicaciones   // PERSIST: cuando creo Servicio debería crear en el mismo momento la/las Aplicaciones
    @JoinColumn(name="servicio_id", referencedColumnName="id") //nombre de la foreing key en tabla aplicaciones
    private List<Aplicacion> aplicaciones;

    @OneToMany(cascade = CascadeType.ALL)     // un Servicio puede tenes varios Sistemas_Operativos   // PERSIST: cuando creo Servicio debería crear en el mismo momento la/las Aplicaciones
    @JoinColumn(name="servicio_id", referencedColumnName="id") //nombre de la foreing key en tabla sistema_operativos
    private List<SistemaOperativo> sist_operativos;
}
