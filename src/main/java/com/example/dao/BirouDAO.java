package com.example.dao;

import com.example.entities.Birou;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BirouDAO extends CrudRepository<Birou, Integer> {

    @Query("SELECT p FROM Birou p WHERE p.dimensiune = :dimensiune")
    List<Birou> cautaBirouriDupaDimensiune(@Param("dimensiune") String dimensiune);

    @Query("SELECT p FROM Birou p WHERE p.material = :material")
    List<Birou> cautaBirouriDupaMaterial(@Param("material") String material);

    @Query("SELECT p FROM Birou p WHERE p.dimensiune = :dimensiune AND p.pret > :pret")
    List<Birou> cautaBirouriDupaDimensiuneSiPretMaiMare(
            @Param("dimensiune") String dimensiune, @Param("pret") int pret);

    @Query("SELECT b FROM Birou b WHERE b.apartament.id = :idApartament")
    List<Birou> cautaBirouriDupaIdApartament(@Param("idApartament") Integer idApartament);

    @Query("SELECT b FROM Birou b WHERE b.culoare = :culoare AND b.pret < :pret")
    List<Birou> cautaBirouriDupaCuloareSiPretMaiMic(
            @Param("culoare") String culoare, @Param("pret") int pret);
}

