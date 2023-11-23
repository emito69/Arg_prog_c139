package ap.modelos;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data   // Getters y Setters
@Entity
@Table(name="especialidad")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;   //acá usar Long no long

    @ManyToMany(cascade = CascadeType.MERGE)   // varios Tecnicos pueden tener varias Especialidades
    private List<Tecnico> tecnicos;

    @OneToMany(cascade = CascadeType.PERSIST)     // una Especialidad puede tenes varias Aplicaciones   // PERSIST: cuando creo Especialidad debería crear en el mismo momento la/las Aplicaciones
    @JoinColumn(name="especialidad_id", referencedColumnName="id") //nombre de la foreing key en tabla aplicaciones
    private List<Aplicacion> aplicaciones;

    @OneToMany(cascade = CascadeType.PERSIST)     // una Especialidad puede tenes varios Sistemas_Operativos   // PERSIST: cuando creo Especialidad debería crear en el mismo momento la/las Aplicaciones
    @JoinColumn(name="especialidad_id", referencedColumnName="id") //nombre de la foreing key en tabla sistema_operativos
    private List<SistemaOperativo> sist_operativos;
}
