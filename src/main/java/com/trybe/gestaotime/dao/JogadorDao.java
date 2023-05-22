package com.trybe.gestaotime.dao;

import com.trybe.gestaotime.model.Jogador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class JogadorDao extends GenericDao<Jogador, Integer> {
  private EntityManagerFactory emf;

  public JogadorDao() {
    this.emf = GenericDao.emf;
  }

  @Override
  public void deletar(Long id) {
    EntityManager em = this.emf.createEntityManager();
    Jogador toBeDeleted = em.find(Jogador.class, id);
    em.getTransaction().begin();
    em.remove(toBeDeleted);
    em.getTransaction().commit();
    // em.close();
  }

  @Override
  public List<Jogador> listar() {
    EntityManager em = this.emf.createEntityManager();
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Jogador> cq = cb.createQuery(Jogador.class);
    Root<Jogador> rootEntry = cq.from(Jogador.class);
    CriteriaQuery<Jogador> all = cq.select(rootEntry);
    TypedQuery<Jogador> allQuery = em.createQuery(all);
    List<Jogador> result = allQuery.getResultList();
    // em.close();
    return result;
  }

  @Override
  public Jogador buscarPorId(Long id) {
    EntityManager em = this.emf.createEntityManager();
    Jogador result = em.find(Jogador.class, id);
    // em.close();
    return result;
  }

}
