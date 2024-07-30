package com.example.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
public class Masa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer numarMasa;
  private Integer capacitate;
  private Boolean rezervata;

  @ManyToOne(fetch = FetchType.EAGER)
  @JsonBackReference
  @JoinColumn(name = "restaurant_id")
  private Restaurant restaurant;

  public Integer getNumarMasa() {
    return numarMasa;
  }

  public void setNumarMasa(Integer numarMasa) {
    this.numarMasa = numarMasa;
  }

  public Integer getCapacitate() {
    return capacitate;
  }

  public void setCapacitate(Integer capacitate) {
    this.capacitate = capacitate;
  }

  public Boolean getRezervata() {
    return rezervata;
  }

  public void setRezervata(Boolean rezervata) {
    this.rezervata = rezervata;
  }

  public Restaurant getRestaurant() {
    return restaurant;
  }

  public void setRestaurant(Restaurant restaurant) {
    this.restaurant = restaurant;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
