package com.example.services;

import com.example.dao.CarteDAO;
import com.example.dao.CarteDAOCustom;
import com.example.dto.CarteDto;
import com.example.entities.Carte;
import com.example.mappers.CarteMapper;
import com.example.mappers.CycleAvoidingMappingContext;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarteService {
  @Autowired private CarteDAO carteDAO;
  @Autowired private CarteMapper carteMapper;
  @Autowired private CarteDAOCustom carteDAOCustom;

  public void adaugaCarte(CarteDto carteDto) {
    carteDAO.save(carteMapper.carteDtoToEntity(carteDto, new CycleAvoidingMappingContext()));
  }

  public CarteDto cautaCarte(Integer id) {
    return carteMapper.carteToDto(carteDAO.findOne(id), new CycleAvoidingMappingContext());
  }

  public List<CarteDto> loadAllCartes() {
    return carteMapper.carteToDto(
        (List<Carte>) carteDAO.findAll(), new CycleAvoidingMappingContext());
  }

  public List<CarteDto> cautaCarteDupaNume(String nume) {
    return carteMapper.carteToDto(
        carteDAO.cautaCarteDupaNume(nume), new CycleAvoidingMappingContext());
  }

  public List<CarteDto> cautaCarteDupaAutorSiGen(String autor, String gen) {
    return carteMapper.carteToDto(
        carteDAO.cautaCarteDupaAutorSiGen(autor, gen), new CycleAvoidingMappingContext());
  }

  public List<CarteDto> cautaCarti(CarteDto carteCuFiltre) {
    return carteMapper.carteToDto(
        carteDAOCustom.cautaCarti(carteCuFiltre), new CycleAvoidingMappingContext());
  }

  public void stergeCarte(Integer id) {
    carteDAOCustom.deleteById(id);
  }

  public CarteDto actualizareCarte(CarteDto cartePentruActualizare) {
    carteDAO.save(
        carteMapper.carteDtoToEntity(cartePentruActualizare, new CycleAvoidingMappingContext()));
    return cartePentruActualizare;
  }
}
