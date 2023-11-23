package ap.controladores;

import ap.app.Util;
import ap.modelos.*;
import ap.repositorios.AplicacionRepository;
import ap.repositorios.ClienteRepository;
import ap.repositorios.EspecialidadRepository;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class EspecialidadController {
    private AplicacionController ap;
    private SistemaOperativoController sc;
    private EspecialidadRepository er;

    public EspecialidadRepository getEr() {
        return er;
    }

    public void setEr(EspecialidadRepository er) {
        this.er = er;
    }

    public EspecialidadController() {
        this.er = new EspecialidadRepository();
    }

    public void agregarEspecialidadTecnicoVacio(Scanner scanner)

    {System.out.print("Ingrse el nombre de la especialidad: ");
     Especialidad esp = new Especialidad();
        String nombre = scanner.next();
        esp.setNombre(nombre);


        System.out.print("elija una Aplicacion para esta especialidad");


        System.out.println("aplicaciones disponibles:");
        ap.traerListaSitemasAplicaciones().forEach(
                aplicacion -> System.out.println(aplicacion.getDenominacion()));

        int aplicacion1 = scanner.nextInt();
        esp.setAplicacion(ap.buscarAplcaconId(aplicacion1));



        System.out.print("elija una Sistema Operativo para esta especialidad");


        System.out.println("Sistemas Operativos disponibles:");
        sc.traerListaSitemasOperativos().forEach(
                so -> System.out.println(so.getDenominacion()));

        int so= scanner.nextInt();
        esp.setSistemaOperativo(sc.buscarSistemaOperativoId(so));


        er.getEm().getTransaction().begin();
        er.insertar(esp);
        er.getEm().getTransaction().commit();

        System.out.println("especialidad agregado con éxito.\n");
    }


















   /* public void mostrarClientes() {
        System.out.println("Especialidad: ");
        er.buscarUna().forEach(
                cliente -> System.out.println(especialidad));
        System.out.println();
    }*/

    public Especialidad buscarEspecialidadId(int nroEspecialidad) {
        Especialidad especialidad = er.buscarUna(nroEspecialidad);
        System.out.println(especialidad);
        return especialidad;
    }

}
