package com.example.dao;

import com.example.entities.Camera;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraDAO extends CrudRepository<Camera, Integer> {
  @Query("SELECT p FROM Camera p WHERE p.jacuzzi = :jacuzzi")
  List<Camera> cautaCameraDupaJacuzzi(@Param("jacuzzi") Boolean jacuzzi);

  @Query(
      "SELECT c FROM Camera c WHERE c.hotel.denumire = :hotelDenumire AND c.tipCamera = :tipCamera")
  List<Camera> cautaCameraDupaHotelSiTipulCamerei(
      @Param("hotelDenumire") String hotelDenumire, @Param("tipCamera") String tipCamera);
}
