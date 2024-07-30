package com.example.services;

import com.example.dao.MasaDAO;
import com.example.dao.MasaDAOCustom;
import com.example.dto.MasaDto;
import com.example.entities.Masa;
import com.example.mappers.CycleAvoidingMappingContext;
import com.example.mappers.MasaMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MasaService {

  @Autowired private MasaDAO masaDAO;
  @Autowired private MasaMapper masaMapper;
  @Autowired private MasaDAOCustom masaDAOCustom;

  public void adaugaMasa(MasaDto masaDto) {
    masaDAO.save(masaMapper.masaDtoToEntity(masaDto, new CycleAvoidingMappingContext()));
  }

  public MasaDto cautaMasa(Integer id) {
    return masaMapper.masaToDto(masaDAO.findOne(id), new CycleAvoidingMappingContext());
  }

  public List<MasaDto> loadAllMasas() {
    return masaMapper.masaToDto((List<Masa>) masaDAO.findAll(), new CycleAvoidingMappingContext());
  }

  public List<MasaDto> cautaMasaDupaCapacitate(Integer capacitate) {
    return masaMapper.masaToDto(
        masaDAO.cautaMasaDupaCapacitate(capacitate), new CycleAvoidingMappingContext());
  }

  public List<MasaDto> cautaMasaDupaDenumireRestaurantSiNumarMasa(
      String denumireRestaurant, Integer numarMasa) {
    return masaMapper.masaToDto(
        masaDAO.cautaMasaDupaDenumireRestaurantSiNumarMasa(denumireRestaurant, numarMasa),
        new CycleAvoidingMappingContext());
  }

  public List<MasaDto> cautaMese(MasaDto masaCuFiltre) {
    return masaMapper.masaToDto(
        masaDAOCustom.cautaMese(masaCuFiltre), new CycleAvoidingMappingContext());
  }

  public void stergeMasa(Integer id) {
    masaDAOCustom.deleteById(id);
  }

  public MasaDto actualizareMasa(MasaDto masaPentruActualizare) {
    masaDAO.save(
        masaMapper.masaDtoToEntity(masaPentruActualizare, new CycleAvoidingMappingContext()));
    return masaPentruActualizare;
  }
}
