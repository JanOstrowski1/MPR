package com.example.MPRgr5.controller;

import com.example.MPRgr5.Car;
import com.example.MPRgr5.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {
    CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/car/{id}")
    public Car getCar(@PathVariable long id) {
        return carService.findById(id);
    }

    @PostMapping("/car/add/{id}")
    public void createCar( @PathVariable long id,@RequestBody Car car){
        carService.addCar(id ,car);
    }

    @DeleteMapping("/car/delete/{id}")
    public void deleteCar(@PathVariable long id){
        carService.deleteCar(id);
    }

//    @GetMapping("/car/{id}")
//    public List<Car> getAllCars(@PathVariable long id) {
//        return carService.getAllCars();
//    }


}
