package ap.repositorios;

import ap.modelos.Aplicacion;
import ap.modelos.Cliente;
import ap.modelos.Servicio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AplicacionRepository {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Aplicacion> buscarAplicaciones() {
        return em.createQuery("select s from Aplicacion s", Aplicacion.class).getResultList();
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
