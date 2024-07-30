package com.example.services;

import com.example.dao.TricouDAO;
import com.example.dao.TricouDAOCustom;
import com.example.dto.TricouDto;
import com.example.entities.Tricou;
import com.example.mappers.CycleAvoidingMappingContext;
import com.example.mappers.TricouMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TricouService {

  @Autowired private TricouDAO tricouDAO;

  @Autowired private TricouMapper tricouMapper;
  @Autowired private TricouDAOCustom tricouDAOCustom;

  public void adaugaTricou(TricouDto tricouDto) {
    tricouDAO.save(tricouMapper.tricouDtoToEntity(tricouDto, new CycleAvoidingMappingContext()));
  }

  public TricouDto cautaTricou(Integer id) {
    return tricouMapper.tricouToDto(tricouDAO.findOne(id), new CycleAvoidingMappingContext());
  }

  public void stergeTricou(Integer id) {
    tricouDAO.delete(id);
  }

  public TricouDto actualizareTricou(TricouDto tricouPentruActualizare) {
    tricouDAO.save(
        tricouMapper.tricouDtoToEntity(tricouPentruActualizare, new CycleAvoidingMappingContext()));
    return tricouPentruActualizare;
  }

  public List<TricouDto> loadAllTricous() {
    return tricouMapper.tricouToDto(
        (List<Tricou>) tricouDAO.findAll(), new CycleAvoidingMappingContext());
  }

  public List<TricouDto> cautaTricouDupaPretMaiMare(Integer pret) {
    return tricouMapper.tricouToDto(
        tricouDAO.cautaTricouDupaPretMaiMare(pret), new CycleAvoidingMappingContext());
  }

  public List<TricouDto> cautaTricouDupaMaterialSiCuloare(String material, String culoare) {
    return tricouMapper.tricouToDto(
        tricouDAO.cautaTricouDupaMaterialSiCuloare(material, culoare),
        new CycleAvoidingMappingContext());
  }

  public List<TricouDto> cautaTricouri(TricouDto tricouCuFiltre) {
    return tricouMapper.tricouToDto(
        tricouDAOCustom.cautaTricouri(tricouCuFiltre), new CycleAvoidingMappingContext());
  }
}
