package org.acme.sample.web;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String nume;
  private String prenume;
  private Long cnp;
  private String nrTel;

  private Date dataNasterii;
  private Integer varsta;
  private Boolean decedat;

  public Person() {}

  public Person(String nume, String prenume) {
    this.nume = nume;
    this.prenume = prenume;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNume() {
    return nume;
  }

  public void setNume(String nume) {
    this.nume = nume;
  }

  public String getPrenume() {
    return prenume;
  }

  public void setPrenume(String prenume) {
    this.prenume = prenume;
  }

  public Long getCnp() {
    return cnp;
  }

  public void setCnp(Long cnp) {
    this.cnp = cnp;
  }

  public String getNrTel() {
    return nrTel;
  }

  public void setNrTel(String nrTel) {
    this.nrTel = nrTel;
  }

  public Date getDataNasterii() {
    return dataNasterii;
  }

  public void setDataNasterii(Date dataNasterii) {
    this.dataNasterii = dataNasterii;
  }

  public Integer getVarsta() {
    return varsta;
  }

  public void setVarsta(Integer varsta) {
    this.varsta = varsta;
  }

  public Boolean isDecedat() {
    return decedat;
  }

  public void setDecedat(Boolean decedat) {
    this.decedat = decedat;
  }
}
