package ap.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data   // Getters y Setters
@AllArgsConstructor     // Todos los Constructores (con todas las combinaciones posibles)
@Entity
@Table(name="tecnico")
//@Table(name="persona")
public class Tecnico extends Persona{

    /*
    @ManyToMany(mappedBy="tecnicos", cascade = CascadeType.ALL)   // varios Tecnicos pueden tener varias Especialidades
    private List<Especialidad> especialidades;
    */

    @ManyToMany   // varios Tecnicos pueden tener varias Especialidades
    @JoinTable(
            name = "especialidad_tecnico",
            joinColumns = @JoinColumn(name = "tecnico_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidad_id"))
    private List<Especialidad> especialidades;

    @OneToMany
    private List<Incidente> incidentes;

    public Tecnico(){
        this.especialidades = new ArrayList<Especialidad>();
        //this.incidentes = new ArrayList<Incidente>();
    }

    public String toString() {
        return this.getId()+"-"+this.getNombre()+"-"+this.especialidades.isEmpty()+"-"+this.incidentes;
    }
}
