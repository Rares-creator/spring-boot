package com.example.managedbeans;

import com.example.dto.PizzaDto;
import com.example.jsf.FacesViewScope;
import com.example.services.PizzaService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("pizzaManagedBean")
@Scope(FacesViewScope.NAME)
public class PizzaManagedBean {

  @Autowired private PizzaService pizzaService;

  List<PizzaDto> pizzas;

  private PizzaDto pizzaToSave;
  private String denumireCautare;

  private Integer gramajCautare;

  private Integer pretCautare;

  private PizzaDto pizzaCautareCustom;

  private Integer pizzaIdPentruStergere;

  private String mesajDialog;

  private PizzaDto pizzaPentruActualizare;

  public void actualizeazaPizza() {
    pizzaService.actualizarePizza(pizzaPentruActualizare);
    reloadPizzaListAndRestoreToDefaults();
  }

  public void pregatesteActualizarePizza(PizzaDto pizza) {
    pizzaPentruActualizare = pizza;
  }

  public void verificaPizza(PizzaDto pizza) {
    pizzaIdPentruStergere = pizza.getId();
  }

  public String stergePizza() {
    pizzaService.stergePizza(pizzaIdPentruStergere);
    reloadPizzaListAndRestoreToDefaults();
    return "pizza.xhtml?faces-redirect=true";
  }

  public void cautaPizzaCustom() {
    pizzas = pizzaService.cautaPizzaCustom(pizzaCautareCustom);
  }

  public void reset() {
    reloadPizzaListAndRestoreToDefaults();
  }

  public void cautaPizzaDupaDenumire() {
    pizzas = pizzaService.cautaPizzaDupaDenumire(denumireCautare);
  }

  public void cautaPizzaDupaGramajSiPret() {
    pizzas = pizzaService.cautaPizzaDupaGramajSiPret(gramajCautare, pretCautare);
  }

  public void reloadPizzaListAndRestoreToDefaults() {
    pizzas = pizzaService.loadAllPizzas();
    pizzaToSave = new PizzaDto();
    pizzaToSave.setGlutenFree(false);
    pizzaToSave.setSosExtra(false);
    denumireCautare = null;
    gramajCautare = null;
    pretCautare = null;
    pizzaCautareCustom = new PizzaDto();
    pizzaPentruActualizare = new PizzaDto();
  }

  public void adaugaPizza() {
    pizzaService.adaugaPizza(pizzaToSave);
    reloadPizzaListAndRestoreToDefaults();
  }

  @PostConstruct
  public void init() {
    reloadPizzaListAndRestoreToDefaults();
    mesajDialog = "Doriți să ștergeți aceasta pizza?";
  }

  public List<PizzaDto> getPizzas() {
    return pizzas;
  }

  public void setPizzas(List<PizzaDto> pizzas) {
    this.pizzas = pizzas;
  }

  public PizzaDto getPizzaToSave() {
    return pizzaToSave;
  }

  public void setPizzaToSave(PizzaDto pizzaToSave) {
    this.pizzaToSave = pizzaToSave;
  }

  public String getDenumireCautare() {
    return denumireCautare;
  }

  public void setDenumireCautare(String denumireCautare) {
    this.denumireCautare = denumireCautare;
  }

  public Integer getGramajCautare() {
    return gramajCautare;
  }

  public void setGramajCautare(Integer gramajCautare) {
    this.gramajCautare = gramajCautare;
  }

  public Integer getPretCautare() {
    return pretCautare;
  }

  public void setPretCautare(Integer pretCautare) {
    this.pretCautare = pretCautare;
  }

  public PizzaDto getPizzaCautareCustom() {
    return pizzaCautareCustom;
  }

  public void setPizzaCautareCustom(PizzaDto pizzaCautareCustom) {
    this.pizzaCautareCustom = pizzaCautareCustom;
  }

  public String getMesajDialog() {
    return mesajDialog;
  }

  public void setMesajDialog(String mesajDialog) {
    this.mesajDialog = mesajDialog;
  }

  public PizzaDto getPizzaPentruActualizare() {
    return pizzaPentruActualizare;
  }

  public void setPizzaPentruActualizare(PizzaDto pizzaPentruActualizare) {
    this.pizzaPentruActualizare = pizzaPentruActualizare;
  }
}
