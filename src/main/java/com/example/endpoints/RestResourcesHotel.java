package com.example.endpoints;

import com.example.dto.HotelDto;
import com.example.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class RestResourcesHotel {
    @Autowired
    private HotelService hotelService;

    //@GetMapping("/cauta/{id}")
    public HotelDto cautaHotel(@PathVariable Integer id) {
        return hotelService.cautaHotel(id);
    }

    //@PostMapping("/lista")
    public String adaugaHotel(@RequestBody HotelDto hotelDto) {
        hotelService.adaugaHotel(hotelDto);
        return "Hotel adaugat cu succes.";
    }
}
