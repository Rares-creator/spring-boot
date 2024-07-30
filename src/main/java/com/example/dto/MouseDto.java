package com.example.dto;

public class MouseDto {
  private Integer id;

  private String denumire;
  private Integer numarButoane;
  private Integer numarDpi;
  private Boolean cabluUsb;
  private Boolean luminaAmbientala;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDenumire() {
    return denumire;
  }

  public void setDenumire(String denumire) {
    this.denumire = denumire;
  }

  public Integer getNumarButoane() {
    return numarButoane;
  }

  public void setNumarButoane(Integer numarButoane) {
    this.numarButoane = numarButoane;
  }

  public Integer getNumarDpi() {
    return numarDpi;
  }

  public void setNumarDpi(Integer numarDpi) {
    this.numarDpi = numarDpi;
  }

  public Boolean getCabluUsb() {
    return cabluUsb;
  }

  public void setCabluUsb(Boolean cabluUsb) {
    this.cabluUsb = cabluUsb;
  }

  public Boolean getLuminaAmbientala() {
    return luminaAmbientala;
  }

  public void setLuminaAmbientala(Boolean luminaAmbientala) {
    this.luminaAmbientala = luminaAmbientala;
  }
}
