package com.example.dao;

import com.example.entities.Mouse;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MouseDAO extends CrudRepository<Mouse, Integer> {
  @Query("SELECT l FROM Mouse l WHERE l.denumire = :denumire")
  List<Mouse> cautaMouseDupaDenumire(@Param("denumire") String denumire);

  @Query("SELECT l FROM Mouse l WHERE l.cabluUsb = :cabluUsb AND l.numarButoane = :numarButoane")
  List<Mouse> cautaMouseDupaCabluUsbSiNumarButoane(
      @Param("cabluUsb") Boolean cabluUsb, @Param("numarButoane") int numarButoane);
}
