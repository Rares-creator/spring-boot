package com.example.services;

import com.example.dao.CameraDAO;
import com.example.dao.CameraDAOCustom;
import com.example.dto.CameraDto;
import com.example.entities.Camera;
import com.example.mappers.CameraMapper;
import com.example.mappers.CycleAvoidingMappingContext;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CameraService {
  @Autowired private CameraDAO cameraDAO;
  @Autowired private CameraMapper cameraMapper;
  @Autowired private CameraDAOCustom cameraDAOCustom;

  public void adaugaCamera(CameraDto cameraDto) {
    cameraDAO.save(cameraMapper.CameraDtoToEntity(cameraDto, new CycleAvoidingMappingContext()));
  }

  public void stergeCamera(Integer id) {
    cameraDAOCustom.deleteById(id);
  }

  public List<CameraDto> loadAllCameras() {
    return cameraMapper.cameraToDto(
        (List<Camera>) cameraDAO.findAll(), new CycleAvoidingMappingContext());
  }

  public List<CameraDto> cautaCameraDupaJacuzzi(Boolean jacuzzi) {
    return cameraMapper.cameraToDto(
        cameraDAO.cautaCameraDupaJacuzzi(jacuzzi), new CycleAvoidingMappingContext());
  }

  public List<CameraDto> cautaCameraDupaHotelSiTipulCamerei(
      String hotelDenumire, String tipCamera) {
    return cameraMapper.cameraToDto(
        cameraDAO.cautaCameraDupaHotelSiTipulCamerei(hotelDenumire, tipCamera),
        new CycleAvoidingMappingContext());
  }

  public List<CameraDto> cautaCamere(CameraDto cameraCuFiltre) {
    return cameraMapper.cameraToDto(
        cameraDAOCustom.cautaCamere(cameraCuFiltre), new CycleAvoidingMappingContext());
  }

  public CameraDto actualizareCamera(CameraDto cameraPentruActualizare) {
    cameraDAO.save(
        cameraMapper.CameraDtoToEntity(cameraPentruActualizare, new CycleAvoidingMappingContext()));
    return cameraPentruActualizare;
  }
}
