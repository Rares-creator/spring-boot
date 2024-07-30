package com.example.endpoints;

import com.example.dto.AnimalDto;
import com.example.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animal")
public class RestResourcesAnimal {
    @Autowired
    private AnimalService animalService;

   // @PostMapping("/lista")
    public String adaugaAnimal(@RequestBody AnimalDto animalDto) {
        animalService.adaugaAnimal(animalDto);
        return "Animal adaugat cu succes.";
    }

   // @DeleteMapping("/sterge/{id}")
    public String stergeAnimal(@PathVariable Integer id) {
        animalService.stergeAnimal(id);
        return null;
    }
}
