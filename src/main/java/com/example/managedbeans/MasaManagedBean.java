package com.example.managedbeans;

import com.example.dto.MasaDto;
import com.example.dto.RestaurantDto;
import com.example.jsf.FacesViewScope;
import com.example.services.MasaService;
import com.example.services.RestaurantService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("masaManagedBean")
@Scope(FacesViewScope.NAME)
public class MasaManagedBean implements Serializable {

  @Autowired private MasaService masaService;
  @Autowired private RestaurantService restaurantService;

  private Integer restaurantId;

  private List<RestaurantDto> restaurante;

  List<MasaDto> masas;

  private MasaDto masaToSave;

  private Integer capacitateMasaCautare;

  private String denumireRestaurantCautare;
  private MasaDto masaCautareCustom;

  private Integer numarMasaCautare;

  private Integer masaIdPentruStergere;

  private String mesajDialog;

  private MasaDto masaPentruActualizare;

  private Integer restaurantIdPentruActualizare;

  public void actualizeazaMasa() {
    RestaurantDto restaurant = new RestaurantDto();
    restaurant.setId(restaurantIdPentruActualizare);
    masaPentruActualizare.setRestaurant(restaurant);
    masaService.actualizareMasa(masaPentruActualizare);
    reloadMasaListAndRestoreToDefaults();
  }

  public void pregatesteActualizareMasa(MasaDto masa) {
    masaPentruActualizare = masa;
    restaurantIdPentruActualizare = masa.getRestaurant().getId();
  }

  public void verificaMasa(MasaDto masa) {
    masaIdPentruStergere = masa.getId();
  }

  public String stergeMasa() {
    masaService.stergeMasa(masaIdPentruStergere);
    reloadMasaListAndRestoreToDefaults();
    return "masa.xhtml?faces-redirect=true";
  }

  public void cautaMese() {
    masas = masaService.cautaMese(masaCautareCustom);
  }

  public void reset() {
    reloadMasaListAndRestoreToDefaults();
  }

  public void cautaMasaDupaCapacitate() {
    masas = masaService.cautaMasaDupaCapacitate(capacitateMasaCautare);
  }

  public void cautaMasaDupaDenumireRestaurantSiNumarMasa() {
    masas =
        masaService.cautaMasaDupaDenumireRestaurantSiNumarMasa(
            denumireRestaurantCautare, numarMasaCautare);
  }

  public void reloadMasaListAndRestoreToDefaults() {
    masas = masaService.loadAllMasas();
    masaToSave = new MasaDto();
    masaToSave.setRezervata(false);
    capacitateMasaCautare = null;
    denumireRestaurantCautare = null;
    numarMasaCautare = null;
    masaCautareCustom = new MasaDto();
    masaPentruActualizare = new MasaDto();
    restaurantIdPentruActualizare = null;
  }

  public void adaugaMasa() {
    RestaurantDto restaurant = new RestaurantDto();
    restaurant.setId(restaurantId);
    masaToSave.setRestaurant(restaurant);
    masaService.adaugaMasa(masaToSave);
    reloadMasaListAndRestoreToDefaults();
  }

  @PostConstruct
  public void init() {
    restaurante = restaurantService.loadAllRestaurants();
    reloadMasaListAndRestoreToDefaults();
    mesajDialog = "Doriți să ștergeți aceasta masa?";
  }

  public List<MasaDto> getMasas() {
    return masas;
  }

  public void setMasas(List<MasaDto> masas) {
    this.masas = masas;
  }

  public MasaDto getMasaToSave() {
    return masaToSave;
  }

  public void setMasaToSave(MasaDto masaToSave) {
    this.masaToSave = masaToSave;
  }

  public Integer getRestaurantId() {
    return restaurantId;
  }

  public void setRestaurantId(Integer restaurantId) {
    this.restaurantId = restaurantId;
  }

  public List<RestaurantDto> getRestaurante() {
    return restaurante;
  }

  public void setRestaurante(List<RestaurantDto> restaurante) {
    this.restaurante = restaurante;
  }

  public Integer getCapacitateMasaCautare() {
    return capacitateMasaCautare;
  }

  public void setCapacitateMasaCautare(Integer capacitateMasaCautare) {
    this.capacitateMasaCautare = capacitateMasaCautare;
  }

  public String getDenumireRestaurantCautare() {
    return denumireRestaurantCautare;
  }

  public void setDenumireRestaurantCautare(String denumireRestaurantCautare) {
    this.denumireRestaurantCautare = denumireRestaurantCautare;
  }

  public Integer getNumarMasaCautare() {
    return numarMasaCautare;
  }

  public void setNumarMasaCautare(Integer numarMasaCautare) {
    this.numarMasaCautare = numarMasaCautare;
  }

  public MasaDto getMasaCautareCustom() {
    return masaCautareCustom;
  }

  public void setMasaCautareCustom(MasaDto masaCautareCustom) {
    this.masaCautareCustom = masaCautareCustom;
  }

  public String getMesajDialog() {
    return mesajDialog;
  }

  public void setMesajDialog(String mesajDialog) {
    this.mesajDialog = mesajDialog;
  }

  public MasaDto getMasaPentruActualizare() {
    return masaPentruActualizare;
  }

  public void setMasaPentruActualizare(MasaDto masaPentruActualizare) {
    this.masaPentruActualizare = masaPentruActualizare;
  }

  public Integer getRestaurantIdPentruActualizare() {
    return restaurantIdPentruActualizare;
  }

  public void setRestaurantIdPentruActualizare(Integer restaurantIdPentruActualizare) {
    this.restaurantIdPentruActualizare = restaurantIdPentruActualizare;
  }
}
