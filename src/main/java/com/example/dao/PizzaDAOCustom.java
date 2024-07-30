package com.example.dao;

import com.example.dto.PizzaDto;
import com.example.entities.Pizza;
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
public class PizzaDAOCustom {
  @PersistenceContext private EntityManager em;

  public List<Pizza> cautaPizza(PizzaDto pizzaCuFiltre) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Pizza> cq = cb.createQuery(Pizza.class);

    Root<Pizza> cameraRoot = cq.from(Pizza.class);
    List<Predicate> predicates = new ArrayList<>();

    if (pizzaCuFiltre.getDenumire() != null && !pizzaCuFiltre.getDenumire().isEmpty()) {
      predicates.add(cb.equal(cameraRoot.get("denumire"), pizzaCuFiltre.getDenumire()));
    }
    if (pizzaCuFiltre.getGramaj() != null) {
      predicates.add(cb.equal(cameraRoot.get("gramaj"), pizzaCuFiltre.getGramaj()));
    }
    if (pizzaCuFiltre.getPret() != null) {
      predicates.add(cb.equal(cameraRoot.get("pret"), pizzaCuFiltre.getPret()));
    }
    if (pizzaCuFiltre.getSosExtra() != null) {
      predicates.add(cb.equal(cameraRoot.get("sosExtra"), pizzaCuFiltre.getSosExtra()));
    }
    if (pizzaCuFiltre.getGlutenFree() != null) {
      predicates.add(cb.equal(cameraRoot.get("glutenFree"), pizzaCuFiltre.getGlutenFree()));
    }
    cq.where(predicates.toArray(new Predicate[0]));
    return em.createQuery(cq).getResultList();
  }
}
