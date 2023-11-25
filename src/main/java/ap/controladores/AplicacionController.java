package ap.controladores;

import ap.modelos.Aplicacion;
import ap.modelos.SistemaOperativo;
import ap.repositorios.AplicacionRepository;
import ap.repositorios.SistemaOperativoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplicacionController {
    private AplicacionRepository ar;

    public AplicacionRepository getAr() {
        return ar;
    }

    public void setAr(AplicacionRepository ar) {
        this.ar = ar;
    }

    public AplicacionController() {
        this.ar = new AplicacionRepository();
    }

    public void agregarAplciacion(Scanner scanner) {
        System.out.print("Ingrse el nombre de la aplicacion: ");
        String denominacion = scanner.next();



        Aplicacion aplicacion = new Aplicacion();

        aplicacion.setDenominacion(denominacion);



        ar.getEm().getTransaction().begin();
        ar.insertar(aplicacion);
        ar.getEm().getTransaction().commit();

        System.out.println("aplicacion agregado con éxito.\n");
    }
    public ArrayList<Aplicacion> traerListaAplicaciones() {
        List<Aplicacion> lista=ar.buscarAplcaciones();
        ArrayList<Aplicacion>arrayListaAplicaciones =new ArrayList<Aplicacion>(lista);
        return arrayListaAplicaciones ;
    }

    public void mostrarAplicacion() {
        System.out.println("Aplicaciones: ");
        ar.buscarAplcaciones().forEach(
                aplicacion-> System.out.println(aplicacion.getDenominacion() +" "+aplicacion.getId()));
        System.out.println();
    }

    public Aplicacion buscarAplcaconId(int id_aplicacion) {
        Aplicacion aplicacion = ar.buscarUnId(id_aplicacion);
        System.out.println(aplicacion);
        return aplicacion;
    }
}
