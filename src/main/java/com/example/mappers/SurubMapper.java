package com.example.mappers;

import com.example.dto.SurubDto;
import com.example.entities.Surub;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SurubMapper {

  SurubDto surubToDto(Surub surub, @Context CycleAvoidingMappingContext context);

  Surub surubDtoToEntity(SurubDto surubDto, @Context CycleAvoidingMappingContext context);

  List<SurubDto> surubToDto(List<Surub> surub, @Context CycleAvoidingMappingContext context);

  List<Surub> surubDtoToEntity(
      List<SurubDto> surubDto, @Context CycleAvoidingMappingContext context);
}
