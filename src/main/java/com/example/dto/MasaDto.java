package com.example.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class MasaDto {
  private Integer id;

  private Integer numarMasa;
  private Integer capacitate;
  private Boolean rezervata;

  @JsonBackReference private RestaurantDto restaurant;

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

  public RestaurantDto getRestaurant() {
    return restaurant;
  }

  public void setRestaurant(RestaurantDto restaurant) {
    this.restaurant = restaurant;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
