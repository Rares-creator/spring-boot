package com.example.dao;

import com.example.dto.PantofDto;
import com.example.entities.Pantof;
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
public class PantofDAOCustom {
  @PersistenceContext private EntityManager em;

  public List<Pantof> cautaPantofi(PantofDto pantofCuFiltre) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Pantof> cq = cb.createQuery(Pantof.class);

    Root<Pantof> cameraRoot = cq.from(Pantof.class);
    List<Predicate> predicates = new ArrayList<>();

    if (pantofCuFiltre.getTipPantof() != null && !pantofCuFiltre.getTipPantof().isEmpty()) {
      predicates.add(cb.equal(cameraRoot.get("tipPantof"), pantofCuFiltre.getTipPantof()));
    }
    if (pantofCuFiltre.getMaterial() != null) {
      predicates.add(cb.equal(cameraRoot.get("material"), pantofCuFiltre.getMaterial()));
    }
    if (pantofCuFiltre.getNumar() != null) {
      predicates.add(cb.equal(cameraRoot.get("numar"), pantofCuFiltre.getNumar()));
    }
    if (pantofCuFiltre.getSex() != null) {
      predicates.add(cb.equal(cameraRoot.get("sex"), pantofCuFiltre.getSex()));
    }
    if (pantofCuFiltre.getGreutate() != null) {
      predicates.add(cb.equal(cameraRoot.get("greutate"), pantofCuFiltre.getGreutate()));
    }
    cq.where(predicates.toArray(new Predicate[0]));
    return em.createQuery(cq).getResultList();
  }
}
