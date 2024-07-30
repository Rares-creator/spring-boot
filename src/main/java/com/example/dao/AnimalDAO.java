package com.example.dao;

import com.example.entities.Animal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalDAO extends CrudRepository<Animal, Integer> {
  @Query("SELECT a from Animal a WHERE a.person.id = :personId")
  List<Animal> cautaAnimaleDupaPersonId(@Param("personId") Integer personId);

  @Query("SELECT p FROM Animal p WHERE p.rasa = :rasa")
  List<Animal> cautaAnimalDupaRasa(@Param("rasa") String rasa);

  @Query("SELECT p FROM Animal p WHERE p.pedigree = :pedigree AND p.varsta < :varsta")
  List<Animal> cautaAnimalDupaPedigreeSiVarstaMaiMica(
      @Param("pedigree") Boolean pedigree, @Param("varsta") int varsta);
}
