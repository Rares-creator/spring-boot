package com.example.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
public class Birou {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String material;
  private Integer pret;
  private String dimensiune;
  private String culoare;
  private Integer greutate;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "id_apartament")
  private Apartament apartament;

  public Apartament getApartament() {
    return apartament;
  }

  public void setApartament(Apartament apartament) {
    this.apartament = apartament;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public String getMaterial() {
    return this.material;
  }

  public void setPret(Integer pret) {
    this.pret = pret;
  }

  public Integer getPret() {
    return this.pret;
  }

  public String getDimensiune() {
    return dimensiune;
  }

  public void setDimensiune(String dimensiune) {
    this.dimensiune = dimensiune;
  }

  public String getCuloare() {
    return culoare;
  }

  public void setCuloare(String culoare) {
    this.culoare = culoare;
  }

  public Integer getGreutate() {
    return greutate;
  }

  public void setGreutate(Integer greutate) {
    this.greutate = greutate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
