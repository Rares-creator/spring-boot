package com.example.dao;

import com.example.entities.Biblioteca;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecaDAO extends CrudRepository<Biblioteca, Integer> {
  @Query("SELECT p FROM Biblioteca p WHERE p.locatie = :locatie")
  List<Biblioteca> cautaBibliotecaDupaLocatie(@Param("locatie") String locatie);
}
