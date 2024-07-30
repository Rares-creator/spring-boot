package com.example.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

public class RestaurantDto {
  private Integer id;

  private String denumire;
  private String locatie;

  @JsonManagedReference private List<MasaDto> mese;

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

  public List<MasaDto> getMese() {
    return mese;
  }

  public void setMese(List<MasaDto> mese) {
    this.mese = mese;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return denumire;
  }
}
