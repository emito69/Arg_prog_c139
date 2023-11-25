package ap.controladores;

import ap.modelos.Aplicacion;
import ap.modelos.Servicio;
import ap.repositorios.AplicacionRepository;

public class AplicacionController {

    private AplicacionRepository sr;

    public AplicacionRepository getSr() {
        return sr;
    }

    public void setSr(AplicacionRepository sr) {
        this.sr = sr;
    }

    public AplicacionController() {

        this.sr = new AplicacionRepository ();
    }

    public void agregarAplicacion(String denominacion) {

        Aplicacion aplicacion = new Aplicacion();

        aplicacion.setDenominacion(denominacion);

        sr.getEm().getTransaction().begin();
        sr.insertar(aplicacion);
        sr.getEm().getTransaction().commit();
    }

    public void actualizarAplicacion(Aplicacion aplicacion) {
        sr.getEm().getTransaction().begin();
        sr.actualizar(aplicacion);
        sr.getEm().getTransaction().commit();
    }

    public void mostrarAplicaciones() {
        System.out.println("Aplicaciones: ");
        sr.buscarAplicaciones().forEach(
                aplicacion -> System.out.println(aplicacion));
        System.out.println();
    }

    public Aplicacion buscarAplicacionId(int nroAplicacion) {
        Aplicacion aplicacion = sr.buscarUnId(nroAplicacion);
        System.out.println(aplicacion);
        return aplicacion;
    }

}
