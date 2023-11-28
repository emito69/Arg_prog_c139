package ap.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Set<Integer> dameListaTecnicosPosibles (ArrayList<Tecnico> listaTecnicos) {
        Set<Integer> setAsignables = new HashSet<Integer>();
        listaTecnicos.stream().forEach( t -> t.getEspecialidades().stream().forEach(
                                                e -> { if (e.getSistemaoperativo().getDenominacion() == this.sistemaoperativo.getDenominacion() &&
                                                e.getAplicacion().getDenominacion() == this.aplicacion.getDenominacion()) {
                                                setAsignables.add(t.getId());
                                                }

                                        }));
        return setAsignables;
    }

    public int dameUnTecnicoAlAzarDeUnaLista(Set<Integer> set) {

        ArrayList<Integer> lista = (ArrayList<Integer>) set.stream().collect(Collectors.toList());

        Random rand = new Random();

        int elementoAlAzar = lista.get(rand.nextInt(lista.size()));

        return elementoAlAzar;
    }
}
