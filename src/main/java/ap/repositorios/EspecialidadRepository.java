package ap.repositorios;

import ap.modelos.Especialidad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EspecialidadRepository {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Especialidad> buscarEspecialidades() {
        return em.createQuery("select e from Especialidad e", Especialidad.class).getResultList();
    }

    public Especialidad buscarUnId(int id) {
        return em.find(Especialidad.class, id);
    }

    public void insertar(Especialidad especialidad) {
        em.persist(especialidad);
    }

    public void actualizar(Especialidad especialidad) {
        em.merge(especialidad);
    }
}
