package com.example.mappers;

import com.example.dto.TricouDto;
import com.example.entities.Tricou;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TricouMapper {
  TricouDto tricouToDto(Tricou tricou, @Context CycleAvoidingMappingContext context);

  Tricou tricouDtoToEntity(TricouDto tricouDto, @Context CycleAvoidingMappingContext context);

  List<TricouDto> tricouToDto(List<Tricou> tricou, @Context CycleAvoidingMappingContext context);

  List<Tricou> tricouDtoToEntity(
      List<TricouDto> tricouDto, @Context CycleAvoidingMappingContext context);
}
