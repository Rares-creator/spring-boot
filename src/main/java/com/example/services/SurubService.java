package com.example.services;

import com.example.dao.SurubDAO;
import com.example.dao.SurubDAOCustom;
import com.example.dto.SurubDto;
import com.example.entities.Surub;
import com.example.mappers.CycleAvoidingMappingContext;
import com.example.mappers.SurubMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurubService {
  @Autowired private SurubDAO surubDAO;

  @Autowired private SurubMapper surubMapper;

  @Autowired private SurubDAOCustom surubDAOCustom;

  public void adaugaSurub(SurubDto surubDto) {
    surubDAO.save(surubMapper.surubDtoToEntity(surubDto, new CycleAvoidingMappingContext()));
  }

  public SurubDto cautaSurub(Integer id) {
    return surubMapper.surubToDto(surubDAO.findOne(id), new CycleAvoidingMappingContext());
  }

  public void stergeSurub(Integer id) {
    surubDAO.delete(id);
  }

  public SurubDto actualizareSurub(SurubDto surubPentruActualizare) {
    surubDAO.save(
        surubMapper.surubDtoToEntity(surubPentruActualizare, new CycleAvoidingMappingContext()));
    return surubPentruActualizare;
  }

  public List<SurubDto> loadAllSurubs() {
    return surubMapper.surubToDto(
        (List<Surub>) surubDAO.findAll(), new CycleAvoidingMappingContext());
  }

  public List<SurubDto> cautaSurubDupaZonaFolosire(String zonaFolosire) {
    return surubMapper.surubToDto(
        surubDAO.cautaSurubDupaZonaFolosire(zonaFolosire), new CycleAvoidingMappingContext());
  }

  public List<SurubDto> cautaSurubDupaTipSurubSiMaterial(String tipSurub, String material) {
    return surubMapper.surubToDto(
        surubDAO.cautaSurubDupaTipSurubSiMaterial(tipSurub, material),
        new CycleAvoidingMappingContext());
  }

  public List<SurubDto> cautaSuruburi(SurubDto surubCuFiltre) {
    return surubMapper.surubToDto(
        surubDAOCustom.cautaSuruburi(surubCuFiltre), new CycleAvoidingMappingContext());
  }
}
