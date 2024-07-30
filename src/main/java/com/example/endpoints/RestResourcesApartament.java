package com.example.endpoints;

import com.example.dto.ApartamentDto;
import com.example.services.ApartamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apartament")
public class RestResourcesApartament {
    @Autowired
    private ApartamentService apartamentService;

    //@PostMapping("/lista")
    public String adaugaApartament(@RequestBody ApartamentDto apartamentDto) {
        apartamentService.adaugaApartament(apartamentDto);
        return "Apartament adaugat cu succes.";
    }

   // @GetMapping("/cauta/{id}")
    public ApartamentDto cautaApartament(@PathVariable Integer id) {
        return apartamentService.cautaApartament(id);
    }
}
