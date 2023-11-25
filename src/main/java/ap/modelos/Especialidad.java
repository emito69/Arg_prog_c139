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
    @Column(name = "id", nullable = false, length = 11)
    private int id;   //acá usar Long no long

    private String nombre;

    @ManyToMany(cascade= CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Tecnico>tecnicos;

    //una especialidad solo puede tener un sistema operativo y una aplicacion

    @ManyToOne(targetEntity = Aplicacion.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Aplicacion aplicacion;

    @ManyToOne(targetEntity = SistemaOperativo.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
     private SistemaOperativo sistemaOperativo;


    public Especialidad()
    {
        //this.tecnicos=new ArrayList<>();

    }
}
