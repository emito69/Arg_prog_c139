package ap.repositorios;

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


public class ServicioRepository {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Servicio> buscarServicios() {
        return em.createQuery("select s from Servicio s", Servicio.class).getResultList();
    }

    public Servicio buscarUnId(int id) {
        return em.find(Servicio.class, id);
    }

    public void insertar(Servicio servicio) {
        em.persist(servicio);
    }

    public void actualizar(Servicio servicio) {
        em.merge(servicio);
    }


}
