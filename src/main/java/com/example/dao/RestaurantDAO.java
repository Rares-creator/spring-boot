package com.example.dao;

import com.example.entities.Restaurant;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDAO extends CrudRepository<Restaurant, Integer> {
  @Query("SELECT p FROM Restaurant p WHERE p.locatie = :locatie")
  List<Restaurant> cautaRestaurantDupaLocatie(@Param("locatie") String locatie);
}
