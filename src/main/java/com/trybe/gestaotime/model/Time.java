package com.trybe.gestaotime.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe Time.
 **/
@Entity
@Table(name = "Times")
public class Time {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;

  @OneToMany(mappedBy = "time", fetch = FetchType.EAGER, cascade = CascadeType.ALL,
      orphanRemoval = true)
  private List<Jogador> jogadores;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(name = "relacionamento_time_torcedor", joinColumns = {@JoinColumn(name = "time_id")},
      inverseJoinColumns = {@JoinColumn(name = "torcedor_id")})
  private List<Torcedor> torcedores;

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
   * Método getJogadores.
   */
  public List<Jogador> getJogadores() {
    return jogadores;
  }

  /**
   * Método setJogadores.
   */
  public void setJogadores(List<Jogador> jogadores) {
    this.jogadores = jogadores;
  }

  /**
   * Método getTorcedores.
   */
  public List<Torcedor> getTorcedores() {
    return torcedores;
  }

  /**
   * Método setTorcedores.
   */
  public void setTorcedores(List<Torcedor> torcedores) {
    this.torcedores = torcedores;
  }

}
