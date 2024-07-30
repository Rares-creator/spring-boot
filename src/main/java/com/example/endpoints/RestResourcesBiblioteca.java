package com.example.endpoints;

import com.example.dto.BibliotecaDto;
import com.example.services.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biblioteca")
public class RestResourcesBiblioteca {
    @Autowired
    private BibliotecaService bibliotecaService;

    //@PostMapping("/lista")
    public String adaugaBiblioteca(@RequestBody BibliotecaDto bibliotecaDto) {
        bibliotecaService.adaugaBiblioteca(bibliotecaDto);
        return "Biblioteca adaugata cu succes.";
    }

   // @GetMapping("/cauta/{id}")
    public BibliotecaDto cautaBiblioteca(@PathVariable Integer id) {
        return bibliotecaService.cautaBiblioteca(id);
    }
}
