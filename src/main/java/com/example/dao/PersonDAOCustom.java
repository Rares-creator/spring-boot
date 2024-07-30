package com.example.dao;

import com.example.dto.PersonDto;
import com.example.entities.Person;
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
public class PersonDAOCustom {
  @PersistenceContext private EntityManager em;

  @Transactional
  public void deleteById(Integer personId) {
    em.createNativeQuery("DELETE FROM Person WHERE id= ?")
        .setParameter(1, personId)
        .executeUpdate();
  }

  public List<Person> cautaPersoane(PersonDto personCuFiltre) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Person> cq = cb.createQuery(Person.class);

    Root<Person> cameraRoot = cq.from(Person.class);
    List<Predicate> predicates = new ArrayList<>();

    if (personCuFiltre.getNume() != null && !personCuFiltre.getNume().isEmpty()) {
      predicates.add(cb.equal(cameraRoot.get("nume"), personCuFiltre.getNume()));
    }
    if (personCuFiltre.getPrenume() != null && !personCuFiltre.getPrenume().isEmpty()) {
      predicates.add(cb.equal(cameraRoot.get("prenume"), personCuFiltre.getPrenume()));
    }
    if (personCuFiltre.getCnp() != null) {
      predicates.add(cb.equal(cameraRoot.get("cnp"), personCuFiltre.getCnp()));
    }
    if (personCuFiltre.getSex() != null) {
      predicates.add(cb.equal(cameraRoot.get("sex"), personCuFiltre.getSex()));
    }
    if (personCuFiltre.getVarsta() != null) {
      predicates.add(cb.equal(cameraRoot.get("varsta"), personCuFiltre.getVarsta()));
    }
    cq.where(predicates.toArray(new Predicate[0]));
    return em.createQuery(cq).getResultList();
  }
}
