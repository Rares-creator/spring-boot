package com.example.services;

import com.example.dao.PantofDAO;
import com.example.dao.PantofDAOCustom;
import com.example.dto.PantofDto;
import com.example.entities.Pantof;
import com.example.entities.Sex;
import com.example.mappers.CycleAvoidingMappingContext;
import com.example.mappers.PantofMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PantofService {
  @Autowired private PantofDAO pantofDAO;

  @Autowired private PantofMapper pantofMapper;
  @Autowired private PantofDAOCustom pantofDAOCustom;

  public void adaugaPantof(PantofDto pantofDto) {
    pantofDAO.save(pantofMapper.pantofDtoToEntity(pantofDto, new CycleAvoidingMappingContext()));
  }

  public PantofDto cautaPantof(Integer id) {
    return pantofMapper.pantofToDto(pantofDAO.findOne(id), new CycleAvoidingMappingContext());
  }

  public void stergePantof(Integer id) {
    pantofDAO.delete(id);
  }

  public PantofDto actualizarePantof(PantofDto pantofPentruActualizare) {
    pantofDAO.save(
        pantofMapper.pantofDtoToEntity(pantofPentruActualizare, new CycleAvoidingMappingContext()));
    return pantofPentruActualizare;
  }

  public List<PantofDto> loadAllPantofs() {
    return pantofMapper.pantofToDto(
        (List<Pantof>) pantofDAO.findAll(), new CycleAvoidingMappingContext());
  }

  public List<PantofDto> cautaPantofDupaTipPantof(String tipPantof) {
    return pantofMapper.pantofToDto(
        pantofDAO.cautaPantofDupaTipPantof(tipPantof), new CycleAvoidingMappingContext());
  }

  public List<PantofDto> cautaPantofDupaSexSiNumar(Sex sex, Integer numar) {
    return pantofMapper.pantofToDto(
        pantofDAO.cautaPantofDupaSexSiNumar(sex, numar), new CycleAvoidingMappingContext());
  }

  public List<PantofDto> cautaPantofi(PantofDto pantofCuFiltre) {
    return pantofMapper.pantofToDto(
        pantofDAOCustom.cautaPantofi(pantofCuFiltre), new CycleAvoidingMappingContext());
  }
}
