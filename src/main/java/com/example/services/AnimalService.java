package com.example.services;

import com.example.dao.AnimalDAO;
import com.example.dao.AnimalDAOCustom;
import com.example.dto.AnimalDto;
import com.example.entities.Animal;
import com.example.mappers.AnimalMapper;
import com.example.mappers.CycleAvoidingMappingContext;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
  @Autowired private AnimalDAO animalDAO;
  @Autowired private AnimalMapper animalMapper;
  @Autowired private AnimalDAOCustom animalDAOCustom;

  public void adaugaAnimal(AnimalDto animalDto) {
    animalDAO.save(animalMapper.animalDtoToEntity(animalDto, new CycleAvoidingMappingContext()));
  }

  public void stergeAnimal(Integer id) {
    animalDAOCustom.deleteById(id);
  }

  public List<AnimalDto> loadAllAnimals() {
    return animalMapper.animalToDto(
        (List<Animal>) animalDAO.findAll(), new CycleAvoidingMappingContext());
  }

  public List<AnimalDto> cautaAnimalDupaRasa(String rasa) {
    return animalMapper.animalToDto(
        animalDAO.cautaAnimalDupaRasa(rasa), new CycleAvoidingMappingContext());
  }

  public List<AnimalDto> cautaAnimalDupaPedigreeSiVarstaMaiMica(Boolean pedigree, int varsta) {
    return animalMapper.animalToDto(
        animalDAO.cautaAnimalDupaPedigreeSiVarstaMaiMica(pedigree, varsta),
        new CycleAvoidingMappingContext());
  }

  public List<AnimalDto> cautaAnimale(AnimalDto animalCuFiltre) {
    return animalMapper.animalToDto(
        animalDAOCustom.cautaAnimale(animalCuFiltre), new CycleAvoidingMappingContext());
  }

  public AnimalDto actualizareAnimal(AnimalDto animalPentruActualizare) {
    animalDAO.save(
        animalMapper.animalDtoToEntity(animalPentruActualizare, new CycleAvoidingMappingContext()));
    return animalPentruActualizare;
  }
}
