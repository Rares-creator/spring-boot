package com.example.mappers;

import com.example.dto.PantofDto;
import com.example.entities.Pantof;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PantofMapper {

  PantofDto pantofToDto(Pantof pantof, @Context CycleAvoidingMappingContext context);

  Pantof pantofDtoToEntity(PantofDto pantofDto, @Context CycleAvoidingMappingContext context);

  List<PantofDto> pantofToDto(List<Pantof> pantof, @Context CycleAvoidingMappingContext context);

  List<Pantof> pantofDtoToEntity(
      List<PantofDto> pantofDto, @Context CycleAvoidingMappingContext context);
}
