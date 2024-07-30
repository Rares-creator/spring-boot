package com.example.services;

import com.example.dao.ApartamentDAO;
import com.example.dao.ApartamentDAOCustom;
import com.example.dao.BirouDAOCustom;
import com.example.dto.ApartamentDto;
import com.example.entities.Apartament;
import com.example.mappers.ApartamentMapper;
import com.example.mappers.CycleAvoidingMappingContext;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApartamentService {
  @Autowired private ApartamentDAO apartamentDAO;

  @Autowired private BirouDAOCustom birouDAOCustom;

  @Autowired private ApartamentMapper apartamentMapper;

  @Autowired private ApartamentDAOCustom apartamentDAOCustom;

  public void adaugaApartament(ApartamentDto apartamentDto) {
    apartamentDAO.save(
        apartamentMapper.ApartamentDtoToEntity(apartamentDto, new CycleAvoidingMappingContext()));
  }

  public ApartamentDto cautaApartament(Integer id) {
    return apartamentMapper.apartamentToDto(
        apartamentDAO.findOne(id), new CycleAvoidingMappingContext());
  }

  public List<ApartamentDto> loadAllApartaments() {
    return apartamentMapper.apartamentToDto(
        (List<Apartament>) apartamentDAO.findAll(), new CycleAvoidingMappingContext());
  }

  public List<ApartamentDto> cautaApartamentDupaLocatie(String locatie) {
    return apartamentMapper.apartamentToDto(
        apartamentDAO.cautaApartamentDupaLocatie(locatie), new CycleAvoidingMappingContext());
  }

  public List<ApartamentDto> cautaApartamentDupaSuprafataMaiMareSiNumarCamereMaiMulte(
      int suprafata, int numarCamere) {
    return apartamentMapper.apartamentToDto(
        apartamentDAO.cautaApartamentDupaSuprafataMaiMareSiNumarCamereMaiMulte(
            suprafata, numarCamere),
        new CycleAvoidingMappingContext());
  }

  public List<ApartamentDto> cautaApartamente(ApartamentDto apartamentCuFiltre) {
    return apartamentMapper.apartamentToDto(
        apartamentDAOCustom.cautaApartamente(apartamentCuFiltre),
        new CycleAvoidingMappingContext());
  }

  public void stergeApartament(Integer id) {
    apartamentDAO.delete(id);
  }

  public ApartamentDto actualizareApartament(ApartamentDto apartamentPentruActualizare) {
    apartamentDAO.save(
        apartamentMapper.ApartamentDtoToEntity(
            apartamentPentruActualizare, new CycleAvoidingMappingContext()));
    return apartamentPentruActualizare;
  }
}
