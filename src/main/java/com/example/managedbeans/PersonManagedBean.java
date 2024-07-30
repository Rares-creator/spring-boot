package com.example.managedbeans;

import com.example.dto.PersonDto;
import com.example.entities.Sex;
import com.example.jsf.FacesViewScope;
import com.example.services.PersonService;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("personManagedBean")
@Scope(FacesViewScope.NAME)
public class PersonManagedBean implements Serializable {

  @Autowired private PersonService personService;

  private List<PersonDto> persons;

  private PersonDto personToSave;

  private Long cnpCautare;

  private String numeCautare;

  private Integer varstaCautare;

  private PersonDto personCautaFiltre;

  private Integer personIdPentruStergere;

  private String mesajDialog;

  private PersonDto personPentruActualizare;

  public void actualizeazaPerson() {
    personService.actualizarePerson(personPentruActualizare);
    reloadPersonListAndRestoreToDefaults();
  }

  public void pregatesteActualizarePerson(PersonDto person) {
    personPentruActualizare = person;
  }

  public void verificaAnimaleSiSeteazaMesajDialog(PersonDto person) {
    personIdPentruStergere = person.getId();
    if (person != null && !person.getAnimale().isEmpty()) {
      mesajDialog =
          "Persoana are animale asociate. Doriți să ștergeți persoana și animalele asociate?";
    } else {
      mesajDialog = "Doriți să ștergeți aceasta persoana?";
    }
  }

  public String stergePerson() {
    personService.stergePerson(personIdPentruStergere);
    reloadPersonListAndRestoreToDefaults();
    return "person.xhtml?faces-redirect=true";
  }

  public void cautaPersoane() {
    persons = personService.cautaPersoane(personCautaFiltre);
  }

  public void reset() {
    reloadPersonListAndRestoreToDefaults();
  }

  public void cautaPersoanaDupaCnp() {
    persons = personService.cautaPersoanaDupaCnp(cnpCautare);
  }

  public void cautaPersoanaDupaNumeSiVarsta() {
    persons = personService.cautaPersoanaDupaNumeSiVarsta(numeCautare, varstaCautare);
  }

  public void reloadPersonListAndRestoreToDefaults() {
    persons = personService.loadAllPersons();
    personToSave = new PersonDto();
    cnpCautare = null;
    numeCautare = null;
    varstaCautare = null;
    personCautaFiltre = new PersonDto();
    personPentruActualizare = new PersonDto();
  }

  public void adaugaPersoana() {
    personService.adaugaPersoana(personToSave);
    reloadPersonListAndRestoreToDefaults();
  }

  public List<Sex> loadListOfSexes() {
    return Arrays.asList(Sex.values());
  }

  @PostConstruct
  public void init() {
    reloadPersonListAndRestoreToDefaults();
    System.out.println("Am apelat metoda de intializare.");
  }

  public List<PersonDto> getPersons() {
    return persons;
  }

  public void setPersons(List<PersonDto> persons) {
    this.persons = persons;
  }

  public void loadAllPersons() {
    persons = personService.loadAllPersons();
  }

  public PersonDto getPersonToSave() {
    return personToSave;
  }

  public void setPersonToSave(PersonDto personToSave) {
    this.personToSave = personToSave;
  }

  public Long getCnpCautare() {
    return cnpCautare;
  }

  public void setCnpCautare(Long cnpCautare) {
    this.cnpCautare = cnpCautare;
  }

  public String getNumeCautare() {
    return numeCautare;
  }

  public void setNumeCautare(String numeCautare) {
    this.numeCautare = numeCautare;
  }

  public Integer getVarstaCautare() {
    return varstaCautare;
  }

  public void setVarstaCautare(Integer varstaCautare) {
    this.varstaCautare = varstaCautare;
  }

  public PersonDto getPersonCautaFiltre() {
    return personCautaFiltre;
  }

  public void setPersonCautaFiltre(PersonDto personCautaFiltre) {
    this.personCautaFiltre = personCautaFiltre;
  }

  public String getMesajDialog() {
    return mesajDialog;
  }

  public void setMesajDialog(String mesajDialog) {
    this.mesajDialog = mesajDialog;
  }

  public PersonDto getPersonPentruActualizare() {
    return personPentruActualizare;
  }

  public void setPersonPentruActualizare(PersonDto personPentruActualizare) {
    this.personPentruActualizare = personPentruActualizare;
  }
}
