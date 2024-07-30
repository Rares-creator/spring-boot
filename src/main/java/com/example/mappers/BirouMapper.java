package com.example.mappers;

import com.example.dto.BirouDto;
import com.example.entities.Birou;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ApartamentMapper.class)
public interface BirouMapper {

    BirouDto birouToDto(Birou birou, @Context CycleAvoidingMappingContext context);

    Birou birouDtoToEntity(BirouDto birouDto, @Context CycleAvoidingMappingContext context);

    List<BirouDto> birouToDto(List<Birou> birous, @Context CycleAvoidingMappingContext context);

    List<Birou> birouDtoToEntity(
            List<BirouDto> birouDto, @Context CycleAvoidingMappingContext context);
}
