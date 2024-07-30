package com.example.managedbeans;

import com.example.dto.SurubDto;
import com.example.jsf.FacesViewScope;
import com.example.services.SurubService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("surubManagedBean")
@Scope(FacesViewScope.NAME)
public class SurubManagedBean {

  @Autowired private SurubService surubService;

  List<SurubDto> surubs;

  private SurubDto surubToSave;

  private String zonaFolosireCautare;

  private String tipSurubCautare;

  private String materialCautare;

  private SurubDto surubCautareCustom;

  private Integer surubIdPentruStergere;

  private String mesajDialog;

  private SurubDto surubPentruActualizare;

  public void actualizeazaSurub() {
    surubService.actualizareSurub(surubPentruActualizare);
    reloadSurubListAndRestoreToDefaults();
  }

  public void pregatesteActualizareSurub(SurubDto surub) {
    surubPentruActualizare = surub;
  }

  public void verificaSurub(SurubDto surub) {
    surubIdPentruStergere = surub.getId();
  }

  public String stergeSurub() {
    surubService.stergeSurub(surubIdPentruStergere);
    reloadSurubListAndRestoreToDefaults();
    return "surub.xhtml?faces-redirect=true";
  }

  public void cautaSuruburiCustom() {
    surubs = surubService.cautaSuruburi(surubCautareCustom);
  }

  public void reset() {
    reloadSurubListAndRestoreToDefaults();
  }

  public void cautaSurubDupaZonaFolosire() {
    surubs = surubService.cautaSurubDupaZonaFolosire(zonaFolosireCautare);
  }

  public void cautaSurubDupaTipSurubSiMaterial() {
    surubs = surubService.cautaSurubDupaTipSurubSiMaterial(tipSurubCautare, materialCautare);
  }

  public void reloadSurubListAndRestoreToDefaults() {
    surubs = surubService.loadAllSurubs();
    surubToSave = new SurubDto();
    zonaFolosireCautare = null;
    tipSurubCautare = null;
    materialCautare = null;
    surubCautareCustom = new SurubDto();
    surubPentruActualizare = new SurubDto();
  }

  public void adaugaSurub() {
    surubService.adaugaSurub(surubToSave);
    reloadSurubListAndRestoreToDefaults();
  }

  @PostConstruct
  public void init() {
    reloadSurubListAndRestoreToDefaults();
    mesajDialog = "Doriți să ștergeți acest surub?";
  }

  public List<SurubDto> getSurubs() {
    return surubs;
  }

  public void setSurubs(List<SurubDto> surubs) {
    this.surubs = surubs;
  }

  public SurubDto getSurubToSave() {
    return surubToSave;
  }

  public void setSurubToSave(SurubDto surubToSave) {
    this.surubToSave = surubToSave;
  }

  public String getZonaFolosireCautare() {
    return zonaFolosireCautare;
  }

  public void setZonaFolosireCautare(String zonaFolosireCautare) {
    this.zonaFolosireCautare = zonaFolosireCautare;
  }

  public String getTipSurubCautare() {
    return tipSurubCautare;
  }

  public void setTipSurubCautare(String tipSurubCautare) {
    this.tipSurubCautare = tipSurubCautare;
  }

  public String getMaterialCautare() {
    return materialCautare;
  }

  public void setMaterialCautare(String materialCautare) {
    this.materialCautare = materialCautare;
  }

  public SurubDto getSurubCautareCustom() {
    return surubCautareCustom;
  }

  public void setSurubCautareCustom(SurubDto surubCautareCustom) {
    this.surubCautareCustom = surubCautareCustom;
  }

  public String getMesajDialog() {
    return mesajDialog;
  }

  public void setMesajDialog(String mesajDialog) {
    this.mesajDialog = mesajDialog;
  }

  public SurubDto getSurubPentruActualizare() {
    return surubPentruActualizare;
  }

  public void setSurubPentruActualizare(SurubDto surubPentruActualizare) {
    this.surubPentruActualizare = surubPentruActualizare;
  }
}
