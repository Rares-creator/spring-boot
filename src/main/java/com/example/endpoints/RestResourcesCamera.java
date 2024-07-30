package com.example.endpoints;

import com.example.dto.CameraDto;
import com.example.services.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/camera")
public class RestResourcesCamera {
    @Autowired
    private CameraService cameraService;

    //@PostMapping("/lista")
    public String adaugaCamera(@RequestBody CameraDto cameraDto) {
        cameraService.adaugaCamera(cameraDto);
        return "Camera adaugata cu succes.";
    }

    //@DeleteMapping("/sterge/{id}")
    public String stergeCamera(@PathVariable Integer id) {
        cameraService.stergeCamera(id);
        return null;
    }
}
