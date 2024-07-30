package com.example.managedbeans;

import com.example.dto.TricouDto;
import com.example.entities.Marime;
import com.example.entities.Sex;
import com.example.jsf.FacesViewScope;
import com.example.services.TricouService;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("tricouManagedBean")
@Scope(FacesViewScope.NAME)
public class TricouManagedBean {
  @Autowired private TricouService tricouService;

  List<TricouDto> tricous;

  private TricouDto tricouToSave;

  public List<Sex> loadListOfSexes() {
    return Arrays.asList(Sex.values());
  }

  public List<Marime> loadListOfMarimi() {
    return Arrays.asList(Marime.values());
  }

  private Integer pretMaiMareCautare;

  private String materialCautare;

  private String culoareCautare;

  private TricouDto tricouCautareCustom;

  private Integer tricouIdPentruStergere;

  private String mesajDialog;

  private TricouDto tricouPentruActualizare;

  public void actualizeazaTricou() {
    tricouService.actualizareTricou(tricouPentruActualizare);
    reloadTricouListAndRestoreToDefaults();
  }

  public void pregatesteActualizareTricou(TricouDto tricou) {
    tricouPentruActualizare = tricou;
  }

  public void verificaTricou(TricouDto tricou) {
    tricouIdPentruStergere = tricou.getId();
  }

  public String stergeTricou() {
    tricouService.stergeTricou(tricouIdPentruStergere);
    reloadTricouListAndRestoreToDefaults();
    return "tricou.xhtml?faces-redirect=true";
  }

  public void cautaTricouriCustom() {
    tricous = tricouService.cautaTricouri(tricouCautareCustom);
  }

  public void reset() {
    reloadTricouListAndRestoreToDefaults();
  }

  public void cautaTricouDupaPretMaiMare() {
    tricous = tricouService.cautaTricouDupaPretMaiMare(pretMaiMareCautare);
  }

  public void cautaTricouDupaMaterialSiCuloare() {
    tricous = tricouService.cautaTricouDupaMaterialSiCuloare(materialCautare, culoareCautare);
  }

  public void reloadTricouListAndRestoreToDefaults() {
    tricous = tricouService.loadAllTricous();
    tricouToSave = new TricouDto();
    pretMaiMareCautare = null;
    materialCautare = null;
    culoareCautare = null;
    tricouCautareCustom = new TricouDto();
    tricouPentruActualizare = new TricouDto();
  }

  public void adaugaTricou() {
    tricouService.adaugaTricou(tricouToSave);
    reloadTricouListAndRestoreToDefaults();
  }

  @PostConstruct
  public void init() {
    reloadTricouListAndRestoreToDefaults();
    mesajDialog = "Doriți să ștergeți acest tricou?";
  }

  public List<TricouDto> getTricous() {
    return tricous;
  }

  public void setTricous(List<TricouDto> tricous) {
    this.tricous = tricous;
  }

  public TricouDto getTricouToSave() {
    return tricouToSave;
  }

  public void setTricouToSave(TricouDto tricouToSave) {
    this.tricouToSave = tricouToSave;
  }

  public Integer getPretMaiMareCautare() {
    return pretMaiMareCautare;
  }

  public void setPretMaiMareCautare(Integer pretMaiMareCautare) {
    this.pretMaiMareCautare = pretMaiMareCautare;
  }

  public String getMaterialCautare() {
    return materialCautare;
  }

  public void setMaterialCautare(String materialCautare) {
    this.materialCautare = materialCautare;
  }

  public String getCuloareCautare() {
    return culoareCautare;
  }

  public void setCuloareCautare(String culoareCautare) {
    this.culoareCautare = culoareCautare;
  }

  public TricouDto getTricouCautareCustom() {
    return tricouCautareCustom;
  }

  public void setTricouCautareCustom(TricouDto tricouCautareCustom) {
    this.tricouCautareCustom = tricouCautareCustom;
  }

  public String getMesajDialog() {
    return mesajDialog;
  }

  public void setMesajDialog(String mesajDialog) {
    this.mesajDialog = mesajDialog;
  }

  public TricouDto getTricouPentruActualizare() {
    return tricouPentruActualizare;
  }

  public void setTricouPentruActualizare(TricouDto tricouPentruActualizare) {
    this.tricouPentruActualizare = tricouPentruActualizare;
  }
}
