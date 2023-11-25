package ap.controladores;

import ap.app.Util;
import ap.modelos.*;
import ap.repositorios.AplicacionRepository;
import ap.repositorios.ClienteRepository;
import ap.repositorios.EspecialidadRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EspecialidadController {

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

    //recibe del Front una lista de aplicaciones, sistemas operativos
    public void agregarEspecialidad(Scanner scanner,
                                                ArrayList<Aplicacion>apli,
                                                ArrayList<SistemaOperativo>sistOp)

    {System.out.print("Ingrese el nombre de la especialidad: ");
     Especialidad esp = new Especialidad();
        String nombre = scanner.next();
        esp.setNombre(nombre);

        System.out.print("Ingrese el id de la aplicacion: ");
        int id = scanner.nextInt();

        apli.forEach(aplicacion -> {
            if (aplicacion.getId() == id) {
                esp.setAplicacion(aplicacion);
            }
        });

        System.out.print("Ingrese el id del sistema operativo: ");
        int id2 = scanner.nextInt();

        sistOp.forEach(so -> {
            if (so.getId() == id2) {
                esp.setSistemaOperativo(so);
            }
        });

        er.getEm().getTransaction().begin();
        er.insertar(esp);
        er.getEm().getTransaction().commit();

        System.out.println("especialidad agregado con éxito.\n");
    }














    public ArrayList<Especialidad> traerListaEspecialidades() {
        List<Especialidad> lista=er.buscarListaEspecialidad();
        ArrayList<Especialidad>arrayListaEspecialidades =new ArrayList<Especialidad>(lista);
        return arrayListaEspecialidades;
    }




    public Especialidad buscarEspecialidadId(int nroEspecialidad) {
        Especialidad especialidad = er.buscarUna(nroEspecialidad);
        System.out.println(especialidad);
        return especialidad;
    }

}
