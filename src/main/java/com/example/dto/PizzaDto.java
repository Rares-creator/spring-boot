package com.example.dto;

public class PizzaDto {
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
