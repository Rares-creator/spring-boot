package com.example.entities;

import javax.persistence.*;

@Entity
public class Pantof {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String tipPantof;
  private Integer numar;

  @Enumerated(EnumType.STRING)
  private Sex sex;

  private String material;
  private Integer greutate;

  public String getTipPantof() {
    return tipPantof;
  }

  public void setTipPantof(String tipPantof) {
    this.tipPantof = tipPantof;
  }

  public Integer getNumar() {
    return numar;
  }

  public void setNumar(Integer numar) {
    this.numar = numar;
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public Integer getGreutate() {
    return greutate;
  }

  public void setGreutate(Integer greutate) {
    this.greutate = greutate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }
}
