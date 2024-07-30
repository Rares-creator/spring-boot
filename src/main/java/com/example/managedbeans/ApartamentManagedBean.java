package com.example.managedbeans;

import com.example.dto.ApartamentDto;
import com.example.jsf.FacesViewScope;
import com.example.services.ApartamentService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("apartamentManagedBean")
@Scope(FacesViewScope.NAME)
public class ApartamentManagedBean implements Serializable {

  @Autowired ApartamentService apartamentService;

  private List<ApartamentDto> apartaments;

  private ApartamentDto apartamentToSave;

  private String locatieCautare;

  private Integer suprafataCautare;

  private Integer numarCamereCautare;

  private ApartamentDto apartamentCautareCustom;

  private String mesajDialog;

  private Integer apartamentIdPentruStergere;

  private ApartamentDto apartamentPentruActualizare;

  public void actualizeazaApartament() {
    apartamentService.actualizareApartament(apartamentPentruActualizare);
    reloadApartamentListAndResetToDefaults();
  }

  public void pregatesteActualizareApartament(ApartamentDto apartament) {
    apartamentPentruActualizare = apartament;
  }

  public void verificaBirouriSiSeteazaMesajDialog(ApartamentDto apartament) {
    apartamentIdPentruStergere = apartament.getId();
    if (apartament != null && !apartament.getBirouri().isEmpty()) {
      mesajDialog =
          "Apartamentul are birouri asociate. Doriți să ștergeți apartamentul și birourile asociate?";
    } else {
      mesajDialog = "Doriți să ștergeți acest apartament?";
    }
  }

  public String stergeApartament() {
    apartamentService.stergeApartament(apartamentIdPentruStergere);
    reloadApartamentListAndResetToDefaults();
    return "apartament.xhtml?faces-redirect=true";
  }

  public void cautaApartamentCustom() {
    apartaments = apartamentService.cautaApartamente(apartamentCautareCustom);
  }

  public void cautaApartamentDupaLocatie() {
    apartaments = apartamentService.cautaApartamentDupaLocatie(locatieCautare);
  }

  public void cautaApartamentDupaSuprafataMaiMareSiNumarCamereMaiMulte() {
    apartaments =
        apartamentService.cautaApartamentDupaSuprafataMaiMareSiNumarCamereMaiMulte(
            suprafataCautare, numarCamereCautare);
  }

  public void reset() {
    reloadApartamentListAndResetToDefaults();
  }

  private void reloadApartamentListAndResetToDefaults() {
    apartaments = apartamentService.loadAllApartaments();
    apartamentToSave = new ApartamentDto();
    apartamentToSave.setBalcon(true);
    apartamentCautareCustom = new ApartamentDto();
    locatieCautare = null;
    suprafataCautare = null;
    numarCamereCautare = null;
    apartamentPentruActualizare = new ApartamentDto();
  }

  public void adaugaApartament() {
    apartamentService.adaugaApartament(apartamentToSave);
    reloadApartamentListAndResetToDefaults();
  }

  @PostConstruct
  public void init() {
    reloadApartamentListAndResetToDefaults();
  }

  public List<ApartamentDto> getApartaments() {
    return apartaments;
  }

  public void setApartaments(List<ApartamentDto> apartaments) {
    this.apartaments = apartaments;
  }

  public ApartamentDto getApartamentToSave() {
    return apartamentToSave;
  }

  public void setApartamentToSave(ApartamentDto apartamentToSave) {
    this.apartamentToSave = apartamentToSave;
  }

  public String getLocatieCautare() {
    return locatieCautare;
  }

  public void setLocatieCautare(String locatieCautare) {
    this.locatieCautare = locatieCautare;
  }

  public Integer getSuprafataCautare() {
    return suprafataCautare;
  }

  public void setSuprafataCautare(Integer suprafataCautare) {
    this.suprafataCautare = suprafataCautare;
  }

  public Integer getNumarCamereCautare() {
    return numarCamereCautare;
  }

  public void setNumarCamereCautare(Integer numarCamereCautare) {
    this.numarCamereCautare = numarCamereCautare;
  }

  public ApartamentDto getApartamentCautareCustom() {
    return apartamentCautareCustom;
  }

  public void setApartamentCautareCustom(ApartamentDto apartamentCautareCustom) {
    this.apartamentCautareCustom = apartamentCautareCustom;
  }

  public String getMesajDialog() {
    return mesajDialog;
  }

  public void setMesajDialog(String mesajDialog) {
    this.mesajDialog = mesajDialog;
  }

  public ApartamentDto getApartamentPentruActualizare() {
    return apartamentPentruActualizare;
  }

  public void setApartamentPentruActualizare(ApartamentDto apartamentPentruActualizare) {
    this.apartamentPentruActualizare = apartamentPentruActualizare;
  }
}
