package com.example.managedbeans;

import com.example.dto.PantofDto;
import com.example.entities.Sex;
import com.example.jsf.FacesViewScope;
import com.example.services.PantofService;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("pantofManagedBean")
@Scope(FacesViewScope.NAME)
public class PantofManagedBean {

  @Autowired private PantofService pantofService;

  List<PantofDto> pantofs;

  private PantofDto pantofToSave;

  private String tipPantofCautare;

  private Sex sexCautare;

  private Integer numarCautare;
  private PantofDto pantofCautareCustom;

  private Integer pantofIdPentruStergere;

  private String mesajDialog;

  private PantofDto pantofPentruActualizare;

  public void actualizeazaPantof() {
    pantofService.actualizarePantof(pantofPentruActualizare);
    reloadPantofListAndRestoreToDefaults();
  }

  public void pregatesteActualizarePantof(PantofDto pantof) {
    pantofPentruActualizare = pantof;
  }

  public void verificaPantof(PantofDto pantof) {
    pantofIdPentruStergere = pantof.getId();
  }

  public String stergePantof() {
    pantofService.stergePantof(pantofIdPentruStergere);
    reloadPantofListAndRestoreToDefaults();
    return "pantof.xhtml?faces-redirect=true";
  }

  public void reset() {
    reloadPantofListAndRestoreToDefaults();
  }

  public void cautaPantofiCustom() {
    pantofs = pantofService.cautaPantofi(pantofCautareCustom);
  }

  public void cautaPantofDupaTipPantof() {
    pantofs = pantofService.cautaPantofDupaTipPantof(tipPantofCautare);
  }

  public void cautaPantofDupaSexSiNumar() {
    pantofs = pantofService.cautaPantofDupaSexSiNumar(sexCautare, numarCautare);
  }

  public void reloadPantofListAndRestoreToDefaults() {
    pantofs = pantofService.loadAllPantofs();
    pantofToSave = new PantofDto();
    tipPantofCautare = null;
    sexCautare = null;
    numarCautare = null;
    pantofCautareCustom = new PantofDto();
    pantofPentruActualizare = new PantofDto();
  }

  public void adaugaPantof() {
    pantofService.adaugaPantof(pantofToSave);
    reloadPantofListAndRestoreToDefaults();
  }

  public List<Sex> loadListOfSexes() {
    return Arrays.asList(Sex.values());
  }

  @PostConstruct
  public void init() {
    reloadPantofListAndRestoreToDefaults();
    mesajDialog = "Doriți să ștergeți acest pantof?";
  }

  public List<PantofDto> getPantofs() {
    return pantofs;
  }

  public void setPantofs(List<PantofDto> pantofs) {
    this.pantofs = pantofs;
  }

  public PantofDto getPantofToSave() {
    return pantofToSave;
  }

  public void setPantofToSave(PantofDto pantofToSave) {
    this.pantofToSave = pantofToSave;
  }

  public String getTipPantofCautare() {
    return tipPantofCautare;
  }

  public void setTipPantofCautare(String tipPantofCautare) {
    this.tipPantofCautare = tipPantofCautare;
  }

  public Sex getSexCautare() {
    return sexCautare;
  }

  public void setSexCautare(Sex sexCautare) {
    this.sexCautare = sexCautare;
  }

  public Integer getNumarCautare() {
    return numarCautare;
  }

  public void setNumarCautare(Integer numarCautare) {
    this.numarCautare = numarCautare;
  }

  public PantofDto getPantofCautareCustom() {
    return pantofCautareCustom;
  }

  public void setPantofCautareCustom(PantofDto pantofCautareCustom) {
    this.pantofCautareCustom = pantofCautareCustom;
  }

  public String getMesajDialog() {
    return mesajDialog;
  }

  public void setMesajDialog(String mesajDialog) {
    this.mesajDialog = mesajDialog;
  }

  public PantofDto getPantofPentruActualizare() {
    return pantofPentruActualizare;
  }

  public void setPantofPentruActualizare(PantofDto pantofPentruActualizare) {
    this.pantofPentruActualizare = pantofPentruActualizare;
  }
}
