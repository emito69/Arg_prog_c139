package ap.repositorios;

import ap.modelos.Tipo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TipoRepository {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Tipo> buscarTipos() {
        return em.createQuery("select s from Tipo s", Tipo.class).getResultList();
    }

    public Tipo buscarUnId(int id) {
        return em.find(Tipo.class, id);
    }

    public void insertar(Tipo tipo) {
        em.persist(tipo);
    }

    public void actualizar(Tipo tipo) {
        em.merge(tipo);
    }
}
