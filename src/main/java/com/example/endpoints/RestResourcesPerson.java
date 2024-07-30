package com.example.endpoints;

import com.example.dto.PersonDto;
import com.example.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class RestResourcesPerson {
    @Autowired
    private PersonService personService;

    //@GetMapping("/cauta/{id}")
    public PersonDto cautaPersoana(@PathVariable Integer id) {
        return personService.cautaPersoana(id);
    }

    //@PostMapping("/lista")
    public String adaugaPersoana(@RequestBody PersonDto personDto) {
        personService.adaugaPersoana(personDto);
        return "Persoana adaugata cu succes.";
    }
}
