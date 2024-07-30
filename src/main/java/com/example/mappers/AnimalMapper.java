package com.example.mappers;

import com.example.dto.AnimalDto;
import com.example.entities.Animal;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = PersonMapper.class)
public interface AnimalMapper {
    AnimalDto animalToDto(Animal animal, @Context CycleAvoidingMappingContext context);

    Animal animalDtoToEntity(AnimalDto animalDto, @Context CycleAvoidingMappingContext context);

    List<AnimalDto> animalToDto(List<Animal> animals, @Context CycleAvoidingMappingContext context);

    List<Animal> animalDtoToEntity(
            List<AnimalDto> animalDtos, @Context CycleAvoidingMappingContext context);
}
