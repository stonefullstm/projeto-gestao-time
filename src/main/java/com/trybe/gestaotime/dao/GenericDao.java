package com.trybe.gestaotime.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe abstrata GenericDao.
 **/

public abstract class GenericDao<T, I extends Serializable> {

  EntityManagerFactory emf = Persistence.createEntityManagerFactory("crudHibernatePU");

  /**
   * Método salvar.
   */
  public void salvar(T entity) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(entity);
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Método editar.
   */
  public void editar(T entity) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(entity);
    em.getTransaction().commit();
    em.close();
  }

  public abstract void deletar(Long id);

  public abstract List<T> listar();

  public abstract T buscarPorId(Long id);

}
