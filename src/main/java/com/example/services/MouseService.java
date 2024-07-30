package com.example.services;

import com.example.dao.MouseDAO;
import com.example.dao.MouseDAOCustom;
import com.example.dto.MouseDto;
import com.example.entities.Mouse;
import com.example.mappers.CycleAvoidingMappingContext;
import com.example.mappers.MouseMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MouseService {

  @Autowired private MouseDAO mouseDAO;

  @Autowired private MouseMapper mouseMapper;
  @Autowired private MouseDAOCustom mouseDAOCustom;

  public void adaugaMouse(MouseDto mouseDto) {
    mouseDAO.save(mouseMapper.mouseDtoToEntity(mouseDto, new CycleAvoidingMappingContext()));
  }

  public MouseDto cautaMouse(Integer id) {
    return mouseMapper.mouseToDto(mouseDAO.findOne(id), new CycleAvoidingMappingContext());
  }

  public void stergeMouse(Integer id) {
    mouseDAO.delete(id);
  }

  public MouseDto actualizareMouse(MouseDto mousePentruActualizare) {
    mouseDAO.save(
        mouseMapper.mouseDtoToEntity(mousePentruActualizare, new CycleAvoidingMappingContext()));
    return mousePentruActualizare;
  }

  public List<MouseDto> loadAllMouses() {
    return mouseMapper.mouseToDto(
        (List<Mouse>) mouseDAO.findAll(), new CycleAvoidingMappingContext());
  }

  public List<MouseDto> cautaMouseDupaDenumire(String denumire) {
    return mouseMapper.mouseToDto(
        mouseDAO.cautaMouseDupaDenumire(denumire), new CycleAvoidingMappingContext());
  }

  public List<MouseDto> cautaMouseDupaCabluUsbSiNumarButoane(
      Boolean cabluUsb, Integer numarButoane) {
    return mouseMapper.mouseToDto(
        mouseDAO.cautaMouseDupaCabluUsbSiNumarButoane(cabluUsb, numarButoane),
        new CycleAvoidingMappingContext());
  }

  public List<MouseDto> cautaMousuri(MouseDto mouseCuFiltre) {
    return mouseMapper.mouseToDto(
        mouseDAOCustom.cautaMousuri(mouseCuFiltre), new CycleAvoidingMappingContext());
  }
}
