package com.example.dao;

import com.example.dto.BirouDto;
import com.example.entities.Birou;
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
public class BirouDAOCustom {
  @PersistenceContext private EntityManager em;

  @Transactional
  public void deleteById(Integer birouId) {
    em.createNativeQuery("DELETE FROM Birou WHERE id= ?").setParameter(1, birouId).executeUpdate();
  }

  public List<Birou> cautaBirouri(BirouDto birouCuFiltre) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Birou> cq = cb.createQuery(Birou.class);

    Root<Birou> birouRoot = cq.from(Birou.class);
    List<Predicate> predicates = new ArrayList<>();

    if (birouCuFiltre.getMaterial() != null && !birouCuFiltre.getMaterial().isEmpty()) {
      predicates.add(cb.equal(birouRoot.get("material"), birouCuFiltre.getMaterial()));
    }
    if (birouCuFiltre.getPret() != null) {
      predicates.add(cb.equal(birouRoot.get("pret"), birouCuFiltre.getPret()));
    }
    if (birouCuFiltre.getDimensiune() != null && !birouCuFiltre.getDimensiune().isEmpty()) {
      predicates.add(cb.equal(birouRoot.get("dimensiune"), birouCuFiltre.getDimensiune()));
    }
    if (birouCuFiltre.getCuloare() != null && !birouCuFiltre.getCuloare().isEmpty()) {
      predicates.add(cb.equal(birouRoot.get("culoare"), birouCuFiltre.getCuloare()));
    }
    if (birouCuFiltre.getGreutate() != null) {
      predicates.add(cb.equal(birouRoot.get("greutate"), birouCuFiltre.getGreutate()));
    }
    cq.where(predicates.toArray(new Predicate[0]));
    return em.createQuery(cq).getResultList();
  }
}
