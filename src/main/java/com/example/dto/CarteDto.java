package com.example.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class CarteDto {
  private Integer id;

  private String nume;

  private String gen;
  private String autor;
  private Integer numarPagini;

  @JsonBackReference private BibliotecaDto biblioteca;

  public String getNume() {
    return nume;
  }

  public void setNume(String nume) {
    this.nume = nume;
  }

  public String getGen() {
    return gen;
  }

  public void setGen(String gen) {
    this.gen = gen;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public Integer getNumarPagini() {
    return numarPagini;
  }

  public void setNumarPagini(Integer numarPagini) {
    this.numarPagini = numarPagini;
  }

  public BibliotecaDto getBiblioteca() {
    return biblioteca;
  }

  public void setBiblioteca(BibliotecaDto biblioteca) {
    this.biblioteca = biblioteca;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
