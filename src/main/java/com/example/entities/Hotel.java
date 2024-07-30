package com.example.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.*;

@Entity
public class Hotel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String denumire;
  private String locatie;
  private Boolean restaurant;
  private Boolean piscina;

  @JsonManagedReference
  @OneToMany(
      mappedBy = "hotel",
      fetch = FetchType.EAGER,
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private List<Camera> camere;

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

  public Boolean getRestaurant() {
    return restaurant;
  }

  public void setRestaurant(Boolean restaurant) {
    this.restaurant = restaurant;
  }

  public Boolean getPiscina() {
    return piscina;
  }

  public void setPiscina(Boolean piscina) {
    this.piscina = piscina;
  }

  public List<Camera> getCamere() {
    return camere;
  }

  public void setCamere(List<Camera> camere) {
    this.camere = camere;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
