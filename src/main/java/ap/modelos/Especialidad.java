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

    private String nombre;

    @ManyToOne
    @JoinColumn(name="sistOp_id", referencedColumnName="id")
    private SistemaOperativo sistemaOperativo;
    @ManyToOne
    @JoinColumn(name="aplicacion_id", referencedColumnName="id")
    private Aplicacion aplicacion;


    @ManyToMany(mappedBy="especialidades", cascade= CascadeType.ALL, fetch=FetchType.LAZY)
     private List<Tecnico>tecnicos;

    public Especialidad(
                        Aplicacion aplicacion,
                        SistemaOperativo sistOperativo) {
        this.tecnicos = new ArrayList<>();
        this.aplicacion=aplicacion;
        this.sistemaOperativo = sistOperativo;
    }
    public Especialidad(List<Tecnico> tecnicos,
            Aplicacion aplicacion,
            SistemaOperativo sistOperativo) {
        this.tecnicos =tecnicos;
        this.aplicacion=aplicacion;
        this.sistemaOperativo = sistOperativo;
    }
    public Especialidad(){
        this.tecnicos=new ArrayList<>();
    }
}
