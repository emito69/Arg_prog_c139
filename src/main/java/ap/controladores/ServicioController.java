package ap.controladores;

import ap.app.Util;
import ap.modelos.*;
import ap.repositorios.ClienteRepository;
import ap.repositorios.InfoContactoRepository;
import ap.repositorios.ServicioRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ServicioController {

    private ServicioRepository sr;

    public ServicioRepository getSr() {
        return sr;
    }

    public void setSr(ServicioRepository sr) {
        this.sr = sr;
    }

    public ServicioController() {

        this.sr = new ServicioRepository();
    }

    public void agregarServicio(Aplicacion aplicacion, SistemaOperativo sistemaOperativo) {

        Servicio servicio = new Servicio();

        servicio.setSistemaoperativo(sistemaOperativo);
        servicio.setAplicacion(aplicacion);

        sr.getEm().getTransaction().begin();
        sr.insertar(servicio);
        sr.getEm().getTransaction().commit();

        System.out.println("Servicio agregado con éxito.\n");
    }

    public void actualizarServicio(Servicio servicio) {
        sr.getEm().getTransaction().begin();
        sr.actualizar(servicio);
        sr.getEm().getTransaction().commit();
    }

    public void mostrarServicios() {
        System.out.println("Servicios: ");
        sr.buscarServicios().forEach(
                servicio -> System.out.println(servicio));
        System.out.println();
    }

    public Servicio buscarServicioId(int nroServicio) {
        Servicio servicio = sr.buscarUnId(nroServicio);
        System.out.println(servicio);
        return servicio;
    }

}
