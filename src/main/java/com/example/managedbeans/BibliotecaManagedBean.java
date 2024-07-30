package com.example.managedbeans;

import com.example.dto.BibliotecaDto;
import com.example.jsf.FacesViewScope;
import com.example.services.BibliotecaService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("bibliotecaManagedBean")
@Scope(FacesViewScope.NAME)
public class BibliotecaManagedBean {

  @Autowired private BibliotecaService bibliotecaService;

  private List<BibliotecaDto> bibliotecas;

  private BibliotecaDto bibliotecaToSave;

  private String locatieCautare;

  private BibliotecaDto bibliotecaCautareCustom;

  private Integer bibliotecaIdPentruStergere;

  private String mesajDialog;

  private BibliotecaDto bibliotecaPentruActualizare;

  public void actualizeazaBiblioteca() {
    bibliotecaService.actualizareBiblioteca(bibliotecaPentruActualizare);
    reloadBibliotecaListAndResetToDefaults();
  }

  public void pregatesteActualizareBiblioteca(BibliotecaDto biblioteca) {
    bibliotecaPentruActualizare = biblioteca;
  }

  public void verificaBibliotecaiSiSeteazaMesajDialog(BibliotecaDto biblioteca) {
    bibliotecaIdPentruStergere = biblioteca.getId();
    if (biblioteca != null && !biblioteca.getCarti().isEmpty()) {
      mesajDialog =
          "Biblioteca are carti asociate. Doriți să ștergeți biblioteca si cartile asociate?";
    } else {
      mesajDialog = "Doriți să ștergeți aceasta biblioteca?";
    }
  }

  public String stergeBiblioteca() {
    bibliotecaService.stergeBiblioteca(bibliotecaIdPentruStergere);
    reloadBibliotecaListAndResetToDefaults();
    return "biblioteca.xhtml?faces-redirect=true";
  }

  public void cautaBibliotecaCustom() {
    bibliotecas = bibliotecaService.cautaBiblioteci(bibliotecaCautareCustom);
  }

  public void cautaBibliotecaDupaLocatie() {
    bibliotecas = bibliotecaService.cautaBibliotecaDupaLocatie(locatieCautare);
  }

  public void reset() {
    reloadBibliotecaListAndResetToDefaults();
  }

  private void reloadBibliotecaListAndResetToDefaults() {
    bibliotecas = bibliotecaService.loadallBibliotecas();
    bibliotecaToSave = new BibliotecaDto();
    bibliotecaToSave.setDeschisWeekend(false);
    bibliotecaCautareCustom = new BibliotecaDto();
    locatieCautare = null;
    bibliotecaPentruActualizare = new BibliotecaDto();
  }

  public void adaugaBiblioteca() {
    bibliotecaService.adaugaBiblioteca(bibliotecaToSave);
    reloadBibliotecaListAndResetToDefaults();
  }

  @PostConstruct
  public void init() {
    reloadBibliotecaListAndResetToDefaults();
    System.out.println("Am apelat metoda de intializare.");
  }

  public List<BibliotecaDto> getBibliotecas() {
    return bibliotecas;
  }

  public void setBibliotecas(List<BibliotecaDto> bibliotecas) {
    this.bibliotecas = bibliotecas;
  }

  public BibliotecaDto getBibliotecaToSave() {
    return bibliotecaToSave;
  }

  public void setBibliotecaToSave(BibliotecaDto bibliotecaToSave) {
    this.bibliotecaToSave = bibliotecaToSave;
  }

  public String getLocatieCautare() {
    return locatieCautare;
  }

  public void setLocatieCautare(String locatieCautare) {
    this.locatieCautare = locatieCautare;
  }

  public BibliotecaDto getBibliotecaCautareCustom() {
    return bibliotecaCautareCustom;
  }

  public void setBibliotecaCautareCustom(BibliotecaDto bibliotecaCautareCustom) {
    this.bibliotecaCautareCustom = bibliotecaCautareCustom;
  }

  public String getMesajDialog() {
    return mesajDialog;
  }

  public void setMesajDialog(String mesajDialog) {
    this.mesajDialog = mesajDialog;
  }

  public BibliotecaDto getBibliotecaPentruActualizare() {
    return bibliotecaPentruActualizare;
  }

  public void setBibliotecaPentruActualizare(BibliotecaDto bibliotecaPentruActualizare) {
    this.bibliotecaPentruActualizare = bibliotecaPentruActualizare;
  }
}
