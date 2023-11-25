package ap.repositorios;

import ap.modelos.Cliente;
import ap.modelos.Tecnico;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TecnicoRepository {
    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Tecnico> buscarTecnicos() {
        return em.createQuery("select c from Tecnico c", Tecnico.class).getResultList();
    }

    public Tecnico buscarUnId(int id) {
        return em.find(Tecnico.class, id);
    }

    public void insertar(Tecnico tecnico) {
        em.persist(tecnico);
    }

    public void actualizar(Tecnico tecnico) {
        em.merge(tecnico);
    }
}
