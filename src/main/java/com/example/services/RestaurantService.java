package com.example.services;

import com.example.dao.RestaurantDAO;
import com.example.dao.RestaurantDAOCustom;
import com.example.dto.RestaurantDto;
import com.example.entities.Restaurant;
import com.example.mappers.CycleAvoidingMappingContext;
import com.example.mappers.RestaurantMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

  @Autowired private RestaurantDAO restaurantDAO;
  @Autowired private RestaurantMapper restaurantMapper;
  @Autowired private RestaurantDAOCustom restaurantDAOCustom;

  public void adaugaRestaurant(RestaurantDto restaurantDto) {
    restaurantDAO.save(
        restaurantMapper.restaurantDtoToEntity(restaurantDto, new CycleAvoidingMappingContext()));
  }

  public RestaurantDto cautaRestaurant(Integer id) {
    return restaurantMapper.restaurantToDto(
        restaurantDAO.findOne(id), new CycleAvoidingMappingContext());
  }

  public List<RestaurantDto> loadAllRestaurants() {
    return restaurantMapper.restaurantToDto(
        (List<Restaurant>) restaurantDAO.findAll(), new CycleAvoidingMappingContext());
  }

  public List<RestaurantDto> cautaRestaurantDupaLocatie(String locatie) {
    return restaurantMapper.restaurantToDto(
        restaurantDAO.cautaRestaurantDupaLocatie(locatie), new CycleAvoidingMappingContext());
  }

  public List<RestaurantDto> cautaRestaurante(RestaurantDto restaurantCuFiltre) {
    return restaurantMapper.restaurantToDto(
        restaurantDAOCustom.cautaRestaurant(restaurantCuFiltre), new CycleAvoidingMappingContext());
  }

  public void stergeRestaurant(Integer id) {
    restaurantDAO.delete(id);
  }

  public RestaurantDto actualizareRestaurant(RestaurantDto restaurantPentruActualizare) {
    restaurantDAO.save(
        restaurantMapper.restaurantDtoToEntity(
            restaurantPentruActualizare, new CycleAvoidingMappingContext()));
    return restaurantPentruActualizare;
  }
}
