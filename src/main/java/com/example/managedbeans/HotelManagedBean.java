package com.example.managedbeans;

import com.example.dto.HotelDto;
import com.example.jsf.FacesViewScope;
import com.example.services.HotelService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("hotelManagedBean")
@Scope(FacesViewScope.NAME)
public class HotelManagedBean {

  @Autowired private HotelService hotelService;

  List<HotelDto> hotels;

  private HotelDto hotelToSave;

  private String locatieCautare;

  private Boolean piscinaCautare;

  private Boolean restaurantCautare;

  private HotelDto hotelCautareCustom;

  private Integer hotelIdPentruStergere;

  private String mesajDialog;

  private HotelDto hotelPentruActualizare;

  public void actualizeazaHotel() {
    hotelService.actualizareHotel(hotelPentruActualizare);
    reloadHotelListAndRestoreToDefaults();
  }

  public void pregatesteActualizareHotel(HotelDto hotel) {
    hotelPentruActualizare = hotel;
  }

  public void verificaCamereSiSeteazaMesajDialog(HotelDto hotel) {
    hotelIdPentruStergere = hotel.getId();
    if (hotel != null && !hotel.getCamere().isEmpty()) {
      mesajDialog = "Hotelul are camere asociate. Doriți să ștergeți hotelul și camerele asociate?";
    } else {
      mesajDialog = "Doriți să ștergeți acest hotel?";
    }
  }

  public String stergeHotel() {
    hotelService.stergeHotel(hotelIdPentruStergere);
    reloadHotelListAndRestoreToDefaults();
    return "hotel.xhtml?faces-redirect=true";
  }

  public void cautareHoteluriCustom() {
    hotels = hotelService.cautaHoteluri(hotelCautareCustom);
  }

  public void reset() {
    reloadHotelListAndRestoreToDefaults();
  }

  public void cautaHotelDupaLocatie() {
    hotels = hotelService.cautaHotelDupaLocatie(locatieCautare);
  }

  public void cautaHotelDupaPiscinaSiRestaurant() {
    hotels = hotelService.cautaHotelDupaPiscinaSiRestaurant(piscinaCautare, restaurantCautare);
  }

  public void reloadHotelListAndRestoreToDefaults() {
    hotels = hotelService.loadAllHotels();
    hotelToSave = new HotelDto();
    hotelToSave.setRestaurant(true);
    hotelToSave.setPiscina(false);
    locatieCautare = null;
    piscinaCautare = null;
    restaurantCautare = null;
    hotelCautareCustom = new HotelDto();
    hotelPentruActualizare = new HotelDto();
  }

  public void adaugaHotel() {
    hotelService.adaugaHotel(hotelToSave);
    reloadHotelListAndRestoreToDefaults();
  }

  @PostConstruct
  public void init() {
    reloadHotelListAndRestoreToDefaults();
  }

  public List<HotelDto> getHotels() {
    return hotels;
  }

  public void setHotels(List<HotelDto> hotels) {
    this.hotels = hotels;
  }

  public HotelDto getHotelToSave() {
    return hotelToSave;
  }

  public void setHotelToSave(HotelDto hotelToSave) {
    this.hotelToSave = hotelToSave;
  }

  public String getLocatieCautare() {
    return locatieCautare;
  }

  public void setLocatieCautare(String locatieCautare) {
    this.locatieCautare = locatieCautare;
  }

  public Boolean getPiscinaCautare() {
    return piscinaCautare;
  }

  public void setPiscinaCautare(Boolean piscinaCautare) {
    this.piscinaCautare = piscinaCautare;
  }

  public Boolean getRestaurantCautare() {
    return restaurantCautare;
  }

  public void setRestaurantCautare(Boolean restaurantCautare) {
    this.restaurantCautare = restaurantCautare;
  }

  public HotelDto getHotelCautareCustom() {
    return hotelCautareCustom;
  }

  public void setHotelCautareCustom(HotelDto hotelCautareCustom) {
    this.hotelCautareCustom = hotelCautareCustom;
  }

  public String getMesajDialog() {
    return mesajDialog;
  }

  public void setMesajDialog(String mesajDialog) {
    this.mesajDialog = mesajDialog;
  }

  public HotelDto getHotelPentruActualizare() {
    return hotelPentruActualizare;
  }

  public void setHotelPentruActualizare(HotelDto hotelPentruActualizare) {
    this.hotelPentruActualizare = hotelPentruActualizare;
  }
}
