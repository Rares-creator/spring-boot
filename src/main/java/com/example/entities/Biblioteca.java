package com.example.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.*;

@Entity
public class Biblioteca {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String denumire;
  private String locatie;
  private Boolean deschisWeekend;

  @JsonManagedReference
  @OneToMany(
      mappedBy = "biblioteca",
      fetch = FetchType.EAGER,
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private List<Carte> carti;

  public String getDenumire() {
    return denumire;
  }

  public void setDenumire(String denumire) {
    this.denumire = denumire;
  }

  public String getLocatie() {
    return locatie;
  }

  public void setLocatie(String locatie) {
    this.locatie = locatie;
  }

  public Boolean getDeschisWeekend() {
    return deschisWeekend;
  }

  public void setDeschisWeekend(Boolean deschisWeekend) {
    this.deschisWeekend = deschisWeekend;
  }

  public List<Carte> getCarti() {
    return carti;
  }

  public void setCarti(List<Carte> carti) {
    this.carti = carti;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
