package com.example.dao;

import com.example.dto.SurubDto;
import com.example.entities.Surub;
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
public class SurubDAOCustom {
  @PersistenceContext private EntityManager em;

  public List<Surub> cautaSuruburi(SurubDto surubCuFiltre) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Surub> cq = cb.createQuery(Surub.class);

    Root<Surub> cameraRoot = cq.from(Surub.class);
    List<Predicate> predicates = new ArrayList<>();

    if (surubCuFiltre.getTipSurub() != null && !surubCuFiltre.getTipSurub().isEmpty()) {
      predicates.add(cb.equal(cameraRoot.get("tipSurub"), surubCuFiltre.getTipSurub()));
    }
    if (surubCuFiltre.getZonaFolosire() != null && !surubCuFiltre.getZonaFolosire().isEmpty()) {
      predicates.add(cb.equal(cameraRoot.get("zonaFolosire"), surubCuFiltre.getZonaFolosire()));
    }
    if (surubCuFiltre.getMaterial() != null && !surubCuFiltre.getMaterial().isEmpty()) {
      predicates.add(cb.equal(cameraRoot.get("material"), surubCuFiltre.getMaterial()));
    }
    if (surubCuFiltre.getLungime() != null) {
      predicates.add(cb.equal(cameraRoot.get("lungime"), surubCuFiltre.getLungime()));
    }
    if (surubCuFiltre.getGrosime() != null) {
      predicates.add(cb.equal(cameraRoot.get("grosime"), surubCuFiltre.getGrosime()));
    }
    cq.where(predicates.toArray(new Predicate[0]));
    return em.createQuery(cq).getResultList();
  }
}
