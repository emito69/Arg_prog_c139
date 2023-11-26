package ap.controladores;


import ap.modelos.*;
import ap.repositorios.IncidenteRepository;

import java.sql.Date;
import java.time.LocalDate;

public class IncidenteController {

    private IncidenteRepository sr;

    public IncidenteRepository getSr() {
        return sr;
    }

    public void setSr(IncidenteRepository sr) {
        this.sr = sr;
    }

    public IncidenteController() {

        this.sr = new IncidenteRepository();
    }

    public void agregarIncidente(Cliente cliente, Servicio servicio, Problema problema) {

        Incidente incidente = new Incidente();

        incidente.setFechaCreacion(Date.valueOf(LocalDate.now()));
        incidente.setCliente(cliente);
        incidente.setServicio(servicio);
        // descripcion
        incidente.setProblema(problema);
        // complejidad
        // tecnico
        incidente.setTiempoResolucion(problema.getTiempoResolucion());
        // tiempoColchon
        // estado
            incidente.setEstado(new INGRESADO());
        //comentario_tec

        sr.getEm().getTransaction().begin();
        sr.insertar(incidente);
        sr.getEm().getTransaction().commit();

        System.out.println("Incidente agregado con éxito.\n");
    }

    public void actualizarIncidente(Incidente incidente) {
        sr.getEm().getTransaction().begin();
        sr.actualizar(incidente);
        sr.getEm().getTransaction().commit();
    }

    public void mostrarIncidentes() {
        System.out.println("Incidentes: ");
        sr.buscarIncidentes().forEach(
                incidente -> System.out.println(incidente));
        System.out.println();
    }

    public Incidente buscarIncidenteId(int nroIncidente) {
        Incidente incidente = sr.buscarUnId(nroIncidente);
        System.out.println(incidente);
        return incidente;
    }


}
