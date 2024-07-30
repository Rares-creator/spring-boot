package com.example.dao;

import com.example.dto.CameraDto;
import com.example.entities.Camera;
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
public class CameraDAOCustom {
  @PersistenceContext private EntityManager em;

  @Transactional
  public void deleteById(Integer cameraId) {
    em.createNativeQuery("DELETE FROM Camera WHERE id= ?")
        .setParameter(1, cameraId)
        .executeUpdate();
  }

  public List<Camera> cautaCamere(CameraDto cameraCuFiltre) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Camera> cq = cb.createQuery(Camera.class);

    Root<Camera> cameraRoot = cq.from(Camera.class);
    List<Predicate> predicates = new ArrayList<>();

    if (cameraCuFiltre.getTipCamera() != null && !cameraCuFiltre.getTipCamera().isEmpty()) {
      predicates.add(cb.equal(cameraRoot.get("tipCamera"), cameraCuFiltre.getTipCamera()));
    }
    if (cameraCuFiltre.getNumarCamera() != null) {
      predicates.add(cb.equal(cameraRoot.get("numarCamera"), cameraCuFiltre.getNumarCamera()));
    }
    if (cameraCuFiltre.getSuprafata() != null) {
      predicates.add(cb.equal(cameraRoot.get("suprafata"), cameraCuFiltre.getSuprafata()));
    }
    if (cameraCuFiltre.getJacuzzi() != null) {
      predicates.add(cb.equal(cameraRoot.get("jacuzzi"), cameraCuFiltre.getJacuzzi()));
    }
    cq.where(predicates.toArray(new Predicate[0]));
    return em.createQuery(cq).getResultList();
  }
}
