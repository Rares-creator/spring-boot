package com.example.dao;

import com.example.entities.Person;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends CrudRepository<Person, Integer> {
  @Query("SELECT l FROM Person l WHERE l.cnp = :cnp")
  List<Person> cautaPersoanaDupaCnp(@Param("cnp") Long cnp);

  @Query("SELECT l FROM Person l WHERE l.nume = :nume AND l.varsta = :varsta")
  List<Person> cautaPersoanaDupaNumeSiVarsta(
      @Param("nume") String nume, @Param("varsta") int varsta);
}
