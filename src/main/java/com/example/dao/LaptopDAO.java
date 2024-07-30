package com.example.dao;

import com.example.entities.Laptop;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopDAO extends CrudRepository<Laptop, Integer> {
  @Query("SELECT l FROM Laptop l WHERE l.denumire = :denumire")
  List<Laptop> cautaLaptopDupaDenumire(@Param("denumire") String denumire);

  @Query("SELECT l FROM Laptop l WHERE l.memorieRam = :memorieRam AND l.fastUsb = :fastUsb")
  List<Laptop> cautaLaptopDupaMemorieRamSiFastUsb(
      @Param("memorieRam") int memorieRam, @Param("fastUsb") Boolean fastUsb);
}
