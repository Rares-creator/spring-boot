package com.example.dao;

import com.example.dto.MasaDto;
import com.example.entities.Masa;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MasaDAOCustom {
  @PersistenceContext private EntityManager em;

  @Transactional
  public void deleteById(Integer masaId) {
    em.createNativeQuery("DELETE FROM Masa WHERE id= ?").setParameter(1, masaId).executeUpdate();
  }

  public List<Masa> cautaMese(MasaDto masaCuFiltre) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Masa> cq = cb.createQuery(Masa.class);

    Root<Masa> cameraRoot = cq.from(Masa.class);
    List<Predicate> predicates = new ArrayList<>();

    if (masaCuFiltre.getNumarMasa() != null) {
      predicates.add(cb.equal(cameraRoot.get("numarMasa"), masaCuFiltre.getNumarMasa()));
    }
    if (masaCuFiltre.getCapacitate() != null) {
      predicates.add(cb.equal(cameraRoot.get("capacitate"), masaCuFiltre.getCapacitate()));
    }
    if (masaCuFiltre.getRezervata() != null) {
      predicates.add(cb.equal(cameraRoot.get("rezervata"), masaCuFiltre.getRezervata()));
    }
    cq.where(predicates.toArray(new Predicate[0]));
    return em.createQuery(cq).getResultList();
  }
}
