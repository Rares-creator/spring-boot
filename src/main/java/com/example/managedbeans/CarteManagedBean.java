package com.example.managedbeans;

import com.example.dto.BibliotecaDto;
import com.example.dto.CarteDto;
import com.example.jsf.FacesViewScope;
import com.example.services.BibliotecaService;
import com.example.services.CarteService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("carteManagedBean")
@Scope(FacesViewScope.NAME)
public class CarteManagedBean {

  @Autowired private CarteService carteService;
  @Autowired private BibliotecaService bibliotecaService;

  private Integer bibliotecaId;
  private List<BibliotecaDto> biblioteci;

  List<CarteDto> cartes;

  private CarteDto carteToSave;

  private String numeCautare;

  private String autorCautare;

  private String genCautare;

  private CarteDto carteCautareCustom;

  private Integer carteIdPentruStergere;

  private String mesajDialog;

  private CarteDto cartePentruActualizare;

  private Integer bibliotecaIdPentruActualizare;

  public void actualizeazaCarte() {
    BibliotecaDto biblioteca = new BibliotecaDto();
    biblioteca.setId(bibliotecaIdPentruActualizare);
    cartePentruActualizare.setBiblioteca(biblioteca);
    carteService.actualizareCarte(cartePentruActualizare);
    reloadCarteListAndResetToDefaults();
  }

  public void pregatesteActualizareCarte(CarteDto carte) {
    cartePentruActualizare = carte;
    bibliotecaIdPentruActualizare = carte.getBiblioteca().getId();
  }

  public void verificaCarte(CarteDto carte) {
    carteIdPentruStergere = carte.getId();
  }

  public String stergeCarte() {
    carteService.stergeCarte(carteIdPentruStergere);
    reloadCarteListAndResetToDefaults();
    return "carte.xhtml?faces-redirect=true";
  }

  public void cautaCarti() {
    cartes = carteService.cautaCarti(carteCautareCustom);
  }

  public void reset() {
    reloadCarteListAndResetToDefaults();
  }

  public void cautaCarteDupaNume() {
    cartes = carteService.cautaCarteDupaNume(numeCautare);
  }

  public void cautaCarteDupaAutorSiGen() {
    cartes = carteService.cautaCarteDupaAutorSiGen(autorCautare, genCautare);
  }

  public void reloadCarteListAndResetToDefaults() {
    cartes = carteService.loadAllCartes();
    carteToSave = new CarteDto();
    carteCautareCustom = new CarteDto();
    numeCautare = null;
    autorCautare = null;
    genCautare = null;
    bibliotecaIdPentruActualizare = null;
    cartePentruActualizare = new CarteDto();
  }

  public void adaugaCarte() {
    BibliotecaDto biblioteca = new BibliotecaDto();
    biblioteca.setId(bibliotecaId);
    carteToSave.setBiblioteca(biblioteca);
    carteService.adaugaCarte(carteToSave);
    reloadCarteListAndResetToDefaults();
  }

  @PostConstruct
  public void init() {
    biblioteci = bibliotecaService.loadallBibliotecas();
    reloadCarteListAndResetToDefaults();
    mesajDialog = "Doriți să ștergeți aceasta carte?";
  }

  public List<CarteDto> getCartes() {
    return cartes;
  }

  public void setCartes(List<CarteDto> cartes) {
    this.cartes = cartes;
  }

  public CarteDto getCarteToSave() {
    return carteToSave;
  }

  public void setCarteToSave(CarteDto carteToSave) {
    this.carteToSave = carteToSave;
  }

  public Integer getBibliotecaId() {
    return bibliotecaId;
  }

  public void setBibliotecaId(Integer bibliotecaId) {
    this.bibliotecaId = bibliotecaId;
  }

  public List<BibliotecaDto> getBiblioteci() {
    return biblioteci;
  }

  public void setBiblioteci(List<BibliotecaDto> biblioteci) {
    this.biblioteci = biblioteci;
  }

  public String getNumeCautare() {
    return numeCautare;
  }

  public void setNumeCautare(String numeCautare) {
    this.numeCautare = numeCautare;
  }

  public String getAutorCautare() {
    return autorCautare;
  }

  public void setAutorCautare(String autorCautare) {
    this.autorCautare = autorCautare;
  }

  public String getGenCautare() {
    return genCautare;
  }

  public void setGenCautare(String genCautare) {
    this.genCautare = genCautare;
  }

  public CarteDto getCarteCautareCustom() {
    return carteCautareCustom;
  }

  public void setCarteCautareCustom(CarteDto carteCautareCustom) {
    this.carteCautareCustom = carteCautareCustom;
  }

  public String getMesajDialog() {
    return mesajDialog;
  }

  public void setMesajDialog(String mesajDialog) {
    this.mesajDialog = mesajDialog;
  }

  public CarteDto getCartePentruActualizare() {
    return cartePentruActualizare;
  }

  public void setCartePentruActualizare(CarteDto cartePentruActualizare) {
    this.cartePentruActualizare = cartePentruActualizare;
  }

  public Integer getBibliotecaIdPentruActualizare() {
    return bibliotecaIdPentruActualizare;
  }

  public void setBibliotecaIdPentruActualizare(Integer bibliotecaIdPentruActualizare) {
    this.bibliotecaIdPentruActualizare = bibliotecaIdPentruActualizare;
  }
}
