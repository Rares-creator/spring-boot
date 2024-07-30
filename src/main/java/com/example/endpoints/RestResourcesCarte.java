package com.example.endpoints;

import com.example.dto.CarteDto;
import com.example.services.CarteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carte")
public class RestResourcesCarte {
    @Autowired
    private CarteService carteService;

    //@PostMapping("/lista")
    public String adaugaCarte(@RequestBody CarteDto carteDto) {
        carteService.adaugaCarte(carteDto);
        return "Carte adaugata cu succes.";
    }

    //@GetMapping("/cauta/{id}")
    public CarteDto cautaCarte(@PathVariable Integer id) {
        return carteService.cautaCarte(id);
    }
}
