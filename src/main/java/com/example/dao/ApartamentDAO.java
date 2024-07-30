package com.example.dao;

import com.example.entities.Apartament;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartamentDAO extends CrudRepository<Apartament, Integer> {
  @Query("SELECT p FROM Apartament p WHERE p.locatie = :locatie")
  List<Apartament> cautaApartamentDupaLocatie(@Param("locatie") String locatie);

  @Query(
      "SELECT p FROM Apartament p WHERE p.suprafata > :suprafata AND p.numarCamere > :numarCamere")
  List<Apartament> cautaApartamentDupaSuprafataMaiMareSiNumarCamereMaiMulte(
      @Param("suprafata") int suprafata, @Param("numarCamere") int numarCamere);
}
