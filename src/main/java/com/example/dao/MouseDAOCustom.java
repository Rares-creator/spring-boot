package com.example.dao;

import com.example.dto.MouseDto;
import com.example.entities.Mouse;
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
public class MouseDAOCustom {
  @PersistenceContext private EntityManager em;

  public List<Mouse> cautaMousuri(MouseDto mouseCuFiltre) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Mouse> cq = cb.createQuery(Mouse.class);

    Root<Mouse> cameraRoot = cq.from(Mouse.class);
    List<Predicate> predicates = new ArrayList<>();

    if (mouseCuFiltre.getDenumire() != null && !mouseCuFiltre.getDenumire().isEmpty()) {
      predicates.add(cb.equal(cameraRoot.get("denumire"), mouseCuFiltre.getDenumire()));
    }
    if (mouseCuFiltre.getLuminaAmbientala() != null) {
      predicates.add(
          cb.equal(cameraRoot.get("luminaAmbientala"), mouseCuFiltre.getLuminaAmbientala()));
    }
    if (mouseCuFiltre.getNumarButoane() != null) {
      predicates.add(cb.equal(cameraRoot.get("numarButoane"), mouseCuFiltre.getNumarButoane()));
    }
    if (mouseCuFiltre.getNumarDpi() != null) {
      predicates.add(cb.equal(cameraRoot.get("numarDpi"), mouseCuFiltre.getNumarDpi()));
    }
    if (mouseCuFiltre.getCabluUsb() != null) {
      predicates.add(cb.equal(cameraRoot.get("cabluUsb"), mouseCuFiltre.getCabluUsb()));
    }
    cq.where(predicates.toArray(new Predicate[0]));
    return em.createQuery(cq).getResultList();
  }
}
