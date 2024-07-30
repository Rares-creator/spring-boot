package com.example.managedbeans;

import com.example.dto.MouseDto;
import com.example.jsf.FacesViewScope;
import com.example.services.MouseService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("mouseManagedBean")
@Scope(FacesViewScope.NAME)
public class MouseManagedBean {

  @Autowired private MouseService mouseService;

  List<MouseDto> mouses;

  private MouseDto mouseToSave;

  private String denumireCautare;

  private Boolean cabluUsbCautare;

  private Integer numarButoaneCautare;

  private MouseDto mouseCautareCustom;

  private Integer mouseIdPentruStergere;

  private String mesajDialog;

  private MouseDto mousePentruActualizare;

  public void actualizeazaMouse() {
    mouseService.actualizareMouse(mousePentruActualizare);
    reloadMouseListAndRestoreToDefaults();
  }

  public void pregatesteActualizareMouse(MouseDto mouse) {
    mousePentruActualizare = mouse;
  }

  public void verificaMouse(MouseDto mouse) {
    mouseIdPentruStergere = mouse.getId();
  }

  public String stergeMouse() {
    mouseService.stergeMouse(mouseIdPentruStergere);
    reloadMouseListAndRestoreToDefaults();
    return "mouse.xhtml?faces-redirect=true";
  }

  public void cautaMouseuriCustom() {
    mouses = mouseService.cautaMousuri(mouseCautareCustom);
  }

  public void reset() {
    reloadMouseListAndRestoreToDefaults();
  }

  public void cautaMouseDupaDenumire() {
    mouses = mouseService.cautaMouseDupaDenumire(denumireCautare);
  }

  public void cautaMouseDupaCabluUsbSiNumarButoane() {
    mouses =
        mouseService.cautaMouseDupaCabluUsbSiNumarButoane(cabluUsbCautare, numarButoaneCautare);
  }

  public void reloadMouseListAndRestoreToDefaults() {
    mouses = mouseService.loadAllMouses();
    mouseToSave = new MouseDto();
    mouseToSave.setCabluUsb(true);
    mouseToSave.setLuminaAmbientala(false);
    denumireCautare = null;
    cabluUsbCautare = null;
    numarButoaneCautare = null;
    mouseCautareCustom = new MouseDto();
    mousePentruActualizare = new MouseDto();
  }

  public void adaugaMouse() {
    mouseService.adaugaMouse(mouseToSave);
    reloadMouseListAndRestoreToDefaults();
  }

  @PostConstruct
  public void init() {
    reloadMouseListAndRestoreToDefaults();
    mesajDialog = "Doriți să ștergeți acest mouse?";
  }

  public List<MouseDto> getMouses() {
    return mouses;
  }

  public void setMouses(List<MouseDto> mouses) {
    this.mouses = mouses;
  }

  public MouseDto getMouseToSave() {
    return mouseToSave;
  }

  public void setMouseToSave(MouseDto mouseToSave) {
    this.mouseToSave = mouseToSave;
  }

  public String getDenumireCautare() {
    return denumireCautare;
  }

  public void setDenumireCautare(String denumireCautare) {
    this.denumireCautare = denumireCautare;
  }

  public Boolean getCabluUsbCautare() {
    return cabluUsbCautare;
  }

  public void setCabluUsbCautare(Boolean cabluUsbCautare) {
    this.cabluUsbCautare = cabluUsbCautare;
  }

  public Integer getNumarButoaneCautare() {
    return numarButoaneCautare;
  }

  public void setNumarButoaneCautare(Integer numarButoaneCautare) {
    this.numarButoaneCautare = numarButoaneCautare;
  }

  public MouseDto getMouseCautareCustom() {
    return mouseCautareCustom;
  }

  public void setMouseCautareCustom(MouseDto mouseCautareCustom) {
    this.mouseCautareCustom = mouseCautareCustom;
  }

  public String getMesajDialog() {
    return mesajDialog;
  }

  public void setMesajDialog(String mesajDialog) {
    this.mesajDialog = mesajDialog;
  }

  public MouseDto getMousePentruActualizare() {
    return mousePentruActualizare;
  }

  public void setMousePentruActualizare(MouseDto mousePentruActualizare) {
    this.mousePentruActualizare = mousePentruActualizare;
  }
}
