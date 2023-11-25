package ap.repositorios;

import ap.modelos.InfoContacto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
