package ap.repositorios;

import ap.modelos.Aplicacion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class AplicacionRepository {
    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Aplicacion> buscarAplcaciones() {
        return em.createQuery("select a from Aplicacion a", Aplicacion.class).getResultList();
    }

    public Aplicacion buscarUnId(int id) {
        return em.find(Aplicacion.class, id);
    }

    public void insertar(Aplicacion aplicacion) {
        em.persist(aplicacion);
    }

    public void actualizar(Aplicacion aplicacion) {
        em.merge(aplicacion);
    }
}
