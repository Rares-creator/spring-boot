package com.example.endpoints;

import com.example.dto.TricouDto;
import com.example.services.TricouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tricou")
public class RestResourcesTricou {

  @Autowired private TricouService tricouService;

  // @PostMapping("/lista")
  public String adaugaTricou(@RequestBody TricouDto tricouDto) {
    tricouService.adaugaTricou(tricouDto);
    return "Tricou adaugat cu succes.";
  }

  // @DeleteMapping("/sterge/{id}")
  public String stergeTricou(@PathVariable Integer id) {
    tricouService.stergeTricou(id);
    return null;
  }

  // @PutMapping("/actualizare/{id}")
  //    public TricouDto actualizareTricou(
  //            @PathVariable Integer id, @RequestBody TricouDto tricouPentruActualizare) {
  //        return tricouService.actualizareTricou(id, tricouPentruActualizare);
  //    }

  // @GetMapping("/cauta/{id}")
  public TricouDto cautaTricou(@PathVariable Integer id) {
    return tricouService.cautaTricou(id);
  }
}
