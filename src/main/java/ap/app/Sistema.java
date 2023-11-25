
package ap.app;

import ap.controladores.*;
import ap.modelos.*;
import ap.persistencia.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Sistema {

    public static void main(String[] args) {
       EntityManager em = EntityManagerUtil.getEntityManager();


        AplicacionController ac = new AplicacionController();
        ac.getAr().setEm(em);

        SistemaOperativoController sc = new SistemaOperativoController();
        sc.getSr().setEm(em);

        EspecialidadController ec = new EspecialidadController();
        ec.getEr().setEm(em);

        TecnicoController tc =new TecnicoController();
        tc.getTr().setEm(em);

        Scanner scanner = new Scanner(System.in);

        int opcion;
        long nroCliente;
        do {
            System.out.println("Menú Principal");
            System.out.println("1. Registrar Aplicación");
            System.out.println("2. Registrar Sistema Operativo");
            System.out.println("3. Registrar Especialidad");
            System.out.println("4. Registrar Técnicos");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ac.agregarAplciacion(scanner);
                    ac.mostrarAplicacion();
                    break;
                case 2:
                    sc.agregarSistemaOperativo(scanner);
                    sc.mostrarSistemasOperativos();
                    break;
                case 3:
                    ArrayList<SistemaOperativo> listaS = sc.traerListaSitemasOperativos();
                    ArrayList<Aplicacion> listaA = ac.traerListaAplicaciones();
                    ec.agregarEspecialidadTecnicoVacio(scanner,listaA,listaS);
                    break;
                case 4:
                    tc.agregarTecnico(scanner);
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 0);


    }

}
