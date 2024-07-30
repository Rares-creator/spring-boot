package com.example.mappers;

import com.example.dto.RestaurantDto;
import com.example.entities.Restaurant;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = MasaMapper.class)
public interface RestaurantMapper {
  RestaurantDto restaurantToDto(
      Restaurant restaurant, @Context CycleAvoidingMappingContext context);

  Restaurant restaurantDtoToEntity(
      RestaurantDto restaurantDto, @Context CycleAvoidingMappingContext context);

  List<RestaurantDto> restaurantToDto(
      List<Restaurant> restaurant, @Context CycleAvoidingMappingContext context);

  List<Restaurant> restaurantDtoToEntity(
      List<RestaurantDto> restaurantDto, @Context CycleAvoidingMappingContext context);
}
