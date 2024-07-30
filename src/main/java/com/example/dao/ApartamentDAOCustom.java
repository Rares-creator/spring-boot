package com.example.dao;

import com.example.dto.ApartamentDto;
import com.example.entities.Apartament;
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
public class ApartamentDAOCustom {
  @PersistenceContext private EntityManager em;

  public List<Apartament> cautaApartamente(ApartamentDto apartamentCuFiltre) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Apartament> cq = cb.createQuery(Apartament.class);

    Root<Apartament> apartamentRoot = cq.from(Apartament.class);
    List<Predicate> predicates = new ArrayList<>();

    if (apartamentCuFiltre.getLocatie() != null && !apartamentCuFiltre.getLocatie().isEmpty()) {
      predicates.add(cb.equal(apartamentRoot.get("locatie"), apartamentCuFiltre.getLocatie()));
    }
    if (apartamentCuFiltre.getSuprafata() != null) {
      predicates.add(cb.equal(apartamentRoot.get("suprafata"), apartamentCuFiltre.getSuprafata()));
    }
    if (apartamentCuFiltre.getBalcon() != null) {
      predicates.add(cb.equal(apartamentRoot.get("balcon"), apartamentCuFiltre.getBalcon()));
    }
    if (apartamentCuFiltre.getNumarBai() != null) {
      predicates.add(cb.equal(apartamentRoot.get("numarBai"), apartamentCuFiltre.getNumarBai()));
    }
    if (apartamentCuFiltre.getNumarCamere() != null) {
      predicates.add(
          cb.equal(apartamentRoot.get("numarCamere"), apartamentCuFiltre.getNumarCamere()));
    }
    cq.where(predicates.toArray(new Predicate[0]));
    return em.createQuery(cq).getResultList();
  }
}
