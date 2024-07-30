package com.example.endpoints;

import com.example.dto.PantofDto;
import com.example.services.PantofService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pantof")
public class RestResourcesPantof {
  @Autowired private PantofService pantofService;

  // @PostMapping("/lista")
  public String adaugaPantof(@RequestBody PantofDto pantofDto) {
    pantofService.adaugaPantof(pantofDto);
    return "Pantof adaugat.";
  }

  // @GetMapping("/cauta/{id}")
  public PantofDto cautaPantof(@PathVariable Integer id) {
    return pantofService.cautaPantof(id);
  }

  // @DeleteMapping("/sterge/{id}")
  public String stergePantof(@PathVariable Integer id) {
    pantofService.stergePantof(id);
    return null;
  }

  // @PutMapping("/actualizare/{id}")
  //    public PantofDto actualizarePantof(
  //            @PathVariable Integer id, @RequestBody PantofDto pantofPentruActualizare) {
  //        return pantofService.actualizarePantof(id, pantofPentruActualizare);
  //    }
}
