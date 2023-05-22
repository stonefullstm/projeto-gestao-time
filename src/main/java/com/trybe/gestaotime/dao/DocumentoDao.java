package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Documento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DocumentoDao extends GenericDao<Documento, Integer> {

  @Override
  public void deletar(Long id) {
    EntityManager em = emf.createEntityManager();
    Documento toBeDeleted = em.find(Documento.class, id);
    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public List<Documento> listar() {
    EntityManager em = emf.createEntityManager();
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Documento> cq = cb.createQuery(Documento.class);
    Root<Documento> rootEntry = cq.from(Documento.class);
    CriteriaQuery<Documento> all = cq.select(rootEntry);

    TypedQuery<Documento> allQuery = em.createQuery(all);
    return allQuery.getResultList();
  }

  @Override
  public Documento buscarPorId(Long id) {
    EntityManager em = emf.createEntityManager();
    return em.find(Documento.class, id);
  }

}
