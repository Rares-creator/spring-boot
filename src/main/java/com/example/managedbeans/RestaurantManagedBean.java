package com.example.managedbeans;

import com.example.dto.RestaurantDto;
import com.example.jsf.FacesViewScope;
import com.example.services.RestaurantService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("restaurantManagedBean")
@Scope(FacesViewScope.NAME)
public class RestaurantManagedBean {

  @Autowired private RestaurantService restaurantService;

  private RestaurantDto restaurantToSave;

  List<RestaurantDto> restaurants;

  private String locatieCautare;
  private RestaurantDto restaurantCautareCustom;

  private Integer restaurantIdPentruStergere;

  private String mesajDialog;

  private RestaurantDto restaurantPentruActualizare;

  public void actualizeazaRestaurant() {
    restaurantService.actualizareRestaurant(restaurantPentruActualizare);
    reloadRestaurantListAndRestoreToDefaults();
  }

  public void pregatesteActualizareRestaurant(RestaurantDto restaurant) {
    restaurantPentruActualizare = restaurant;
  }

  public void verificaMeseSiSeteazaMesajDialog(RestaurantDto restaurant) {
    restaurantIdPentruStergere = restaurant.getId();
    if (restaurant != null && !restaurant.getMese().isEmpty()) {
      mesajDialog =
          "Restaurantul are mese asociate. Doriți să ștergeți restaurantul și mesele asociate?";
    } else {
      mesajDialog = "Doriți să ștergeți aceast restaurant?";
    }
  }

  public String stergeRestaurant() {
    restaurantService.stergeRestaurant(restaurantIdPentruStergere);
    reloadRestaurantListAndRestoreToDefaults();
    return "restaurant.xhtml?faces-redirect=true";
  }

  public void cautaRestaurantCustom() {
    restaurants = restaurantService.cautaRestaurante(restaurantCautareCustom);
  }

  public void cautaRestaurantDupaLocatie() {
    restaurants = restaurantService.cautaRestaurantDupaLocatie(locatieCautare);
  }

  public void reset() {
    reloadRestaurantListAndRestoreToDefaults();
  }

  public void reloadRestaurantListAndRestoreToDefaults() {
    restaurants = restaurantService.loadAllRestaurants();
    restaurantToSave = new RestaurantDto();
    locatieCautare = null;
    restaurantCautareCustom = new RestaurantDto();
    restaurantPentruActualizare = new RestaurantDto();
  }

  public void adaugaRestaurant() {
    restaurantService.adaugaRestaurant(restaurantToSave);
    reloadRestaurantListAndRestoreToDefaults();
  }

  @PostConstruct
  public void init() {
    reloadRestaurantListAndRestoreToDefaults();
  }

  public List<RestaurantDto> getRestaurants() {
    return restaurants;
  }

  public void setRestaurants(List<RestaurantDto> restaurants) {
    this.restaurants = restaurants;
  }

  public RestaurantDto getRestaurantToSave() {
    return restaurantToSave;
  }

  public void setRestaurantToSave(RestaurantDto restaurantToSave) {
    this.restaurantToSave = restaurantToSave;
  }

  public String getLocatieCautare() {
    return locatieCautare;
  }

  public void setLocatieCautare(String locatieCautare) {
    this.locatieCautare = locatieCautare;
  }

  public RestaurantDto getRestaurantCautareCustom() {
    return restaurantCautareCustom;
  }

  public void setRestaurantCautareCustom(RestaurantDto restaurantCautareCustom) {
    this.restaurantCautareCustom = restaurantCautareCustom;
  }

  public String getMesajDialog() {
    return mesajDialog;
  }

  public void setMesajDialog(String mesajDialog) {
    this.mesajDialog = mesajDialog;
  }

  public RestaurantDto getRestaurantPentruActualizare() {
    return restaurantPentruActualizare;
  }

  public void setRestaurantPentruActualizare(RestaurantDto restaurantPentruActualizare) {
    this.restaurantPentruActualizare = restaurantPentruActualizare;
  }
}
