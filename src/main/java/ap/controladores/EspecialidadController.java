package ap.controladores;

import ap.app.Util;
import ap.modelos.*;
import ap.repositorios.ClienteRepository;
import ap.repositorios.EspecialidadRepository;

import java.sql.Date;
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

    public void agregarEspecialidadTecnicoVacio(
                                    List<SistemaOperativo> sistemaOperativos,
                                    List<Aplicacion>aplicaciones) {
    Especialidad esp = new Especialidad(aplicaciones, sistemaOperativos);



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
