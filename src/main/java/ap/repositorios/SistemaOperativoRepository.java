package ap.repositorios;


import ap.modelos.SistemaOperativo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class SistemaOperativoRepository {
    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<SistemaOperativo> buscarSistemasOperativos() {
        return em.createQuery("select s from SistemaOperativo s", SistemaOperativo.class).getResultList();
    }

    public SistemaOperativo buscarUnId(int id) {
        return em.find(SistemaOperativo.class, id);
    }

    public void insertar(SistemaOperativo sistemaOperativo) {
        em.persist(sistemaOperativo);
    }

    public void actualizar(SistemaOperativo sistemaOperativo) {
        em.merge(sistemaOperativo);
    }
}
