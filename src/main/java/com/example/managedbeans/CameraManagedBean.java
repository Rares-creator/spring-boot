package com.example.managedbeans;

import com.example.dto.CameraDto;
import com.example.dto.HotelDto;
import com.example.jsf.FacesViewScope;
import com.example.services.CameraService;
import com.example.services.HotelService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("cameraManagedBean")
@Scope(FacesViewScope.NAME)
public class CameraManagedBean implements Serializable {

  @Autowired private CameraService cameraService;

  @Autowired private HotelService hotelService;

  private Integer hotelId;

  private List<HotelDto> hoteluri;

  List<CameraDto> cameras;

  private CameraDto cameraToSave;

  private Boolean jacuzziCautare;
  private String hotelDenumireCautare;

  private String tipCameraCautare;

  private CameraDto cameraCautareCustom;

  private Integer cameraIdPentruStergere;

  private String mesajDialog;

  private CameraDto cameraPentruActualizare;

  private Integer hotelIdPentruActualizare;

  public void actualizeazaCamera() {
    HotelDto hotel = new HotelDto();
    hotel.setId(hotelIdPentruActualizare);
    cameraPentruActualizare.setHotel(hotel);
    cameraService.actualizareCamera(cameraPentruActualizare);
    reloadCameraListAndResetToDefaults();
  }

  public void pregatesteActualizareBirou(CameraDto camera) {
    cameraPentruActualizare = camera;
    hotelIdPentruActualizare = camera.getHotel().getId();
  }

  public void verificaCamere(CameraDto camera) {
    cameraIdPentruStergere = camera.getId();
  }

  public String stergeCamera() {
    cameraService.stergeCamera(cameraIdPentruStergere);
    reloadCameraListAndResetToDefaults();
    return "camera.xhtml?faces-redirect=true";
  }

  public void cautaCamere() {
    cameras = cameraService.cautaCamere(cameraCautareCustom);
  }

  public void cautaCameraDupaJacuzzi() {
    cameras = cameraService.cautaCameraDupaJacuzzi(jacuzziCautare);
  }

  public void cautaCameraDupaHotelSiTipulCamerei() {
    cameras =
        cameraService.cautaCameraDupaHotelSiTipulCamerei(hotelDenumireCautare, tipCameraCautare);
  }

  public void reset() {
    reloadCameraListAndResetToDefaults();
  }

  public void reloadCameraListAndResetToDefaults() {
    cameras = cameraService.loadAllCameras();
    cameraToSave = new CameraDto();
    cameraToSave.setJacuzzi(true);
    jacuzziCautare = null;
    hotelDenumireCautare = null;
    tipCameraCautare = null;
    cameraCautareCustom = new CameraDto();
    cameraPentruActualizare = new CameraDto();
    hotelIdPentruActualizare = null;
  }

  public void adaugaCamera() {
    HotelDto hotel = new HotelDto();
    hotel.setId(hotelId);
    cameraToSave.setHotel(hotel);
    cameraService.adaugaCamera(cameraToSave);
    reloadCameraListAndResetToDefaults();
  }

  @PostConstruct
  public void init() {
    hoteluri = hotelService.loadAllHotels();
    reloadCameraListAndResetToDefaults();
    mesajDialog = "Doriți să ștergeți aceasta camera?";
  }

  public List<CameraDto> getCameras() {
    return cameras;
  }

  public void setCameras(List<CameraDto> cameras) {
    this.cameras = cameras;
  }

  public CameraDto getCameraToSave() {
    return cameraToSave;
  }

  public void setCameraToSave(CameraDto cameraToSave) {
    this.cameraToSave = cameraToSave;
  }

  public Integer getHotelId() {
    return hotelId;
  }

  public void setHotelId(Integer hotelId) {
    this.hotelId = hotelId;
  }

  public List<HotelDto> getHoteluri() {
    return hoteluri;
  }

  public void setHoteluri(List<HotelDto> hoteluri) {
    this.hoteluri = hoteluri;
  }

  public Boolean getJacuzziCautare() {
    return jacuzziCautare;
  }

  public void setJacuzziCautare(Boolean jacuzziCautare) {
    this.jacuzziCautare = jacuzziCautare;
  }

  public String getHotelDenumireCautare() {
    return hotelDenumireCautare;
  }

  public void setHotelDenumireCautare(String hotelDenumireCautare) {
    this.hotelDenumireCautare = hotelDenumireCautare;
  }

  public String getTipCameraCautare() {
    return tipCameraCautare;
  }

  public void setTipCameraCautare(String tipCameraCautare) {
    this.tipCameraCautare = tipCameraCautare;
  }

  public CameraDto getCameraCautareCustom() {
    return cameraCautareCustom;
  }

  public void setCameraCautareCustom(CameraDto cameraCautareCustom) {
    this.cameraCautareCustom = cameraCautareCustom;
  }

  public String getMesajDialog() {
    return mesajDialog;
  }

  public void setMesajDialog(String mesajDialog) {
    this.mesajDialog = mesajDialog;
  }

  public CameraDto getCameraPentruActualizare() {
    return cameraPentruActualizare;
  }

  public void setCameraPentruActualizare(CameraDto cameraPentruActualizare) {
    this.cameraPentruActualizare = cameraPentruActualizare;
  }

  public Integer getHotelIdPentruActualizare() {
    return hotelIdPentruActualizare;
  }

  public void setHotelIdPentruActualizare(Integer hotelIdPentruActualizare) {
    this.hotelIdPentruActualizare = hotelIdPentruActualizare;
  }
}
