package com.example.services;

import com.example.dao.LaptopDAO;
import com.example.dao.LaptopDAOCustom;
import com.example.dto.LaptopDto;
import com.example.entities.Laptop;
import com.example.mappers.CycleAvoidingMappingContext;
import com.example.mappers.LaptopMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

  @Autowired private LaptopDAO laptopDAO;

  @Autowired private LaptopMapper laptopMapper;
  @Autowired private LaptopDAOCustom laptopDAOCustom;

  public void adaugaLaptop(LaptopDto laptopDto) {
    laptopDAO.save(laptopMapper.laptopDtoToEntity(laptopDto, new CycleAvoidingMappingContext()));
  }

  public LaptopDto cautaLaptop(Integer id) {
    return laptopMapper.laptopToDto(laptopDAO.findOne(id), new CycleAvoidingMappingContext());
  }

  public void stergeLaptop(Integer id) {
    laptopDAO.delete(id);
  }

  public LaptopDto actualizareLaptop(LaptopDto laptopPentruActualizare) {
    laptopDAO.save(
        laptopMapper.laptopDtoToEntity(laptopPentruActualizare, new CycleAvoidingMappingContext()));
    return laptopPentruActualizare;
  }

  public List<LaptopDto> cautaLaptopDupaDenumire(String denumire) {
    return laptopMapper.laptopToDto(
        laptopDAO.cautaLaptopDupaDenumire(denumire), new CycleAvoidingMappingContext());
  }

  public List<LaptopDto> cautaLaptopDupaMemorieRamSiFastUsb(Integer memorieRam, Boolean fastUsb) {
    return laptopMapper.laptopToDto(
        laptopDAO.cautaLaptopDupaMemorieRamSiFastUsb(memorieRam, fastUsb),
        new CycleAvoidingMappingContext());
  }

  public List<LaptopDto> loadAllLaptops() {
    return laptopMapper.laptopToDto(
        (List<Laptop>) laptopDAO.findAll(), new CycleAvoidingMappingContext());
  }

  public List<LaptopDto> cautaLaptopuri(LaptopDto laptopCuFiltre) {
    return laptopMapper.laptopToDto(
        laptopDAOCustom.cautaLaptopuri(laptopCuFiltre), new CycleAvoidingMappingContext());
  }
}
