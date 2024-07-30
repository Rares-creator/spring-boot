package com.example.managedbeans;

import com.example.dto.ApartamentDto;
import com.example.dto.BirouDto;
import com.example.jsf.FacesViewScope;
import com.example.services.ApartamentService;
import com.example.services.BirouService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("birouManagedBean")
@Scope(FacesViewScope.NAME)
public class BirouManagedBean implements Serializable {

  @Autowired private BirouService birouService;

  @Autowired private ApartamentService apartamentService;
  private BirouDto birouCautareCustom;

  private BirouDto birouToSave;
  private List<BirouDto> birous;

  private Integer apartamentId;

  private List<ApartamentDto> apartamente;

  private String materialCautare;

  private String dimensiuneCautare;

  private Integer pretMaiMareCautare;

  private String culoareCautare;

  private Integer pretMaiMicCautare;

  private Integer birouIdPentruStergere;

  private String mesajDialog;

  private BirouDto birouPentruActualizare;

  private Integer apartamentIdPentruActualizare;

  public void actualizeazaBirou() {
    ApartamentDto apartament = new ApartamentDto();
    apartament.setId(apartamentIdPentruActualizare);
    birouPentruActualizare.setApartament(apartament);
    birouService.actualizareBirou(birouPentruActualizare);
    reloadBirouListAndResetToDefaults();
  }

  public void pregatesteActualizareBirou(BirouDto birou) {
    birouPentruActualizare = birou;
    apartamentIdPentruActualizare = birou.getApartament().getId();
  }

  public void seteazaIdBirourPentruStergere(BirouDto birou) {
    birouIdPentruStergere = birou.getId();
  }

  public String stergeBirou() {
    birouService.stergeBirou(birouIdPentruStergere);
    reloadBirouListAndResetToDefaults();
    return "birou.xhtml?faces-redirect=true";
  }

  private void reloadBirouListAndResetToDefaults() {
    birous = birouService.loadAllBirous();
    birouToSave = new BirouDto();
    birouPentruActualizare = new BirouDto();
    birouCautareCustom = new BirouDto();
    dimensiuneCautare = null;
    culoareCautare = null;
    pretMaiMicCautare = null;
    apartamentIdPentruActualizare = null;
  }

  public void adaugaBirou() {
    ApartamentDto apartament = new ApartamentDto();
    apartament.setId(apartamentId);
    birouToSave.setApartament(apartament);
    birouService.adaugaBirou(birouToSave);
    reloadBirouListAndResetToDefaults();
  }

  public void cautaBirouCustom() {
    birous = birouService.cautaBirouri(birouCautareCustom);
  }

  public void cautaBirouriDupaMaterial() {
    birous = birouService.cautaBirouriDupaMaterial(materialCautare);
    System.out.println("Am apelat metoda");
  }

  public void cautaBirouriDupaDimensiuneSiPretMaiMare() {
    birous =
        birouService.cautaBirouriDupaDimensiuneSiPretMaiMare(dimensiuneCautare, pretMaiMareCautare);
  }

  public void cautaBirouriDupaCuloareSiPretMaiMic() {
    birous = birouService.cautaBirouriDupaCuloareSiPretMaiMic(culoareCautare, pretMaiMicCautare);
  }

  public void reset() {
    reloadBirouListAndResetToDefaults();
  }

  @PostConstruct
  public void init() {
    apartamente = apartamentService.loadAllApartaments();
    reloadBirouListAndResetToDefaults();
    mesajDialog = "Doriți să ștergeți acest birou?";
  }

  public List<BirouDto> getBirous() {
    return birous;
  }

  public void setBirous(List<BirouDto> birous) {
    this.birous = birous;
  }

  public BirouDto getBirouToSave() {
    return birouToSave;
  }

  public void setBirouToSave(BirouDto birouToSave) {
    this.birouToSave = birouToSave;
  }

  public Integer getApartamentId() {
    return apartamentId;
  }

  public void setApartamentId(Integer apartamentId) {
    this.apartamentId = apartamentId;
  }

  public List<ApartamentDto> getApartamente() {
    return apartamente;
  }

  public void setApartamente(List<ApartamentDto> apartamente) {
    this.apartamente = apartamente;
  }

  public String getMaterialCautare() {
    return materialCautare;
  }

  public void setMaterialCautare(String materialCautare) {
    this.materialCautare = materialCautare;
  }

  public String getDimensiuneCautare() {
    return dimensiuneCautare;
  }

  public void setDimensiuneCautare(String dimensiuneCautare) {
    this.dimensiuneCautare = dimensiuneCautare;
  }

  public Integer getPretMaiMareCautare() {
    return pretMaiMareCautare;
  }

  public void setPretMaiMareCautare(Integer pretMaiMareCautare) {
    this.pretMaiMareCautare = pretMaiMareCautare;
  }

  public String getCuloareCautare() {
    return culoareCautare;
  }

  public void setCuloareCautare(String culoareCautare) {
    this.culoareCautare = culoareCautare;
  }

  public Integer getPretMaiMicCautare() {
    return pretMaiMicCautare;
  }

  public void setPretMaiMicCautare(Integer pretMaiMicCautare) {
    this.pretMaiMicCautare = pretMaiMicCautare;
  }

  public BirouDto getBirouCautareCustom() {
    return birouCautareCustom;
  }

  public void setBirouCautareCustom(BirouDto birouCautareCustom) {
    this.birouCautareCustom = birouCautareCustom;
  }

  public String getMesajDialog() {
    return mesajDialog;
  }

  public void setMesajDialog(String mesajDialog) {
    this.mesajDialog = mesajDialog;
  }

  public BirouDto getBirouPentruActualizare() {
    return birouPentruActualizare;
  }

  public void setBirouPentruActualizare(BirouDto birouPentruActualizare) {
    this.birouPentruActualizare = birouPentruActualizare;
  }

  public Integer getApartamentIdPentruActualizare() {
    return apartamentIdPentruActualizare;
  }

  public void setApartamentIdPentruActualizare(Integer apartamentIdPentruActualizare) {
    this.apartamentIdPentruActualizare = apartamentIdPentruActualizare;
  }
}
