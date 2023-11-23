package ap.repositorios;

import ap.modelos.Cliente;
import ap.modelos.InfoContacto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class InfoContactoRepository {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<InfoContacto> buscarInfoContactos() {
        return em.createQuery("select i from InfoContacto i", InfoContacto.class).getResultList();
    }

    public InfoContacto buscarUnId(int id) {
        return em.find(InfoContacto.class, id);
    }

    public void insertar(InfoContacto infoContacto) {
        em.persist(infoContacto);
    }

    public void actualizar(InfoContacto infoContacto) {
        em.merge(infoContacto);
    }

}
