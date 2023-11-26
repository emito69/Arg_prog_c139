package ap.repositorios;

import ap.modelos.Tecnico;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
        return em.createQuery("select s from Tecnico s", Tecnico.class).getResultList();
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
