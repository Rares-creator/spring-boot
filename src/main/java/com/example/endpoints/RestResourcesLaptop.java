package com.example.endpoints;

import com.example.dto.LaptopDto;
import com.example.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/laptop")
public class RestResourcesLaptop {
  @Autowired private LaptopService laptopService;

  // @PostMapping("/lista")
  public String adaugaLaptop(@RequestBody LaptopDto laptopDto) {
    laptopService.adaugaLaptop(laptopDto);
    return "Laptop adaugat cu succes.";
  }

  // @GetMapping("/cauta/{id}")
  public LaptopDto cautaLaptop(@PathVariable Integer id) {
    return laptopService.cautaLaptop(id);
  }

  // @PutMapping("/actualizare/{id}")
  //    public LaptopDto actualizareLaptop(
  //            @PathVariable Integer id, @RequestBody LaptopDto laptopPentruActualizare) {
  //        return laptopService.actualizareLaptop(id, laptopPentruActualizare);
  //    }
}
