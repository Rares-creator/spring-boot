package com.example.dao;

import com.example.entities.Tricou;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TricouDAO extends CrudRepository<Tricou, Integer> {
  @Query("SELECT l FROM Tricou l WHERE l.pret > :pret")
  List<Tricou> cautaTricouDupaPretMaiMare(@Param("pret") int pret);

  @Query("SELECT l FROM Tricou l WHERE l.material = :material AND l.culoare = :culoare")
  List<Tricou> cautaTricouDupaMaterialSiCuloare(
      @Param("material") String material, @Param("culoare") String culoare);
}
