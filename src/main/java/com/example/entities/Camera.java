package com.example.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
public class Camera {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer numarCamera;

  private Integer suprafata;
  private Boolean jacuzzi;

  private String tipCamera;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "hotel_id")
  private Hotel hotel;

  public Integer getNumarCamera() {
    return numarCamera;
  }

  public void setNumarCamera(Integer numarCamera) {
    this.numarCamera = numarCamera;
  }

  public Integer getSuprafata() {
    return suprafata;
  }

  public void setSuprafata(Integer suprafata) {
    this.suprafata = suprafata;
  }

  public Boolean getJacuzzi() {
    return jacuzzi;
  }

  public void setJacuzzi(Boolean jacuzzi) {
    this.jacuzzi = jacuzzi;
  }

  public String getTipCamera() {
    return tipCamera;
  }

  public void setTipCamera(String tipCamera) {
    this.tipCamera = tipCamera;
  }

  public Hotel getHotel() {
    return hotel;
  }

  public void setHotel(Hotel hotel) {
    this.hotel = hotel;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
