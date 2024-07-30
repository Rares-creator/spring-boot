package com.example.mappers;

import com.example.dto.MouseDto;
import com.example.entities.Mouse;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MouseMapper {
  MouseDto mouseToDto(Mouse mouse, @Context CycleAvoidingMappingContext context);

  Mouse mouseDtoToEntity(MouseDto mouseToDto, @Context CycleAvoidingMappingContext context);

  List<MouseDto> mouseToDto(List<Mouse> mouse, @Context CycleAvoidingMappingContext context);

  List<Mouse> mouseDtoToEntity(
      List<MouseDto> mouseToDto, @Context CycleAvoidingMappingContext context);
}
