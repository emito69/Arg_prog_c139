package ap.repositorios;

import ap.modelos.Incidente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class IncidenteRepository {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Incidente> buscarIncidentes() {
        return em.createQuery("select s from Incidente s", Incidente.class).getResultList();
    }

    public Incidente buscarUnId(int id) {
        return em.find(Incidente.class, id);
    }

    public void insertar(Incidente incidente) {
        em.persist(incidente);
    }

    public void actualizar(Incidente incidente) {
        em.merge(incidente);
    }
}
