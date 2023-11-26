
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

        EspecialidadController ec = new EspecialidadController();
        TecnicoController tc = new TecnicoController();

        TipoController tic = new TipoController();
        ProblemaController prc = new ProblemaController();

        IncidenteController ic = new IncidenteController();

        //seteando el entityManager al repository
        apc.getSr().setEm(em);
        soc.getSr().setEm(em);

        sc.getSr().setEm(em);
        cc.getCr().setEm(em);

        ec.getSr().setEm(em);
        tc.getCr().setEm(em);

        tic.getSr().setEm(em);
        prc.getSr().setEm(em);

        ic.getSr().setEm(em);

        // completamos las tablas SistemaOperativo y Aplicacion y Tipo
        soc.agregarSistemaOperativo("WINDOWS");
        soc.agregarSistemaOperativo("MACOS");
        soc.agregarSistemaOperativo("LINUX");
        soc.agregarSistemaOperativo("UBUNTU");

        apc.agregarAplicacion("TANGO");
        apc.agregarAplicacion("SAP");

        tic.agregarTipo("INSTALACION");
        tic.agregarTipo("COFIGURACION");
        tic.agregarTipo("ERROR");
        tic.agregarTipo("OTRO");

        // completamos la tabla Servicio
        sc.agregarServicio(apc.buscarAplicacionId(1), soc.buscarSistemaOperativoId(1));
        sc.agregarServicio(apc.buscarAplicacionId(2), soc.buscarSistemaOperativoId(1));

        Servicio servicio1 = sc.buscarServicioId(1);
        Servicio servicio2 = sc.buscarServicioId(2);

        // completamos la tabla Especialidad
        ec.agregarEspecialidad(apc.buscarAplicacionId(1), soc.buscarSistemaOperativoId(1));
        ec.agregarEspecialidad(apc.buscarAplicacionId(2), soc.buscarSistemaOperativoId(2));

        Especialidad especialidad1 = ec.buscarEspecialidadId(1);
        Especialidad especialidad2 = ec.buscarEspecialidadId(2);

        // completamos la tabla Problema
        prc.agregarProblema(tic.buscarTipoId(1), 1);
        prc.agregarProblema(tic.buscarTipoId(2), 2);
        prc.agregarProblema(tic.buscarTipoId(3), 3);
        prc.agregarProblema(tic.buscarTipoId(4), 4);

        // SCANNER
        Scanner scanner = new Scanner(System.in);



        // CLIENTE 1, servicio1
        cc.agregarCliente(scanner);

        Cliente cliente = cc.buscarClienteId(1);

        cliente.getServicios().add(servicio1);
        cliente.getServicios().add(servicio2);

        cc.actualizarCliente(cliente);

        cliente = cc.buscarClienteId(1);

        cliente.getServicios().forEach(
                servicio -> System.out.println(servicio));
        System.out.println();


        // TECNICO 1, servicio2
        tc.agregarTecnico(scanner);

        Tecnico tecnico = tc.buscarTecnicoId(2);

        tecnico.getEspecialidades().add(especialidad1);
        tecnico.getEspecialidades().add(especialidad2);

        tc.actualizarTecnico(tecnico);

        tecnico = tc.buscarTecnicoId(2);

        tecnico.getEspecialidades().forEach(
                especialidad -> System.out.println(especialidad));
        System.out.println();

        // INCIDENTE 1, cliente1, servicio1

        ic.agregarIncidente(cc.buscarClienteId(1), cc.buscarClienteId(1).getServicios().get(1), prc.buscarProblemaId(3));

        Incidente incidente = ic.buscarIncidenteId(1);

        System.out.println("ACAAAAA !!!!!!");
        ic.mostrarIncidentes();

        incidente.dameFechaFinalizacion(); // la fecah de finalización tentativa es la de inicio + tiempo + colchon
        incidente.setTiempoColchon(10);
        incidente.dameFechaFinalizacion();  // la fecah de finalización tentativa es la de inicio + tiempo + colchon

        incidente.dameEstado();     // con estado inicial INGRESADO
        incidente.setFinalizado();  // EL Técnico indica que ya resolvió el Incidente, le pide fecha real de finalizado
        incidente.actualizarEstado();  // Ahora si pido actualizar el estado va a cambiar
        incidente.dameEstado();         // con estado RESUELTO
        incidente.actualizarEstado();   // mensaje de advertencia: no se puede volver a actualziar el estado porque ya está resuelto
        incidente.dameFechaFinalizacion(); // ahora toma como fecha de finalización la real

    }
}