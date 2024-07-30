package com.example.dao;

import com.example.dto.LaptopDto;
import com.example.entities.Laptop;
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
public class LaptopDAOCustom {
  @PersistenceContext private EntityManager em;

  public List<Laptop> cautaLaptopuri(LaptopDto laptopCuFiltre) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Laptop> cq = cb.createQuery(Laptop.class);

    Root<Laptop> cameraRoot = cq.from(Laptop.class);
    List<Predicate> predicates = new ArrayList<>();

    if (laptopCuFiltre.getDenumire() != null && !laptopCuFiltre.getDenumire().isEmpty()) {
      predicates.add(cb.equal(cameraRoot.get("denumire"), laptopCuFiltre.getDenumire()));
    }
    if (laptopCuFiltre.getPlacaVideo() != null && !laptopCuFiltre.getPlacaVideo().isEmpty()) {
      predicates.add(cb.equal(cameraRoot.get("placaVideo"), laptopCuFiltre.getPlacaVideo()));
    }
    if (laptopCuFiltre.getMemorieRam() != null) {
      predicates.add(cb.equal(cameraRoot.get("memorieRam"), laptopCuFiltre.getMemorieRam()));
    }
    if (laptopCuFiltre.getMemorieRam() != null) {
      predicates.add(cb.equal(cameraRoot.get("fastUsb"), laptopCuFiltre.getFastUsb()));
    }
    if (laptopCuFiltre.getCapacitateBaterie() != null
        && !laptopCuFiltre.getCapacitateBaterie().isEmpty()) {
      predicates.add(
          cb.equal(cameraRoot.get("capacitateBaterie"), laptopCuFiltre.getCapacitateBaterie()));
    }
    cq.where(predicates.toArray(new Predicate[0]));
    return em.createQuery(cq).getResultList();
  }
}
