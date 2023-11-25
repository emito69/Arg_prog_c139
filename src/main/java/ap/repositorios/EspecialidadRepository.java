package ap.repositorios;

import ap.modelos.Especialidad;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class EspecialidadRepository {
    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
   public List<Especialidad> buscarListaEspecialidad() {

      return  em.createQuery("select e from Especialidad e" ,Especialidad.class).getResultList();

    }
   public Especialidad buscarUna(int numero) {

       return em.find(Especialidad.class, numero);
   }

    public void insertar(Especialidad especialidad) {
        em.persist(especialidad);
    }

    public void actualizar(Especialidad especialidad) {
        em.merge(especialidad);
    }
}
