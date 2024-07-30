package com.example.services;

import com.example.dao.PersonDAO;
import com.example.dao.PersonDAOCustom;
import com.example.dto.PersonDto;
import com.example.entities.Person;
import com.example.mappers.CycleAvoidingMappingContext;
import com.example.mappers.PersonMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
  @Autowired private PersonDAO personDAO;

  @Autowired private PersonMapper personMapper;

  @Autowired private PersonDAOCustom personDAOCustom;

  public void adaugaPersoana(PersonDto personDto) {
    personDAO.save(personMapper.personDtoToEntity(personDto, new CycleAvoidingMappingContext()));
  }

  public PersonDto cautaPersoana(Integer id) {
    return personMapper.personToDto(personDAO.findOne(id), new CycleAvoidingMappingContext());
  }

  public List<PersonDto> loadAllPersons() {
    return personMapper.personToDto(
        (List<Person>) personDAO.findAll(), new CycleAvoidingMappingContext());
  }

  public List<PersonDto> cautaPersoanaDupaCnp(Long cnp) {
    return personMapper.personToDto(
        personDAO.cautaPersoanaDupaCnp(cnp), new CycleAvoidingMappingContext());
  }

  public List<PersonDto> cautaPersoanaDupaNumeSiVarsta(String nume, Integer varsta) {
    return personMapper.personToDto(
        personDAO.cautaPersoanaDupaNumeSiVarsta(nume, varsta), new CycleAvoidingMappingContext());
  }

  public List<PersonDto> cautaPersoane(PersonDto personCuFiltre) {
    return personMapper.personToDto(
        personDAOCustom.cautaPersoane(personCuFiltre), new CycleAvoidingMappingContext());
  }

  public void stergePerson(Integer id) {
    personDAOCustom.deleteById(id);
  }

  public PersonDto actualizarePerson(PersonDto personPentruActualizare) {
    personDAO.save(
        personMapper.personDtoToEntity(personPentruActualizare, new CycleAvoidingMappingContext()));
    return personPentruActualizare;
  }
}
