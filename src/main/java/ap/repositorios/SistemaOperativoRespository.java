package ap.repositorios;

import ap.modelos.Aplicacion;
import ap.modelos.Cliente;
import ap.modelos.Servicio;
import ap.modelos.SistemaOperativo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SistemaOperativoRespository {

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
