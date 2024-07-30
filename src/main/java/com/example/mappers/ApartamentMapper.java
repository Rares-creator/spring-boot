package com.example.mappers;

import com.example.dto.ApartamentDto;
import com.example.entities.Apartament;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = BirouMapper.class)
public interface ApartamentMapper {

    ApartamentDto apartamentToDto(
            Apartament apartament, @Context CycleAvoidingMappingContext context);

    Apartament ApartamentDtoToEntity(
            ApartamentDto apartamentDto, @Context CycleAvoidingMappingContext context);

    List<ApartamentDto> apartamentToDto(
            List<Apartament> apartaments, @Context CycleAvoidingMappingContext context);

    List<Apartament> ApartamentDtoToEntity(
            List<ApartamentDto> apartamentDtos, @Context CycleAvoidingMappingContext context);
}
