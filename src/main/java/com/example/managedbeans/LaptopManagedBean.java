package com.example.managedbeans;

import com.example.dto.LaptopDto;
import com.example.jsf.FacesViewScope;
import com.example.services.LaptopService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("laptopManagedBean")
@Scope(FacesViewScope.NAME)
public class LaptopManagedBean {

  @Autowired private LaptopService laptopService;

  List<LaptopDto> laptops;

  private LaptopDto laptopToSave;

  private String denumireCautare;

  private Integer memorieRamCautare;

  private Boolean fastUsbCautare;

  private LaptopDto laptopCautareCustom;

  private Integer laptopIdPentruStergere;

  private String mesajDialog;

  private LaptopDto laptopPentruActualizare;

  public void actualizeazaLaptop() {
    laptopService.actualizareLaptop(laptopPentruActualizare);
    reloadLaptopListAndRestoreToDefaults();
  }

  public void pregatesteActualizareLaptop(LaptopDto laptop) {
    laptopPentruActualizare = laptop;
  }

  public void verificaLaptop(LaptopDto laptop) {
    laptopIdPentruStergere = laptop.getId();
  }

  public String stergeLaptop() {
    laptopService.stergeLaptop(laptopIdPentruStergere);
    reloadLaptopListAndRestoreToDefaults();
    return "laptop.xhtml?faces-redirect=true";
  }

  public void cautaLaptopuri() {
    laptops = laptopService.cautaLaptopuri(laptopCautareCustom);
  }

  public void reset() {
    reloadLaptopListAndRestoreToDefaults();
  }

  public void cautaLaptopDupaDenumire() {
    laptops = laptopService.cautaLaptopDupaDenumire(denumireCautare);
  }

  public void cautaLaptopDupaMemorieRamSiFastUsb() {
    laptops = laptopService.cautaLaptopDupaMemorieRamSiFastUsb(memorieRamCautare, fastUsbCautare);
  }

  public void reloadLaptopListAndRestoreToDefaults() {
    laptops = laptopService.loadAllLaptops();
    laptopToSave = new LaptopDto();
    laptopToSave.setFastUsb(true);
    denumireCautare = null;
    memorieRamCautare = null;
    fastUsbCautare = null;
    laptopCautareCustom = new LaptopDto();
    laptopPentruActualizare = new LaptopDto();
  }

  public void adaugaLaptop() {
    laptopService.adaugaLaptop(laptopToSave);
    reloadLaptopListAndRestoreToDefaults();
  }

  @PostConstruct
  public void init() {
    reloadLaptopListAndRestoreToDefaults();
    mesajDialog = "Doriți să ștergeți acest laptop?";
  }

  public List<LaptopDto> getLaptops() {
    return laptops;
  }

  public void setLaptops(List<LaptopDto> laptops) {
    this.laptops = laptops;
  }

  public LaptopDto getLaptopToSave() {
    return laptopToSave;
  }

  public void setLaptopToSave(LaptopDto laptopToSave) {
    this.laptopToSave = laptopToSave;
  }

  public String getDenumireCautare() {
    return denumireCautare;
  }

  public void setDenumireCautare(String denumireCautare) {
    this.denumireCautare = denumireCautare;
  }

  public Integer getMemorieRamCautare() {
    return memorieRamCautare;
  }

  public void setMemorieRamCautare(Integer memorieRamCautare) {
    this.memorieRamCautare = memorieRamCautare;
  }

  public Boolean getFastUsbCautare() {
    return fastUsbCautare;
  }

  public void setFastUsbCautare(Boolean fastUsbCautare) {
    this.fastUsbCautare = fastUsbCautare;
  }

  public LaptopDto getLaptopCautareCustom() {
    return laptopCautareCustom;
  }

  public void setLaptopCautareCustom(LaptopDto laptopCautareCustom) {
    this.laptopCautareCustom = laptopCautareCustom;
  }

  public String getMesajDialog() {
    return mesajDialog;
  }

  public void setMesajDialog(String mesajDialog) {
    this.mesajDialog = mesajDialog;
  }

  public LaptopDto getLaptopPentruActualizare() {
    return laptopPentruActualizare;
  }

  public void setLaptopPentruActualizare(LaptopDto laptopPentruActualizare) {
    this.laptopPentruActualizare = laptopPentruActualizare;
  }
}
