package com.example.dto;

import com.example.entities.Marime;
import com.example.entities.Sex;

public class TricouDto {
  private Integer id;
  private String material;
  private Marime marime;
  private Integer pret;
  private Sex sex;
  private String culoare;

  public void setMaterial(String material) {
    this.material = material;
  }

  public String getMaterial() {
    return material;
  }

  public Marime getMarime() {
    return marime;
  }

  public void setMarime(Marime marime) {
    this.marime = marime;
  }

  public Integer getPret() {
    return pret;
  }

  public void setPret(Integer pret) {
    this.pret = pret;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  public String getCuloare() {
    return culoare;
  }

  public void setCuloare(String culoare) {
    this.culoare = culoare;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
