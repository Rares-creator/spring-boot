package com.example.services;

import com.example.dao.PizzaDAO;
import com.example.dao.PizzaDAOCustom;
import com.example.dto.PizzaDto;
import com.example.entities.Pizza;
import com.example.mappers.CycleAvoidingMappingContext;
import com.example.mappers.PizzaMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
  @Autowired private PizzaDAO pizzaDAO;

  @Autowired private PizzaMapper pizzaMapper;

  @Autowired private PizzaDAOCustom pizzaDAOCustom;

  public void adaugaPizza(PizzaDto pizzaDto) {
    pizzaDAO.save(pizzaMapper.pizzaDtoToEntity(pizzaDto, new CycleAvoidingMappingContext()));
  }

  public PizzaDto cautaPizza(Integer id) {
    return pizzaMapper.pizzaToDto(pizzaDAO.findOne(id), new CycleAvoidingMappingContext());
  }

  public void stergePizza(Integer id) {
    pizzaDAO.delete(id);
  }

  public PizzaDto actualizarePizza(PizzaDto pizzaPentruActualizare) {
    pizzaDAO.save(
        pizzaMapper.pizzaDtoToEntity(pizzaPentruActualizare, new CycleAvoidingMappingContext()));
    return pizzaPentruActualizare;
  }

  public List<PizzaDto> loadAllPizzas() {
    return pizzaMapper.pizzaToDto(
        (List<Pizza>) pizzaDAO.findAll(), new CycleAvoidingMappingContext());
  }

  public List<PizzaDto> cautaPizzaDupaDenumire(String denumire) {
    return pizzaMapper.pizzaToDto(
        pizzaDAO.cautaPizzaDupaDenumire(denumire), new CycleAvoidingMappingContext());
  }

  public List<PizzaDto> cautaPizzaDupaGramajSiPret(Integer gramaj, Integer pret) {
    return pizzaMapper.pizzaToDto(
        pizzaDAO.cautaPizzaDupaGramajSiPret(gramaj, pret), new CycleAvoidingMappingContext());
  }

  public List<PizzaDto> cautaPizzaCustom(PizzaDto pizzaCuFiltre) {
    return pizzaMapper.pizzaToDto(
        pizzaDAOCustom.cautaPizza(pizzaCuFiltre), new CycleAvoidingMappingContext());
  }
}
