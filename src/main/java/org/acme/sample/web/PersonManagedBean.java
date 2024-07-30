package org.acme.sample.web;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.acme.sample.jsf.FacesViewScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("personManagedBean")
@Scope(FacesViewScope.NAME)
public class PersonManagedBean implements Serializable {

  @Autowired private PersonService personService;

  private List<Person> persons;

  @PostConstruct
  public void init() {
    persons = personService.loadAllPersons();
    System.out.println("Am apelat constructorul.");
  }

  public void loadAllPersons() {
    persons = personService.loadAllPersons();
  }

  public List<Person> getPersons() {
    return persons;
  }

  public void setPersons(List<Person> persons) {
    this.persons = persons;
  }
}
