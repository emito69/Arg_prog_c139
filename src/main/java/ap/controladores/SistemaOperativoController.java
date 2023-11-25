package ap.controladores;

import ap.app.Util;
import ap.modelos.Cliente;
import ap.modelos.SistemaOperativo;
import ap.repositorios.SistemaOperativoRepository;

import java.sql.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SistemaOperativoController {
    private SistemaOperativoRepository sr;

    public SistemaOperativoRepository getSr() {
        return sr;
    }

    public void setSr(SistemaOperativoRepository sr) {
        this.sr = sr;
    }

    public SistemaOperativoController() {
        this.sr = new SistemaOperativoRepository();
    }

    public void agregarSistemaOperativo(Scanner scanner) {
        System.out.print("Ingrse el nombre del sistema operativo: ");
        String denominacion = scanner.next();



      SistemaOperativo sistemaOperativo = new SistemaOperativo();

        sistemaOperativo.setDenominacion(denominacion);



        sr.getEm().getTransaction().begin();
        sr.insertar(sistemaOperativo);
        sr.getEm().getTransaction().commit();

        System.out.println("Sistema operativo agregado con éxito.\n");
    }

    public ArrayList<SistemaOperativo> traerListaSitemasOperativos() {
        List<SistemaOperativo>lista=sr.buscarSistemasOperativos();
        ArrayList<SistemaOperativo>arrayListaSistemasOperativos =new ArrayList<SistemaOperativo>(lista);
        return arrayListaSistemasOperativos ;
    }

    public void mostrarSistemasOperativos() {
        System.out.println("Sistemas Operativos: ");
        sr.buscarSistemasOperativos().forEach(
              sistemaOperativo -> System.out.println(sistemaOperativo.getDenominacion()+" "+sistemaOperativo.getId()));
        System.out.println();
    }

    public SistemaOperativo buscarSistemaOperativoId(int id_sistemaOperativo) {
        SistemaOperativo sistemaOperativo = sr.buscarUnId(id_sistemaOperativo);
        System.out.println(sistemaOperativo);
        return sistemaOperativo;
    }

}
