package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Jogador;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class JogadorDao extends GenericDao<Jogador, Integer> {

  @Override
  public void deletar(Long id) {
    Jogador toBeDeleted = em.find(Jogador.class, id);
    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();
  }

  @Override
  public List<Jogador> listar() {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Jogador> cq = cb.createQuery(Jogador.class);
    Root<Jogador> rootEntry = cq.from(Jogador.class);
    CriteriaQuery<Jogador> all = cq.select(rootEntry);

    TypedQuery<Jogador> allQuery = em.createQuery(all);
    return allQuery.getResultList();
  }

  @Override
  public Jogador buscarPorId(Long id) {
    return em.find(Jogador.class, id);
  }

}
