package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Surub {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String tipSurub;
  private Integer lungime;
  private String material;
  private Integer grosime;
  private String zonaFolosire;

  public String getTipSurub() {
    return tipSurub;
  }

  public void setTipSurub(String tipSurub) {
    this.tipSurub = tipSurub;
  }

  public Integer getLungime() {
    return lungime;
  }

  public void setLungime(Integer lungime) {
    this.lungime = lungime;
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public Integer getGrosime() {
    return grosime;
  }

  public void setGrosime(Integer grosime) {
    this.grosime = grosime;
  }

  public String getZonaFolosire() {
    return zonaFolosire;
  }

  public void setZonaFolosire(String zonaFolosire) {
    this.zonaFolosire = zonaFolosire;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
