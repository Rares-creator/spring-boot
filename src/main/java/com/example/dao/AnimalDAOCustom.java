package com.example.dao;

import com.example.dto.AnimalDto;
import com.example.entities.Animal;
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
public class AnimalDAOCustom {
  @PersistenceContext private EntityManager em;

  @Transactional
  public void deleteById(Integer animalId) {
    em.createNativeQuery("DELETE FROM Animal WHERE id= ?")
        .setParameter(1, animalId)
        .executeUpdate();
  }

  public List<Animal> cautaAnimale(AnimalDto animalCuFiltre) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Animal> cq = cb.createQuery(Animal.class);

    Root<Animal> animalRoot = cq.from(Animal.class);
    List<Predicate> predicates = new ArrayList<>();

    if (animalCuFiltre.getRasa() != null && !animalCuFiltre.getRasa().isEmpty()) {
      predicates.add(cb.equal(animalRoot.get("rasa"), animalCuFiltre.getRasa()));
    }
    if (animalCuFiltre.getNume() != null && !animalCuFiltre.getNume().isEmpty()) {
      predicates.add(cb.equal(animalRoot.get("nume"), animalCuFiltre.getNume()));
    }
    if (animalCuFiltre.getVarsta() != null) {
      predicates.add(cb.equal(animalRoot.get("varsta"), animalCuFiltre.getVarsta()));
    }
    if (animalCuFiltre.getPedigree() != null) {
      predicates.add(cb.equal(animalRoot.get("pedigree"), animalCuFiltre.getPedigree()));
    }
    if (animalCuFiltre.getSex() != null) {
      predicates.add(cb.equal(animalRoot.get("sex"), animalCuFiltre.getSex()));
    }
    cq.where(predicates.toArray(new Predicate[0]));
    return em.createQuery(cq).getResultList();
  }
}
