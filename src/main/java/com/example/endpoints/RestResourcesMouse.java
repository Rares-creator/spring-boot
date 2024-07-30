package com.example.endpoints;

import com.example.dto.MouseDto;
import com.example.services.MouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mouse")
public class RestResourcesMouse {

  @Autowired private MouseService mouseService;

  // @PostMapping("/lista")
  public String adaugaMouse(@RequestBody MouseDto mouseDto) {
    mouseService.adaugaMouse(mouseDto);
    return "Mouse adaugat cu succes.";
  }

  // @GetMapping("/cauta/{id}")
  public MouseDto cautaMouse(@PathVariable Integer id) {
    return mouseService.cautaMouse(id);
  }

  // @DeleteMapping("/sterge/{id}")
  public String stergeMouse(@PathVariable Integer id) {
    mouseService.stergeMouse(id);
    return null;
  }

  // @PutMapping("/actualizare/{id}")
  //    public MouseDto actualizareMouse(
  //            @PathVariable Integer id, @RequestBody MouseDto mousePentruActualizare) {
  //        return mouseService.actualizareMouse(id, mousePentruActualizare);
  //    }
}
