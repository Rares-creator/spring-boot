package com.example.services;

import com.example.dao.BirouDAO;
import com.example.dao.BirouDAOCustom;
import com.example.dto.BirouDto;
import com.example.entities.Birou;
import com.example.mappers.BirouMapper;
import com.example.mappers.CycleAvoidingMappingContext;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BirouService {

  @Autowired private BirouDAO birouDAO;
  @Autowired private BirouDAOCustom birouDAOCustom;

  @Autowired private BirouMapper birouMapper;

  public void adaugaBirou(BirouDto birouDto) {
    birouDAO.save(birouMapper.birouDtoToEntity(birouDto, new CycleAvoidingMappingContext()));
  }

  public BirouDto cautaBirou(Integer id) {
    return birouMapper.birouToDto(birouDAO.findOne(id), new CycleAvoidingMappingContext());
  }

  public List<BirouDto> cautaBirouriDupaMaterial(String material) {
    return birouMapper.birouToDto(
        birouDAO.cautaBirouriDupaMaterial(material), new CycleAvoidingMappingContext());
  }

  public List<BirouDto> cautaBirouriDupaDimensiuneSiPretMaiMare(String dimensiune, int pret) {
    return birouMapper.birouToDto(
        birouDAO.cautaBirouriDupaDimensiuneSiPretMaiMare(dimensiune, pret),
        new CycleAvoidingMappingContext());
  }

  public List<BirouDto> cautaBirouriDupaCuloareSiPretMaiMic(String culoare, int pret) {
    return birouMapper.birouToDto(
        birouDAO.cautaBirouriDupaCuloareSiPretMaiMic(culoare, pret),
        new CycleAvoidingMappingContext());
  }

  public List<BirouDto> cautaBirouri(BirouDto birouCuFiltre) {
    return birouMapper.birouToDto(
        birouDAOCustom.cautaBirouri(birouCuFiltre), new CycleAvoidingMappingContext());
  }

  public void stergeBirou(Integer id) {
    birouDAOCustom.deleteById(id);
  }

  public BirouDto actualizareBirou(BirouDto birouPentruActualizare) {
    birouDAO.save(
        birouMapper.birouDtoToEntity(birouPentruActualizare, new CycleAvoidingMappingContext()));
    return birouPentruActualizare;
  }

  public List<Birou> cautaBirouriDupaIdApartament(Integer idApartament) {
    return birouDAO.cautaBirouriDupaIdApartament(idApartament);
  }

  public List<BirouDto> loadAllBirous() {
    return birouMapper.birouToDto(
        (List<Birou>) birouDAO.findAll(), new CycleAvoidingMappingContext());
  }
}
