package com.example.dao;

import com.example.entities.Surub;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SurubDAO extends CrudRepository<Surub, Integer> {
  @Query("SELECT l FROM Surub l WHERE l.zonaFolosire = :zonaFolosire")
  List<Surub> cautaSurubDupaZonaFolosire(@Param("zonaFolosire") String zonaFolosire);

  @Query("SELECT l FROM Surub l WHERE l.tipSurub = :tipSurub AND l.material = :material")
  List<Surub> cautaSurubDupaTipSurubSiMaterial(
      @Param("tipSurub") String tipSurub, @Param("material") String material);
}
