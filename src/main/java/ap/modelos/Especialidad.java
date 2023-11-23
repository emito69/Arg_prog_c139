package ap.modelos;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Data   // Getters y Setters
@Entity
@Table(name="especialidad")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;   //acá usar Long no long

    @ManyToMany(targetEntity = Tecnico.class ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)   // varios Tecnicos pueden tener varias Especialidades
    private List<Tecnico> tecnicos;

    @OneToMany(cascade = CascadeType.PERSIST)     // una Especialidad puede tenes varias Aplicaciones   // PERSIST: cuando creo Especialidad debería crear en el mismo momento la/las Aplicaciones
    @JoinColumn(name="especialidad_id", referencedColumnName="id") //nombre de la foreing key en tabla aplicaciones
    private List<Aplicacion> aplicaciones;

    @OneToMany(cascade = CascadeType.PERSIST)     // una Especialidad puede tenes varios Sistemas_Operativos   // PERSIST: cuando creo Especialidad debería crear en el mismo momento la/las Aplicaciones
    @JoinColumn(name="especialidad_id", referencedColumnName="id") //nombre de la foreing key en tabla sistema_operativos
    private List<SistemaOperativo> sist_operativos;

    public Especialidad(
                        List<Aplicacion> aplicaciones,
                        List<SistemaOperativo> sist_operativos) {
        this.tecnicos = new ArrayList<>();
        this.aplicaciones = aplicaciones;
        this.sist_operativos = sist_operativos;
    }
    public Especialidad(List<Tecnico> tecnicos,
            List<Aplicacion> aplicaciones,
            List<SistemaOperativo> sist_operativos) {
        this.tecnicos =tecnicos;
        this.aplicaciones = aplicaciones;
        this.sist_operativos = sist_operativos;
    }
}
