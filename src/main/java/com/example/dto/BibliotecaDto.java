package com.example.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

public class BibliotecaDto {
  private Integer id;

  private String denumire;
  private String locatie;
  private Boolean deschisWeekend;

  @JsonManagedReference private List<CarteDto> carti;

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

  public List<CarteDto> getCarti() {
    return carti;
  }

  public void setCarti(List<CarteDto> carti) {
    this.carti = carti;
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
