package com.example.mappers;

import com.example.dto.LaptopDto;
import com.example.entities.Laptop;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LaptopMapper {

  LaptopDto laptopToDto(Laptop laptop, @Context CycleAvoidingMappingContext context);

  Laptop laptopDtoToEntity(LaptopDto laptopDto, @Context CycleAvoidingMappingContext context);

  List<LaptopDto> laptopToDto(List<Laptop> laptop, @Context CycleAvoidingMappingContext context);

  List<Laptop> laptopDtoToEntity(
      List<LaptopDto> laptopDto, @Context CycleAvoidingMappingContext context);
}
