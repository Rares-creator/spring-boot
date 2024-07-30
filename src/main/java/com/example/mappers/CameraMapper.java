package com.example.mappers;

import com.example.dto.CameraDto;
import com.example.entities.Camera;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = HotelMapper.class)
public interface CameraMapper {
  CameraDto cameraToDto(Camera camera, @Context CycleAvoidingMappingContext context);

  Camera CameraDtoToEntity(CameraDto cameraDto, @Context CycleAvoidingMappingContext context);

  List<CameraDto> cameraToDto(List<Camera> camera, @Context CycleAvoidingMappingContext context);

  List<Camera> CameraDtoToEntity(
      List<CameraDto> cameraDto, @Context CycleAvoidingMappingContext context);
}
