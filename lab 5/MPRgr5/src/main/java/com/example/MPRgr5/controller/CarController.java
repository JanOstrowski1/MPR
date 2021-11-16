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

    @PostMapping("/car/add/{name}/{model}/{plate}")
    public void createCar(@PathVariable String name,@PathVariable String model,@PathVariable String plate ){
        carService.addCar(name,model,plate);
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
