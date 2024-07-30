package com.example.managedbeans;

import com.example.dto.AnimalDto;
import com.example.dto.PersonDto;
import com.example.entities.Sex;
import com.example.jsf.FacesViewScope;
import com.example.services.AnimalService;
import com.example.services.PersonService;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("animalManagedBean")
@Scope(FacesViewScope.NAME)
public class AnimalManagedBean implements Serializable {

  @Autowired private AnimalService animalService;

  @Autowired private PersonService personService;

  private List<AnimalDto> animals;

  private AnimalDto animalToSave;

  private Integer stapanId;

  private List<PersonDto> persoane;

  private String rasaCautare;

  private Boolean pedigreeCautare;

  private Integer varstaMaiMicaDeCautare;

  private AnimalDto animalCautareCustom;

  private String mesajDialog;

  private Integer animalIdPentruStergere;

  private AnimalDto animalPentruActualizare;

  private Integer personIdPentruActualizare;

  public void actualizeazaAnimal() {
    PersonDto person = new PersonDto();
    person.setId(personIdPentruActualizare);
    animalPentruActualizare.setPerson(person);
    animalService.actualizareAnimal(animalPentruActualizare);
    reloadAnimalListAndResetToDefaults();
  }

  public void pregatesteActualizareAnimal(AnimalDto animal) {
    animalPentruActualizare = animal;
    personIdPentruActualizare = animal.getPerson().getId();
  }

  public void verificaAnimale(AnimalDto animal) {
    animalIdPentruStergere = animal.getId();
  }

  public String stergeAnimal() {
    animalService.stergeAnimal(animalIdPentruStergere);
    reloadAnimalListAndResetToDefaults();
    return "animal.xhtml?faces-redirect=true";
  }

  public void cautaAnimalCustom() {
    animals = animalService.cautaAnimale(animalCautareCustom);
  }

  public void adaugaAnimal() {
    PersonDto stapan = new PersonDto();
    stapan.setId(stapanId);
    animalToSave.setPerson(stapan);
    animalService.adaugaAnimal(animalToSave);
    reloadAnimalListAndResetToDefaults();
  }

  public void cautaAnimalDupaRasa() {
    animals = animalService.cautaAnimalDupaRasa(rasaCautare);
    System.out.println("Am apelat metoda");
  }

  public void cautaAnimalDupaPedigreeSiVarstaMaiMica() {
    animals =
        animalService.cautaAnimalDupaPedigreeSiVarstaMaiMica(
            pedigreeCautare, varstaMaiMicaDeCautare);
  }

  public List<Sex> loadListOfSexes() {
    return Arrays.asList(Sex.values());
  }

  public AnimalDto getAnimalToSave() {
    return animalToSave;
  }

  public void setAnimalToSave(AnimalDto animalToSave) {
    this.animalToSave = animalToSave;
  }

  @PostConstruct
  public void init() {
    persoane = personService.loadAllPersons();
    reloadAnimalListAndResetToDefaults();
    mesajDialog = "Doriți să ștergeți acest animal?";
    System.out.println("Am apelat metoda de intializare.");
  }

  private void reloadAnimalListAndResetToDefaults() {
    animals = animalService.loadAllAnimals();
    animalToSave = new AnimalDto();
    animalToSave.setPedigree(true);
    animalCautareCustom = new AnimalDto();
    rasaCautare = null;
    pedigreeCautare = null;
    varstaMaiMicaDeCautare = null;
    personIdPentruActualizare = null;
    animalPentruActualizare = new AnimalDto();
  }

  public void reset() {
    reloadAnimalListAndResetToDefaults();
  }

  public List<AnimalDto> getAnimals() {
    return animals;
  }

  public void setAnimals(List<AnimalDto> animals) {
    this.animals = animals;
  }

  public Integer getStapanId() {
    return stapanId;
  }

  public void setStapanId(Integer stapanId) {
    this.stapanId = stapanId;
  }

  public List<PersonDto> getPersoane() {
    return persoane;
  }

  public void setPersoane(List<PersonDto> persoane) {
    this.persoane = persoane;
  }

  public String getRasaCautare() {
    return rasaCautare;
  }

  public void setRasaCautare(String rasaCautare) {
    this.rasaCautare = rasaCautare;
  }

  public Boolean getPedigreeCautare() {
    return pedigreeCautare;
  }

  public void setPedigreeCautare(Boolean pedigreeCautare) {
    this.pedigreeCautare = pedigreeCautare;
  }

  public Integer getVarstaMaiMicaDeCautare() {
    return varstaMaiMicaDeCautare;
  }

  public void setVarstaMaiMicaDeCautare(Integer varstaMaiMicaDeCautare) {
    this.varstaMaiMicaDeCautare = varstaMaiMicaDeCautare;
  }

  public AnimalDto getAnimalCautareCustom() {
    return animalCautareCustom;
  }

  public void setAnimalCautareCustom(AnimalDto animalCautareCustom) {
    this.animalCautareCustom = animalCautareCustom;
  }

  public String getMesajDialog() {
    return mesajDialog;
  }

  public void setMesajDialog(String mesajDialog) {
    this.mesajDialog = mesajDialog;
  }

  public AnimalDto getAnimalPentruActualizare() {
    return animalPentruActualizare;
  }

  public void setAnimalPentruActualizare(AnimalDto animalPentruActualizare) {
    this.animalPentruActualizare = animalPentruActualizare;
  }

  public Integer getPersonIdPentruActualizare() {
    return personIdPentruActualizare;
  }

  public void setPersonIdPentruActualizare(Integer personIdPentruActualizare) {
    this.personIdPentruActualizare = personIdPentruActualizare;
  }
}
