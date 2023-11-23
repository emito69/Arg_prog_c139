package ap.persistencia;

import ap.modelos.Aplicacion;
import ap.modelos.Cliente;
import ap.modelos.SistemaOperativo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
        return factory.createEntityManager();
    }

    public void crear(Object obj) {
        EntityManager en = getEntityManager();
        en.getTransaction().begin();
        en.persist(obj);
        en.getTransaction().commit();
        en.close();  // Cierra el EntityManager después de realizar las operaciones
    }

    public static void main(String[] args) {
        SistemaOperativo sistemaOperativo = new SistemaOperativo();
        sistemaOperativo.setDenominacion("Linux Ubuntu");

        Cliente cliente = new Cliente();
        cliente.setNombre("Dario");
        cliente.setCuit("2025");
        cliente.setRazon_social("2");

        Aplicacion aplicacion = new Aplicacion();
        aplicacion.setDenominacion("Tango");

        EntityManagerUtil entityManagerUtil = new EntityManagerUtil();
        entityManagerUtil.crear(cliente);
        entityManagerUtil.crear(sistemaOperativo);
        entityManagerUtil.crear(aplicacion);
    }
}


