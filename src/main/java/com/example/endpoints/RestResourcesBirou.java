package com.example.endpoints;

import com.example.dto.BirouDto;
import com.example.services.BirouService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/birou")
public class RestResourcesBirou {
  @Autowired private BirouService birouService;

  // @PostMapping("/lista")
  public String adaugaBirou(@RequestBody BirouDto birouDto) {
    birouService.adaugaBirou(birouDto);
    return "Birou adaugat cu succes.";
  }

  // @GetMapping("/cauta/{id}")
  public BirouDto cautaBirou(@PathVariable Integer id) {
    return birouService.cautaBirou(id);
  }

  // @DeleteMapping("/birou/sterge/{id}")
  public String stergeBirou(@PathVariable Integer id) {
    birouService.stergeBirou(id);
    return null;
  }

  // @PutMapping("/birou/actualizare/{id}")
  // public String actualizareBirou(
  //    @PathVariable Integer id, @RequestBody BirouDto birouPentruActualizare) {
  //   birouService.actualizareBirou(id, birouPentruActualizare);
  //  return null;
  // }

  // @GetMapping("/birou/cauta/culoare/{culoare}/pretmaimic/{pret}")
  public List<BirouDto> cautaBirouriDupaCuloareSiPretMaiMic(
      @PathVariable String culoare, @PathVariable int pret) {
    return birouService.cautaBirouriDupaCuloareSiPretMaiMic(culoare, pret);
  }

  // @GetMapping("/birou/cauta/confectie/{material}")
  public List<BirouDto> cautaPersoaneDupaNume(@PathVariable String material) {
    return birouService.cautaBirouriDupaMaterial(material);
  }

  // @GetMapping("/birou/cauta/dimensiune/{dimensiune}/pretmaimare/{pret}")
  public List<BirouDto> cautaBirouriDupaDimensiuneSiPretMaiMare(
      @PathVariable String dimensiune, @PathVariable int pret) {
    return birouService.cautaBirouriDupaDimensiuneSiPretMaiMare(dimensiune, pret);
  }

  //  @PostMapping("/birou/cauta")
  public List<BirouDto> cautaBirouri(@RequestBody BirouDto birouCuFiltre) {
    return birouService.cautaBirouri(birouCuFiltre);
  }
}
