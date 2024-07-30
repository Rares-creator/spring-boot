package com.example.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
public class Animal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String rasa;
  private String nume;
  private int varsta;
  private Boolean pedigree;

  @Enumerated(EnumType.STRING)
  private Sex sex;

  @ManyToOne(fetch = FetchType.EAGER)
  @JsonBackReference
  @JoinColumn(name = "person_id")
  private Person person;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
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

  public int getVarsta() {
    return varsta;
  }

  public void setVarsta(int varsta) {
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
