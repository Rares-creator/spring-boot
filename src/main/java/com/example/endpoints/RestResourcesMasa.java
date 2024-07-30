package com.example.endpoints;

import com.example.dto.MasaDto;
import com.example.services.MasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/masa")
public class RestResourcesMasa {

    @Autowired
    private MasaService masaService;

    //@GetMapping("/cauta/{id}")
    public MasaDto cautaMasa(@PathVariable Integer id) {
        return masaService.cautaMasa(id);
    }

    //@PostMapping("/lista")
    public String adaugaMasa(@RequestBody MasaDto masaDto) {
        masaService.adaugaMasa(masaDto);
        return "Masa adaugata cu succes.";
    }
}
