package com.example.dao;

import com.example.entities.Hotel;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelDAO extends CrudRepository<Hotel, Integer> {
  @Query("SELECT h FROM Hotel h WHERE h.locatie = :locatie")
  List<Hotel> cautaHotelDupaLocatie(@Param("locatie") String locatie);

  @Query("SELECT h FROM Hotel h WHERE h.piscina = :piscina AND h.restaurant = :restaurant")
  List<Hotel> cautaHotelDupaPiscinaSiRestaurant(
      @Param("piscina") Boolean piscina, @Param("restaurant") Boolean restaurant);
}
