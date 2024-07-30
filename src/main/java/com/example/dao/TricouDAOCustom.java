package com.example.dao;

import com.example.dto.TricouDto;
import com.example.entities.Tricou;
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
public class TricouDAOCustom {
  @PersistenceContext private EntityManager em;

  public List<Tricou> cautaTricouri(TricouDto tricouCuFiltre) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Tricou> cq = cb.createQuery(Tricou.class);

    Root<Tricou> animalRoot = cq.from(Tricou.class);
    List<Predicate> predicates = new ArrayList<>();

    if (tricouCuFiltre.getMaterial() != null && !tricouCuFiltre.getMaterial().isEmpty()) {
      predicates.add(cb.equal(animalRoot.get("material"), tricouCuFiltre.getMaterial()));
    }
    if (tricouCuFiltre.getCuloare() != null && !tricouCuFiltre.getCuloare().isEmpty()) {
      predicates.add(cb.equal(animalRoot.get("culoare"), tricouCuFiltre.getCuloare()));
    }
    if (tricouCuFiltre.getMarime() != null) {
      predicates.add(cb.equal(animalRoot.get("marime"), tricouCuFiltre.getMarime()));
    }
    if (tricouCuFiltre.getPret() != null) {
      predicates.add(cb.equal(animalRoot.get("pret"), tricouCuFiltre.getPret()));
    }
    if (tricouCuFiltre.getSex() != null) {
      predicates.add(cb.equal(animalRoot.get("sex"), tricouCuFiltre.getSex()));
    }
    cq.where(predicates.toArray(new Predicate[0]));
    return em.createQuery(cq).getResultList();
  }
}
