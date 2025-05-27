package com.vm.smartvin.controller;

import com.vm.smartvin.model.*;
import com.vm.smartvin.service.CarDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/car-details")
public class CarDetailsController {

    @Autowired
    private CarDetailsService carDetailsService;

    @GetMapping
    public ResponseEntity<CarDetailsResponse> getCarDetailsByVin(@RequestParam("vin") String vin) {
        // Delegate to service layer
       return ResponseEntity.ok(carDetailsService.getCarDetailsByVin(vin));

    }
    @PostMapping("/images")
    public ResponseEntity<List<Image>> getImageDetailsByVin(@RequestBody CarDetails carDetails) {
        // Delegate to service layer
        return ResponseEntity.ok(carDetailsService.getImageDetailsByVin(carDetails).getImages());
    }
    @GetMapping("/marketvalue")
    public ResponseEntity<String> findCarMarketValue(@RequestParam("vin") String vin) {
     return ResponseEntity.ok(carDetailsService.findMarketValue(vin));
    }

    @GetMapping("/history")
    public ResponseEntity<String> findCarHistory(@RequestParam("vin") String vin) {
        Arrays.asList(1,2,3,3).stream().collect(Collectors.toSet());
        return ResponseEntity.ok(carDetailsService.findCarHistory(vin));
    }
}
