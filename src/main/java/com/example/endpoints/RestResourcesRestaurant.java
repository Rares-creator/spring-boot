package com.example.endpoints;

import com.example.dto.RestaurantDto;
import com.example.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestResourcesRestaurant {

    @Autowired
    private RestaurantService restaurantService;

    //@GetMapping("/cauta/{id}")
    public RestaurantDto cautaRestaurant(@PathVariable Integer id) {
        return restaurantService.cautaRestaurant(id);
    }

    //@PostMapping("/lista")
    public String adaugaRestaurant(@RequestBody RestaurantDto restaurantDto) {
        restaurantService.adaugaRestaurant(restaurantDto);
        return "Restaurant adaugat cu succes.";
    }
}
