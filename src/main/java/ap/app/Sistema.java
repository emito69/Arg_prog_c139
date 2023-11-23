
package ap.app;

import ap.controladores.AplicacionController;
import ap.controladores.ClienteController;
import ap.controladores.EspecialidadController;
import ap.controladores.SistemaOperativoController;
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


        // EntityManager em = EntityManagerUtil.getEntityManager();
        //System.out.println("EntityManager class ==> " + em.getClass().getCanonicalName());
       /* EntityTransaction tx = em.getTransaction();

        tx.begin();

        String razon_social = "xxx";
        String cuit = "xxx";
        Cliente cliente = new Cliente();
        Timestamp fecha = Timestamp.from(Instant.now());

        cliente.setCuit("xxx");
        cliente.setRazon_social("xxx");
        cliente.setNombre("xxx");
        cliente.setApellido("xxx");
        cliente.setFechaNacim(fecha);

        em.persist(cliente);

        InfoContacto infoContacto = new InfoContacto();
        infoContacto.setCelular("1111");
        infoContacto.setEmail("xxx");
        infoContacto.setDireccion("xxx");
        infoContacto.setTelefono("xxx");

        em.persist(infoContacto);

        cliente.setInfoContacto(infoContacto);
        em.merge(cliente);

        tx.commit();
        System.out.println("Objeto guardado!!!");
        */

        //EntityManager em = EntityManagerUtil.getEntityManager();

       /* ClienteController cc = new ClienteController();
        //seteando el entityManager al repository
        cc.getCr().setEm(em);

        Scanner scanner = new Scanner(System.in);

        cc.agregarCliente(scanner);

        cc.mostrarClientes();*/


        EntityManager em = EntityManagerUtil.getEntityManager();

        AplicacionController ac = new AplicacionController();
        //seteando el entityManager al repository
        ac.getAr().setEm(em);
        Scanner scanner = new Scanner(System.in);
        ac.agregarAplciacion(scanner);
        ac.mostrarAplicacion();
        ArrayList<Aplicacion> listaA = ac.traerListaSitemasAplicaciones();

        SistemaOperativoController sc = new SistemaOperativoController();
        //seteando el entityManager al repository
        sc.getSr().setEm(em);
        Scanner scanner2 = new Scanner(System.in);
        sc.agregarSistemaOperativo(scanner2);
        sc.mostrarSistemasOperativos();

        ArrayList<SistemaOperativo> listaS = sc.traerListaSitemasOperativos();

        EspecialidadController es = new EspecialidadController();
        es.getEr().setEm(em);

        Scanner scanner3 = new Scanner(System.in);

    es.agregarEspecialidadTecnicoVacio(scanner3);
    }




    }
