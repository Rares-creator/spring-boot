package com.example.dto;

import com.example.entities.Sex;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;

public class AnimalDto implements Serializable {
  private Integer id;
  private String rasa;
  private String nume;
  private Integer varsta;
  private Boolean pedigree;
  private Sex sex;

  @JsonBackReference private PersonDto person;

  public PersonDto getPerson() {
    return person;
  }

  public void setPerson(PersonDto person) {
    this.person = person;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRasa() {
    return rasa;
  }

  public void setRasa(String rasa) {
    this.rasa = rasa;
  }

  public String getNume() {
    return nume;
  }

  public void setNume(String nume) {
    this.nume = nume;
  }

  public Integer getVarsta() {
    return varsta;
  }

  public void setVarsta(Integer varsta) {
    this.varsta = varsta;
  }

  public Boolean getPedigree() {
    return pedigree;
  }

  public void setPedigree(Boolean pedigree) {
    this.pedigree = pedigree;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }
}
