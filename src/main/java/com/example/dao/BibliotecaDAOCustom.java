package com.example.dao;

import com.example.dto.BibliotecaDto;
import com.example.entities.Biblioteca;
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
public class BibliotecaDAOCustom {
  @PersistenceContext private EntityManager em;

  public List<Biblioteca> cautaBiblioteci(BibliotecaDto bibliotecaCuFiltre) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Biblioteca> cq = cb.createQuery(Biblioteca.class);

    Root<Biblioteca> bibliotecaRoot = cq.from(Biblioteca.class);
    List<Predicate> predicates = new ArrayList<>();

    if (bibliotecaCuFiltre.getLocatie() != null && !bibliotecaCuFiltre.getLocatie().isEmpty()) {
      predicates.add(cb.equal(bibliotecaRoot.get("locatie"), bibliotecaCuFiltre.getLocatie()));
    }
    if (bibliotecaCuFiltre.getDenumire() != null && !bibliotecaCuFiltre.getDenumire().isEmpty()) {
      predicates.add(cb.equal(bibliotecaRoot.get("denumire"), bibliotecaCuFiltre.getDenumire()));
    }
    if (bibliotecaCuFiltre.getDeschisWeekend() != null) {
      predicates.add(
          cb.equal(bibliotecaRoot.get("deschisWeekend"), bibliotecaCuFiltre.getDeschisWeekend()));
    }
    cq.where(predicates.toArray(new Predicate[0]));
    return em.createQuery(cq).getResultList();
  }
}
