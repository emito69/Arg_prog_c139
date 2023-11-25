package ap.modelos;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data   // Getters y Setters
@Entity
@Table(name="tecnico")
public class Tecnico extends Persona{



    /* CREO QUE TIENE QUE SE MANYtoMANY
    @OneToMany(cascade = CascadeType.PERSIST)     // un Tecnico puede tener varias Especialidades // PERSIST: cuando creo un Tecnico debería crear en el mismo momento la/las Especialidades
    @JoinColumn(name="tecnico_id", referencedColumnName="id") //nombre de la foreing key en tabla Especialidad
    private List<Especialidad> especialidades;
    */
    @ManyToMany(mappedBy="tecnicos", cascade = CascadeType.ALL)   // varios Tecnicos pueden tener varias Especialidades
    private List<Especialidad> especialidades;


    @ManyToMany(mappedBy="tecnicos", cascade = CascadeType.ALL)   // varios Tecnicos pueden aparecer en varios Incidentes
    private List<Incidente> incidentes;
}
