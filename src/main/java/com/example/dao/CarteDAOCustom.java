package com.example.dao;

import com.example.dto.CarteDto;
import com.example.entities.Carte;
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
public class CarteDAOCustom {
  @PersistenceContext private EntityManager em;

  @Transactional
  public void deleteById(Integer carteId) {
    em.createNativeQuery("DELETE FROM Carte WHERE id= ?").setParameter(1, carteId).executeUpdate();
  }

  public List<Carte> cautaCarti(CarteDto carteCuFiltre) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Carte> cq = cb.createQuery(Carte.class);

    Root<Carte> cameraRoot = cq.from(Carte.class);
    List<Predicate> predicates = new ArrayList<>();

    if (carteCuFiltre.getGen() != null && !carteCuFiltre.getGen().isEmpty()) {
      predicates.add(cb.equal(cameraRoot.get("gen"), carteCuFiltre.getGen()));
    }
    if (carteCuFiltre.getAutor() != null && !carteCuFiltre.getAutor().isEmpty()) {
      predicates.add(cb.equal(cameraRoot.get("autor"), carteCuFiltre.getAutor()));
    }
    if (carteCuFiltre.getNume() != null && !carteCuFiltre.getNume().isEmpty()) {
      predicates.add(cb.equal(cameraRoot.get("nume"), carteCuFiltre.getNume()));
    }
    if (carteCuFiltre.getNumarPagini() != null) {
      predicates.add(cb.equal(cameraRoot.get("numarPagini"), carteCuFiltre.getNumarPagini()));
    }
    cq.where(predicates.toArray(new Predicate[0]));
    return em.createQuery(cq).getResultList();
  }
}
