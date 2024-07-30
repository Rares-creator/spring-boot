package com.example.endpoints;

import com.example.dto.PizzaDto;
import com.example.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pizza")
public class RestResourcesPizza {
  @Autowired private PizzaService pizzaService;

  // @PostMapping("/lista")
  public String adaugaPizza(@RequestBody PizzaDto pizzaDto) {
    pizzaService.adaugaPizza(pizzaDto);
    return "Pizza adaugata  cu succes.";
  }

  // @GetMapping("/cauta/{id}")
  public PizzaDto cautaPizza(@PathVariable Integer id) {
    return pizzaService.cautaPizza(id);
  }

  // @DeleteMapping("/sterge/{id}")
  public String stergePizza(@PathVariable Integer id) {
    pizzaService.stergePizza(id);
    return null;
  }

  // @PutMapping("/actualizare/{id}")
  //    public PizzaDto actualizarePizza(
  //            @PathVariable Integer id, @RequestBody PizzaDto pizzaPentruActualizare) {
  //        return pizzaService.actualizarePizza(id, pizzaPentruActualizare);
  //    }
}
