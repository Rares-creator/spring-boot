package com.example.mappers;

import com.example.dto.PersonDto;
import com.example.entities.Person;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = AnimalMapper.class)
public interface PersonMapper {

    PersonDto personToDto(Person person, @Context CycleAvoidingMappingContext context);

    Person personDtoToEntity(PersonDto personDto, @Context CycleAvoidingMappingContext context);

    List<PersonDto> personToDto(List<Person> persons, @Context CycleAvoidingMappingContext context);

    List<Person> personDtoToEntity(
            List<PersonDto> personDtos, @Context CycleAvoidingMappingContext context);
}
