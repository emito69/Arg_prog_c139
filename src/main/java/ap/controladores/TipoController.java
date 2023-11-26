package ap.controladores;

import ap.modelos.Tipo;
import ap.repositorios.TipoRepository;

public class TipoController {

    private TipoRepository sr;

    public TipoRepository getSr() {
        return sr;
    }

    public void setSr(TipoRepository sr) {
        this.sr = sr;
    }

    public TipoController() {

        this.sr = new TipoRepository ();
    }

    public void agregarTipo(String denominacion) {

        Tipo tipo = new Tipo();

        tipo.setDenominacion(denominacion);

        sr.getEm().getTransaction().begin();
        sr.insertar(tipo);
        sr.getEm().getTransaction().commit();
    }

    public void actualizarTipo(Tipo tipo) {
        sr.getEm().getTransaction().begin();
        sr.actualizar(tipo);
        sr.getEm().getTransaction().commit();
    }

    public void mostrarTipos() {
        System.out.println("Tipos: ");
        sr.buscarTipos().forEach(
                tipo -> System.out.println(tipo));
        System.out.println();
    }

    public Tipo buscarTipoId(int nroTipo) {
        Tipo tipo = sr.buscarUnId(nroTipo);
        System.out.println(tipo);
        return tipo;
    }

}
