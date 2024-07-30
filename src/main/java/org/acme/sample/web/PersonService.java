package org.acme.sample.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  @Autowired private PersonDao personDao;

  public void adaugaPersoana(Person persoana) {
    personDao.save(persoana);
  }

  public Person cautaPersoana(Integer id) {
    return personDao.findOne(id);
  }

  public List<Person> loadAllPersons() {
    return (List<Person>) personDao.findAll();
  }
}
