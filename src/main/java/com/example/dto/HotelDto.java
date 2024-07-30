package com.example.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

public class HotelDto {
  private Integer id;

  private String denumire;
  private String locatie;
  private Boolean restaurant;
  private Boolean piscina;
  @JsonManagedReference private List<CameraDto> camere;

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

  public List<CameraDto> getCamere() {
    return camere;
  }

  public void setCamere(List<CameraDto> camere) {
    this.camere = camere;
  }

  @Override
  public String toString() {
    return denumire;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
