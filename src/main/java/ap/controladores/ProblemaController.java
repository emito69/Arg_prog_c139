package ap.controladores;

import ap.modelos.Problema;
import ap.modelos.Tipo;
import ap.repositorios.ProblemaRepository;

import java.time.Period;

public class ProblemaController {

    private ProblemaRepository sr;

    public ProblemaRepository getSr() {
        return sr;
    }

    public void setSr(ProblemaRepository sr) {
        this.sr = sr;
    }

    public ProblemaController() {

        this.sr = new ProblemaRepository();
    }

    public void agregarProblema(Tipo tipo, int dias) {

        Period fromDays = Period.ofDays(dias);

        Problema problema = new Problema();

        problema.setTipo(tipo);
        problema.setTiempoResolucion(fromDays);

        sr.getEm().getTransaction().begin();
        sr.insertar(problema);
        sr.getEm().getTransaction().commit();

        System.out.println("Problema agregado con éxito.\n");
    }

    public void actualizarProblema(Problema problema) {
        sr.getEm().getTransaction().begin();
        sr.actualizar(problema);
        sr.getEm().getTransaction().commit();
    }

    public void mostrarProblemas() {
        System.out.println("Problema: ");
        sr.buscarProblemas().forEach(
                problema -> System.out.println(problema));
        System.out.println();
    }

    public Problema buscarProblemaId(int nroProblema) {
        Problema problema = sr.buscarUnId(nroProblema);
        System.out.println(problema);
        return problema;
    }

}
