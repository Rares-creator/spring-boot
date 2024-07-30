package com.example.dao;

import com.example.dto.RestaurantDto;
import com.example.entities.Restaurant;
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
public class RestaurantDAOCustom {
  @PersistenceContext private EntityManager em;

  public List<Restaurant> cautaRestaurant(RestaurantDto restaurantCuFiltre) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Restaurant> cq = cb.createQuery(Restaurant.class);

    Root<Restaurant> cameraRoot = cq.from(Restaurant.class);
    List<Predicate> predicates = new ArrayList<>();

    if (restaurantCuFiltre.getDenumire() != null && !restaurantCuFiltre.getDenumire().isEmpty()) {
      predicates.add(cb.equal(cameraRoot.get("denumire"), restaurantCuFiltre.getDenumire()));
    }
    if (restaurantCuFiltre.getLocatie() != null && !restaurantCuFiltre.getLocatie().isEmpty()) {
      predicates.add(cb.equal(cameraRoot.get("locatie"), restaurantCuFiltre.getLocatie()));
    }

    cq.where(predicates.toArray(new Predicate[0]));
    return em.createQuery(cq).getResultList();
  }
}
