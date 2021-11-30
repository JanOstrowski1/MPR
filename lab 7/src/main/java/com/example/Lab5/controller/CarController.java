package com.example.Lab5.controller;

import com.example.Lab5.car.Car;
import com.example.Lab5.exceptions.CarAlreadyExistException;
import com.example.Lab5.exceptions.CarNotFoundException;
import com.example.Lab5.exceptions.InvalidDataException;
import com.example.Lab5.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    @Autowired
    CarService carService;


    @GetMapping("/car/{id}")
    public ResponseEntity getCar(@PathVariable int id) {
        Car car = carService.getCar(id);
        return new ResponseEntity<>(car,HttpStatus.OK);
    }

    @PostMapping("/car/add/{id}/{color}/{make}/{model}")
    public ResponseEntity addCar(@PathVariable int id, @PathVariable String color, @PathVariable String make) {
        carService.addCar(id, color, make);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/car/add/{id}")
    public ResponseEntity addCar(@PathVariable int id, @RequestBody Car car) {
        carService.addCar(id, car);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("car/remove/{id}")
    public ResponseEntity deleteCar(@PathVariable int id){
        carService.removeCar(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("car/update/{id}")
    public ResponseEntity updateCar(@PathVariable int id, @RequestBody Car car){
        carService.updateCar(id,car);
        return new ResponseEntity(HttpStatus.OK);
    }


}
