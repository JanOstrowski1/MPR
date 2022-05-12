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

import java.util.List;

@RestController
public class CarController {

    @Autowired
    CarService carService;


    @GetMapping("/car")
    public ResponseEntity<List<Car>> getCar() {
        List<Car> cars =carService.getCarsFromRepo();
        return new ResponseEntity<>(cars,HttpStatus.OK);
    }

    @PostMapping("/car/add/")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
       Car car1= carService.addCar(car.getId(), car.getColor(), car.getMake());
        return new ResponseEntity<>(car1,HttpStatus.OK);
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
