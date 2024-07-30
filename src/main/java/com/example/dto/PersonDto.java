package com.example.dto;

import com.example.entities.Sex;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;

public class PersonDto implements Serializable {
  private Integer id;
  private Long cnp;
  private String nume;
  private String prenume;
  private Integer varsta;
  private Sex sex;

  @JsonManagedReference private List<AnimalDto> animale;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Long getCnp() {
    return cnp;
  }

  public void setCnp(Long cnp) {
    this.cnp = cnp;
  }

  public String getNume() {
    return nume;
  }

  public void setNume(String nume) {
    this.nume = nume;
  }

  public String getPrenume() {
    return prenume;
  }

  public void setPrenume(String prenume) {
    this.prenume = prenume;
  }

  public Integer getVarsta() {
    return varsta;
  }

  public void setVarsta(Integer varsta) {
    this.varsta = varsta;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  public List<AnimalDto> getAnimale() {
    return animale;
  }

  public void setAnimale(List<AnimalDto> animale) {
    this.animale = animale;
  }

  @Override
  public String toString() {
    return nume + " " + prenume;
  }
}
