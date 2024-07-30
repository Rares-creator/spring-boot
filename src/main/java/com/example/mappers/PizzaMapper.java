package com.example.mappers;

import com.example.dto.PizzaDto;
import com.example.entities.Pizza;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PizzaMapper {

  PizzaDto pizzaToDto(Pizza pizza, @Context CycleAvoidingMappingContext context);

  Pizza pizzaDtoToEntity(PizzaDto pizzaDto, @Context CycleAvoidingMappingContext context);

  List<PizzaDto> pizzaToDto(List<Pizza> pizza, @Context CycleAvoidingMappingContext context);

  List<Pizza> pizzaDtoToEntity(
      List<PizzaDto> pizzaDto, @Context CycleAvoidingMappingContext context);
}
