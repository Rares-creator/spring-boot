package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pizza {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String denumire;
  private Integer gramaj;
  private Boolean glutenFree;
  private Boolean sosExtra;
  private Integer pret;

  public String getDenumire() {
    return denumire;
  }

  public void setDenumire(String denumire) {
    this.denumire = denumire;
  }

  public Integer getGramaj() {
    return gramaj;
  }

  public void setGramaj(Integer gramaj) {
    this.gramaj = gramaj;
  }

  public Boolean getGlutenFree() {
    return glutenFree;
  }

  public void setGlutenFree(Boolean glutenFree) {
    this.glutenFree = glutenFree;
  }

  public Boolean getSosExtra() {
    return sosExtra;
  }

  public void setSosExtra(Boolean sosExtra) {
    this.sosExtra = sosExtra;
  }

  public Integer getPret() {
    return pret;
  }

  public void setPret(Integer pret) {
    this.pret = pret;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
