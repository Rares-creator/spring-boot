package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Laptop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String denumire;
  private Integer memorieRam;
  private String placaVideo;
  private Boolean fastUsb;
  private String capacitateBaterie;

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

  public Integer getMemorieRam() {
    return memorieRam;
  }

  public void setMemorieRam(Integer memorieRam) {
    this.memorieRam = memorieRam;
  }

  public String getPlacaVideo() {
    return placaVideo;
  }

  public void setPlacaVideo(String placaVideo) {
    this.placaVideo = placaVideo;
  }

  public Boolean getFastUsb() {
    return fastUsb;
  }

  public void setFastUsb(Boolean fastUsb) {
    this.fastUsb = fastUsb;
  }

  public String getCapacitateBaterie() {
    return capacitateBaterie;
  }

  public void setCapacitateBaterie(String capacitateBaterie) {
    this.capacitateBaterie = capacitateBaterie;
  }
}
