
package ap.app;

import ap.controladores.AplicacionController;
import ap.controladores.ClienteController;
import ap.controladores.ServicioController;
import ap.controladores.SistemaOperativoController;
import ap.modelos.Aplicacion;
import ap.modelos.Cliente;
import ap.modelos.InfoContacto;
import ap.modelos.Servicio;
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

        /*
        EntityManager em = EntityManagerUtil.getEntityManager();
        // System.out.println("EntityManager class ==> " + em.getClass().getCanonicalName());
        EntityTransaction tx = em.getTransaction();
        */

        EntityManager em = EntityManagerUtil.getEntityManager();


        AplicacionController apc = new AplicacionController();
        SistemaOperativoController soc = new SistemaOperativoController();
        ServicioController sc = new ServicioController();
        ClienteController cc = new ClienteController();

        //seteando el entityManager al repository
        cc.getCr().setEm(em);
        sc.getSr().setEm(em);
        apc.getSr().setEm(em);
        soc.getSr().setEm(em);

        // completamos las tablas SistemaOperativo y Aplicacion
        soc.agregarSistemaOperativo("WINDOWS");
        soc.agregarSistemaOperativo("MACOS");
        soc.agregarSistemaOperativo("LINUX");
        soc.agregarSistemaOperativo("UBUNTU");

        apc.agregarAplicacion("TANGO");
        apc.agregarAplicacion("SAP");

        // completamos la tabla Servicio

        //Servicio servicio1 = new Servicio();
        //Servicio servicio2 = new Servicio();

        //sc.agregarServicio(apc.buscarAplicacionId(2), soc.buscarSistemaOperativoId(2));
        //sc.agregarServicio(apc.buscarAplicacionId(2), soc.buscarSistemaOperativoId(2));
        //servicio1.getAplicaciones().add(apc.buscarAplicacionId(1));
        //servicio1.getSist_operativos().add(soc.buscarSistemaOperativoId(1));

        sc.agregarServicio(apc.buscarAplicacionId(1), soc.buscarSistemaOperativoId(1));
        sc.agregarServicio(apc.buscarAplicacionId(2), soc.buscarSistemaOperativoId(1));

        Servicio servicio1 = sc.buscarServicioId(1);
        Servicio servicio2 = sc.buscarServicioId(2);

        Scanner scanner = new Scanner(System.in);

        // CLIENTE 1, servicio1
        cc.agregarCliente(scanner);

        //cc.buscarClienteId(1).getServicios().add(servicio1);


        Cliente cliente = cc.buscarClienteId(1);

        cliente.getServicios().add(servicio1);
        cliente.getServicios().add(servicio2);


        cc.actualizarCliente(cliente);

        //System.out.println(cliente);


        cliente.getServicios().forEach(
                servicio -> System.out.println(servicio));
        System.out.println();

        /*
        // CLIENTE 2, servicio1 + serivicio2

        cc.agregarCliente(scanner);
        cc.buscarClienteId(2).getServicios().add(servicio1);
        cc.buscarClienteId(2).getServicios().add(servicio2);

        cc.actualizarCliente(cc.buscarClienteId(1));
        cc.actualizarCliente(cc.buscarClienteId(2));

        cc.mostrarClientes();
        */
        //Cliente cliente1 = cc.buscarClienteId(1);

        //cliente1.setNombre("Nadia");

        //cc.actualizarCliente(cliente1);

        //cc.mostrarClientes();


    }
}