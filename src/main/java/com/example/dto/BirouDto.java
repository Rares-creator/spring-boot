package com.example.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;

public class BirouDto implements Serializable {
  private Integer id;

  private String material;
  private Integer pret;
  private String dimensiune;
  private String culoare;
  private Integer greutate;

  @JsonBackReference private ApartamentDto apartament;

  public ApartamentDto getApartament() {
    return apartament;
  }

  public void setApartament(ApartamentDto apartament) {
    this.apartament = apartament;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public String getMaterial() {
    return this.material;
  }

  public void setPret(Integer pret) {
    this.pret = pret;
  }

  public Integer getPret() {
    return this.pret;
  }

  public String getDimensiune() {
    return dimensiune;
  }

  public void setDimensiune(String dimensiune) {
    this.dimensiune = dimensiune;
  }

  public String getCuloare() {
    return culoare;
  }

  public void setCuloare(String culoare) {
    this.culoare = culoare;
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
}
