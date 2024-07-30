package com.example.mappers;

import com.example.dto.CarteDto;
import com.example.entities.Carte;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = BibliotecaMapper.class)
public interface CarteMapper {

    CarteDto carteToDto(Carte carte, @Context CycleAvoidingMappingContext context);

    Carte carteDtoToEntity(CarteDto carteDto, @Context CycleAvoidingMappingContext context);

    List<CarteDto> carteToDto(List<Carte> carti, @Context CycleAvoidingMappingContext context);

    List<Carte> carteDtoToEntity(
            List<CarteDto> carteDtos, @Context CycleAvoidingMappingContext context);
}
