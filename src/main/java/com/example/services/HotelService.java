package com.example.services;

import com.example.dao.HotelDAO;
import com.example.dao.HotelDAOCustom;
import com.example.dto.HotelDto;
import com.example.entities.Hotel;
import com.example.mappers.CycleAvoidingMappingContext;
import com.example.mappers.HotelMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
  @Autowired private HotelDAO hotelDAO;
  @Autowired private HotelMapper hotelMapper;
  @Autowired private HotelDAOCustom hotelDAOCustom;

  public void adaugaHotel(HotelDto hotelDto) {
    hotelDAO.save(hotelMapper.HotelDtoToEntity(hotelDto, new CycleAvoidingMappingContext()));
  }

  public HotelDto cautaHotel(Integer id) {
    return hotelMapper.hotelToDto(hotelDAO.findOne(id), new CycleAvoidingMappingContext());
  }

  public List<HotelDto> loadAllHotels() {
    return hotelMapper.hotelToDto(
        (List<Hotel>) hotelDAO.findAll(), new CycleAvoidingMappingContext());
  }

  public List<HotelDto> cautaHotelDupaLocatie(String locatie) {
    return hotelMapper.hotelToDto(
        hotelDAO.cautaHotelDupaLocatie(locatie), new CycleAvoidingMappingContext());
  }

  public List<HotelDto> cautaHotelDupaPiscinaSiRestaurant(Boolean piscina, Boolean restaurant) {
    return hotelMapper.hotelToDto(
        hotelDAO.cautaHotelDupaPiscinaSiRestaurant(piscina, restaurant),
        new CycleAvoidingMappingContext());
  }

  public List<HotelDto> cautaHoteluri(HotelDto hotelCuFiltre) {
    return hotelMapper.hotelToDto(
        hotelDAOCustom.cautaHoteluri(hotelCuFiltre), new CycleAvoidingMappingContext());
  }

  public void stergeHotel(Integer id) {
    hotelDAO.delete(id);
  }

  public HotelDto actualizareHotel(HotelDto hotelPentruActualizare) {
    hotelDAO.save(
        hotelMapper.HotelDtoToEntity(hotelPentruActualizare, new CycleAvoidingMappingContext()));
    return hotelPentruActualizare;
  }
}
