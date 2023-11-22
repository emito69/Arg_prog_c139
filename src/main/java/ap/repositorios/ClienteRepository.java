package ap.repositorios;

import ap.modelos.Cliente;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ClienteRepository {

    @PersistenceContext
    private EntityManager em;

    public void insertar(Cliente cliente) {

        em.persist(cliente);
    }

}
