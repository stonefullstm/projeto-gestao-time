package com.trybe.gestaotime.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Classe Torcedor.
 **/
@Entity
@Table(name = "Torcedores")
public class Torcedor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;

  @ManyToMany(mappedBy = "torcedores")
  private List<Time> times;

  /**
   * Método getId.
   */
  public Long getId() {
    return id;
  }

  /**
   * Método setId.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Método getNome.
   */
  public String getNome() {
    return nome;
  }

  /**
   * Método setNome.
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Método getTimes.
   */
  public List<Time> getTimes() {
    return times;
  }

  /**
   * Método addTime.
   */
  public void addTime(Time time) {
    this.times.add(time);
  }

}
