package com.example.dao;

import com.example.dto.HotelDto;
import com.example.entities.Hotel;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

@Repository
public class HotelDAOCustom {
  @PersistenceContext private EntityManager em;

  public List<Hotel> cautaHoteluri(HotelDto hotelCuFiltre) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Hotel> cq = cb.createQuery(Hotel.class);

    Root<Hotel> cameraRoot = cq.from(Hotel.class);
    List<Predicate> predicates = new ArrayList<>();

    if (hotelCuFiltre.getLocatie() != null && !hotelCuFiltre.getLocatie().isEmpty()) {
      predicates.add(cb.equal(cameraRoot.get("locatie"), hotelCuFiltre.getLocatie()));
    }
    if (hotelCuFiltre.getDenumire() != null && !hotelCuFiltre.getDenumire().isEmpty()) {
      predicates.add(cb.equal(cameraRoot.get("denumire"), hotelCuFiltre.getDenumire()));
    }
    if (hotelCuFiltre.getRestaurant() != null) {
      predicates.add(cb.equal(cameraRoot.get("restaurant"), hotelCuFiltre.getRestaurant()));
    }
    if (hotelCuFiltre.getPiscina() != null) {
      predicates.add(cb.equal(cameraRoot.get("piscina"), hotelCuFiltre.getPiscina()));
    }
    cq.where(predicates.toArray(new Predicate[0]));
    return em.createQuery(cq).getResultList();
  }
}
