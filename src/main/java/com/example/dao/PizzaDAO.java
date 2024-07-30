package com.example.dao;

import com.example.entities.Pizza;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaDAO extends CrudRepository<Pizza, Integer> {
  @Query("SELECT l FROM Pizza l WHERE l.denumire = :denumire")
  List<Pizza> cautaPizzaDupaDenumire(@Param("denumire") String denumire);

  @Query("SELECT l FROM Pizza l WHERE l.gramaj = :gramaj AND l.pret = :pret")
  List<Pizza> cautaPizzaDupaGramajSiPret(@Param("gramaj") int gramaj, @Param("pret") int pret);
}
