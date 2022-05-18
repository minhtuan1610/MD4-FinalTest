package com.example.finaltest.controller;

import com.example.finaltest.model.City;
import com.example.finaltest.model.Nation;
import com.example.finaltest.service.city.ICityService;
import com.example.finaltest.service.nation.INationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/city")
public class CityController {
    @Autowired
    ICityService cityService;
    @Autowired
    INationService nationService;

    @GetMapping("/nations")
    public ResponseEntity<Iterable<Nation>> displayNation() {
        Iterable<Nation> nations = nationService.findAll();
        return new ResponseEntity<>(nations, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Iterable<City>> listAllCity() {
        Iterable<City> cities = cityService.findAll();
        List<City> cityList = (List<City>) cities;
        return new ResponseEntity<>(cityList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<City> createCity(@RequestBody City city) {
        cityService.save(city);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City city) {
        Optional<City> cityOptional = cityService.findById(id);
        if (cityOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        city.setId(cityOptional.get().getId());
        cityService.save(city);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (cityOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findCityById(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (cityOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        City city = cityOptional.get();
        return new ResponseEntity<>(city, HttpStatus.FOUND);
    }
}
