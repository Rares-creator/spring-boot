package com.example.mappers;

import com.example.dto.HotelDto;
import com.example.entities.Hotel;
import java.util.List;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CameraMapper.class)
public interface HotelMapper {
  HotelDto hotelToDto(Hotel hotel, @Context CycleAvoidingMappingContext context);

  Hotel HotelDtoToEntity(HotelDto hotelDto, @Context CycleAvoidingMappingContext context);

  List<HotelDto> hotelToDto(List<Hotel> hotel, @Context CycleAvoidingMappingContext context);

  List<Hotel> HotelDtoToEntity(
      List<HotelDto> hotelDto, @Context CycleAvoidingMappingContext context);
}
