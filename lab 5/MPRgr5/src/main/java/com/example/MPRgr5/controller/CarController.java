package com.example.MPRgr5.controller;

import com.example.MPRgr5.Car;
import com.example.MPRgr5.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CarController {
    CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/car/{id}")
    public Car getCar(@PathVariable Integer id) {

        return carService.getCar(id);
    }

    @PostMapping("/car/add/{id}/{name}/{model}/{plate}")
    public void createCar(@PathVariable Integer id,@PathVariable String name,@PathVariable String model,@PathVariable String plate ){
        carService.addCar(id,name,model,plate);
    }

    


}
