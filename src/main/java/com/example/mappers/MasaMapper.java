package com.example.mappers;

import com.example.dto.MasaDto;
import com.example.entities.Masa;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = RestaurantMapper.class)
public interface MasaMapper {

  MasaDto masaToDto(Masa masa, @Context CycleAvoidingMappingContext context);

  Masa masaDtoToEntity(MasaDto masaDto, @Context CycleAvoidingMappingContext context);

  List<MasaDto> masaToDto(List<Masa> masa, @Context CycleAvoidingMappingContext context);

  List<Masa> masaDtoToEntity(List<MasaDto> masaDto, @Context CycleAvoidingMappingContext context);
}
