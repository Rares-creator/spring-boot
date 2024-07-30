package com.example.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.*;

@Entity
public class Apartament {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String locatie;
  private Integer numarCamere;
  private Integer numarBai;
  private Boolean balcon;
  private Integer suprafata;

  @JsonManagedReference
  @OneToMany(
      mappedBy = "apartament",
      fetch = FetchType.EAGER,
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private List<Birou> birouri;

  public String getLocatie() {
    return locatie;
  }

  public void setLocatie(String locatie) {
    this.locatie = locatie;
  }

  public Integer getNumarCamere() {
    return numarCamere;
  }

  public void setNumarCamere(Integer numarCamere) {
    this.numarCamere = numarCamere;
  }

  public Integer getNumarBai() {
    return numarBai;
  }

  public void setNumarBai(Integer numarBai) {
    this.numarBai = numarBai;
  }

  public Boolean getBalcon() {
    return balcon;
  }

  public void setBalcon(Boolean balcon) {
    this.balcon = balcon;
  }

  public Integer getSuprafata() {
    return suprafata;
  }

  public void setSuprafata(Integer suprafata) {
    this.suprafata = suprafata;
  }

  public List<Birou> getBirouri() {
    return birouri;
  }

  public void setBirouri(List<Birou> birouri) {
    this.birouri = birouri;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
