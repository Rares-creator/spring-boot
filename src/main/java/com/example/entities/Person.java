package com.example.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.*;

@Entity
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Long cnp;
  private String nume;
  private String prenume;
  private Integer varsta;
  private Sex sex;

  @OneToMany(
      mappedBy = "person",
      fetch = FetchType.EAGER,
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  @JsonManagedReference
  private List<Animal> animale;

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

  public List<Animal> getAnimale() {
    return animale;
  }

  public void setAnimale(List<Animal> animale) {
    this.animale = animale;
  }
}
