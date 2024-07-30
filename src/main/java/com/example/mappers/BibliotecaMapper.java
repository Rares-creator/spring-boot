package com.example.mappers;

import com.example.dto.BibliotecaDto;
import com.example.entities.Biblioteca;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CarteMapper.class)
public interface BibliotecaMapper {
    BibliotecaDto bibliotecaToDto(
            Biblioteca biblioteca, @Context CycleAvoidingMappingContext context);

    Biblioteca bibliotecaDtoToEntity(
            BibliotecaDto bibliotecaDto, @Context CycleAvoidingMappingContext context);

    List<BibliotecaDto> bibliotecaToDto(
            List<Biblioteca> biblioteci, @Context CycleAvoidingMappingContext context);

    List<Biblioteca> bibliotecaDtoToEntity(
            List<BibliotecaDto> biblioteciDtos, @Context CycleAvoidingMappingContext context);
}
