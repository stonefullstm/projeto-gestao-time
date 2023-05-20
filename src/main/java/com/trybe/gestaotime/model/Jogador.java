package com.trybe.gestaotime.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe Jogador.
 **/
@Entity
@Table(name = "Jogadores")
public class Jogador {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String posicao;

  @JoinColumn(name = "documento_id")
  @OneToOne(fetch = FetchType.LAZY)
  private Documento documento;

  @ManyToOne
  @JoinColumn(name = "time_id")
  private Time time;

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
   * Método getPosicao.
   */
  public String getPosicao() {
    return posicao;
  }

  /**
   * Método setPosicao.
   */
  public void setPosicao(String posicao) {
    this.posicao = posicao;
  }

  /**
   * Método getDocumento.
   */
  public Documento getDocumento() {
    return documento;
  }

  /**
   * Método setDocumento.
   */
  public void setDocumento(Documento documento) {
    this.documento = documento;
  }

  /**
   * Método getTime.
   */
  public Time getTime() {
    return time;
  }

  /**
   * Método setTime.
   */
  public void setTime(Time time) {
    this.time = time;
  }


}
