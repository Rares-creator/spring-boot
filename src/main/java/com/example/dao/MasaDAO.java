package com.example.dao;

import com.example.entities.Masa;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MasaDAO extends CrudRepository<Masa, Integer> {
  @Query("SELECT l FROM Masa l WHERE l.capacitate = :capacitate")
  List<Masa> cautaMasaDupaCapacitate(@Param("capacitate") int capacitate);

  @Query(
      "SELECT l FROM Masa l WHERE l.restaurant.denumire = :restaurantDenumire AND l.numarMasa = :numarMasa")
  List<Masa> cautaMasaDupaDenumireRestaurantSiNumarMasa(
      @Param("restaurantDenumire") String restaurantDenumire, @Param("numarMasa") int numarMasa);
}
