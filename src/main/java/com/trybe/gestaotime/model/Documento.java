package com.trybe.gestaotime.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe Documento.
 */
@Entity
@Table(name = "Documentos")
public class Documento {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String cpf;
  @Column(name = "carteira_trabalho")
  private String carteiraTrabalho;
  @Column(name = "numero_cbf")
  private String numeroCbf;

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
   * Método getCpf.
   */
  public String getCpf() {
    return cpf;
  }

  /**
   * Método setCpf.
   */
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /**
   * Método getCarteiraTrabalho.
   */
  public String getCarteiraTrabalho() {
    return carteiraTrabalho;
  }

  /**
   * Método setCarteiraTrabalho.
   */
  public void setCarteiraTrabalho(String carteiraTrabalho) {
    this.carteiraTrabalho = carteiraTrabalho;
  }

  /**
   * Método setNumeroCbf.
   */
  public String getNumeroCbf() {
    return numeroCbf;
  }

  /**
   * Método getNumeroCbf.
   */
  public void setNumeroCbf(String numeroCbf) {
    this.numeroCbf = numeroCbf;
  }


}
