package com.example.converter;

import com.example.dto.PersonDto;
import com.example.services.PersonService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FacesConverter("personConverter")
public class PersonConverter implements Converter {

  @Autowired private PersonService personService;

  @Override
  public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
    return personService.cautaPersoana(Integer.parseInt(s));
  }

  @Override
  public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
    return ((PersonDto) o).getId().toString();
  }
}
