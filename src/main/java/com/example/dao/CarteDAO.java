package com.example.dao;

import com.example.entities.Carte;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteDAO extends CrudRepository<Carte, Integer> {
  @Query("SELECT p FROM Carte p WHERE p.nume = :nume")
  List<Carte> cautaCarteDupaNume(@Param("nume") String nume);

  @Query("SELECT p FROM Carte p WHERE p.autor = :autor AND p.gen = :gen")
  List<Carte> cautaCarteDupaAutorSiGen(@Param("autor") String autor, @Param("gen") String gen);
}
