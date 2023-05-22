package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Time;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TimeDao extends GenericDao<Time, Integer> {
  private EntityManagerFactory emf;

  public TimeDao() {
    this.emf = super.emf;
  }

  @Override
  public void deletar(Long id) {
    EntityManager em = this.emf.createEntityManager();
    Time toBeDeleted = em.find(Time.class, id);
    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();
    em.close();
  }

  @Override
  public List<Time> listar() {
    EntityManager em = this.emf.createEntityManager();
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Time> cq = cb.createQuery(Time.class);
    Root<Time> rootEntry = cq.from(Time.class);
    CriteriaQuery<Time> all = cq.select(rootEntry);
    TypedQuery<Time> allQuery = em.createQuery(all);
    List<Time> result = allQuery.getResultList();
    em.close();
    return result;
  }

  @Override
  public Time buscarPorId(Long id) {
    EntityManager em = this.emf.createEntityManager();
    Time result = em.find(Time.class, id);
    em.close();
    return result;
  }

}
