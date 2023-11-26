package ap.repositorios;

import ap.modelos.Problema;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ProblemaRepository {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Problema> buscarProblemas() {
        return em.createQuery("select s from Problema s", Problema.class).getResultList();
    }

    public Problema buscarUnId(int id) {
        return em.find(Problema.class, id);
    }

    public void insertar(Problema problema) {
        em.persist(problema);
    }

    public void actualizar(Problema problema) {
        em.merge(problema);
    }

}
