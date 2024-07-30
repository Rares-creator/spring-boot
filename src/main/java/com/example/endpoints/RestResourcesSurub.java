package com.example.endpoints;

import com.example.dto.SurubDto;
import com.example.services.SurubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/surub")
public class RestResourcesSurub {
  @Autowired private SurubService surubService;

  // @PostMapping("/lista")
  public String adaugaSurub(@RequestBody SurubDto surubDto) {
    surubService.adaugaSurub(surubDto);
    return "Surub adaugat cu succes.";
  }

  // @DeleteMapping("/sterge/{id}")
  public String stergeSurub(@PathVariable Integer id) {
    surubService.stergeSurub(id);
    return null;
  }

  // @PutMapping("/actualizare/{id}")
  //    public SurubDto actualizareSurub(
  //            @PathVariable Integer id, @RequestBody SurubDto surubPentruActualizare) {
  //        return surubService.actualizareSurub(id, surubPentruActualizare);
  //    }

  // @GetMapping("/cauta/{id}")
  public SurubDto cautaSurub(@PathVariable Integer id) {
    return surubService.cautaSurub(id);
  }
}
