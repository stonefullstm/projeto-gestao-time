package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Time;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TimeDao extends GenericDao<Time, Integer> {

  @Override
  public void deletar(Long id) {
    Time toBeDeleted = em.find(Time.class, id);
    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();
  }

  @Override
  public List<Time> listar() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Time> cq = cb.createQuery(Time.class);
    Root<Time> rootEntry = cq.from(Time.class);
    CriteriaQuery<Time> all = cq.select(rootEntry);

    TypedQuery<Time> allQuery = em.createQuery(all);
    return allQuery.getResultList();

  }

  @Override
  public Time buscarPorId(Long id) {
    return em.find(Time.class, id);

  }

}
