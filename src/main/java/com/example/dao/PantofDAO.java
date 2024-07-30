package com.example.dao;

import com.example.entities.Pantof;
import com.example.entities.Sex;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PantofDAO extends CrudRepository<Pantof, Integer> {
  @Query("SELECT l FROM Pantof l WHERE l.tipPantof = :tipPantof")
  List<Pantof> cautaPantofDupaTipPantof(@Param("tipPantof") String tipPantof);

  @Query("SELECT l FROM Pantof l WHERE l.sex = :sex AND l.numar = :numar")
  List<Pantof> cautaPantofDupaSexSiNumar(@Param("sex") Sex sex, @Param("numar") int numar);
}
