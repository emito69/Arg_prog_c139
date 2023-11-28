
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
import java.util.Set;


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
        sc.agregarServicio(apc.buscarAplicacionId(1), soc.buscarSistemaOperativoId(2));
        sc.agregarServicio(apc.buscarAplicacionId(2), soc.buscarSistemaOperativoId(2));

        Servicio servicio1 = sc.buscarServicioId(1);
        Servicio servicio2 = sc.buscarServicioId(2);
        Servicio servicio3 = sc.buscarServicioId(3);
        Servicio servicio4 = sc.buscarServicioId(4);

        // completamos la tabla Especialidad
        ec.agregarEspecialidad(apc.buscarAplicacionId(1), soc.buscarSistemaOperativoId(1));
        ec.agregarEspecialidad(apc.buscarAplicacionId(2), soc.buscarSistemaOperativoId(1));
        ec.agregarEspecialidad(apc.buscarAplicacionId(1), soc.buscarSistemaOperativoId(2));
        ec.agregarEspecialidad(apc.buscarAplicacionId(2), soc.buscarSistemaOperativoId(2));

        Especialidad especialidad1 = ec.buscarEspecialidadId(1);
        Especialidad especialidad2 = ec.buscarEspecialidadId(2);
        Especialidad especialidad3 = ec.buscarEspecialidadId(3);
        Especialidad especialidad4 = ec.buscarEspecialidadId(4);

        // completamos la tabla Problema
        prc.agregarProblema(tic.buscarTipoId(1), 1);
        prc.agregarProblema(tic.buscarTipoId(2), 2);
        prc.agregarProblema(tic.buscarTipoId(3), 3);
        prc.agregarProblema(tic.buscarTipoId(4), 4);

        // SCANNER
        Scanner scanner = new Scanner(System.in);

        // CLIENTE 1/2/3/4, servicioxx
        //cc.agregarCliente(scanner);
        cc.agregarClienteConDatos("Ciente1", "Alva1", "111", "111", "05/01/1981"); // id:1
        cc.agregarClienteConDatos("Ciente2", "Alva2", "222", "222", "05/02/1982"); // id:2
        cc.agregarClienteConDatos("Ciente3", "Alva3", "333", "444", "05/03/1983"); // id:3
        cc.agregarClienteConDatos("Ciente4", "Alva4", "444", "444", "05/04/1984"); // id:4

        Cliente cliente = cc.buscarClienteId(1);
        cliente.getServicios().add(servicio1);
        cliente.getServicios().add(servicio2);
        cc.actualizarCliente(cliente);   // Servicio 1 y 2

        cliente = cc.buscarClienteId(2);
        cliente.getServicios().add(servicio3);
        cliente.getServicios().add(servicio4);
        cc.actualizarCliente(cliente);  // Servicio 3 y 4

        cliente = cc.buscarClienteId(3);
        cliente.getServicios().add(servicio1);
        cliente.getServicios().add(servicio2);
        cc.actualizarCliente(cliente);   // Servicio 1 y 2

        cliente = cc.buscarClienteId(4);
        cliente.getServicios().add(servicio3);   // Servicio 1 y 2
        cliente.getServicios().add(servicio4);
        cc.actualizarCliente(cliente);  // Servicio 3 y 4

        cliente = cc.buscarClienteId(4);

        cliente.getServicios().forEach(
                servicio -> System.out.println(servicio));
        System.out.println();


        // TECNICO 1/2/3/4, servicioxx
        //tc.agregarTecnico(scanner);

        tc.agregarTecnicoConDatos("Tecnico1", "Sando1", "04/05/1995");
        tc.agregarTecnicoConDatos("Tecnico2", "Sando2", "04/06/1996");
        tc.agregarTecnicoConDatos("Tecnico3", "Sando3", "04/07/1997");
        tc.agregarTecnicoConDatos("Tecnico4", "Sando4", "04/08/1998");

        Tecnico tecnico = tc.buscarTecnicoId(5);
        tecnico.getEspecialidades().add(especialidad1);
        tecnico.getEspecialidades().add(especialidad2);
        tc.actualizarTecnico(tecnico);   // Especialidad 1 y 2

        tecnico = tc.buscarTecnicoId(6);
        tecnico.getEspecialidades().add(especialidad3);
        tecnico.getEspecialidades().add(especialidad4);
        tc.actualizarTecnico(tecnico);   // Especialidad 3 y 4

        tecnico = tc.buscarTecnicoId(7);
        tecnico.getEspecialidades().add(especialidad1);
        tecnico.getEspecialidades().add(especialidad2);
        tc.actualizarTecnico(tecnico);   // Especialidad 1 y 2

        tecnico = tc.buscarTecnicoId(8);
        tecnico.getEspecialidades().add(especialidad3);
        tecnico.getEspecialidades().add(especialidad4);
        tc.actualizarTecnico(tecnico);   // Especialidad 3 y 4

        //tecnico = tc.buscarTecnicoId(8);

        //tecnico.getEspecialidades().forEach(
        //        especialidad -> System.out.println(especialidad));
        //System.out.println();

        // INCIDENTE 1, cliente1, servicio1

        ic.agregarIncidente(cc.buscarClienteId(4), cc.buscarClienteId(4).getServicios().get(1), prc.buscarProblemaId(3));

        Incidente incidente = ic.buscarIncidenteId(1);   // obtego el incidente

        System.out.println("Servicio por el que buscamos técnico: " + cc.buscarClienteId(4).getServicios().get(1));  //servicio3
        ArrayList<Tecnico> listaTecnicos = (ArrayList<Tecnico>) tc.dameListaTecnicos();
        System.out.println("Lista de Técnicos disponibles: " + listaTecnicos);
        Set<Integer> setIdTecnicosAsignables = incidente.getServicio().dameListaTecnicosPosibles(listaTecnicos); // obtego los Técnicos que pueden serolver el servicio del incidente
        System.out.println("Lista de Técnicos asignables: " + setIdTecnicosAsignables);
        int id_tecnido_elegido = incidente.getServicio().dameUnTecnicoAlAzarDeUnaLista(setIdTecnicosAsignables); // elegimos un técnico al azar de los Asignables

        incidente.setTecnico(tc.buscarTecnicoId(id_tecnido_elegido)); // asginamos un técnico al azar de los ASignables

        ic.actualizarIncidente(incidente);
        ic.mostrarIncidentes();

        incidente.dameFechaFinalizacion(); // la fecha de finalización tentativa es la de inicio + tiempo + colchon
        incidente.setTiempoColchon(10);
        incidente.dameFechaFinalizacion();  // la fecha de finalización tentativa es la de inicio + tiempo + colchon

        incidente.dameEstado();     // con estado inicial INGRESADO
        incidente.setFinalizado();  // El Técnico indica que ya resolvió el Incidente, le pide fecha real de finalizado
        incidente.actualizarEstado();  // Ahora si pido actualizar el estado va a cambiar
        incidente.dameEstado();         // con estado RESUELTO
        incidente.actualizarEstado();   // mensaje de advertencia: no se puede volver a actualizar el estado porque ya está resuelto
        incidente.dameFechaFinalizacion(); // ahora toma como fecha de finalización la real

    }
}