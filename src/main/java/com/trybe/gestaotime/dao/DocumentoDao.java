package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Documento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DocumentoDao extends GenericDao<Documento, Integer> {
  private EntityManagerFactory emf;

  public DocumentoDao() {
    this.emf = GenericDao.emf;
  }

  @Override
  public void deletar(Long id) {
    EntityManager em = this.emf.createEntityManager();
    Documento toBeDeleted = em.find(Documento.class, id);
    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();
    // em.close();
  }

  @Override
  public List<Documento> listar() {
    EntityManager em = this.emf.createEntityManager();
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Documento> cq = cb.createQuery(Documento.class);
    Root<Documento> rootEntry = cq.from(Documento.class);
    CriteriaQuery<Documento> all = cq.select(rootEntry);
    TypedQuery<Documento> allQuery = em.createQuery(all);
    List<Documento> result = allQuery.getResultList();
    // em.close();
    return result;
  }

  @Override
  public Documento buscarPorId(Long id) {
    EntityManager em = this.emf.createEntityManager();
    Documento result = em.find(Documento.class, id);
    // em.close();
    return result;
  }

}
